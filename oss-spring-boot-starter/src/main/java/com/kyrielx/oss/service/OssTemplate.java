package com.kyrielx.oss.service;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.InputStream;
import java.util.List;

/**
 * oss操作模板
 * @author kyrielx
 * @date 2023/4/7 9:56
 */
public interface OssTemplate {
    /**
     * 创建bucket
     * @param bucketName bucket名称
     */
    void createBucket(String bucketName);

    /**
     * 获取所有bucket
     * @return
     */
    List<Bucket> getAllBuckets();

    /**
     * 通过bucket名称删除bucket
     * @param bucketName
     */
    void removeBucket(String bucketName);

    /**
     * 上传文件
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream 文件流
     * @param contextType 文件类型
     */
    void putObject(String bucketName, String objectName, InputStream stream, String contextType);

    /**
     * 上传文件
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream 文件流
     * @throws Exception
     */
    void putObject(String bucketName, String objectName, InputStream stream) throws Exception;

    /**
     * 获取文件
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return S3Object
     */
    S3Object getObject(String bucketName, String objectName);

    /**
     * 获取文件对象的url
     * @param bucketName
     * @param objectName
     * @param expires
     * @return
     */
    String getObjectURL(String bucketName, String objectName, Integer expires);

    /**
     * 通过bucketName和objectName删除对象
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    void removeObject(String bucketName, String objectName) throws Exception;

    /**
     * 根据文件名前缀查询文件
     * @param bucketName
     * @param prefix
     * @param recursive
     * @return
     */
    List<S3ObjectSummary> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive);
}
