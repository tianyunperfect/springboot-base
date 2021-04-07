package com.alvin.controller;

import com.alvin.annotation.ResponseResult;
import com.alvin.common.entity.PageResult;
import com.alvin.common.entity.Result;
import com.alvin.entity.User;
import com.alvin.service.AppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/user")
@ResponseResult
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {
    private final AppService appService;

    /**
     * 找到一个
     *
     * @return {@link Result<User>}
     */
    @ResponseResult
    @GetMapping("/findOne")
    public User findOne() {
        User user = new User();
        user.setName("小米");
        user.setAge(18);
        log.info(user.toString());
        return user;
    }

    @GetMapping("/queryPage")
    public PageResult<User> queryPage() {
        User user = new User();
        user.setName("小米");
        user.setAge(18);
        PageResult<User> pageResult = new PageResult<>(1, 10, 100L, Collections.singletonList(user));
        return pageResult;
    }

}
