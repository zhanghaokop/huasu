package com.huashu.huashuManager.common.file;

import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件服务控制器
 */
@Controller
@RequestMapping("file")
public class FileController {

    public static final String CONTENT_TYPE_OCTET = "application/octet-stream; charset=utf-8";
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";

    @Autowired
    private FileService fileService;

    /**
     * 多文件上传
     * @param file
     * @return
     */
    @PostMapping("upload")
    public @ResponseBody ResponseEntity<List<String>> upload(@RequestPart("file") MultipartFile[] file){
        List<String> result = new ArrayList<>(file.length);
        Arrays.stream(file).forEach(f ->{
            String fileName = f.getOriginalFilename();
            try {
                result.add(fileService.saveFileStream(fileName, f.getInputStream()));
            } catch (IOException e) {
                throw new IllegalStateException("上传文件出现异常,文件名称:" + fileName , e);
            }
        });
        return new ResponseEntity.Builder<List<String>>().setData(result).build();
    }

    /**
     * 单文件下载
     * @param fileName
     * @param response
     */
    @GetMapping("")
    public void download(String fileName, HttpServletResponse response){
        byte[] file = fileService.getFileByteArray(fileName);

        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader(HEADER_CONTENT_DISPOSITION, "attachment;filename=" + fileName + ";filename*=UTF-8''" + fileName);
            response.setContentType(CONTENT_TYPE_OCTET);
            response.getOutputStream().write(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("下载文件错误，" + fileName, e);
        }

    }

    /**
     * 单文件渲染
     * @param fileName
     * @param response
     */
    @GetMapping("/render")
    public void render(String fileName, HttpServletResponse response){
        byte[] file = fileService.getFileByteArray(fileName);
        try {
            response.getOutputStream().write(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("读取文件错误:" + fileName);
        }
    }

    /**
     * 文件删除
     * @param fileName
     * @return
     */
    @GetMapping("/delete")
    public @ResponseBody ResponseEntity<Boolean> delete(String fileName){
        return new ResponseEntity.Builder<Boolean>().setData(fileService.deleteFile(fileName)).build();
    }
}
