package buildingBridges;

import java.util.Arrays;

public class CityPairs implements Comparable<CityPairs>{
    int north;
    int south;

    public CityPairs  (int north,int south){
        this.north=north;
        this.south=south;
    }


    @Override
    public String toString() {
        return "CityPairs{" +
                "north=" + north +
                ", south=" + south +
                '}';
    }
    @Override
    public int compareTo(CityPairs o) {
        //If 2 cities have same north coordinates so sort them in based on the south co-ordinate.
        if(this.north==o.north){
           return this.south-o.south;
        }else{
            // sort based on north
            return this.north-o.north;
        }


    }

//    public static void main(String[] args) {
//        CityPairs [] cityPairs= new CityPairs[10];
//        cityPairs[0]= new CityPairs(10,20);
//        cityPairs[1]= new CityPairs(2,7);
//        cityPairs[2]= new CityPairs(8,15);
//        cityPairs[3]= new CityPairs(17,3);
//        cityPairs[4]= new CityPairs(21,40);
//        cityPairs[5]= new CityPairs(50,4);
//        cityPairs[6]= new CityPairs(41,57);
//        cityPairs[7]= new CityPairs(60,80);
//        cityPairs[8]= new CityPairs(80,90);
//        cityPairs[9]= new CityPairs(1,30);
//        Arrays.sort(cityPairs);
//
//        Arrays.asList(cityPairs).stream().forEach(System.out::println);
//    }
}
