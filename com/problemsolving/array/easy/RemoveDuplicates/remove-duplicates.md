Initialize 2 variables i as 0 and j as 1, where i will track the position of the last unique element found and j will iterate through the array to find unique element

Iterate in array using j from second element to the end of the array

If the element at position j is different from element at poisiton i, it means a new unique element is found. This is because the array is sorted in non-decreasing order, so any new element that is different from previous one must be unique

When a new unique element is found , increment i to move to the next position for storing unique elements. Copy the element at position j to the new position at i. This ensures that first i+1 elements in the array are unique