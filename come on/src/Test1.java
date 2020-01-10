import java.util.Arrays;

public class Test1 {
    private static int[] arr1 = {1, 2, 3, 4};
    private static int[] arr2 = {5, 6, 7, 8};
    public static void change(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
    }
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void adjustArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <right) {
            while (arr[left] % 2 == 0) {
                left++;
            }
            while (arr[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }
    }
    public  static void main(String[] args) {
//        change(arr1,arr2);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        adjustArr(arr);
        System.out.println(Arrays.toString(arr));
    }

}

