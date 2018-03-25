package com.imooc.demo.service;

import com.imooc.demo.entity.DoLike;

import java.util.List;

public interface DoLikeService {
    List<DoLike> getDoLikeByUserId(String userId);
    Integer increaseLikeNumberAndAddDoLike(Integer musicId, DoLike doLike);
    Integer reduceLikeNumberAndMoveDoLike(Integer musicId, DoLike doLike);
}
