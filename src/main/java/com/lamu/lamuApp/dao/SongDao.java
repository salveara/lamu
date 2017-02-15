package com.lamu.lamuApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lamu.lamuApp.model.Song;

public interface SongDao extends CrudRepository<Song, Long>{

	Song findById(Long id);
	
	List<Song> findAll();
	
	List<Song> findByTittleContaining(String tittle);
	
	List<Song> findByArtistContaining(String artist);
	
	List<Song> findByAlbumContaining(String album);
	
	List<Song> findByGenreContaining(String genre);
	
	List<Song> findByTrackContaining(String track);
	
	List<Song> findByYearContaining(String year);
	
}
