package boxstacking;

import java.util.*;

public class BoxStacking {

    public List<Box>  createAllRotations (List<Box> boxes){
        List<Box> rotations= new ArrayList<>();
        for(Box box: boxes){
            rotations.add(box);
            ///keeping width constant
            rotations.add(new Box(Math.max(box.length,box.height),Math.min(box.length,box.height), box.width));
            ///keeping length constant
            rotations.add(new Box(Math.max(box.width,box.height),Math.min(box.width,box.height), box.length));
        }
        return rotations;

    }

    public int getMaxHeight(List<Box> boxes){
        // get all the combination with rotation
        List<Box> rotations= createAllRotations(boxes);

        //sort based on the 2-D  W*L
        Collections.sort(rotations,(x,y)->y.length*y.width-x.length*x.width);

        // create dp array-
        int dp[] = new int [rotations.size()];
        //LIS Concept
        for(int i=0;i<rotations.size();i++){
           for (int j=0;j<i;j++){
                if(rotations.get(i).length<rotations.get(j).length && rotations.get(i).width <rotations.get(j).width){
                    dp[i]=Math.max(dp[i],dp[j]);

                }
            }
           dp[i] +=rotations.get(i).height;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args)
    {
        // input boxes
        List<Box> boxes = Arrays.asList(new Box(4, 2, 5),
                new Box(3, 1, 6),
                new Box(3, 2, 1),
                new Box(6, 3, 8));

        BoxStacking boxStacking= new BoxStacking();

        System.out.println("The maximum height is " + boxStacking.getMaxHeight(boxes));
    }

}
