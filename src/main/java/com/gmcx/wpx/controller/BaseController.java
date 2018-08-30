package com.gmcx.wpx.controller;

import com.gmcx.wpx.model.BaseResModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wpx on 2017/8/7.
 * 统一的异常处理
 */
@ControllerAdvice
public abstract class BaseController {
    @ExceptionHandler(value = Exception.class)
    public BaseResModel<Map<String, Object>> defaultErrorHandler(HttpServletRequest httpServletRequest, Exception exception) {
        // 如果异常使用了ResponseStatus注解，那么重新抛出该异常，Spring框架会处理该异常。
        BaseResModel<Map<String, Object>> model = new BaseResModel<Map<String, Object>>();
        model.setCode(400);
        model.setMsg("异常信息");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("url", httpServletRequest.getRequestURI());

        //获取详细异常信息
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        exception.printStackTrace(pw);
        pw.flush();
        sw.flush();
        map.put("errDetailMsg", sw.toString());

        //获取基本异常信息
        map.put("errMsg", exception.toString());

        model.setData(map);
        return model;
    }
}
