package com.huashu.huashuManager.common.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.huashuManager.auth.SessionState;
import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.Customers;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页插件
 */
@Aspect
@Component
public class PageHelperAop {

    @Pointcut("execution(public * com.huashu.huashuManager..*.service.*.pageList*(..))")
    public void pageList(){}

//    @Before("pageList()")
//    public void doBefore() throws Throwable {
//        SessionState state = SessionStateHolder.get();
//
//        PageEntity page = null;
//        if (state != null) {
//            page = (PageEntity) state.getAttr("pageEntity");
//        }
//
//        if (page == null) {
//            //未携带参数默认展示第一页10条数据.
//            page = new PageEntity();
//        }
//        PageHelper.startPage(page.getPageIndex(), page.getPageSize());
//    }
//
//    @After("pageList()")
//    public void doAfter(){
//        PageHelper.clearPage();
//    }

    @Around("pageList()")
    public PageEntity pageCount(ProceedingJoinPoint pjp) throws Throwable {
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

        PageEntity<?> entity = (PageEntity<?>) pjp.proceed();

        PageInfo<Object> pageinfo = new PageInfo<Object>((List<Object>) entity.getPageData());
        PageHelper.clearPage();

        return  page.setCount(pageinfo.getTotal()).setPageData(entity.getPageData());
    }
}
