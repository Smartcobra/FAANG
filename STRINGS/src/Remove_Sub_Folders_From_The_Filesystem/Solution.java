package Remove_Sub_Folders_From_The_Filesystem;

import java.util.*;
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(String f:folder){
            boolean isSubFolder = false;

            for(String existing:set){
                if(f.startsWith(existing+'/')){
                    isSubFolder=true;
                    break;
                }
            }

            if(!isSubFolder){
                result.add(f);
                set.add(f);
            }
        }
        return result;

    }
}
