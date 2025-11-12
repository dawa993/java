public class Movie {
    private String title;           // название
    private int releaseYear;        // год
    private String country;         // страна
    private String genre;           // жанр
    private double rentalCost;      // стоимость

    // Конструктор
    public Movie(String title, int releaseYear, String country, String genre, double rentalCost) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.country = country;
        this.genre = genre;
        this.rentalCost = rentalCost;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public String toString() {
        return String.format("Название: %-20s Год: %-6d Страна: %-15s Жанр: %-15s Стоимость: %.2f",
                title, releaseYear, country, genre, rentalCost);
    }
}
