package com.atguigu.guli.service.vod.service;

import com.aliyuncs.exceptions.ClientException;

import java.io.InputStream;
import java.util.Map;

/**
 * @author zsf
 * @create 2019-12-02 21:05
 */
public interface VideoService {

    String uploadVideo(InputStream file, String originalFilename);

    void removeVideo(String videoId) throws ClientException;

    Map<String, Object> getVideoUploadAuthAndAddress(String title, String fileName) throws ClientException;

    Map<String, Object> refreshVideoUploadAuth(String videoId) throws ClientException;

    String getVideoPlayAuth(String videoSourceId) throws ClientException;
}
