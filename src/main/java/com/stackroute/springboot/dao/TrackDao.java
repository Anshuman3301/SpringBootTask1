package com.stackroute.springboot.dao;

import com.stackroute.springboot.exceptions.TrackAlreadyExistsException;
import com.stackroute.springboot.exceptions.TrackNotFoundException;
import com.stackroute.springboot.model.Track;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface TrackDao {
    public boolean saveTrack(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrack(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks();
    public Track getTrackById(int id);
    public Track UpdateTrack(int id, String comment);
    List<Track> getByTrackName(String name);
    List<Track> getByTrackNameSortByName(String name);
}
