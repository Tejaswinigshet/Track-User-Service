package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Music;
import io.swagger.models.auth.In;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:4200/")
public interface MusicRepository extends MongoRepository<Music, Integer> {

    //public Music getTrackByName(String trackName);
    //public List<Music> searchById(int id);
}
