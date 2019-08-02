package com.stackroute.service;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.services.TrackServiceImpl;
import com.stackroute.muzix.services.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrackServiceImplTest {



    Track track;

    @Mock
    TrackRepository trackRepository;

    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(11);
        track.setName("Rihana");
        track.setComment("Good song");
        list = new ArrayList<>();
        list.add(track);
    }


    @Test
    public void saveTrackTest() throws TrackAlreadyExistException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        boolean savedTrack = trackService.saveTrack(list);
        Assert.assertEquals(true,savedTrack);
    }

    @Test
    public void getTrackTest()
    {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> trackList = trackService.getAllTracks();
        Assert.assertEquals(list,trackList);
    }

    @Test
    public void updateTrackTest() throws TrackNotFoundException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        boolean updateTrack=false;
        try {
            updateTrack = trackService.saveTrack(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true,updateTrack);
    }
}
