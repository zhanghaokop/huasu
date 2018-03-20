package com.huashu.huashuManager.customerManage.supplier.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.SupplierInfo;

import java.util.List;

public interface SupplierService {

    /**
     * 删除供应商
     * @param supplierId
     * @return
     */
    int deleteSupplier(String supplierId);

    /**
     * 新增供应商
     * @param supplierInfo
     * @return
     */
    int addSupplier(SupplierInfo supplierInfo);

    /**
     * 列表供应商
     * @param supplierInfo
     * @return
     */
    PageEntity<SupplierInfo> pageListSuppliers(SupplierInfo supplierInfo);

    /**
     * 获取供应商
     * @param supplierInfo
     * @return
     */
    List<SupplierInfo> getSupplier(SupplierInfo supplierInfo);

    /**
     * 根据供应商id获取供应商
     * @param id
     * @return
     */
    SupplierInfo getSupplierById(String id);

    /**
     * 更新供应商
     * @param supplierInfo
     * @return
     */
    int updateSupplier(SupplierInfo supplierInfo);
}
