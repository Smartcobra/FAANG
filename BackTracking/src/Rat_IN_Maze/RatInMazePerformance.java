package Rat_IN_Maze;

public class RatInMazePerformance {
    /**
     *
     *  removing extra space by removing isVisited
     *  Modify the given array, if the place has been visited put -1, and again backtrack
     * @param args
     */

    public static void main(String[] args) {

        int[][] maze = {{1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1}};

        int row = maze.length;
        int col = maze[0].length;

        boolean[][] isVisited = new boolean[row][col];
        mazeRat(0, 0, row - 1, col - 1, maze, "");

    }

    private static void mazeRat(int sr, int sc, int er, int ec, int[][] maze, String s) {
        if (sc < 0 || sr < 0) return;
        if (sr > er || sc > ec) return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        if (maze[sr][sc] == 0) return; // blocker to move the maze
        if (maze[sr][sc]==-1) return;

        maze[sr][sc] = -1;


        //right
        mazeRat(sr, sc + 1, er, ec, maze,s + "R");
        //down
        mazeRat(sr + 1, sc, er, ec, maze, s + "D");
        //left
        mazeRat(sr, sc - 1, er, ec, maze, s + "L");
        //up
        mazeRat(sr - 1, sc, er, ec, maze, s + "U");
        maze[sr][sc] = 1;
    }
}
