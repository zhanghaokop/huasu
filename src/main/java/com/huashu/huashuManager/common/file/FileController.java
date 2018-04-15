package com.huashu.huashuManager.common.file;

import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping({"file","/wxgzh/file"})
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
    public @ResponseBody ResponseEntity<List<String>> upload(HttpServletRequest request, @RequestPart("file") MultipartFile[] file){

        List<String> result = new ArrayList<>(file.length);

        String finalImgFolder = getImgFolder(request);

        Arrays.stream(file).forEach(f ->{
            String fileName = f.getOriginalFilename();
            try {
                result.add(fileService.saveFileStream(finalImgFolder, fileName, f.getInputStream()));
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
    public void download(HttpServletRequest request, String fileName, HttpServletResponse response){

        String imgFolder = getImgFolder(request);

        byte[] file = fileService.getFileByteArray(imgFolder, fileName);

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
    public void render(HttpServletRequest request, String fileName, HttpServletResponse response){

        String imgFolder = getImgFolder(request);

        byte[] file = fileService.getFileByteArray(imgFolder, fileName);
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
    public @ResponseBody ResponseEntity<Boolean> delete(HttpServletRequest request, String fileName){
        String imgFolder = getImgFolder(request);

        return new ResponseEntity.Builder<Boolean>().setData(fileService.deleteFile(imgFolder, fileName)).build();
    }

    private String getImgFolder(HttpServletRequest request){
        String uri = request.getRequestURI();

        boolean isWxUpload = uri.contains("wxgzh/");

        //上传目录     upload/wechat/openid*    upload/web/userid/*
        String imgFolder =  "upload/";

        if (isWxUpload) {
            //wx上传
            String openId = (String) SessionStateHolder.get().getAttr("openId");
            imgFolder = "wechat/" + openId;
        } else {
            //web上传
            String userId = SessionStateHolder.getUser().getId();
            imgFolder = "web/" + userId;

        }

        return imgFolder;

    }
}
