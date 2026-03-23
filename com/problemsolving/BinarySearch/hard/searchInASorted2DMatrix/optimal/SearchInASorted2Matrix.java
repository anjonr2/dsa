public class SearchInASorted2Matrix {
    /*
     * map 1D index into the corresponding row and column of the 2 matrix
     * To do this mapping if there are 'm' columns in the matrix an the index is 'i'
     * then
     * row = i/m, column = i%m
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows
        int n = matrix.length;

        // Get the number of cols
        int m = matrix[0].length;

        // intial binary search range
        int low = 0, high = n * m - 1;

        // Perform binary search
        while (low <= high) {
            // it calculates an index between 0 to n*m - 1
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            // check if the target is found
            if (matrix[row][col] == target)
                return true;

            // Discard left half
            else if (matrix[row][col] < target) {
                // since the matrix is sorted so any element to left of target will also be
                // smaller than target
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}

/*
 * Time complexity : O(log n*m) where n = given row no m = given col no
 * we are applying a binary search in a imaginary matrix of size n*m
 */