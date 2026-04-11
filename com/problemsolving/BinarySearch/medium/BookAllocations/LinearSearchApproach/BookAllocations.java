package com.problemsolving.BinarySearch.medium.BookAllocations.LinearSearchApproach;

public class BookAllocations {
    /*
     * Function to count the number of students required given the maximum pages
     * each student can read
     */
    private int countStudents(int[] books, int pages) {
        int n = books.length;
        int students = 1;
        int pagesStudentAllocated = 0;
        for (int i = 0; i < n; i += 1) {
            // this checks if allocation of a book is within the limit of maximum pages a
            // student can read which is pages. If it is true then pages of new book
            // allocated is added to current no pf pages student has
            if (pagesStudentAllocated + books[i] <= pages) {
                // add pages to current student
                pagesStudentAllocated += books[i];
            } else {
                // if it crosses the limit book is allocated to a new student
                students += 1;
                pagesStudentAllocated = books[i];
            }
        }
        return students;
    }

    /*
     * Function to allocate the book to 'm'
     * students such that the maximum number
     * of pages assigned to a stadium is minimum
     */
    public int findPages(int[] books, int m) {
        int n = books.length;

        // if no of students is more than no of books then each student can't be
        // allocated atleast one book so returning 1
        if (m > n)
            return -1;

        // calculate the range for search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i += 1) {
            // low is the maximum pages any book has because a student must read at least
            // one full book
            low = Math.max(low, books[i]);

            // high is sum of all the pages. If only one student read all books
            high += books[i];
        }

        // pages is the count of at most pages any student can read
        for (int pages = low; pages <= high; pages += 1) {
            if (countStudents(books, pages) == m)
                return pages;
        }

        return low;
    }
}
