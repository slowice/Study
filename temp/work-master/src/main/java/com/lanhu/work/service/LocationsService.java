package com.lanhu.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.LocationsMapper;
import com.lanhu.work.pojo.Locations;

@Service
public class LocationsService {

	@Autowired
	private LocationsMapper locationsMapper;

	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Locations> findAllByParentId(Integer parentId) {
		List<Locations> list = locationsMapper.findAllByParentId(parentId);
		return list;
	}

}
