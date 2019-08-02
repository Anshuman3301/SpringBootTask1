package com.stackroute.muzix;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.controller.TrackController;
import com.stackroute.muzix.services.TrackService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class MuzixApplicationTests {

	@Test
	public void test1() {
		TrackService trackService= Mockito.mock(TrackService.class);
		TrackController trackController=new TrackController(trackService);

		List<Track> list= new ArrayList<>();
		Track track=new Track(1,"a","b");
		list.add(track);
		trackController.saveTrack(list);
		when(trackService.getAllTracks()).thenReturn(list);
		Assert.assertEquals(list,trackController.getAllTracks());


	}

}
