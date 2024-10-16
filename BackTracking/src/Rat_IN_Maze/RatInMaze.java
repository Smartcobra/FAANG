package Rat_IN_Maze;

public class RatInMaze {


    public static void main(String[] args) {
        int[][] maze = {{1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1}};

         int row = maze.length;
         int col = maze[0].length;

        boolean[][] isVisited = new boolean[row][col];

        mazeRat(0, 0, row - 1, col - 1, maze, isVisited, "");

    }

    private static void mazeRat(int sr, int sc, int er, int ec, int[][] maze, boolean[][] isVisited, String s) {
        if (sc < 0 || sr < 0) return;
        if (sr > er || sc > ec) return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        if (maze[sr][sc] == 0) return; // blocker to move the maze
        if (isVisited[sr][sc]) return;

        isVisited[sr][sc] = true;


        //right
        mazeRat(sr, sc + 1, er, ec, maze, isVisited, s + "R");
        //down
        mazeRat(sr + 1, sc, er, ec, maze, isVisited, s + "D");
        //left
        mazeRat(sr, sc - 1, er, ec, maze, isVisited, s + "L");
        //up
        mazeRat(sr - 1, sc, er, ec, maze, isVisited, s + "U");
        isVisited[sr][sc] = false;
    }
}
