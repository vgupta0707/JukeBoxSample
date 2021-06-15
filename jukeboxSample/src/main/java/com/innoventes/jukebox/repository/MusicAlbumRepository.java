package com.innoventes.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innoventes.jukebox.model.MusicAlbum;

@Repository
public interface MusicAlbumRepository extends CrudRepository<MusicAlbum, Long>{
	
	@Query("SELECT m from MusicAlbum m  INNER JOIN m.musician c WHERE c.musician_id IN (?1)")
	List<MusicAlbum> findByMusicianId(Long musicianId);

}
