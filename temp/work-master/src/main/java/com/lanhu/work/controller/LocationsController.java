package com.lanhu.work.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.exception.ValidException;
import com.lanhu.work.pojo.Locations;
import com.lanhu.work.service.LocationsService;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.LocationsListVo;

@RestController
public class LocationsController extends BaseController {
	
	
	
	@Autowired
	private LocationsService locationsService;
	
	/**
	 * 
	 * @param vo
	 * @param bindingResult
	 * @return
	 */
	@IgnoreSecurity
	@GetMapping(value="/v1/locations/list")
	public Object locationsList(@Valid LocationsListVo vo,BindingResult bindingResult) {
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		List<Locations> list  = locationsService.findAllByParentId(vo.getParentId());
		return R.ok(list);
		
	}

}
