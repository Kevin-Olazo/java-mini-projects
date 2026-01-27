package week02_entertainment_collection_system;

public class Movie extends PhysicalMedia {
    private String director;
    private String genre;

    public Movie(String title, int releaseYear, double rating, String mediaType, boolean hasDamage, int duration, String director, String genre) {
        super(title, releaseYear, rating, mediaType, hasDamage, duration);
        this.director = director;
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: [" + director + "]: [" + getTitle() + "]");
        super.play();
    }

    @Override
    public double calculateValue() {
        return super.calculateValue();
    }

    public String getGenreRecommendations(){
      return genre;
    };
}
