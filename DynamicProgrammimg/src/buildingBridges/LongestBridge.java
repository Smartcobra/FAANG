package buildingBridges;

import java.util.Arrays;

public class LongestBridge {
    public int getLongestUncrossedNumber(CityPairs[] cities) {
        int n = cities.length;
        if (cities.length == 0 || cities == null) {
            return 0;
        }
        Arrays.sort(cities);
        Arrays.asList(cities).stream().forEach(System.out::println);

        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (cities[i].south > cities[j].south && dp[j] > dp[i]) {
                    dp[i] = dp[j] ;
                }
            }
            dp[i]++;

        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        CityPairs [] cityPairs= new CityPairs[10];
        cityPairs[0]= new CityPairs(10,20);
        cityPairs[1]= new CityPairs(2,7);
        cityPairs[2]= new CityPairs(8,15);
        cityPairs[3]= new CityPairs(17,3);
        cityPairs[4]= new CityPairs(21,40);
        cityPairs[5]= new CityPairs(50,4);
        cityPairs[6]= new CityPairs(41,57);
        cityPairs[7]= new CityPairs(60,80);
        cityPairs[8]= new CityPairs(80,90);
        cityPairs[9]= new CityPairs(1,30);
        Arrays.sort(cityPairs);

        LongestBridge longestBridge = new LongestBridge();

        //Arrays.asList(cityPairs).stream().forEach(System.out::println);
        System.out.println(longestBridge.getLongestUncrossedNumber(cityPairs));
    }
}
