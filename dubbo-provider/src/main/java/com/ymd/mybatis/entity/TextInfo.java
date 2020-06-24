package com.ymd.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@TableName("text_info")
public class TextInfo implements Serializable {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("text_name")
    private String textName;

    @TableField("text_value")
    private String textValue;


}
