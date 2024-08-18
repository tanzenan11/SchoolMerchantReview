package com.cmr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cmr.dto.LoginFormDTO;
import com.cmr.dto.Result;
import com.cmr.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 谭泽楠
 * @since 2024-8-4
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    /**
     * 签到功能
     * @return
     */
    Result sign();

    /**
     * 签到统计
     * @return
     */
    Result signCount();
}
