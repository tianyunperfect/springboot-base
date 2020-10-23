package com.alvin.controller;

import com.alvin.common.entity.PageResult;
import com.alvin.common.entity.Result;
import com.alvin.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/user")
public class AppController {

    /**
     * 找到一个
     *
     * @return {@link Result<User>}
     */
    @GetMapping("/findOne")
    public Result<User> findOne() {
        User user = new User();
        user.setName("小米");
        user.setAge(18);
        log.info(user.toString());
        return Result.success(user);
    }

    @GetMapping("/queryPage")
    public Result<PageResult<User>> queryPage() {
        User user = new User();
        user.setName("小米");
        user.setAge(18);
        PageResult<User> pageResult = new PageResult<>(1, 10, 100L, Collections.singletonList(user));
        return Result.success(pageResult);
    }

}
