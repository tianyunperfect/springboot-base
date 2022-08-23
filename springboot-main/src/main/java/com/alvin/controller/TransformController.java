package com.alvin.controller;


import com.alvin.entity.Transform;
import com.alvin.service.ITransformService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
* <p>
    * 数据集数据转换 前端控制器
    * </p>
*
* @author tianyun
* @since 2022-08-23
*/
@RestController
@RequestMapping("/transform")
public class TransformController {

    @Resource
    private ITransformService transformService;

    @PostMapping
    public Boolean save(@RequestBody Transform transform) {
    return transformService.saveOrUpdate(transform);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
    return transformService.removeById(id);
    }

    @GetMapping
    public List<Transform> findAll() {
    return transformService.list();
    }

    @GetMapping("/{id}")
    public Transform findOne(@PathVariable Integer id) {
    return transformService.getById(id);
    }

    @GetMapping("/page")
    public Page<Transform> findPage(@RequestParam Integer pageNum,
    @RequestParam Integer pageSize) {
    return transformService.page(new Page<>(pageNum, pageSize));
    }
}
