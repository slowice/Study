package com.lanhu.work.pojo;

/**
 * 上传文件配置表
 * 
 * @author wcyong
 * 
 * @date 2018-08-13
 */
public class UploadFileConfig {
    private Long id;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 可上传文件数量
     */
    private Integer fileSize;

    /**
     * 可上传单个文件大小
     */
    private Integer fileMax;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 文件bucketName
     */
    private String fileBucketname;

    /**
     * 文件baseOssUri
     */
    private String fileBaseossuri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getFileMax() {
        return fileMax;
    }

    public void setFileMax(Integer fileMax) {
        this.fileMax = fileMax;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix == null ? null : fileSuffix.trim();
    }

    public String getFileBucketname() {
        return fileBucketname;
    }

    public void setFileBucketname(String fileBucketname) {
        this.fileBucketname = fileBucketname == null ? null : fileBucketname.trim();
    }

    public String getFileBaseossuri() {
        return fileBaseossuri;
    }

    public void setFileBaseossuri(String fileBaseossuri) {
        this.fileBaseossuri = fileBaseossuri == null ? null : fileBaseossuri.trim();
    }
}