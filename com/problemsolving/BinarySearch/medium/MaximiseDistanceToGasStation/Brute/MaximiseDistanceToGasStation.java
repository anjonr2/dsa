package com.problemsolving.BinarySearch.medium.MaximiseDistanceToGasStation.Brute;

public class MaximiseDistanceToGasStation {
    /*
     * Function to minimise the maximum distance between gas stations
     */
    public double minimiseMaxGasStationDistance(int[] gasStations, int noOfGasStations) {
        int n = gasStations.length;

        /*
         * Array to store how many gas stations are placed in each section. Where
         * section is the place between any two consecutive gas stations given in input
         * array
         * gasStations = [1, 2, 3, 4, 5]
         * 1 --- 2 --- 3 --- 4 --- 5 . If there are 5 gas stations then there are 4
         * sections . So if there are n gas stations then there will be n-1 sections
         * hence the size of howMany array is n-1
         */
        int[] howMany = new int[n - 1];

        for (int gasStation = 1; gasStation <= noOfGasStations; gasStation += 1) {
            /* maxSectionWidth stores the max distance between any two gas station */
            double maxSectionWidth = -1;
            int maxInd = -1;

            for (int i = 0; i < n; i += 1) {
                double diff = gasStations[i + 1] - gasStations[i];
                /*
                 * 1 -- 2 -- 3 -- 4 -- 5
                 * if we insert a gas station between 1 and 2
                 * 1 - 1.2 - 2 -- 3 -- 4 -- 5
                 * so section previously was 1 after inserting new gas station now it's 2
                 * section
                 * so if we insert n gas station no of section becomes n + 1
                 */
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxSectionWidth) {
                    maxSectionWidth = sectionLength;
                    maxInd = i;
                }
            }
            /* Insert the current gas station gasStation into maxInd section */
            howMany[maxInd] += 1;
        }

        double answer = -1;
        /*
         * Traverse through the howMany array which stores in each section how many gas
         * stations are added
         */
        for (int i = 0; i < n - 1; i += 1) {
            double diff = gasStations[i + 1] - gasStations[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            answer = Math.max(answer, sectionLength);
        }
        return answer;
    }
}
