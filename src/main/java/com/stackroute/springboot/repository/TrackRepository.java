package com.stackroute.springboot.repository;

import com.stackroute.springboot.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
