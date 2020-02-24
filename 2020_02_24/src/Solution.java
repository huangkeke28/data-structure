import com.sun.deploy.ref.AppModel;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import org.omg.CORBA.StringHolder;
import sun.plugin2.applet.Applet2Manager;

import javax.naming.PartialResultException;
import javax.swing.plaf.BorderUIResource;
import java.util.Arrays;

public class Solution {
    //4、赎金信
//    public static boolean canConstruct(String ransomNote, String magazine) {
//
//    }

    //5、判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
    //a. 简单粗暴
    public static boolean isPliandrome(int x) {
        String reverseStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reverseStr);
    }

    //b. 数学解法
    public static boolean isPliandrome2(int x) {
        //边界判断
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reverseNum = 0;
        int y = x;
        while (y != 0) {
            reverseNum = reverseNum * 10 + y % 10;
            y /= 10;
        }
        return x == reverseNum;
    }

    //巧妙解法
    public static boolean isPliandrome3(int x) {
        //对参数边界条件的判断
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int y, reverseNum = 0;
        while (x > reverseNum) {
            y = x % 10;
            reverseNum = reverseNum * 10 + y;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }

    //4、给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。如果不存在最后一个单词，
    //请返回 0
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    //5、给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//    public static void merge(int[] num1, int m, int[] num2, int n) {
//        System.arraycopy(num2, 0, num1, m, n);
//        Arrays.sort(num1);
//    }
//    public static void merge(int[] num1, int m, int[] num2, int n) {
//        //双指针，从前往后
//        //1.先复制一个num1数组
//        int[] num1_copy = new int[m];
//        System.arraycopy(num1, 0, num1_copy, 0, m);
//        //对num1_copy和num2设两个指p1,p2
//        int p1 = 0;
//        int p2 = 0;
//        //num1设指针p
//        int p = 0;
//        //比较num1_copy和num2中的元素，加入到num1中
//        while (p1 < m && p2 < n) {
//            num1[p++] = (num1_copy[p1] < num2[p2]) ? num1_copy[p1++] : num2[p2++];
//        }
//        //如果还有元素要添加
//        if (p1 < m) {
//            System.arraycopy(num1_copy, p1, num1, p1 + p2,m + n - p1 -p2);
//        }
//        if (p2 < n) {
//            System.arraycopy(num2, p2, num1, p1 + p2, m + n - p1 - p2);
//        }
//    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            num1[p--] = (num1[p1--] < num2[p2--] ? num2[p2--] : num1[p1--]);
        }
        System.arraycopy(num2, 0, num1, 0, p2 + 1);
    }

    //4、给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中
    //每个元素都不相同，则返回 false

    //a. 此算法繁琐 会超时
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (cur == nums[j]) {
                    count++;
                }
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }

    //排序
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        //升序排列 {1, 2, 8, 4, 3, 6}
        for (int bound = 0; bound < nums.length; bound++) {
            for (int cur = nums.length - 1; cur > bound; cur--) {
                if (nums[cur - 1] > nums[cur]) {
                    int temp = nums[cur - 1];
                    nums[cur - 1] = nums[cur];
                    nums[cur] = temp;
                }
            }
        }
    }
    //二分查找
    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == toFind) {
                return mid;
            } else if (arr[mid] < toFind) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    //冒泡排序
    public static void bubbleSort2(int[] nums) {
        for (int bound = 0; bound < nums.length; bound++) {
            for (int cur = nums.length - 1; cur > bound; cur--) {
                if (nums[cur - 1] > nums[cur]) {
                    int temp = nums[cur - 1];
                    nums[cur - 1] = nums[cur];
                    nums[cur] = temp;
                }
            }
        }
    }

    //5、你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入
    //1 次或多次。你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长
    //按），那么就返回 True。
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();
        int namelength = nameArray.length;
        int typedlength = typedArray.length;
        if (namelength > typedlength) {
            return false;
        }
        while (i < namelength && j < typedlength) {
            if (nameArray[i] == typedArray[j]) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == namelength) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isPliandrome3(131));
//        System.out.println(lengthOfLastWord("In a room "));
//        int[] num1 = {1, 2, 3};
//        int[] num2 = {2, 3, 4};
//        merge(num1, 3, num2, 3);
//        System.out.println(Arrays.toString(num1));
//        int[] nums = {1, 1, 2, 3, 4, 5};
//        System.out.println(containsDuplicate2(nums));
//        int[] nums = {1, 3, 2, 9, 4, 6};
//        bubbleSort(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(isLongPressedName("alexz", "aaleexxd"));
    }
}
