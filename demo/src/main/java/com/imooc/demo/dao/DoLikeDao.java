package com.imooc.demo.dao;

import com.imooc.demo.entity.DoLike;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DoLikeDao {
    Integer insertDoLike(DoLike doLike);
    Integer deleteDoLike(DoLike doLike);
    List<DoLike> selectDoLikeByUserId(String userId);
}
