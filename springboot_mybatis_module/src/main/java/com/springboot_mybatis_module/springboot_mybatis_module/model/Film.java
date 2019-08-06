package com.springboot_mybatis_module.springboot_mybatis_module.model;

import java.util.Date;

public class Film {
    private Integer filmId;

    private String description;

    private Date lastUpdate;

    private Integer length;

    private String rating;

    private Integer releaseYear;

    private Integer rentalDuration;

    private Float rentalRate;

    private Float replacementCost;

    private String specialFeatures;

    private String title;

    private Integer languageId;

    private Integer originalLanguageId;

    public Film(Integer filmId, String description, Date lastUpdate, Integer length, String rating, Integer releaseYear, Integer rentalDuration, Float rentalRate, Float replacementCost, String specialFeatures, String title, Integer languageId, Integer originalLanguageId) {
        this.filmId = filmId;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.length = length;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.specialFeatures = specialFeatures;
        this.title = title;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
    }

    public Film() {
        super();
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating == null ? null : rating.trim();
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures == null ? null : specialFeatures.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }
}