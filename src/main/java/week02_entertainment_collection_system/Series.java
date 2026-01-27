package week02_entertainment_collection_system;

public class Series extends PhysicalMedia {
    private int seasons;
    private int episodesPerSeason;

    public Series(String title, int releaseYear, double rating, String mediaType, boolean hasDamage, int duration, int seasons, int episodesPerSeason) {
        super(title, releaseYear, rating, mediaType, hasDamage, duration);
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
    }

    @Override
    public void play() {
        System.out.println("Binge-watching [" + getTitle() + "]");
        super.play();
    }

    @Override
    public double calculateValue() {
        if (seasons > 4) {
            return super.calculateValue() + 12.90;
        }

        return super.calculateValue();
    }

    ;

    public int getTotalEpisodes() {
        return seasons * episodesPerSeason;
    }
}
