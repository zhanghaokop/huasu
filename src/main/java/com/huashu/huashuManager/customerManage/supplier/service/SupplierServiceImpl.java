package com.huashu.huashuManager.customerManage.supplier.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.SupplierInfoMapper;
import com.huashu.huashuManager.model.SupplierInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierInfoMapper mapper;

    @Override
    public int deleteSupplier(String supplierId) {
        return mapper.deleteByPrimaryKey(supplierId);
    }

    @Override
    public int addSupplier(SupplierInfo supplierInfo) {
        return mapper.insert(supplierInfo);
    }

    @Override
    public PageEntity<SupplierInfo> pageListSuppliers(SupplierInfo supplierInfo) {
        PageEntity<SupplierInfo> page = new PageEntity<SupplierInfo>();
        page.setPageData(mapper.pageSelect(supplierInfo));
        return page;
    }

    @Override
    public List<SupplierInfo> getSupplier(SupplierInfo supplierInfo) {
        return mapper.pageSelect(supplierInfo);
    }

    @Override
    public SupplierInfo getSupplierById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateSupplier(SupplierInfo supplierInfo) {
        return mapper.updateByPrimaryKey(supplierInfo);
    }
}
