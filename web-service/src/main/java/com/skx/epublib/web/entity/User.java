package com.skx.epublib.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField("username")
    private String userName;

    @TableField("password")
    private String passWord;

    @TableField("salt")
    private String salt;

    @TableField("registerdate")
    private Date registerDate;

    @TableField("type")
    private int type;
}
