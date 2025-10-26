import java.util.PriorityQueue;

public class KthLargestElement {
    public int kthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i += 1) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i += 1) {
            if (nums[i] > pq.peek()) {
                pq.poll(); // remove the smallest element from the min-heap
                pq.add(nums[i]);
            }
        }
        return pq.peek(); // return the kth largest element
    }
}
