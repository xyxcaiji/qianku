package com.springboot.bootcache.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliyunOssProperties {
    @Value("${ali-oss.endpoint}")
    private   String endpoint;
    @Value("${ali-oss.access-key-id}")
    private   String accessKeyId;
    @Value("${ali-oss.access-key-secret}")
    private   String accessKeySecret;
    @Value("${ali-oss.bucket-name}")
    private   String bucketName;
    @Value("${ali-oss.dir}")
    private   String dir;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

}
