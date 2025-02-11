package main.java;

import main.java.models.Movie;
import main.java.services.MovieService;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String MOVIES_FILE = "src/main/resources/movies.csv";
    private static MovieService movieService;
    private static Scanner scanner;

    public static void main(String[] args) {
        movieService = new MovieService(MOVIES_FILE);
        scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1: displayAllMovies(); break;
                case 2: displayTop10Movies(); break;
                case 3: searchMoviesByGenre(); break;
                case 4: searchMoviesByReleaseYear(); break;
                case 5: updateMovieRating(); break;
                case 6: deleteMovie(); break;
                case 7: System.out.println("Exiting..."); System.exit(0);
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Movie Management System ---");
        System.out.println("1. Display All Movies");
        System.out.println("2. Top 10 Rated Movies");
        System.out.println("3. Search Movies by Genre");
        System.out.println("4. Search Movies by Release Year");
        System.out.println("5. Update Movie Rating");
        System.out.println("6. Delete Movie");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void displayAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        movies.forEach(System.out::println);
    }

    private static void displayTop10Movies() {
        List<Movie> topMovies = movieService.getTop10RatedMovies();
        topMovies.forEach(System.out::println);
    }

    private static void searchMoviesByGenre() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        movies.forEach(System.out::println);
    }

    private static void searchMoviesByReleaseYear() {
        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        List<Movie> movies = movieService.getMoviesByReleaseYear(year);
        movies.forEach(System.out::println);
    }

    private static void updateMovieRating() {
        System.out.print("Enter movie ID: ");
        int movieId = scanner.nextInt();
        System.out.print("Enter new rating: ");
        double newRating = scanner.nextDouble();
        movieService.updateMovieRating(movieId, newRating);
        System.out.println("Rating updated successfully.");
    }

    private static void deleteMovie() {
        System.out.print("Enter movie ID to delete: ");
        int movieId = scanner.nextInt();
        boolean deleted = movieService.deleteMovie(movieId);
        System.out.println(deleted ? "Movie deleted successfully." : "Movie not found.");
    }
}
