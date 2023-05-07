package validIPAddress;

import java.util.Arrays;
import java.util.stream.Stream;
///still need to work
public class CheckValidIP {

    public static boolean isValidIP(String ip) {

        if (ip.length() < 1) {
            return false;
        }

        String[] groups = ip.split("\\.");
        if (groups.length != 4) {
            return false;
        }
        System.out.println(groups.length);
        Arrays.stream(groups).filter(s -> s.length() > 1 )
                .map(Integer::parseInt).forEach(System.out::println);

        long count = Arrays.stream(groups).filter(s -> s.length() > 1 && s.startsWith("0"))
                .map(Integer::parseInt)
                .filter(i -> (i >= 0 && i <= 255))
                .count();
          System.out.println(count);
        return false;
    }

    public static void main(String[] args)
    {
        // an IPv4 address
        final String INET4ADDRESS = "172.8.7.28";

        // Validate an IPv4 address
        if (isValidIP(INET4ADDRESS)) {
            System.out.print("The IP address " + INET4ADDRESS + " is valid");
        }
        else {
            System.out.print("The IP address " + INET4ADDRESS + " isn't valid");
        }
    }
}
