package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private String id;
    private String name;
    private String nationality;
    private int birthYear;
    private List<String> movieIds;

    public Director(String id, String name, String nationality, int birthYear) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
        this.movieIds = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getNationality() { return nationality; }
    public int getBirthYear() { return birthYear; }
    public List<String> getMovieIds() { return movieIds; }

    public void addMovie(String movieId) {
        movieIds.add(movieId);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}

