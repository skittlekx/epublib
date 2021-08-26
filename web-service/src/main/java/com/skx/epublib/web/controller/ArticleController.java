package com.skx.epublib.web.controller;

import com.skx.epublib.web.entity.Article;
import com.skx.epublib.web.entity.RespData;
import com.skx.epublib.web.service.ArticleService;
import com.skx.epublib.web.utils.StringUtils;
import com.skx.epublib.web.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/chapter/{ind}")
    @CrossOrigin
    public RespData getChapter(@PathVariable(name = "ind", required = true) int ind) {
        return articleService.getChapter(ind);
    }

    @PostMapping("/upload")
    @CrossOrigin
    public RespData upload(@RequestParam("filename") MultipartFile file) {
        if (file.isEmpty()) {
            return RespData.FAIL("上传失败！！！");
        }

        int size = (int)file.getSize();
        try {
            InputStream inputStream = file.getInputStream();
            return articleService.uploadArticle(inputStream);
        } catch (IOException e) {
            return RespData.FAIL("解析失败！！！", e);
        }
    }
}
