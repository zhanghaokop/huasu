package com.huashu.huashuManager.afterSaleManager.faultLib.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.ErrorCodeLibMapper;
import com.huashu.huashuManager.model.Customers;
import com.huashu.huashuManager.model.ErrorCodeLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FaultLibServiceImpl implements FaultLibService {

    @Autowired
    private ErrorCodeLibMapper mapper;

    @Override
    public int deleteErrorCode(String errorCodeId) {
        return mapper.deleteByPrimaryKey(errorCodeId);
    }

    @Override
    public int addErrorCode(ErrorCodeLib errorCode) {
        return mapper.insert(errorCode);
    }

    @Override
    public PageEntity<ErrorCodeLib> pageListErrorCodes(ErrorCodeLib errorCode) {

        PageEntity<ErrorCodeLib> entity = new PageEntity<>();
        entity.setPageData(mapper.pageSelect(errorCode));

        return entity;
    }

    @Override
    public List<ErrorCodeLib> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public ErrorCodeLib getErrorCodeById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateErrorCode(ErrorCodeLib errorCode) {
        return mapper.updateByPrimaryKey(errorCode);
    }
}
