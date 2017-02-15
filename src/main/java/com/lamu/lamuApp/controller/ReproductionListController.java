package com.lamu.lamuApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamu.lamuApp.dao.ReproductionListDao;
import com.lamu.lamuApp.model.ReproductionList;

@RestController
public class ReproductionListController {

	@Autowired
	ReproductionListDao reproductionListDao;
	
	@RequestMapping(value = "/resproductionlists", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ReproductionList> addResroductionList(@RequestBody ReproductionList reproductionList){
		if (reproductionList != null){
			reproductionListDao.save(reproductionList);
			return new ResponseEntity<ReproductionList>(reproductionList, HttpStatus.OK);
		}else{
			return new ResponseEntity<ReproductionList>(reproductionList, HttpStatus.BAD_REQUEST);
		}
	}
}
