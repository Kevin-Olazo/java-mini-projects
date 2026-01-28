package week02_entertainment_collection_system;

public class PhysicalMedia extends Entertainment {
    private String mediaType;
    private boolean hasDamage;
    private int duration;

    public PhysicalMedia(String title, int releaseYear, double rating, String mediaType, boolean hasDamage, int duration) {
        super(title, releaseYear, rating);
        this.mediaType = mediaType;
        this.hasDamage = hasDamage;
        this.duration = duration;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public boolean isHasDamage() {
        return hasDamage;
    }

    public void setHasDamage(boolean hasDamage) {
        this.hasDamage = hasDamage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void play() {
        System.out.println("Inserting " + mediaType + " of " + getTitle());
    }

    @Override
    public double calculateValue() {
        double basePrice = 20.00;

        if (mediaType.equals("4K")) {
            basePrice += 10;
        }

        if (hasDamage) {
            basePrice -= 15;
        }

        return basePrice;

    }

    public String inspectCondition() {
        return hasDamage ? "Poor" : "Good";
    }
}
