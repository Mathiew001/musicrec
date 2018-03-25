package com.imooc.demo.service;

import com.imooc.demo.entity.MusicRec;

import java.util.List;

public interface MusicRecService {
    void addMusicRec(MusicRec musicRec);
    List<MusicRec> getListAll();
    List<MusicRec> getListTopThree();
    List<MusicRec> getListByUserId(String userId);
    MusicRec getListByMusicId(Integer musicId);
}
