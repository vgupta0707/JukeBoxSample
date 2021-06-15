package com.innoventes.jukebox.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="MusicAlbum")
@Table(name ="MUSIC_ALBUM")
public class MusicAlbum implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long music_album_id;

	@Length(min =5)
	@Column(name = "NAME")
	private String name;

	
	@ManyToMany(mappedBy = "musicAlbum", cascade = {CascadeType.MERGE,CascadeType.PERSIST} , fetch=FetchType.LAZY )
	private List<Musician> musician = new ArrayList();

	@NotNull
	@Column(name = "RELEASE_DATE")
	private Date releaseDate ;

	@Column(name = "GENRE")
	private String genre;

	@Range( min =100 , max =1000)
	@Column(name = "PRICE")
	private String price;

	@Column(name = "DESCRIPTION")
	private String description;
	
	public MusicAlbum() {
		
	}
	
	public MusicAlbum(String name, Date releaseDate, String genre, String price, String description) {
		
		this.name = name;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.price = price;
		this.description = description;
	}
	
	public void addMusician(Musician musicianNew) {
		musician.add(musicianNew);
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Long getMusic_album_id() {
		return music_album_id;
	}
	
	public List<Musician> getMusician() {
		return musician;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	
	public String getPrice() {
		return price;
	}
	
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setMusic_album_id(Long music_album_id) {
		this.music_album_id = music_album_id;
	}
	
	
	public void setMusician(List<Musician> musician) {
		this.musician = musician;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		return "MusicAlbum [music_album_id=" + music_album_id + ", name=" + name + ", musicians=" + musician
				+ ", releaseDate=" + releaseDate + ", genre=" + genre + ", price=" + price + ", description="
				+ description + "]";
	}
	

}
