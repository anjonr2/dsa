package basic.ReverseAnArray.Recursive;

public class ReverseAnArray {
    public static void reverse(int[] arr, int n, int left, int right) {
        if (left > right)
            return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left = left + 1;
        right = right - 1;
        reverse(arr, n, left, right);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        reverse(arr, n, 0, n - 1);
        for (int el : arr) {
            System.out.println("el: " + el);
        }
    }
}
