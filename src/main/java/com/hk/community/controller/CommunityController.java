package com.hk.community.controller;


import com.hk.community.Service.UserService;
import com.hk.community.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * created by hk on 2019/9/28 11:48
 */
@Controller
public class CommunityController {
    private UserService userService;

    @Autowired
    public CommunityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        if (userId != null) {
            UserDto user = userService.getUserInfoByUserId(userId);
            model.addAttribute("username", user.getUsername());
        }
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(@RequestParam(name="username") String username, @RequestParam(name="passwd") String passwd
            , HttpServletRequest request, Model model) {
        List<UserDto> userList = this.userService.getUserInfoByUsername(username);
        if (userList.isEmpty()) {
            model.addAttribute("error", "用户名不存在");
            return "login";
        }
        UserDto user = null;
        for (UserDto u: userList) {
            if (passwd.equals(u.getPasswd())) {
                user = u;
            }
        }
        if (user == null) {
            model.addAttribute("error", "密码错误");
            return "login";
        }
        request.getSession().setAttribute("userId", user.getUserId());
        return "redirect:/";
    }
}
