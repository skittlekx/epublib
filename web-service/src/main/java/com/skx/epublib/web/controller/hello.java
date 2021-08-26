package com.skx.epublib.web.controller;

import com.skx.epublib.web.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class hello {

    @ResponseBody
    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
    public String sayHello() {
        return StringUtils.sayHello();
    }
}
