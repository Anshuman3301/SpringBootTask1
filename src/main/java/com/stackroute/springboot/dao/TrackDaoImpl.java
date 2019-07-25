package com.stackroute.springboot.dao;

import com.stackroute.springboot.exceptions.TrackAlreadyExistsException;
import com.stackroute.springboot.exceptions.TrackNotFoundException;
import com.stackroute.springboot.model.Track;
import com.stackroute.springboot.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public boolean saveTrack (Track track)throws TrackAlreadyExistsException
    {
        trackRepository.save(track);
        return true;
    }

    @Override
    public boolean deleteTrack(int id)throws TrackNotFoundException
    {
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
    public Track UpdateTrack(int id,String comment) {

        Optional<Track> track = trackRepository.findById(id);
        Track track1 = track.get();
        track1.setComment(comment);
        Track savedTrack = trackRepository.save(track1);
        return savedTrack;

    }


    @Override
    public List<Track> getByTrackName(String name) {
        return trackRepository.findByName(name);
    }

    @Override
    public List<Track> getByTrackNameSortByName(String name) {
        return trackRepository.findByNameSortById(name);
    }
}
