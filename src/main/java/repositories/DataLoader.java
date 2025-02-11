package main.java.repositories;

import models.Actor;
import models.Director;
import models.Movie;
import services.ActorService;
import services.DirectorService;
import services.MovieService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DataLoader {
    private MovieService movieService;
    private ActorService actorService;
    private DirectorService directorService;

    public DataLoader(MovieService movieService, ActorService actorService, DirectorService directorService) {
        this.movieService = movieService;
        this.actorService = actorService;
        this.directorService = directorService;
    }

    public void loadData() {
        loadDirectors();
        loadActors();
        loadMovies();
    }

    private void loadMovies() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("movies_large.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Movie movie = new Movie(
                        data[0].trim(), // id
                        data[1].trim(), // title
                        Integer.parseInt(data[2].trim()), // year
                        data[3].trim(), // directorId
                        data[4].trim(), // genre
                        Double.parseDouble(data[5].trim()) // rating
                );

                movieService.addMovie(movie);

                // Add movie to director's filmography
                Director director = directorService.getDirectorById(movie.getDirectorId());
                if (director != null) {
                    director.addMovie(movie.getId());
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading movies: " + e.getMessage());
        }
    }

    private void loadActors() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("actors_large.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Actor actor = new Actor(
                        data[0].trim(), // id
                        data[1].trim(), // name
                        data[2].trim(), // nationality
                        Integer.parseInt(data[3].trim()) // birthYear
                );

                actorService.addActor(actor);
            }
        } catch (Exception e) {
            System.err.println("Error loading actors: " + e.getMessage());
        }
    }

    private void loadDirectors() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("directors_large.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Director director = new Director(
                        data[0].trim(), // id
                        data[1].trim(), // name
                        data[2].trim(), // nationality
                        Integer.parseInt(data[3].trim()) // birthYear
                );

                directorService.addDirector(director);
            }
        } catch (Exception e) {
            System.err.println("Error loading directors: " + e.getMessage());
        }
    }
}
