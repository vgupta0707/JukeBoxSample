package com.innoventes.jukebox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoventes.jukebox.model.Musician;
import com.innoventes.jukebox.repository.MusicianRepository;

@Service
public class MusicianService {
	
	@Autowired
	MusicianRepository musicianRepository;
	
	public Musician findMusicianById(Long musicianId) {
		
		Optional<Musician> musicianResponse = musicianRepository.findById(musicianId);
		Musician musicianTemp = musicianResponse.get();
		return musicianTemp;
		
	}

	public Musician saveMusician(Musician musician) {
		return musicianRepository.save(musician);
		
		
	}

	public Iterable<Musician> findAllMusician() {
		
		return musicianRepository.findAll();
	}
	

	public Optional<Musician> findMusicianByMusicianId(Long musician_id) {
		
		return musicianRepository.findById(musician_id);
	}

	public List<Musician> findMusicianByMusicAlbumId(Long music_album_id) {
		return musicianRepository.findMusicianByMusicAlbumId(music_album_id);
	}


	
	

}
