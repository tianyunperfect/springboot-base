package com.alvin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据集数据转换
 * </p>
 *
 * @author tianyun
 * @since 2022-08-23
 */
@Getter
@Setter
public class Transform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据集编码
     */
    private String setCode;

    /**
     * 数据转换类型，DIC_NAME=TRANSFORM_TYPE; js，javaBean，字典转换
     */
    private String transformType;

    /**
     * 数据转换script,处理逻辑
     */
    private String transformScript;

    /**
     * 排序,执行数据转换顺序
     */
    private Integer orderNum;

    /**
     * 0--已禁用 1--已启用  DIC_NAME=ENABLE_FLAG
     */
    private Integer enableFlag;

    /**
     * 0--未删除 1--已删除 DIC_NAME=DELETE_FLAG
     */
    private Integer deleteFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Integer version;


}
