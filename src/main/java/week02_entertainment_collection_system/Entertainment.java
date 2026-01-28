package week02_entertainment_collection_system;

public abstract class Entertainment {
    protected String title;
    protected int releaseYear;
    protected double rating;
    protected boolean isAvailable;

    public Entertainment(String title, int releaseYear, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
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
    public String toString(){
        return getInfo();
    }

}
