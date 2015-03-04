
public class Search2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        int lo = 0;
        int hi = h*w-1;
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;
            int i = mid/w;
            int j = mid%w;
            if (target == matrix[i][j]) return true;
            if (target < matrix[i][j])
                hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
}
