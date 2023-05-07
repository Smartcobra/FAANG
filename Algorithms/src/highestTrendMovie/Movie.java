package highestTrendMovie;

public class Movie {
    String name;
    String genre;
    Double trendScore;

    public Movie(String name,String genre,Double trendScore){
        this.name=name;
        this.genre=genre;
        this.trendScore=trendScore;
    }

    public void updateScore(Double trendScore){
        this.trendScore +=trendScore;
    }

    public String toString(){
        return this.name+" "+this.genre+" "+this.trendScore;
    }
}
