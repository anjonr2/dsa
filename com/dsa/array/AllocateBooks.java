import java.util.ArrayList;

public class AllocateBooks {
    public static int countNoOfStudents(ArrayList<Integer> arr, int pages) {
        // initially at student 1
        int student = 1;
        // he has initially 0 pages or books allocated
        int noOfPages = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (noOfPages + arr.get(i) <= pages) {
                noOfPages += arr.get(i);
            } else {
                student++;
                noOfPages = arr.get(i);
            }
        }
        return student;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }

        for (int pages = low; pages <= high; pages++) {
            int noOfStudents = countNoOfStudents(arr, pages);
            if (noOfStudents == m)
                return pages;
        }
        return -1;
    }

    public static int findPages1(ArrayList<Integer> arr, int n, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr.get(i));
            high += arr.get(i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfStudents = countNoOfStudents(arr, mid);
            if (noOfStudents > m) {
                // if no of students required more than given then eliminate left half
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
