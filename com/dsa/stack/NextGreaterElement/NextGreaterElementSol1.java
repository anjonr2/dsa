public class NextGreaterElementSol1 {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
