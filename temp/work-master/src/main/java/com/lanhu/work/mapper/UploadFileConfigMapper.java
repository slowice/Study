package com.lanhu.work.mapper;

import com.lanhu.work.pojo.UploadFileConfig;

public interface UploadFileConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UploadFileConfig record);

    int insertSelective(UploadFileConfig record);

    UploadFileConfig findByFileType(String fileType);

    int updateByPrimaryKeySelective(UploadFileConfig record);

    int updateByPrimaryKey(UploadFileConfig record);
    
    
}