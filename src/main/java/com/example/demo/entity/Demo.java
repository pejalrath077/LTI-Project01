package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflex")
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long showId;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String dateAdded;
	private int releaseYear;
	private String rating;
	private String duration;
	private String listedIn;
	private String description;
	
	public long getShowId() {
		return showId;
	}
	public void setShowId(long showId) {
		this.showId = showId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getListedIn() {
		return listedIn;
	}
	public void setListedIn(String listedIn) {
		this.listedIn = listedIn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Demo [showId=" + showId + ", type=" + type + ", title=" + title + ", director=" + director + ", cast="
				+ cast + ", country=" + country + ", dateAdded=" + dateAdded + ", releaseYear=" + releaseYear
				+ ", rating=" + rating + ", duration=" + duration + ", listedIn=" + listedIn + ", description="
				+ description + "]";
	}
	
	
	
}
