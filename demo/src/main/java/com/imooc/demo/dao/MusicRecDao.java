package com.imooc.demo.dao;

import com.imooc.demo.entity.MusicRec;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MusicRecDao {
    void insertMusicRec(MusicRec musicRec);
    List<MusicRec> queryListAll();
    List<MusicRec> queryListTopThree();
    List<MusicRec> queryListByUserId(String userId);
    Integer increaseLikeNumberByMusicId(Integer musicId);
    Integer reduceLikeNumberByMusicId(Integer musicId);
    MusicRec queryListByMusicId(Integer musicId);
}
