package basic.ReverseAnArray.Iterative;

public class ReverseAnArray {
    public void reverse(int arr[], int n) {
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i -= 1) {
            ans[n - 1 - i] = arr[i];
        }

        /* Copy the elements from ans to original array */
        for (int i = 0; i < n; i += 1) {
            arr[i] = ans[i];
        }
    }
}
