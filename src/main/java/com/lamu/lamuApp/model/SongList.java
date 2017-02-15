package com.lamu.lamuApp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "songlist")
public class SongList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int download;
	private Date date;
	@ManyToOne
	private Song song;
	@ManyToOne
	private ReproductionList reproductionList;

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public ReproductionList getReproductionList() {
		return reproductionList;
	}

	public void setReproductionList(ReproductionList reproductionList) {
		this.reproductionList = reproductionList;
	}

}
