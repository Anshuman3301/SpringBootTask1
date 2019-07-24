package com.stackroute.springboot.dao;

import com.stackroute.springboot.model.Track;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface TrackDao {
    public boolean saveTrack(Track track);
    public boolean deleteTrack(int id);
    public List<Track> getAllTracks();
    public Track getTrackById(int id);
    public boolean UpdateTrack(Track track);
}
