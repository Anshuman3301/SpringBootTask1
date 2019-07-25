package com.stackroute.springboot.controller;

import com.stackroute.springboot.model.Track;
import com.stackroute.springboot.dao.TrackDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    TrackDao trackService;

    public TrackController(TrackDao trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {

        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }

        catch(Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id) {

        ResponseEntity responseEntity;
        try{

            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity("Delete Successfull", HttpStatus.NO_CONTENT);

        }

        catch (Exception ex) {

            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @PutMapping(value = "/update/{id}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @PathVariable String comment) {

        ResponseEntity responseEntity;
        try {
            trackService.UpdateTrack(id,comment);
            responseEntity = new ResponseEntity<String>("Update Successfull", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }



    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
        System.out.println(trackService.getByTrackName("hello").toString());
        System.out.println(trackService.getByTrackName("hello").toString());
        return responseEntity;

    }

}