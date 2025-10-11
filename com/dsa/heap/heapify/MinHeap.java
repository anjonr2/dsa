/*Function to implement the heapify algorithm for a min-heap */
public class MinHeap {
    public void heapifyUp(int[] arr, int ind) {
        int parentIndex = (ind - 1) / 2;
        if (ind > 0 && arr[parentIndex] > arr[ind]) {
            int temp = arr[parentIndex];
            arr[ind] = arr[parentIndex];
            arr[parentIndex] = temp;
            heapifyUp(arr, parentIndex);
        }
    }

    public void heapifyDown(int[] arr, int ind) {
        int n = arr.length;

        // index of the smallest element
        int smallest_Index = ind;

        int leftChildrenIndex = 2 * ind + 1;
        int rightChildrenIndex = 2 * ind + 2;

        if (leftChildrenIndex < n && arr[leftChildrenIndex] < arr[smallest_Index]) {
            smallest_Index = leftChildrenIndex;
        }
        if (rightChildrenIndex < n && arr[rightChildrenIndex] < arr[smallest_Index]) {
            smallest_Index = rightChildrenIndex;
        }

        if (smallest_Index != ind) {
            int temp = arr[ind];
            arr[ind] = arr[smallest_Index];
            arr[smallest_Index] = temp;
            heapifyDown(arr, rightChildrenIndex);
        }
    }

    public void heapify(int[] arr, int ind, int val) {
        if (arr[ind] > val) {
            arr[ind] = val;
            heapifyUp(arr, ind);
        } else {
            arr[ind] = val;
            heapifyDown(arr, ind);
        }
    }
}
