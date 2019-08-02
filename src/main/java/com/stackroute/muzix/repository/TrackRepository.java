package com.stackroute.muzix.repository;

import com.stackroute.muzix.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {

    public Track findByName(String name);
    public List<Track> findByComment(String comment);


}
