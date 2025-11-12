import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MovieManager {
    private Movie[] movies;

    public MovieManager(Movie[] movies) {
        this.movies = movies;
    }

    public void showMoviesAboveAverageCost() {
        if (movies.length == 0) {
            System.out.println("Массив фильмов пуст!");
            return;
        }

        double averageCost = calculateAverageCost();
        System.out.println("\n=== Фильмы со стоимостью проката выше средней (" + averageCost + ") ===");

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getRentalCost() > averageCost) {
                System.out.println(movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Фильмы со стоимостью выше средней не найдены.");
        }
    }

    private double calculateAverageCost() {
        double sum = 0;
        for (Movie movie : movies) {
            sum += movie.getRentalCost();
        }
        return sum / movies.length;
    }

    public void showEarliestMovie() {
        if (movies.length == 0) {
            System.out.println("Массив фильмов пуст!");
            return;
        }

        Movie earliestMovie = movies[0];
        for (int i = 1; i < movies.length; i++) {
            if (movies[i].getReleaseYear() < earliestMovie.getReleaseYear()) {
                earliestMovie = movies[i];
            }
        }

        System.out.println("\n=== Фильм самого раннего года выпуска ===");
        System.out.println(earliestMovie);
    }

    public void sortMoviesByTitle() {
        Arrays.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        });

        System.out.println("\n=== Массив фильмов отсортирован по названиям ===");
        printAllMovies();
    }

    public void searchAndEditMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите название фильма для поиска: ");
        String searchTitle = scanner.nextLine();

        Movie foundMovie = findMovieByTitle(searchTitle);

        if (foundMovie == null) {
            System.out.println("Фильм с названием '" + searchTitle + "' не найден.");
            return;
        }

        System.out.println("\n=== Найден фильм ===");
        System.out.println(foundMovie);

        // Меню редактирования
        System.out.println("\n=== Редактирование полей ===");
        System.out.println("1 - Название");
        System.out.println("2 - Год выпуска");
        System.out.println("3 - Страна");
        System.out.println("4 - Жанр");
        System.out.println("5 - Стоимость проката");
        System.out.print("Выберите поле для редактирования: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Введите новое название: ");
                String newTitle = scanner.nextLine();
                foundMovie.setTitle(newTitle);
                break;
            case 2:
                System.out.print("Введите новый год выпуска: ");
                int newYear = scanner.nextInt();
                foundMovie.setReleaseYear(newYear);
                break;
            case 3:
                System.out.print("Введите новую страну: ");
                String newCountry = scanner.nextLine();
                foundMovie.setCountry(newCountry);
                break;
            case 4:
                System.out.print("Введите новый жанр: ");
                String newGenre = scanner.nextLine();
                foundMovie.setGenre(newGenre);
                break;
            case 5:
                System.out.print("Введите новую стоимость проката: ");
                double newCost = scanner.nextDouble();
                foundMovie.setRentalCost(newCost);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        System.out.println("\n=== Информация о фильме после редактирования ===");
        System.out.println(foundMovie);
    }

    private Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public void printAllMovies() {
        if (movies.length == 0) {
            System.out.println("Массив фильмов пуст!");
            return;
        }

        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
    }

    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("Интерстеллар", 2014, "США", "Фантастика", 1500.50),
                new Movie("Побег из Шоушенка", 1994, "США", "Драма", 800.25),
                new Movie("Крестный отец", 1972, "США", "Криминал", 1200.75),
                new Movie("Начало", 2010, "США", "Фантастика", 1100.00),
                new Movie("Форрест Гамп", 1994, "США", "Драма", 900.30)
        };

        MovieManager manager = new MovieManager(movies);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== МЕНЮ УПРАВЛЕНИЯ ФИЛЬМАМИ ===");
            System.out.println("1 - Показать все фильмы");
            System.out.println("2 - Фильмы со стоимостью проката выше средней");
            System.out.println("3 - Фильм самого раннего года выпуска");
            System.out.println("4 - Упорядочить по названиям");
            System.out.println("5 - Поиск и редактирование");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n=== ВСЕ ФИЛЬМЫ ===");
                    manager.printAllMovies();
                    break;
                case 2:
                    manager.showMoviesAboveAverageCost();
                    break;
                case 3:
                    manager.showEarliestMovie();
                    break;
                case 4:
                    manager.sortMoviesByTitle();
                    break;
                case 5:
                    manager.searchAndEditMovie();
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        } while (choice != 0);

        scanner.close();
    }
}