package com.imooc.demo.Controller;

import com.imooc.demo.entity.DoLike;
import com.imooc.demo.service.DoLikeService;
import com.imooc.demo.service.MusicRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoLikeController {

    @Autowired
    private DoLikeService doLikeService;

    @Autowired
    private MusicRecService musicRecService;

    @GetMapping(value = "/like")
    public Integer doLike(@RequestParam(name = "userId")String userId,
                          @RequestParam(name = "musicId")Integer musicId,
                          @RequestParam(name = "doLike")String like) {
        DoLike doLike = new DoLike();
        doLike.setUserId(userId);
        doLike.setMusicId(musicId);
        if("true".equals(like)) {
            if(doLikeService.reduceLikeNumberAndMoveDoLike(musicId, doLike) == 1) {
                System.out.println("true");
                Integer res = musicRecService.getListByMusicId(musicId).getLikeNumber();
                return res;
            }
            else {
                return 0;
            }
        }
        else {
            if(doLikeService.increaseLikeNumberAndAddDoLike(musicId, doLike) == 1) {
                Integer res = musicRecService.getListByMusicId(musicId).getLikeNumber();
                return res;
            }
            else {
                return 0;
            }
        }
    }
}
