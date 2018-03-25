package com.imooc.demo.service.impl;

import com.imooc.demo.dao.DoLikeDao;
import com.imooc.demo.dao.MusicRecDao;
import com.imooc.demo.entity.DoLike;
import com.imooc.demo.entity.MusicRec;
import com.imooc.demo.service.DoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoLikeServiceImpl implements DoLikeService {

    @Autowired
    private DoLikeDao doLikeDao;

    @Autowired
    private MusicRecDao musicRecDao;

//    @Transactional
//    @Override
//    public Integer addDoLike(DoLike doLike) {
//
//        return doLikeDao.insertDoLike(doLike);
//    }
//
//    @Override
//    @Transactional
//    public Integer moveDoLike(DoLike doLike) {
//        return doLikeDao.deleteDoLike(doLike);
//    }

    @Override
    public List<DoLike> getDoLikeByUserId(String userId) {
        return doLikeDao.selectDoLikeByUserId(userId);
    }

    @Override
    @Transactional
    public Integer increaseLikeNumberAndAddDoLike(Integer musicId, DoLike doLike) {
        Integer u = musicRecDao.increaseLikeNumberByMusicId(musicId);
        Integer i = doLikeDao.insertDoLike(doLike);
        if(u != null && i !=null)
            return 1;
        else
            return 0;
    }

    @Override
    @Transactional
    public Integer reduceLikeNumberAndMoveDoLike(Integer musicId, DoLike doLike) {
        Integer r = musicRecDao.reduceLikeNumberByMusicId(musicId);
        Integer d = doLikeDao.deleteDoLike(doLike);
        if(r != null && d !=null)
            return 1;
        else
            return 0;
    }
}
