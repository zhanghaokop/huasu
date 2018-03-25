package com.huashu.huashuManager.afterSaleManager.faultLib.controller;

import com.huashu.huashuManager.afterSaleManager.faultLib.service.FaultLibService;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.model.ErrorCodeLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 故障代码库控制器
 */
@RestController
@RequestMapping("faultLib")
public class FaultLibController {

    @Autowired
    private FaultLibService faultLibService;

    /**
     * 分页根据条件模糊查询返回错误代码集合
     * @param fault
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<PageEntity<ErrorCodeLib>> listFaults(ErrorCodeLib fault){
        return new ResponseEntity.Builder<PageEntity<ErrorCodeLib>>().setData(faultLibService.pageListErrorCodes(fault)).build();
    }

    /**
     * 获取全部错误代码集合
     * @return
     */
    @GetMapping("listAll")
    public ResponseEntity<List<ErrorCodeLib>> listAll(){
        return new ResponseEntity.Builder<List<ErrorCodeLib>>().setData(faultLibService.selectAll()).build();
    }

    /**
     * 根据错误代码Id获取错误代码信息
     * @param faultId
     * @return
     */
    @GetMapping("/{faultId}")
    public ResponseEntity<ErrorCodeLib> getFaultById(@PathVariable("faultId") String faultId){
        return new ResponseEntity.Builder<ErrorCodeLib>().setData(faultLibService.getErrorCodeById(faultId)).build();
    }

    /**
     * 新增错误代码
     * @param errorCodeLib
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<String> addFault(@RequestBody ErrorCodeLib errorCodeLib){

        String id = UUIDUtils.getUUID();
        errorCodeLib.setId(id);
        faultLibService.addErrorCode(errorCodeLib);

        return new ResponseEntity.Builder<String>().setData(id).build();
    }

    /**
     * 根据错误代码Id更新错误代码信息
     * @param fault
     * @return
     */
    @PostMapping("update")
    public ResponseEntity<Boolean> updateFault(@RequestBody ErrorCodeLib fault){
        return new ResponseEntity.Builder<Boolean>().setData(faultLibService.updateErrorCode(fault) > 0).build();
    }

    /**
     * 根据错误代码Id删除错误代码
     * @param faultId
     * @return
     */
    @GetMapping("/delete/{faultId}")
    public ResponseEntity<Boolean> deleteFault(@PathVariable("faultId") String faultId){
        return new ResponseEntity.Builder<Boolean>().setData(faultLibService.deleteErrorCode(faultId) > 0).build();
    }

}
