package com.jc.service.impl;

import com.jc.entity.pojo.Joiner;
import com.jc.entity.pojo.Post;
import com.jc.mapper.JoinerMapper;
import com.jc.mapper.PostMapper;
import com.jc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private JoinerMapper joinerMapper;


    @Override
    public Integer add(Map<String,String> map) {
        Post post = new Post();

        Integer postId = Integer.parseInt(map.get("postId"));
        Integer initiatorId = Integer.parseInt(map.get("initiatorId"));
        Integer reserveId = Integer.parseInt(map.get("reverseId"));
        Timestamp postTime = Timestamp.valueOf(map.get("postTime"));
        Timestamp beginTime = Timestamp.valueOf(map.get("beginTime"));
        Timestamp endTime = Timestamp.valueOf(map.get("endTime"));
        String postImg = map.get("postImg");
        Integer ballId = Integer.parseInt(map.get("ballId"));
        Integer batNeedNumber = Integer.parseInt(map.get("batNeedNumber"));
        Integer ballNeedNumber = Integer.parseInt(map.get("ballNeedNumber"));
        Integer batOwnedNumber = Integer.parseInt(map.get("batOwnedNumber"));
        Integer ballOwnedNumber = Integer.parseInt(map.get("ballOwnedNumber"));
        Integer peopleCurrentNumber = Integer.parseInt(map.get("peopleCurrentNumber"));
        Integer peopleMinNumber = Integer.parseInt(map.get("peopleMinNumber"));
        Integer peopleMaxNumber = Integer.parseInt(map.get("peopleMaxNumber"));
        String initiatorNote = map.get("initiatorNote");
        String initiatorNoteDetails = map.get("initiatorNoteDetails");
        Integer state = Integer.parseInt(map.get("state"));

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("joiner_id",initiatorId);
        List<Joiner> joiners = joinerMapper.selectByMap(columnMap);

        for (Joiner joiner:joiners) {
            Integer joinedPostId = joiner.getPostId();
            Post joinedPost = postMapper.selectById(joinedPostId);
            if(!(beginTime.getTime()>joinedPost.getEndTime().getTime()
                    ||endTime.getTime()<joinedPost.getBeginTime().getTime()))return -1;
        }

        post.setPostId(postId);
        post.setBallId(ballId);
        post.setBeginTime(beginTime);
        post.setPostImg(postImg);
        post.setEndTime(endTime);
        post.setPostTime(postTime);
        post.setBallNeedNumber(ballNeedNumber);
        post.setBallOwnedNumber(ballOwnedNumber);
        post.setBatNeedNumber(batNeedNumber);
        post.setBatOwnedNumber(batOwnedNumber);
        post.setInitiatorId(initiatorId);
        post.setInitiatorNote(initiatorNote);
        post.setInitiatorNoteDetails(initiatorNoteDetails);
        post.setPeopleCurrentNumber(peopleCurrentNumber);
        post.setReserveId(reserveId);
        post.setPeopleMaxNumber(peopleMaxNumber);
        post.setPeopleMinNumber(peopleMinNumber);
        post.setState(state);

        return postMapper.insert(post);
    }
}
