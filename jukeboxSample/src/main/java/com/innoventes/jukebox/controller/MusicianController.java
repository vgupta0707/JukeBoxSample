package com.innoventes.jukebox.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innoventes.jukebox.model.Musician;
import com.innoventes.jukebox.service.MusicianService;

@RestController
@RequestMapping("/innoventes/jukebox")
public class MusicianController {
	
	@Autowired
	MusicianService musicianService ;
	
	
	//Create a Musician
	@RequestMapping(path="/musician", method=RequestMethod.POST)
	public ResponseEntity<Musician>  createMusician (@RequestBody Musician musician) {
		
		return new ResponseEntity(musicianService.saveMusician(musician),HttpStatus.OK) ;
		
	}
	
	
	//Update a Musician
	@RequestMapping(path="/musician", method=RequestMethod.PUT)
	public ResponseEntity<Musician> updateMusician (@RequestBody Musician musician) {
		
		if (musicianService.findMusicianByMusicianId(musician.getMusician_id()).isPresent())

			return new ResponseEntity(musicianService.saveMusician(musician), HttpStatus.OK);

		else

			return new ResponseEntity(musician, HttpStatus.BAD_REQUEST);
			
	}
	
	
	
	//Get all the musicians
	@RequestMapping(path="/musician", method=RequestMethod.GET)
	public Iterable<Musician> getAllMusician () {
		return musicianService.findAllMusician();
		
	}
	
	

	// Get list of Musician for specified Music Album sorted by Musician Name in ascending order.
	@RequestMapping(path = "/musician/{music_album_id}/musicAlbum/", method = RequestMethod.GET)
	public Iterable<Musician> getAllMusicianForMusicAlbum(@PathVariable Long music_album_id ) {
		List<Musician> musicianList = new ArrayList<>();
		musicianList = (List<Musician>) musicianService.findMusicianByMusicAlbumId(music_album_id);
		
		Collections.sort(musicianList, (m1, m2) -> m1.getName().compareTo(m2.getName()));
		
		return musicianList;
		

	}

	

}
