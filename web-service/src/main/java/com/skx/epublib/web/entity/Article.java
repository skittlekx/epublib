package com.skx.epublib.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@TableName("article")
public class Article {

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField
    private String title;

    @TableField
    private String author;

    @TableField
    private String content;

    @TableField(exist = false)
    private Span span;

    @TableField(exist = false)
    private Map<String, String> contents = new HashMap<>();

    @TableField(exist = false)
    private Map<String, String> contentsHtml = new HashMap<>();

    @TableField(exist = false)
    private boolean hasHtml = false;

    public boolean put(String title, String content) {
        if(contents.containsKey(title)) {
            return false;
        }
        return contents.put(title, content) != null;
    }

    public String getContent(String title) {
        return contents.getOrDefault(title,null);
    }

    public String getHtmlContent(String title) {
        return contentsHtml.getOrDefault(title,null);
    }

    public void coverHtml() {
        contents.forEach((k,v) -> {
            StringBuilder sb = new StringBuilder();
            String[] split = v.split("\n");

            sb.append("<h1>").append(split[0]).append("</h1>");

            for (int i = 1; i < split.length; i++) {
                sb.append("<p>").append(split[i]).append("</p>");
            }
            contentsHtml.put(k,sb.toString());
        });

        hasHtml = true;
    }
}
