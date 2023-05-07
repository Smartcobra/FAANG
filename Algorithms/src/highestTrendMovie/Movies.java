package highestTrendMovie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Movies {
    Map<String, Movie> movieMap;
    Map<String, PriorityQueue<Movie>> highestTrend;


    public Movies() {
        movieMap = new HashMap<>();
        highestTrend = new HashMap<String, PriorityQueue<Movie>>();
    }


    public void addMovie(String name, String genre, Double trendScore) {
        Movie newMovie = new Movie(name, genre, trendScore);
        movieMap.put(name, newMovie);

        if (!highestTrend.containsKey(genre)) {
            PriorityQueue<Movie> pq = new PriorityQueue<>((m1,m2)->m2.trendScore.compareTo(m1.trendScore));
            highestTrend.put(genre, pq);
        }

        PriorityQueue<Movie> movies = highestTrend.get(genre);
        movies.add(newMovie);
    }

    public String getMovieWithMaxTrendScoreByGenre(String genre) {
        if (highestTrend.containsKey(genre)) {
            return highestTrend.get(genre).peek().name;
        } else {
            return "no movies found";
        }
    }

    public void updateMovieTrendScore(String movieName, double score) {
        Movie movie = movieMap.get(movieName);
        if (movie != null) {
            PriorityQueue<Movie> movies = highestTrend.get(movie.genre);
            movies.remove(movie);
            movie.updateScore(score);
            movies.add(movie);
        }
    }
}
