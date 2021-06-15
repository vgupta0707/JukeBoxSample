package com.innoventes.jukebox.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.innoventes.jukebox.model.MusicAlbum;
import com.innoventes.jukebox.model.Musician;
import com.innoventes.jukebox.repository.MusicAlbumRepository;

@Service
public class MusicAlbumService {
	
	@Autowired
	private MusicAlbumRepository musicAlbumRepository;
	
	@Autowired
	private MusicianService musicianService;

	public MusicAlbum saveMusicAlbum(MusicAlbum musicAlbum) {

		MusicAlbum newmusicAlbum = new MusicAlbum();
		newmusicAlbum.setDescription(musicAlbum.getDescription());
		newmusicAlbum.setGenre(musicAlbum.getGenre());
		newmusicAlbum.setName(musicAlbum.getName());
		newmusicAlbum.setPrice(musicAlbum.getPrice());
		newmusicAlbum.setReleaseDate(musicAlbum.getReleaseDate());
		
		newmusicAlbum.getMusician()
		.addAll(musicAlbum
				.getMusician()
				.stream()
				.map(m -> {
					
					Musician mu = musicianService.findMusicianById(m.getMusician_id());
					mu.getMusicAlbum().add(newmusicAlbum);
					return mu;
				}).collect(Collectors.toList()));
				
				
				
		
		return musicAlbumRepository.save(newmusicAlbum);
	}

	public Iterable<MusicAlbum> findAllMusicAlbum() {
		return musicAlbumRepository.findAll();
	}

	public Optional<MusicAlbum> findByMusicAlbumId(Long music_album_id) {
		
		
		return musicAlbumRepository.findById(music_album_id);
	}

	public List<MusicAlbum> findMusicAlbumByMusicianId(Long musicianId) {
		
		return musicAlbumRepository.findByMusicianId(musicianId);
	}

	
	
	public MusicAlbum updateMusicAlbum(MusicAlbum musicAlbum) {
		MusicAlbum newmusicAlbum = new MusicAlbum();
		
		newmusicAlbum.setMusic_album_id(musicAlbum.getMusic_album_id());
		newmusicAlbum.setDescription(musicAlbum.getDescription());
		newmusicAlbum.setGenre(musicAlbum.getGenre());
		newmusicAlbum.setName(musicAlbum.getName());
		newmusicAlbum.setPrice(musicAlbum.getPrice());
		newmusicAlbum.setReleaseDate(musicAlbum.getReleaseDate());
		
		newmusicAlbum.getMusician()
		.addAll(musicAlbum
				.getMusician()
				.stream()
				.map(m -> {
					
					Musician mu = musicianService.findMusicianById(m.getMusician_id());
					mu.getMusicAlbum().add(newmusicAlbum);
					return mu;
				}).collect(Collectors.toList()));
				
				
				
		
		return musicAlbumRepository.save(newmusicAlbum);
	}

	
}
