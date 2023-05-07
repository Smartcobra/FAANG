package Validate_IP_Address;


//https://leetcode.com/problems/validate-ip-address/
public class Validate_IP_Address {

    public static String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) return "IPv4";
        else if (isIPv6(queryIP)) return "IPv6";
        else return "Neither";

    }

    private static boolean isIPv6(String ip) {
        String[] arr = ip.split(":", -1);
        for(String a: arr) {
            try{
                if(Integer.parseInt(a, 16)>65535 || a.length()>4) return false;
            } catch (NumberFormatException e) { return false; }
        }
        return arr.length == 8;
    }

    public static boolean isIPv4(String queryIP) {
        String[] arr = queryIP.split("\\.", -1);
        for (String a : arr) {
            try {
                if (Integer.parseInt(a) > 255 || (a.charAt(0) == '0' && a.length() != 1)) return false;
            } catch (NumberFormatException e) {
                return false;
            }

        }
        return arr.length == 4;
    }

    public static void main(String[] args) {
        String queryIP = "172.16.254.1";
        String queryIP2 = "256.256.256.256";
        String queryIP3 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
                         // "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//
//        System.out.println(isIPv4(queryIP));
         System.out.println(isIPv6(queryIP3));
        System.out.println(validIPAddress(queryIP3));
    }
}
