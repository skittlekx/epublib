package com.skx.epublib.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("log")
public class Log {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField
    private int aid;

    @TableField
    private int uid;

    @TableField
    private Date date;

    @TableField
    private String desc;
}
