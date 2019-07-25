package com.stackroute.springboot.repository;

import com.stackroute.springboot.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    public List<Track> findByName(String name);

    @Query("from Track where name = ?1 order by id")
    List<Track> findByNameSortById(String name);

}
