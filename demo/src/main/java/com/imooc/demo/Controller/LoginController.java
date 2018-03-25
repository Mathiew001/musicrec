package com.imooc.demo.Controller;

import com.imooc.demo.entity.User;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/login")
    public void login(@RequestParam(name = "userId")String userId,
                      @RequestParam(name = "nickName")String nickName,
                      @RequestParam(name = "city")String city,
                      @RequestParam(name = "province")String province,
                      @RequestParam(name = "country")String country,
                      @RequestParam(name = "avatarUrl")String avatarUrl) {
        if(null == userService.getByUserId(userId)) {
            User user = new User();
            user.setAvatarUrl(avatarUrl);
            user.setCity(city);
            user.setCountry(country);
            user.setNickName(nickName);
            user.setProvince(province);
            user.setUserId(userId);
            userService.addUser(user);
        }
    }
}
