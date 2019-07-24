package com.stackroute.springboot.dao;

import com.stackroute.springboot.model.Track;
import com.stackroute.springboot.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TrackDaoImpl implements TrackDao {

    @Autowired
    private TrackRepository trackRepository;

    public TrackDaoImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }

    @Override
    public boolean saveTrack(Track track)
    {
        trackRepository.save(track);
        return true;
    }

    @Override
    public boolean deleteTrack(int id) {
        trackRepository.delete(getTrackById(id));
        return true;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.getOne(id);
    }

    @Override
    public boolean UpdateTrack(Track track) {
        trackRepository.save(track);
        return true;
    }
}
