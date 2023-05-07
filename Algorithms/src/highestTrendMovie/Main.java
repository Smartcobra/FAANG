package highestTrendMovie;



public class Main {
    public static void main(String[] args) {
        Movies movies = new Movies();

        movies.addMovie("Dont Look up", "Comedy", 8.5);
        movies.addMovie("Birdman", "Drama", 8.2);
        movies.addMovie("Avengers", "Action", 9.0);
        movies.addMovie("Bhaag Milkha Bhaag", "Sports", 8.5);

        System.out.println(movies.getMovieWithMaxTrendScoreByGenre("Comedy"));
        movies.addMovie("Dont Look up 2", "Comedy", 8.8);

        System.out.println(movies.getMovieWithMaxTrendScoreByGenre("Comedy"));
        System.out.println(movies.getMovieWithMaxTrendScoreByGenre("Drama"));
        movies.updateMovieTrendScore("Dont Look up", 1);
        // System.out.println(movies.highestGenre.get("Comedy"));
        System.out.println(movies.getMovieWithMaxTrendScoreByGenre("Comedy"));

    }
}
