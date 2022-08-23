package com.alvin.service.impl;

import com.alvin.entity.Transform;
import com.alvin.mapper.TransformMapper;
import com.alvin.service.ITransformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 数据集数据转换 服务实现类
 * </p>
 *
 * @author tianyun
 * @since 2022-08-23
 */
@Service
public class TransformServiceImpl extends ServiceImpl<TransformMapper, Transform> implements ITransformService {

  @Resource
  private TransformMapper transformMapper;
}
