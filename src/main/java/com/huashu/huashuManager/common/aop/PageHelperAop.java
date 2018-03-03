package com.huashu.huashuManager.common.aop;

import com.github.pagehelper.PageHelper;
import com.huashu.huashuManager.auth.SessionState;
import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.PageEntity;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 分页插件
 */
@Aspect
@Component
public class PageHelperAop {

    @Pointcut("execution(public * com.huashu.huashuManager..*.service.*.pageList*(..))")
    public void pageList(){}

    @Before("pageList()")
    public void doBefore() throws Throwable {
        SessionState state = SessionStateHolder.get();
        if (state != null) {
            PageEntity entity = (PageEntity) state.getAttr("pageEntity");

            PageHelper.startPage(entity.getPageIndex(), entity.getPageSize());

        }
    }

    @After("pageList()")
    public void doAfter(){
        PageHelper.clearPage();
    }
}
