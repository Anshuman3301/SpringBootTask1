package com.stackroute.repository;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;




@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track1;
    @Before
    public void setUp()
    {
        track1 = new Track();
        // track1.setTrackID(30);
        track1.setName("Believe");
        track1.setComment("Cher");
    }
    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }
    @Test
    public void testSaveTrack(){
        trackRepository.save(track1);
        Track fetchUser = trackRepository.findById(track1.getId()).get();
        Assert.assertEquals(4,fetchUser.getId());
    }
    @Test
    public void testSaveTrackFailure(){
        Track testUser = new Track("Believe Me Natalie","The Killers");
        trackRepository.save(track1);
        Track fetchUser = trackRepository.findById(track1.getId()).get();
        Assert.assertNotSame(new Track("Believe Me Natalie","The Killers"),track1);
    }
    @Test
    public void testGetAllTrack(){
        Track u = new Track("Johny12","102");
        Track u1 = new Track("Harry12","103");
        trackRepository.save(u);
        trackRepository.save(u1);
        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Johny12",list.get(0).getName());
    }
}
