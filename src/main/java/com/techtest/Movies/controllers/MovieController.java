package com.techtest.Movies.controllers;

import com.techtest.Movies.model.Movie;
import com.techtest.Movies.dataAccess.database;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MovieController {




  //create a movie record and return the id
  @PostMapping("/movies")
  @ResponseStatus(HttpStatus.CREATED)
  public long createNewMovie(@RequestBody Movie movie){
    //make the movies table if it is not already created
    try{
      database.createTable();
      long createdlocation = database.insertItem(movie);
      return createdlocation;
    } catch(Exception e){
      System.out.println(e);
      return -1;
    }
  }


  //get all movies
  @GetMapping("/movies")
  public List<Movie> getAllMovies(HttpServletResponse response) {
    try {
      List<Movie> movies = database.getAll();
      response.setHeader("Content-Range", movies.size());
      return movies;
    } catch(Exception e){
      System.out.println(e);
      return null;
    }
  }

  //get a single movie
  @GetMapping("/movies/{id}")
  public Movie getOneMovie(@PathVariable("id") long MovieId) {
    try {
      Movie result = database.getOne(MovieId);
      return result;
    } catch(Exception e){
      System.out.println(e);
      return null;
    }
  }

  //edit a single movie
  @PutMapping("/movies/{id}")
  public Movie EditOneMovie(@PathVariable("id") long MovieId, @RequestBody Movie newMov) {
    try {
      Movie result = database.EditOne(MovieId, newMov);
      return result;
    } catch(Exception e){
      System.out.println(e);
      return null;
    }
  }

  @DeleteMapping("/movies/{id}")
  public int EditOneMovie(@PathVariable("id") long MovieId) {
    try {
      database.DeleteItem(MovieId);
      return 1;
    } catch(Exception e){
      System.out.println(e);
      return -1;
    }
  }

}
