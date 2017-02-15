package com.lamu.lamuApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamu.lamuApp.dao.SongListDao;
import com.lamu.lamuApp.model.SongList;

@RestController
public class SongListController {

	@Autowired
	SongListDao songListDao;
	
	@RequestMapping(value = "/songlists", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<SongList> addSongList(@RequestBody SongList songList){
		if(songList != null){
			songListDao.save(songList);
			return new ResponseEntity<SongList>(songList, HttpStatus.OK);
		}else{
			return new ResponseEntity<SongList>(songList, HttpStatus.BAD_REQUEST);
		}
	}
}
