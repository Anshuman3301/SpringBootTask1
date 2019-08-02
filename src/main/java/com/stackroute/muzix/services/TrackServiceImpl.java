package com.stackroute.muzix.services;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.List;



@Repository
@Transactional
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;


    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    //implement all the methods
    @Override
    public boolean saveTrack(List<Track> tracks) {
        for(int i=0;i<tracks.size();i++)
        {
            for(Track track:tracks)
            trackRepository.save(track);
        }

        return true;
    }

    @Override
    public boolean deleteTrack(int id) {
        trackRepository.delete(getTrackById(id));
        return true;
    }

    @Override
    public List<Track> getAllTracks() {
        return  trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
         Track track = trackRepository.findById(id).get();
        return track;

    }

    @Override
    public boolean UpdateTrack(Track track) {
        trackRepository.save(track);
        return true;
    }

    public Track findByName(String name){
        return trackRepository.findByName(name);
    }

    public List<Track> findByComment(String comment){
        return trackRepository.findByComment(comment);
    }


}


