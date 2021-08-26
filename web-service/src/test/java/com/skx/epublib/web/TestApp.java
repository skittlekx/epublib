package com.skx.epublib.web;

import com.skx.epublib.web.entity.Article;
import com.skx.epublib.web.entity.User;
import com.skx.epublib.web.mapper.UserMapper;
import com.skx.epublib.web.utils.StringUtils;
import com.skx.epublib.web.utils.TextUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
public class TestApp {
    @Test
    public void test1() {
        System.out.println(StringUtils.sayHello());
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapper() {
        System.out.println(new Date());
        User user = new User(-1,"test","test","test",new Date(),0);
//        System.out.println(user.toString());
//        userMapper.insert(user);
        int delete = userMapper.delete(null);
        System.out.println(delete);
        List<User> userPage = userMapper.selectList(null);

        userPage.forEach(System.out::println);

    }
    @Test
    public void testzz(){
        String str = "abcaaaaaaaaaaa";

        Pattern p = Pattern.compile("ab");
        Matcher matcher = p.matcher(str);
        Matcher matcher2 = p.matcher(str);

        System.out.println(matcher);
        System.out.println(matcher2);

    }
    @Test
    public void testText() throws IOException {
        File file = new File("C:\\Users\\skittle\\IdeaProjects\\epublib\\web-service\\寒天帝.txt");
        String enCoding = "UTF-8";

        Article article = TextUtils.splitText(file, enCoding);

        article.coverHtml();
//        System.out.println(article);
        System.out.println("Span : ");
        System.out.println(article.getSpan().getChild());

    }
}
