package com.skx.epublib.web.utils;

import com.skx.epublib.web.entity.Article;
import com.skx.epublib.web.entity.Content;
import com.skx.epublib.web.entity.Span;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    public static Article splitText(InputStream in, String encoding) throws IOException {
        // 输入流
        InputStreamReader read = new InputStreamReader(in, encoding);// 考虑到编码格
        BufferedReader bufferedReader = new BufferedReader(read);

        //目录
        Span span = new Span();
        //全文
        Article article = new Article();
        article.setSpan(span);

        //文本
        StringBuilder curText = new StringBuilder("");
        String curTitle = "前言";
        String content;

        int curInd = -1;

        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            // 正则表达式
            // 匹配卷
            Pattern p0 = Pattern.compile("(^\\s*第)(.{1,9})[卷集部篇](\\s{1})(.*)($\\s*)");
            // 匹配章节
            Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节回](\\s{1})(.*)($\\s*)");

            Matcher matcher = p0.matcher(lineTxt);
            Matcher matcher1 = p.matcher(lineTxt);

            if (matcher.find()) {
                if (!curText.isEmpty()) {
                    //写入完成章节
                    content = curText.toString();
                    article.put(curTitle, content);
                    curText.delete(0,curText.length());
                }

                curTitle = matcher.group().trim();

                curInd = span.addChapter(curTitle);
            }
            else if (matcher1.find()) {
                if (!curText.isEmpty()) {
                    //写入完成章节
                    content = curText.toString();
                    article.put(curTitle, content);
                    curText.delete(0,curText.length());
                }
                curTitle = matcher1.group().trim();

                if (curInd == -1) {
                    span.addChapter(curTitle);
                }
                else {
                    span.addChapter(curInd, curTitle);
                }
            }

            curText.append(lineTxt).append('\n');
        }
        bufferedReader.close();

        return article;
    }

    public static Article splitText(File file,String encoding) throws IOException {
        if (!file.isFile() || !file.exists()) { // 判断文件是否存在
            return null;
        }

        return splitText(new FileInputStream(file), encoding);
    }
}
