package com.lamu.lamuApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reproductionlist")
public class ReproductionList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@ManyToOne
	private MusicProducer musicProducer;
	@OneToOne
	private Client client;
	
	public MusicProducer getMusicProducer() {
		return musicProducer;
	}
	public void setMusicProducer(MusicProducer musicProducer) {
		this.musicProducer = musicProducer;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
