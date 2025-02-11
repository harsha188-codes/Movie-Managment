package main.java.models;



import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String title;
    private int year;
    private String directorId;
    private List<String> actorIds;
    private String genre;
    private double rating;

    public Movie(String id, String title, int year, String directorId, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.directorId = directorId;
        this.genre = genre;
        this.rating = rating;
        this.actorIds = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getDirectorId() { return directorId; }
    public List<String> getActorIds() { return actorIds; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    public void addActor(String actorId) {
        actorIds.add(actorId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
