package com.huashu.huashuManager.common.file.service;

import java.io.InputStream;

public interface FileService {

    /**
     * 存储文件字节，根据文件名称存储（如果存在同名的，会抛出异常）
     * @param fileName
     * @param content
     * @return
     */
    String saveFileByteArray(String fileName, byte[] content);

    /**
     * 保存文件流，根据文件名称存储（如果存在同名的，会抛出异常）
     * @param fileName
     * @param is
     * @return
     */
    String saveFileStream(String fileName, InputStream is);

    /**
     * 根据文件名读取文件字节
     * @param fileName
     * @return
     */
    byte[] getFileByteArray(String fileName);

    /**
     * 文件是否存在
     * @param fileName
     * @return
     */
    boolean exist(String fileName);

    boolean deleteFile(String fileName);
}
