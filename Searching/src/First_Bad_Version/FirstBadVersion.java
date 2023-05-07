package First_Bad_Version;


///https://leetcode.com/problems/first-bad-version/

public class FirstBadVersion extends VersionControl{
        public int firstBadVersion(int n) {
            int l = 0;
            int h = n;

            while(l<=h){
                int mid = l + (h-l)/2;

                if(!isBadVersion(mid)){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }

            return l;

        }

}
