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

        PageEntity page = null;
        if (state != null) {
            page = (PageEntity) state.getAttr("pageEntity");
        }

        if (page == null) {
            //未携带参数默认展示第一页10条数据.
            page = new PageEntity();
        }
        PageHelper.startPage(page.getPageIndex(), page.getPageSize());
    }

    @After("pageList()")
    public void doAfter(){
        PageHelper.clearPage();
    }
}
