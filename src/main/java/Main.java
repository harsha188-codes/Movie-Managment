package main.java;



import models.Movie;
import models.Actor;
import models.Director;
import services.MovieService;
import services.ActorService;
import services.DirectorService;
import repositories.DataLoader;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        MovieService movieService = new MovieService();
        ActorService actorService = new ActorService();
        DirectorService directorService = new DirectorService();

        // Initialize and run data loader
        DataLoader dataLoader = new DataLoader(movieService, actorService, directorService);
        dataLoader.loadData();

        // Example usage
        System.out.println("All Movies:");
        movieService.getAllMovies().forEach(System.out::println);

        System.out.println("\nAll Actors:");
        actorService.getAllActors().forEach(System.out::println);

        System.out.println("\nAll Directors:");
        directorService.getAllDirectors().forEach(System.out::println);
    }
}