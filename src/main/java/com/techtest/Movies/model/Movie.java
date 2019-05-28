package com.techtest.Movies.model;

public class Movie {
  private long id;
  private String title;
  private String director;

  public Movie(){
    id = 1;
    title = "Endgame";
    director = "Russos";
  }

  public Movie(long id, String title, String director){
    this.id = id;
    this.title = title;
    this.director = director;
  }

  public void setId(long newid){
    id = newid;
  }

  public long getID(){
    return id;
  }

  public String getTitle(){
    return title;
  }

  public String getDirector(){
    return director;
  }


}
