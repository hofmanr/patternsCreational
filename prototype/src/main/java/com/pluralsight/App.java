package com.pluralsight;

import com.pluralsight.prototype.Movie;
import com.pluralsight.prototype.Registry;
import com.pluralsight.serialization.Movie2;
import com.pluralsight.serialization.Record;
import com.pluralsight.serialization.Registry2;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Creational Patterns in Java");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

        System.out.println("--------------------------");
        System.out.println("commons-lang3");
        Registry2 registry2 = new Registry2();

        System.out.println(LocalDateTime.now());
        Movie2 movie2 = null;
        for (int i = 0; i < 1000000; i++) {
            movie2 = (Movie2) registry2.createItem("Movie");
        }
        System.out.println(LocalDateTime.now());
        movie.setTitle("Creational Patterns in Java");

        System.out.println(movie2);
        System.out.println(movie2.getTitle());
        System.out.println(movie2.getActors());
        System.out.println(movie2.getRecord());

        System.out.println(LocalDateTime.now());
        Movie2 anotherMovie2 = null;
        for (int i = 0; i < 1000000; i++) {
            anotherMovie2 = (Movie2) registry2.createItem("Movie");
        }
        System.out.println(LocalDateTime.now());
        anotherMovie.setTitle("Gang of Four");

        System.out.println(anotherMovie2);
        System.out.println(anotherMovie2.getTitle());
        System.out.println(anotherMovie2.getActors());
        System.out.println(anotherMovie2.getRecord());


        System.out.println("--------------------------");
        System.out.println("New Movie");
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < 1000000; i++) {
            movie2 = new Movie2();
            movie2.setTitle("Basic Movie");
            movie2.setPrice(24.99);
            movie2.setRecord(new Record());
            movie2.setActors(Arrays.asList("John Wayne", "Sudrey Hepburn"));
        }
        System.out.println(LocalDateTime.now());
    }
}
