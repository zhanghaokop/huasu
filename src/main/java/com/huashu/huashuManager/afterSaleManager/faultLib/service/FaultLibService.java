package com.huashu.huashuManager.afterSaleManager.faultLib.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.ErrorCodeLib;

import java.util.List;

public interface FaultLibService {
    /**
     * 删除错误代码
     * @param errorCodeId
     * @return
     */
    int deleteErrorCode(String errorCodeId);

    /**
     * 新增错误代码
     * @param errorCode
     * @return
     */
    int addErrorCode(ErrorCodeLib errorCode);

    /**
     * 列表错误代码
     * @param errorCode
     * @return
     */
    PageEntity<ErrorCodeLib> pageListErrorCodes(ErrorCodeLib errorCode);

    List<ErrorCodeLib> selectAll();

    /**
     * 根据错误代码id获取错误代码
     * @param id
     * @return
     */
    ErrorCodeLib getErrorCodeById(String id);

    /**
     * 更新错误代码
     * @param errorCode
     * @return
     */
    int updateErrorCode(ErrorCodeLib errorCode);

}
