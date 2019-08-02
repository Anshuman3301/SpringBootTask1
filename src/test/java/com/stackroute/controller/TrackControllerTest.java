package com.stackroute.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.controller.TrackController;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.services.TrackServiceImpl;
import com.stackroute.muzix.services.TrackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TrackControllerTest {


    private MockMvc mockMvc;
    private Track track;

    private TrackServiceImpl trackServiceImpl= Mockito.mock(TrackServiceImpl.class);
    @InjectMocks
    private TrackController trackController;

    private List<Track> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        //track.setId(26);
        track.setName("Despacito");
        track.setComment("SlowlySlowly");
        list = new ArrayList();

        list.add(track);
    }

    @Test
    public void saveUser() throws Exception {
        when(trackServiceImpl.saveTrack(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/saveTrack")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
      @Test
     public void saveUserFailure() throws Exception {
        when(trackServiceImpl.saveTrack(any())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/saveTrack")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    //test class to
    @Test
    public void getAllUser() throws Exception {
        when(trackServiceImpl.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getAllTracks")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
