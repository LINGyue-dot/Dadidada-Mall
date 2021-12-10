package com.jc.service.impl;

import com.github.pagehelper.PageHelper;
import com.jc.entity.pojo.Joiner;
import com.jc.entity.pojo.Post;
import com.jc.entity.pojo.User;
import com.jc.entity.vo.Applicants;
import com.jc.entity.vo.Participant;
import com.jc.entity.vo.PostView;
import com.jc.mapper.JoinerMapper;
import com.jc.mapper.PostMapper;
import com.jc.mapper.UserMapper;
import com.jc.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private JoinerMapper joinerMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public Integer add(Map<String,String> map) {
        Post post = new Post();

        Integer initiatorId = Integer.parseInt(map.get("initiatorId"));
        Integer reserveId = Integer.parseInt(map.get("reserveId"));
        Timestamp postTime = new Timestamp(System.currentTimeMillis());
        Timestamp beginTime = new Timestamp(Long.parseLong(map.get("beginTime")));
        Timestamp endTime = new Timestamp(Long.parseLong(map.get("endTime")));
        String postImg = map.get("postImg");
        Integer ballId = Integer.parseInt(map.get("ballId"));
        Integer batNeedNumber = Integer.parseInt(map.get("batNeedNumber"));
        Integer ballNeedNumber = Integer.parseInt(map.get("ballNeedNumber"));
        Integer peopleMinNumber = Integer.parseInt(map.get("peopleMinNumber"));
        Integer peopleMaxNumber = Integer.parseInt(map.get("peopleMaxNumber"));
        String initiatorNote = map.get("initiatorNote");
        String initiatorNoteDetails = "222";

        Integer batOffer = Integer.parseInt(map.get("batOffer"));
        Integer ballOffer = Integer.parseInt(map.get("ballOffer"));
        String position = map.get("position");

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("joiner_id",initiatorId);
        List<Joiner> joiners = joinerMapper.selectByMap(columnMap);

        for (Joiner joiner:joiners) {
            Integer joinedPostId = joiner.getPostId();
            Post joinedPost = postMapper.selectById(joinedPostId);
            if(!(beginTime.getTime()>joinedPost.getEndTime().getTime()
                    ||endTime.getTime()<joinedPost.getBeginTime().getTime()))return -1;
        }

        post.setBallId(ballId);
        post.setBeginTime(beginTime);
        post.setPostImg(postImg);
        post.setEndTime(endTime);
        post.setPostTime(postTime);
        post.setBallNeedNumber(ballNeedNumber);
        post.setBallOwnedNumber(ballOffer);
        post.setBatNeedNumber(batNeedNumber);
        post.setBatOwnedNumber(batOffer);
        post.setInitiatorId(initiatorId);
        post.setInitiatorNote(initiatorNote);
        post.setInitiatorNoteDetails(initiatorNoteDetails);
        post.setPeopleCurrentNumber(1);
        post.setReserveId(reserveId);
        post.setPeopleMaxNumber(peopleMaxNumber);
        post.setPeopleMinNumber(peopleMinNumber);
        post.setState(0);
        post.setIsDelete(false);

        postMapper.insert(post);
        postCountDown(post.getPostId());

        Joiner joiner = new Joiner();

        joiner.setState(3);
        joiner.setJoinerId(initiatorId);
        joiner.setPostId(post.getPostId());
        joiner.setBallOffer(ballOffer);
        joiner.setBatOffer(batOffer);
        joiner.setPosition(position);

        joinerMapper.insert(joiner);

        return 1;
    }


    @Override
    public Integer postDelete(Integer postId) {

        Post post = postMapper.selectById(postId);
        post.setIsDelete(true);

        return postMapper.updateById(post);
    }

    public void postCountDown(Integer postId) {

        Timer timer = new Timer();
        Post post = postMapper.selectById(postId);
        Date dateEndTime = new Date(post.getEndTime().getTime());
        Date dateBeginTime = new Date(post.getBeginTime().getTime());

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!postMapper.selectById(postId).getIsDelete()){

                    post.setState(1);
                    postMapper.updateById(post);
                }
            }
        }, dateBeginTime);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!postMapper.selectById(postId).getIsDelete()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("post_id",postId);

                    post.setState(3);
                    postMapper.updateById(post);
                    joinerMapper.deleteByMap(map);
                    timer.cancel();
                }
            }
        }, dateEndTime);


    }


    @Override
    public List<Applicants> getApplicant(Integer userId) {
        Map<String,Object> map = new HashMap<>();


        map.put("initiator_id",userId);
        List<Applicants> applicants = new ArrayList<>();

        List<Post> posts = postMapper.selectByMap(map);
        map.clear();

        for (Post post:posts){
            Integer postId = post.getPostId();
            map.put("post_id",postId);
            map.put("state",2);
            List<Joiner> joiners = joinerMapper.selectByMap(map);
            for (Joiner joiner:joiners) {
                Applicants applicant = new Applicants();
                User user = userMapper.selectById(joiner.getJoinerId());
                String userName = user.getUserName();
                String userAvatar = user.getUserAvatar();
                Integer joinerId = joiner.getJoinerId();
                Integer batOffer = joiner.getBatOffer();
                Integer ballOffer = joiner.getBallOffer();
                String position = joiner.getPosition();

                applicant.setUserName(userName);
                applicant.setPosition(position);
                applicant.setBallOffer(ballOffer);
                applicant.setJoinerId(joinerId);
                applicant.setUserAvatar(userAvatar);
                applicant.setBatOffer(batOffer);
                applicant.setPostId(postId);
                applicants.add(applicant);


            }
        }

        return applicants;
    }

    @Override
    public List<PostView> getPostList(Integer pageNum , Integer pageSize) {

        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.selectByPage(false,3);
        List<PostView> postViews = new ArrayList<>();
        for (Post post: posts
             ) {
            PostView postView = new PostView(post);
            postViews.add(postView);
        }

        return postViews;
    }

    @Override
    public PostView getPostInformation(Integer postId) {
        PostView postView = new PostView(postMapper.selectById(postId));
        return postView;
    }


    @Override
    public List<Participant> getParticipant(Integer postId) {

        Map<String,Object> map = new HashMap<>();
        map.put("post_id",postId);
        map.put("state",1);

        List<Joiner> joiners = joinerMapper.selectByMap(map);
        List<Participant> participants = new ArrayList<>();
        for (Joiner joiner: joiners) {
            Participant participant = new Participant();
            String userName = userMapper.selectById(joiner.getJoinerId()).getUserName();
            String userAvatar = userMapper.selectById(joiner.getJoinerId()).getUserAvatar();

            participant.setJoinerId(joiner.getJoinerId());
            participant.setPosition(joiner.getPosition());
            participant.setUserAvatar(userAvatar);
            participant.setUserName(userName);

            participants.add(participant);
        }


        return participants;
    }
}
