package com.skx.epublib.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skx.epublib.web.entity.User;
import com.skx.epublib.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public boolean checkUser(String userName,String passWord) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userName)
                .eq("password",passWord);

        User user = baseMapper.selectOne(wrapper);
        return user != null;
    }

    public User selectByName(String name) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username",name));
    }

}
