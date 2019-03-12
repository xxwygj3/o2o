package com.testssm.o2o.util;

import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(CodeUtil.class);
    /**
     * 后台获取验证码的信息和前台的验证码对比
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request, HttpSession session){
        // 获取生成的验证码
        String verifyCodeExpected = (String) session.getAttribute("code");
        // 获取用户输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if(verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)){
            return false;
        }
        return true;
    }
}
