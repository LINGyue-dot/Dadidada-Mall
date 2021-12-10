package com.jc.service.impl;


import com.jc.entity.pojo.Joiner;
import com.jc.entity.pojo.Post;
import com.jc.mapper.JoinerMapper;
import com.jc.mapper.PostMapper;
import com.jc.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JoinerServiceImpl implements JoinerService {

    @Autowired
    private JoinerMapper joinerMapper;

    @Autowired
    private PostMapper postMapper;


    @Override
    public Integer addApplicant(Joiner joiner) {
        joiner.setState(2);
        joinerMapper.insert(joiner);
        return joiner.getJoinerId();
    }


    @Override
    public Integer solve(Map<String, String> map) {
        Map<String,Object> findMap = new HashMap<>();
        Integer postId = Integer.parseInt(map.get("postId"));
        findMap.put("joiner_id",Integer.parseInt(map.get("userId")));
        findMap.put("post_id",postId);
        Joiner joiner = joinerMapper.selectByMap(findMap).get(0);

        Post post = postMapper.selectById(postId);

        String flag = map.get("flag");
        if(flag.equals("true")){
            joiner.setState(1);

            Integer batOffer = joiner.getBatOffer();
            Integer ballOffer = joiner.getBallOffer();

            post.setPeopleCurrentNumber(post.getPeopleCurrentNumber()+1);
            post.setBatOwnedNumber(post.getBatOwnedNumber()+batOffer);
            post.setBallOwnedNumber(post.getBallOwnedNumber()+ballOffer);

            postMapper.updateById(post);

            return joinerMapper.update(joiner.getJoinerId(),postId);
        }
        else return joinerMapper.deleteById(joiner);
    }

}
