package com.skx.epublib.web.controller;

import com.skx.epublib.web.entity.RespData;
import com.skx.epublib.web.entity.User;
import com.skx.epublib.web.service.UserService;
import com.skx.epublib.web.utils.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin
    public RespData login(String loginName,String passWord) {
        if(loginName == null || passWord == null){
            int contentLength = request.getContentLength();
            byte[] buffer = new byte[contentLength];

            try {
                request.getInputStream().read(buffer,0,contentLength);
                String json = new String(buffer);
                Map<String,Object> param = StringUtils.parseJSON(json);

                loginName = (String)param.get("loginName");
                passWord = (String)param.get("passWord");
            }
            catch (Exception e){
                return RespData.FAIL(e.getMessage());
            }
        }

        System.out.println(loginName + ":" + passWord);

        if(userService.checkUser(loginName,passWord)){
            User user = userService.selectByName(loginName);
            return RespData.OK(user);
        }
        else
            return RespData.FAIL("登录失败！！！");
    }
}
