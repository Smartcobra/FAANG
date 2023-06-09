package Valid_Anagram;

public class Valid_Anagram_Solution_SORT {
    public boolean isAnagram(String s, String t) {
        int [] counter= new int [26];

        if(s.length()!=t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }

        for(int count:counter){
            if(count!=0){
                return false;
            }
        }

        return true;
    }
}
