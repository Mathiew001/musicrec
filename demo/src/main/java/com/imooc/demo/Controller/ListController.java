package com.imooc.demo.Controller;

import com.imooc.demo.entity.DoLike;
import com.imooc.demo.entity.MusicRec;
import com.imooc.demo.entity.User;
import com.imooc.demo.service.DoLikeService;
import com.imooc.demo.service.MusicRecService;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/list")
public class ListController {
    @Autowired
    private UserService userService;

    @Autowired
    private MusicRecService musicRecService;

    @Autowired
    private DoLikeService doLikeService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/listall")
    public List<Map<String, Object>> getTotalList(@RequestParam(name = "pageSize")Integer pageSize,
                                                  @RequestParam(name = "pageNum")Integer pageNum,
                                                  @RequestParam(name = "userId")String userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<MusicRec> musicRecs = musicRecService.getListAll();
        for(int i = (pageNum-1)*pageSize; i < pageSize*pageNum && i < musicRecs.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            buidMap(map, musicRecs.get(i));
            addLike(map, musicRecs.get(i), userId);
            list.add(map);
        }
        return list;
    }

    @GetMapping(value = "/topthree")
    public List<Map<String, Object>> getTopThree(String userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<MusicRec> musicRecs = musicRecService.getListTopThree();
        for (MusicRec musicRec : musicRecs) {
            Map<String, Object> map = new HashMap<>();
            addMapInList(map, list, musicRec, userId);
        }
        return list;
    }

    @GetMapping(value = "/myrec")
    public List<Map<String, Object>> getMyRec(String userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<MusicRec> musicRecs = musicRecService.getListByUserId(userId);
        for (MusicRec musicRec : musicRecs) {
            Map<String, Object> map = new HashMap<>();
            addMapInList(map, list, musicRec, userId);
        }
        return list;
    }


    @GetMapping(value = "/hisrec")
    public List<Map<String, Object>> getHeLike(String myUserId, String hisUserId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<MusicRec> musicRecs = musicRecService.getListByUserId(hisUserId);
        for (MusicRec musicRec : musicRecs) {
            Map<String, Object> map = new HashMap<>();
            addMapInList(map, list, musicRec, myUserId);
        }
        return list;
    }

    @GetMapping(value = "/mylike")
    public List<Map<String, Object>> getMyLike(String userId) {
        List<DoLike> doLikes = doLikeService.getDoLikeByUserId(userId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (DoLike doLike : doLikes) {
            Map<String, Object> map = new HashMap<>();
            MusicRec musicRec = musicRecService.getListByMusicId(doLike.getMusicId());
            buidMap(map, musicRec);
            map.put("doLike", true);
            list.add(map);
        }
        return list;
    }

    private void addLike(Map<String, Object> map, MusicRec musicRec, String userId) {
        map.put("doLike", false);
        for (DoLike doLike : doLikeService.getDoLikeByUserId(userId)) {
            if (musicRec.getId().equals(doLike.getMusicId())) {
                map.put("doLike", true);
                break;
            }
        }
    }

    private void buidMap(Map<String, Object> map, MusicRec musicRec) {
        User user = userService.getByUserId(musicRec.getUserId());
        map.put("musicrec", musicRec);
        map.put("user", user);
    }

    private void addMapInList(Map<String, Object> map, List<Map<String, Object>> list,
                              MusicRec musicRec, String userId) {
        buidMap(map, musicRec);
        addLike(map, musicRec, userId);
        list.add(map);
    }
}
