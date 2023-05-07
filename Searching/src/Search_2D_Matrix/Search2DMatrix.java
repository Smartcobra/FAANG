package Search_2D_Matrix;
///https://leetcode.com/problems/search-a-2d-matrix/
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int r = rowSearch(matrix, target, rowLen, colLen);

        if (r == -1) return false;

        return binarySearch(matrix, target, r, colLen);

    }


    public int rowSearch(int[][] matrix, int target, int rowLen, int colLen) {
        int l = 0;
        int h = rowLen - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (matrix[mid][0] <= target && matrix[mid][colLen - 1] >= target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }

    public boolean binarySearch(int[][] matrix, int target, int row, int colLen) {
        int l = 0;
        int h = colLen - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return false;
    }

}

