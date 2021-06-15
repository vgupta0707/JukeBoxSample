package com.innoventes.jukebox.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="Musician" )
@Table(name = "MUSICIAN")
public class Musician implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long musician_id;

	@Length(min = 3)
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinTable(name="MUSICIAN_MUSIC_ALBUM", joinColumns = {@JoinColumn(name="musician_id", referencedColumnName="musician_id")}, 
	inverseJoinColumns = {@JoinColumn(name="music_album_id",referencedColumnName="music_album_id" )})
	@JsonIgnore
	List<MusicAlbum> musicAlbum = new ArrayList();
	
	public Musician() {
		
	}
	
	public void addMusicAlbum(MusicAlbum musicAlbumNew) {
		musicAlbum.add(musicAlbumNew);
	}
	
	public Musician(@Length(min = 3) String name, String type) {
		this.name = name;
		this.type = type;
	};
	
	public List<MusicAlbum> getMusicAlbum() {
		return musicAlbum;
	}
	
	public Long getMusician_id() {
		return musician_id;
	}
	
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void setMusicAlbum(List<MusicAlbum> musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	
	
	public void setMusician_id(Long musician_id) {
		this.musician_id = musician_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		return "Musician [musician_id=" + musician_id + ", name=" + name + ", type=" + type + ", musicAlbum="
				+ musicAlbum + "]";
	}
	
	
	
	

}
