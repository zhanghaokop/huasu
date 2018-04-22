package com.huashu.huashuManager.common.file.service;

import com.huashu.huashuManager.common.utils.UUIDUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    /**
     * 文件上传存储文件夹
     */
    @Value("${huasu.file.storageDir:files}")
    private String fileDepositaryDir;

    private Path fileDepositary;

    @PostConstruct
    public void init(){
        //初始化
        Assert.notNull(fileDepositaryDir, "文件上传存储目录路径不能为空,请正确配置huasu.file.storageDir值");

        try {
            Path classesPath = Paths.get(FileServiceImpl.class.getResource("/").toURI());

            fileDepositary = classesPath.resolve(fileDepositaryDir);

            if(Files.notExists(fileDepositary)){
                Files.createDirectory(fileDepositary);
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String saveFileByteArray(String fileName, byte[] content) {

        String fileId = UUIDUtils.getUUID();

        Path filePath = fileDepositary.resolve(fileId);
        if (Files.exists(filePath)) {
            throw new IllegalArgumentException(String.format("存在同名称文件[%s]，请修改名称再上传", fileId));
        }
        try {
            Files.createFile(filePath);
            Files.write(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileId;
    }

    @Override
    public String saveFileStream(String fileName, InputStream is) {

        String suffix = fileName.split("\\.")[1];

        String fileId = UUIDUtils.getUUID() + "." + suffix;

        Path filePath = fileDepositary.resolve(fileId);
        if (Files.exists(filePath)) {
            throw new IllegalArgumentException(String.format("存在同名称文件[%s]，请修改名称再上传", fileId));
        }
        try {
            Files.createFile(filePath);
            FileUtils.copyInputStreamToFile(is, filePath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileId;

    }

    private Path getFileFolder(String folder){

        Path folderPath = fileDepositary.resolve(folder);

        if(Files.notExists(folderPath)) {
            try {
                Files.createDirectories(folderPath);
            } catch (IOException e) {
                throw new IllegalArgumentException("创建文件夹失败" + e);
            }
        }

        return folderPath;
    }

    @Override
    public String saveFileStream(String folder, String fileName, InputStream is) {

        Path folderPath = getFileFolder(folder);

        String fileId = UUIDUtils.getUUID();

        if (fileName.contains(".")) {
            String suffix = fileName.split("\\.")[1];

            fileId = fileId + "." + suffix;

        }

        Path filePath = folderPath.resolve(fileId);

        if (Files.exists(filePath)) {
            throw new IllegalArgumentException(String.format("存在同名称文件[%s]，请修改名称再上传", fileId));
        }
        try {
            Files.createFile(filePath);
            FileUtils.copyInputStreamToFile(is, filePath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileId;
    }

    @Override
    public byte[] getFileByteArray(String fileName) {
        Path filePath = fileDepositary.resolve(fileName);
        if (Files.notExists(filePath)) {
            throw new IllegalArgumentException(String.format("下载文件[%s]不存在", fileName));
        }
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new IllegalArgumentException("读取文件异常", e);
        }
    }

    @Override
    public byte[] getFileByteArray(String folder, String fileName) {
        Path folderPath = getFileFolder(folder);
        Path filePath = folderPath.resolve(fileName);
        if (Files.notExists(filePath)) {
            throw new IllegalArgumentException(String.format("下载文件[%s]不存在", fileName));
        }
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new IllegalArgumentException("读取文件异常", e);
        }
    }

    @Override
    public boolean exist(String fileName) {
        Path filePath = fileDepositary.resolve(fileName);

        return Files.exists(filePath);
    }

    @Override
    public boolean exist(String folder, String fileName) {
        Path folderPath = getFileFolder(folder);
        Path filePath = folderPath.resolve(fileName);


        return Files.exists(filePath);
    }

    @Override
    public boolean deleteFile(String fileName) {
        Path filePath = fileDepositary.resolve(fileName);

        try {
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new IllegalArgumentException("删除文件错误:" + fileName);
        }
    }

    @Override
    public boolean deleteFile(String folder, String fileName) {
        Path folderPath = getFileFolder(folder);
        Path filePath = folderPath.resolve(fileName);
        try {
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new IllegalArgumentException("删除文件错误:" + fileName);
        }

    }
}
