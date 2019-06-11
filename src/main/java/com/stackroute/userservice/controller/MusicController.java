package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Music;
import com.stackroute.userservice.exceptions.TrackAlreadyExistException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import com.stackroute.userservice.service.MusicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
//@PropertySource("application.properties")
@RequestMapping(value="/api/v1")
public class MusicController {

    @Autowired
    MusicService musicService;
//
//    public MusicService getMusicService() {
//        return musicService;
//    }
//
//    public MusicController(MusicService musicService) {
//
//        this.musicService = musicService;
//    }




//    @ApiOperation(value = "Saves track in database")
    @PostMapping("/music")
    public ResponseEntity<Music> addTracks(@RequestBody Music music) throws TrackAlreadyExistException{
        ResponseEntity responseEntity;
        try {
            Music music1 = musicService.addTracks(music);
            responseEntity = new ResponseEntity<Music>(music1, HttpStatus.OK);
        } catch (TrackAlreadyExistException ex) {
            //responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            //ex.printStackTrace();
            throw ex;
        }
        return responseEntity;
    }

//
//@ApiOperation(value = "Gets all tracks from database")
    @GetMapping("/display")
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> music = musicService.getAllMusic();
        return new ResponseEntity<List<Music>>(music, HttpStatus.OK);
    }

//   @Value("${del_msg}")
//   private String del_msg;

   // @ApiOperation(value = "Update comment of a track")
    @PutMapping("/music/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Music music) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            Music music1 = musicService.updateComment(music);
            return new ResponseEntity<String>("successfully", HttpStatus.CREATED);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity<String>("invalid", HttpStatus.CONFLICT);
            //ex.printStackTrace();
            throw ex;
        }
     // return responseEntity;
    }


//@ApiOperation(value="delete track from database")
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> deleteTracks(@PathVariable int id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

//@ApiOperation(value = "search by name from database")
//    @GetMapping("/music/{name}")
//    public ResponseEntity<List<Music>> searchByName(@PathVariable String name) throws TrackNotFoundException
//    {
//        List<Music> music=musicService.searchByName(name);
//        return new ResponseEntity<List<Music>> (music,HttpStatus.OK);
//    }

}