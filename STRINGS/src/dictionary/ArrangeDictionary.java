package dictionary;

//Given String which contain only lower case Alphabets,Sort the given string in dictionary orders
//dabaedb  =>aabbdde

public class ArrangeDictionary {
    //count frequency
    public static int[] countFrequency(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        int count[] = new int[26];
        for (int i = 0; i < n; i++) {
            int index = s[i] - 'a';
            count[index]++;
        }
        return count;
    }

    public static String sortDictionary(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        int k = 0;
        int[] c = countFrequency(str);
        char[] res = new char[n];
        //iterate over c
        for (int i = 0; i < 26; i++) {
            // iterate for each c[i] and append the char
            for (int j = 0; j < c[i]; j++) {
                res[k] = (char) (i + 'a');
                k++;
            }
        }
        //String string = new String(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="dabaedb";
        String s = sortDictionary(str);
        System.out.println(s);

    }
}
