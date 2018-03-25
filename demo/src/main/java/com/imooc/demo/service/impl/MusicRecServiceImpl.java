package com.imooc.demo.service.impl;

import com.imooc.demo.dao.MusicRecDao;
import com.imooc.demo.entity.MusicRec;
import com.imooc.demo.service.MusicRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicRecServiceImpl implements MusicRecService {

    @Autowired
    private MusicRecDao musicRecDao;

    @Transactional
    @Override
    public void addMusicRec(MusicRec musicRec) {
        musicRecDao.insertMusicRec(musicRec);
    }

    @Override
    public List<MusicRec> getListAll() {
        return musicRecDao.queryListAll();
    }

    @Override
    public List<MusicRec> getListTopThree() {
        return musicRecDao.queryListTopThree();
    }

    @Override
    public List<MusicRec> getListByUserId(String userId) {
        return musicRecDao.queryListByUserId(userId);
    }

    @Override
    public MusicRec getListByMusicId(Integer musicId) {
        return musicRecDao.queryListByMusicId(musicId);
    }
}
