package com.huashu.huashuManager.customerManage.supplier.controller;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.supplier.service.SupplierService;
import com.huashu.huashuManager.model.SupplierInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商管理控制器
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 分页模糊查询供应商列表
     * @param supplierInfo 模糊查询参数
     * @return 查询结果结合
     */
    @GetMapping("/list")
    public ResponseEntity<PageEntity<SupplierInfo>> pageListSupplier(SupplierInfo supplierInfo){
        return new ResponseEntity.Builder<PageEntity<SupplierInfo>>().setData(supplierService.pageListSuppliers(supplierInfo)).build();
    }

    /**
     * 根据供应商Id获取供应商信息
     * @param supplierId 供应商Id
     * @return 供应商
     */
    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierInfo> getSupplierById(@PathVariable String supplierId){
        return new ResponseEntity.Builder<SupplierInfo>().setData(supplierService.getSupplierById(supplierId)).build();
    }

    /**
     * 新增供应商
     * @param supplierInfo 供应商信息
     * @return 主键Id
     */
    @PostMapping("/add")
    public ResponseEntity<String> addSupplier(@RequestBody SupplierInfo supplierInfo){
        String id = UUIDUtils.getUUID();
        supplierInfo.setId(id);
        supplierService.addSupplier(supplierInfo);

        return new ResponseEntity.Builder<String>().setData(id).build();
    }

    /**
     * 根据主键Id更新供应商
     * @param supplierInfo 待更新供应商，主键id
     * @return 是否成功
     */
    @PostMapping("update")
    public ResponseEntity<Boolean> updateSupplierById(@RequestBody SupplierInfo supplierInfo){
        return new ResponseEntity.Builder<Boolean>().setData(supplierService.updateSupplier(supplierInfo) > 0).build();
    }

    /**
     * 根据供应商Id 删除供应商
     * @param supplierId 供应商Id
     * @return 操作是否成功
     */
    @GetMapping("/delete/{supplierId}")
    public ResponseEntity<Boolean> deleteSupplierByID(@PathVariable String supplierId){
        return new ResponseEntity.Builder<Boolean>().setData(supplierService.deleteSupplier(supplierId) > 0).build();
    }

}
