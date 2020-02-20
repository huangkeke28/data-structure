import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.Arrays;
import java.util.Enumeration;

public class Test {
    //4、实现函数 ToLowerCase() ，该函数接收一个字符串参数 str ，并将该字符串中的大写字母转换成小写字母，
    //之后返回新的字符串
    public static String ToLowerCase(String STR) {
        char[] st = new char[STR.length()];
        char c;
        for (int i = 0; i < STR.length(); i++) {
            c = STR.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char)(c + 32);
            }
            st[i] = c;
        }
        return new String(st);
    }

    public static String toLowerCase2(String str) {
        String str1 = str.toLowerCase();
        return str1;
    }

    //5、给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数

    //a. 暴力旋转
    public static void rotate(int[] num, int k) {
        for (int i = 0; i < k; i++) {
            int cur = num[num.length - 1];
            for (int j = 0; j < num.length; j++) {
                int temp = num[j];
                num[j] = cur;
                cur = temp;
            }
        }
    }

    //b. 使用反转
    public static void rotate2(int[] num, int k) {
        k %= num.length;
        reverse(num,0,num.length - 1);
        reverse(num, 0, k - 1);
        reverse(num, k, num.length - 1);
    }
    private static void reverse(int[] num, int src, int dest) {
        while (src < dest) {
            int temp = num[src];
            num[src] = num[dest];
            num[dest] = temp;
            src++;
            dest--;
        }
    }

    //c. 使用额外数组
    public static void rotate3(int[] num, int k) {
        int[] a = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            a[(i + k) % num.length] = num[i];
        }
        for (int i = 0; i < num.length; i++) {
            num[i] = a[i];
        }
    }

    //d.使用环状代替

//    public static void rotate4(int[] num, int k) {
//
//    }

    //给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if(nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    //5、给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它
    //将会被按顺序插入的位置,你可以假设数组中无重复元素
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    //二分法
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] < target) {
            return nums.length;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.out.println(toLowerCase2("STR"));
//        rotate3(arr, 3);
//        System.out.println(Arrays.toString(arr));
        System.out.println(searchInsert(arr, 7));

    }
}
