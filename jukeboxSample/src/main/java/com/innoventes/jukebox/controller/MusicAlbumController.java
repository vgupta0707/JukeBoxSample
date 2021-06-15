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

import com.innoventes.jukebox.model.MusicAlbum;
import com.innoventes.jukebox.service.MusicAlbumService;

@RestController
@RequestMapping("/innoventes/jukebox")
public class MusicAlbumController {

	@Autowired
	MusicAlbumService musicAlbumService;

	// Create a Music Album
	@RequestMapping(path = "/musicAlbum", method = RequestMethod.POST)
	public ResponseEntity<MusicAlbum> createMusicAlbum(@RequestBody MusicAlbum musicAlbum) {

		return new ResponseEntity(musicAlbumService.saveMusicAlbum(musicAlbum), HttpStatus.OK);

	}

	// Update a Music Album
	@RequestMapping(path = "/musicAlbum", method = RequestMethod.PUT)
	public ResponseEntity<MusicAlbum> updateMusicAlbum(@RequestBody MusicAlbum musicAlbum) {

		if (musicAlbumService.findByMusicAlbumId(musicAlbum.getMusic_album_id()).isPresent())

			//return new ResponseEntity(musicAlbumService.saveMusicAlbum(musicAlbum), HttpStatus.OK);
			return new ResponseEntity(musicAlbumService.updateMusicAlbum(musicAlbum), HttpStatus.OK);

		else

			return new ResponseEntity(musicAlbum, HttpStatus.BAD_REQUEST);

	}

	// Get All the Music Albums
	@RequestMapping(path = "/musicAlbum", method = RequestMethod.GET)
	public Iterable<MusicAlbum> getAllMusicAlbum() {

		return musicAlbumService.findAllMusicAlbum();

	}

	// Get List of All Music Albums sorted by Date in Ascending Order
	@RequestMapping(path = "/musicAlbumSortedByDate", method = RequestMethod.GET)
	public Iterable<MusicAlbum> getMusicAlbumByDate() {

		List<MusicAlbum> musicList = new ArrayList<>();
		musicList = (List<MusicAlbum>) musicAlbumService.findAllMusicAlbum();

		Collections.sort(musicList, (m1, m2) -> m1.getReleaseDate().compareTo(m2.getReleaseDate()));

		return musicList;

	}

	// Get List of Music Albums by Musician Id sorted by price in ascending order
	@RequestMapping(path = "/musicAlbum/musician/{musicianId}/", method = RequestMethod.GET)
	public Iterable<MusicAlbum> getMusicAlbumByMusicianId(@PathVariable Long musicianId) {

		List<MusicAlbum> musicList = new ArrayList<>();
		musicList = (List<MusicAlbum>) musicAlbumService.findMusicAlbumByMusicianId(musicianId);

		Collections.sort(musicList, (m1, m2) -> m1.getPrice().compareTo(m2.getPrice()));

		return musicList;

	}

}
