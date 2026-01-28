package week02_entertainment_collection_system;

import java.time.LocalDate;

public abstract class Entertainment {
    protected String title;
    protected int releaseYear;
    protected double rating;
    protected boolean isAvailable;

    public Entertainment(String title, int releaseYear, double rating) {
        setTitle(title);
        setReleaseYear(releaseYear);
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year cannot be from future");
        }
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 - 10");
        }
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void rent() {
        this.isAvailable = false;
    }

    public void returnItem() {
        this.isAvailable = true;
    }

    public String getInfo() {
        return title + " (" + releaseYear + ") - Rating: " + rating + "/10";
    }

    public abstract void play();

    public abstract double calculateValue();

    @Override
    public String toString() {
        return getInfo();
    }

}
