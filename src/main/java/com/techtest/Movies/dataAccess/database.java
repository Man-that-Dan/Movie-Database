package com.techtest.Movies.dataAccess;

import com.techtest.Movies.model.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class database {

  //edit a single record
    public static Movie EditOne(long id, Movie newEdit) throws Exception{
      try {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("UPDATE movielist SET title = '"+newEdit.getTitle()+"', director = '"+newEdit.getDirector()+"' WHERE id = '"+id+"'");
        PreparedStatement verify = con.prepareStatement("SELECT * FROM movielist WHERE id = '"+id+"'");
        statement.executeUpdate();
        ResultSet result = verify.executeQuery();
        Movie tempresult =  new Movie(result.getLong("id"), result.getString("title"), result.getString("director"));
        System.out.println(tempresult.getTitle());
        return tempresult;

      } catch(Exception e){
        System.out.println(e);
        return null;

      }

    }


    //delete single movie from database, takes in an id
    public static void DeleteItem(long id) throws Exception{
      try{
        Connection con = getConnection();
        PreparedStatement inserted = con.prepareStatement("DELETE FROM movielist WHERE id = '"+id+"'");
        inserted.executeUpdate();
      } catch(Exception e){
        System.out.println(e);
      }
    }

    //get a single movie by its id
    public static Movie getOne(long id) throws Exception{
      try {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM movielist WHERE id = '"+id+"'");
        ResultSet result = statement.executeQuery();
        result.next();
        Movie tempresult =  new Movie(result.getLong("id"), result.getString("title"), result.getString("director"));
        System.out.println(tempresult.getTitle());
        return tempresult;

      } catch(Exception e){
        System.out.println(e);
        return null;

      }

    }

  //get all records in database, returns List of Movie objects
    public static List<Movie> getAll() throws Exception{
      try {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM movielist");
        ResultSet result = statement.executeQuery();
        List<Movie> array = new ArrayList<>();
        while(result.next()){
          Movie tempresult = new Movie(result.getLong("id"), result.getString("title"), result.getString("director"));
          System.out.println(tempresult.getTitle());
          array.add(tempresult);
        }

        return array;

      } catch(Exception e){
        System.out.println(e);
        return null;

      }

    }

    //insert single movie into database, takes in a movie object
  public static long insertItem(Movie m) throws Exception{
    try{
      Connection con = getConnection();
      PreparedStatement inserted = con.prepareStatement("INSERT INTO movielist (title, director) VALUES ('"+m.getTitle()+"', '"+m.getDirector()+"')");
      PreparedStatement gettheID = con.prepareStatement("SELECT LAST_INSERT_ID()");
      inserted.executeUpdate();
      ResultSet result = gettheID.executeQuery();
  
      return 1;
    } catch(Exception e){
      System.out.println(e);
      return -1;
    }

  }



  //create the table if it doesn't exist
  public static void createTable() throws Exception{
    try {
      Connection con = getConnection();
      PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS movielist(id INTEGER NOT NULL AUTO_INCREMENT, title TEXT, director TEXT, PRIMARY KEY(id))");
      create.executeUpdate();

    } catch(Exception e){
      System.out.println(e);
    }
  }



  //connect to sql database, returns connection
  public static Connection getConnection() throws Exception {

    try {
      String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://us-cdbr-iron-east-02.cleardb.net/heroku_c43655a8b77a3f1";
      String username = "bfa5edd8208651";
      String password = "bd6f46e9";
      Class.forName(driver);

      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("SQL Database connected");
      return conn;
    } catch(Exception e){
      System.out.println(e);
      return null;
    }


  }

}
