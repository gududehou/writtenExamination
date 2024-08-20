package com.tianyuan.service.impl;

import com.tianyuan.service.LoginService;
import com.tianyuan.vo.LoginVo;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    /**
     * this method to Login
     *
     * @param loginVo
     * @return
     */
    @Override
    public Boolean login(LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        if ("test".equals(username) && "123456".equals(password)) {
            return true;
        }
        return false;
    }
}
