package com.lanhu.work.mapper;

import com.lanhu.work.pojo.BusDocumentTemplate;

public interface BusDocumentTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BusDocumentTemplate record);

    int insertSelective(BusDocumentTemplate record);

    BusDocumentTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusDocumentTemplate record);

    int updateByPrimaryKey(BusDocumentTemplate record);
}