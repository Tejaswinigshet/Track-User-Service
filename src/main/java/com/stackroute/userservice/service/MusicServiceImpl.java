package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Music;
import com.stackroute.userservice.exceptions.TrackAlreadyExistException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import com.stackroute.userservice.repository.MusicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

   @Autowired
   private MusicRepository musicRepository;




   public void setTrackRepository(MusicRepository musicRepository) {
       this.musicRepository = musicRepository;
   }

   public MusicServiceImpl(MusicRepository musicRepository) {
       this.musicRepository = musicRepository;
   }




    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music addTracks(Music music) throws TrackAlreadyExistException {
        if(musicRepository.existsById(music.getTrackId()))
        {
            throw new TrackAlreadyExistException("Track already exists");
        }
        Music music1= musicRepository.save(music);
        if(music1==null)
        {
            throw new TrackAlreadyExistException("Track already exists");
        }
        return music1;
    }


    @Override
    public Music updateComment(Music music) throws TrackNotFoundException {

        Music music1= musicRepository.save(music);
        if(music1==null)
        {
            throw new TrackNotFoundException("Track not found");
        }
return music1;
    }


    @Override
    public void deleteMusic(int id) {
musicRepository.deleteById(id);
    }

//    @Override
//    public List<Music> searchByName(String name) throws TrackNotFoundException{
//        List<Music> trackName=null;
//        trackName= (List<Music>) musicRepository.getTrackByName(name);
//        if(trackName.equals(null))
//        {
//            throw new TrackNotFoundException("music not found");
//        }
//        return trackName;
//       // boolean flag=musicRepository.exists(music.getTrackName());
//
//    }

    @Override
    public void seedData(Music music) {
        if(!musicRepository.existsById(music.getTrackId()))
            musicRepository.save(music);
    }

//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException{
//
//        List<Track> listOfTracks = null;
//        listOfTracks = trackRepository.getTrackByName(trackName);
//        if (listOfTracks.equals(null))
//        {
//            throw new TrackNotFoundException("Track not found exception");
//        }
//        return listOfTracks;
//    }
}


