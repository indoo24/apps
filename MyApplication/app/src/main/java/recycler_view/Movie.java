package recycler_view;

public class Movie {
    private final String title;
    private final String description;
    private final String releaseDate;
    private final float rating;
    private final int imageResId;

    public Movie(String title, String description, String releaseDate, float rating, int imageResId) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.imageResId = imageResId;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getRating() {
        return rating;
    }

    public int getImageResId() {
        return imageResId;
    }
}
