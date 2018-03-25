package com.imooc.demo.Controller;

import com.imooc.demo.entity.MusicRec;
import com.imooc.demo.service.MusicRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    @Autowired
    private MusicRecService musicRecService;

    @GetMapping(value = "/upload")
    public Map<String, Integer> upload(@RequestParam(name = "musicSrc")String musicSrc,
                      @RequestParam(name = "posterSrc")String posterSrc,
                      @RequestParam(name = "musicName")String musicName,
                      @RequestParam(name = "musicAuthor")String musicAuthor,
                      @RequestParam(name = "userId")String userId,
                      @RequestParam(name = "musicComment")String musicComment) {
        Map<String, Integer> res = new HashMap<>();
        if("".equals(musicSrc.trim()))
            return setErrCode(res, 1);
        else if("".equals(musicName.trim()))
            return setErrCode(res, 2);
        else if("".equals(musicAuthor))
            return setErrCode(res, 3);
        else {
            MusicRec musicRec = new MusicRec();
            musicRec.setMusicAuthor(musicAuthor);
            musicRec.setMusicComment(musicComment);
            musicRec.setMusicName(musicName);
            musicRec.setMusicSrc(musicSrc);
            musicRec.setPosterSrc(posterSrc);
            musicRec.setSharedTime(new Date());
            musicRec.setUserId(userId);
            musicRecService.addMusicRec(musicRec);
            return setErrCode(res, 0);
        }
    }

    private Map<String, Integer> setErrCode(Map<String, Integer> res, Integer val) {
        res.put("errcode", val);
        return res;
    }
}
