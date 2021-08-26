package com.skx.epublib.web.service;

import com.skx.epublib.web.entity.Article;
import com.skx.epublib.web.entity.RespData;
import com.skx.epublib.web.entity.Span;
import com.skx.epublib.web.utils.TextUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ArticleService {
    private Article article = null;

    public RespData getChapter(int ind) {
        if(article != null) {
            String name = article.getSpan().getChild().get(ind).getName();
            String content = article.getHtmlContent(name);
            return RespData.OK(content);
        }
        else
            return RespData.FAIL("未上传文档！！！");
    }

    public RespData uploadArticle(InputStream in) {
        try {
            article = TextUtils.splitText(in,"utf-8");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    article.coverHtml();
                }
            }).start();
            return RespData.OK("解析成功！！！", article.getSpan().getChild());
        } catch (IOException e) {
            return RespData.FAIL(e.getMessage());
        }
    }
}
