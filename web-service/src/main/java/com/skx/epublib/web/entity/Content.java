package com.skx.epublib.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class Content {
    private int id;
    private String name;
    private String content;
    private boolean hasChild;
}
