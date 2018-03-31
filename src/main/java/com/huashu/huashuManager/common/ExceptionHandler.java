package com.huashu.huashuManager.common;

import com.alibaba.fastjson.JSONObject;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *  全局异常解析器，返回500
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    private View jsonErrorView = new View() {
        @Override
        public String getContentType() {
            return "application/json;charset=utf-8";
        }

        @Override
        public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            ResponseEntity<String> error = new ResponseEntity.Builder<String>().setCode(500).setMsg((String) model.get("errorMsg")).build();

            response.getWriter().write(JSONObject.toJSONString(error));
        }
    };

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView(jsonErrorView);
        String err = ex.getMessage();
        if (StringUtils.isBlank(err)) {
            err = "发生异常，请联系管理员";
        }
        mav.addObject("errorMsg", err);
        return mav;
    }
}
