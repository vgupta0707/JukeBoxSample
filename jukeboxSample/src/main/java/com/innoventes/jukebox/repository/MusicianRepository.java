package com.innoventes.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innoventes.jukebox.model.Musician;

@Repository
public interface MusicianRepository extends CrudRepository<Musician, Long>{
	
	@Query("SELECT m from Musician m  INNER JOIN m.musicAlbum c WHERE c.music_album_id IN (?1)")
	List<Musician> findMusicianByMusicAlbumId(Long music_album_id);

}
