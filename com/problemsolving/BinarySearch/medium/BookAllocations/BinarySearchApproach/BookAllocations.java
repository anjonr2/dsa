package com.problemsolving.BinarySearch.medium.BookAllocations.BinarySearchApproach;

public class BookAllocations {
    /*
     * Function to calculate the number of students required given the maximum pages
     * each student can read
     * 
     * @Param books : which is an array of number of pages each book has in that
     * list
     * 
     * @Param pages : no of pages each student at max can read
     */
    private int countStudents(int[] books, int pages) {
        int n = books.length;
        int student = 1;
        // this keeps a count of no of pages current student has
        int noOfPages = 0;
        for (int i = 0; i < n; i += 1) {
            // it checks if the allocation of a book is within the limit of maximum pages a
            // student can read
            if (noOfPages + books[i] <= pages) {
                noOfPages += books[i];
            } else {
                // if it exceeds the limit new book is allocated to a new student and noPages is
                // reinitialized to pages of current book
                student += 1;
                noOfPages = books[i];
            }
        }
        return student;
    }

    public int findPages(int[] books, int m) {
        int n = books.length;

        // if number of student is more than number of book then it is impossible to
        // allocate atleast one book to each student
        if (m > n)
            return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i += 1) {
            /*
             * because a student must read atleast one full book
             * books [] = {25,46,28,49,24}
             * for low 25 i.e starting point is 25
             * if each student at max can read 25 pages of book then book no 1 ,2,3 having
             * pages 46, 28 and 49 can't be allocated to any student
             */
            low = Math.max(low, books[i]);
            high += books[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(books, mid);
            if (students > m) {
                // if with minum pages mid it requires more student than m to allocate all the
                // book then anything to right of mid will also require more no of books so
                // eliminate right
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
