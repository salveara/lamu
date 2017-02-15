package com.lamu.lamuApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamu.lamuApp.dao.SongDao;
import com.lamu.lamuApp.model.Song;

@RestController
public class SongController {

	@Autowired
	SongDao songDao;

	@RequestMapping(value = "/songs", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Song>> allSongs(
			@RequestParam(value = "name", required = false) String tittle) {
		if (tittle == null) {
			return new ResponseEntity<List<Song>>(songDao.findAll(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Song>>(songDao.findByTittleContaining("tittle"), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/songs", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Song> addSong(@RequestBody Song song) {
		if (song != null) {
			songDao.save(song);
			return new ResponseEntity<Song>(song, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Song>(song, HttpStatus.BAD_REQUEST);
		}
	}
}
