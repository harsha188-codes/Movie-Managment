package main.java.services;

import models.Director;
import java.util.ArrayList;
import java.util.List;

public class DirectorService {
    private List<Director> directors;

    public DirectorService() {
        this.directors = new ArrayList<>();
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public Director getDirectorById(String id) {
        return directors.stream()
                .filter(director -> director.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Director> getAllDirectors() {
        return new ArrayList<>(directors);
    }

    public List<Director> getDirectorsByNationality(String nationality) {
        return directors.stream()
                .filter(director -> director.getNationality().equalsIgnoreCase(nationality))
                .toList();
    }
}