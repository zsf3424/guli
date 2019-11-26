package com.atguigu.guli.service.oss.service;

import java.io.InputStream;

/**
 * @author zsf
 * @create 2019-11-25 21:07
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    void removeFile(String url);
}
