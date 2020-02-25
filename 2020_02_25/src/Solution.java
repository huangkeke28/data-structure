import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.util.Arrays;

public class Solution {
    //4、给定一个按非递减顺序排序的整数数组 A ，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    //(注意：非递减顺序即递增，并且这里你注意负数哈！)
    //排序
    public static int[] sortedSquares(int[] A) {
        int[] newA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            newA[i] = A[i] * A[i];
        }
        Arrays.sort(newA);
        return newA;
    }
    //双指针
    public static int[] sortedSquares2(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0) {
            //j取的是正数
            j++;
        }
        int i = j - 1;
        int[] ans = new int[N];
        int t = 0;
        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
    }

    //5、给定一个字符串 S ，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反
    //转。
    public static String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                ans.append(j--);
            } else {
                ans.append(i);
            }
        }
        return ans.toString();
    }

    //4、给定一个非负整数数组 A ，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素(注意：不
    //是排序，只是奇数在前偶数在后哈！)
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (A[left] % 2 == 0) {
                left++;
            }
            while (A[right] % 2 != 0) {
                right--;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }

    //两边扫描
    public static int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[t++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                ans[t++] = A[i];
            }
        }
        return ans;
    }

    //原地算法
    public static int[] sortArrayByParity3(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if (A[i] % 2 == 0) {
                i++;
            }
            if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }

    //5、给定一个整数类型的数组 nums ，请编写一个能够返回数组“中心索引”的方法。我们是这样定义数组中心索引
    //的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。如果数组不存在中心索引，那么我们应该
    //返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
    public static int pivoIndex(int[] nums) {
        if (nums.length % 2 == 1) {
            int sum1 = 0;
            for (int i = 0; i < nums.length / 2 + 1; i++) {
                sum1 += nums[i];
            }
            int sum2 = 0;
            for (int i = nums.length / 2; i < nums.length; i++) {
                sum2 += nums[i];
            }
            if (sum1 == sum2) {
                return nums.length / 2 + 1;
            } else {
                return -1;
            }
        } else {
            int sum1 = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                sum1 += nums[i];
            }
            int sum2 = 0;
            for (int i = nums.length / 2; i < nums.length; i++) {
                sum2 += nums[i];
            }
            if (sum1 == sum2) {
                return nums.length / 2;
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
//        System.out.println(Arrays.toString(sortedSquares(arr)));
//        System.out.println(Arrays.toString(sortArrayByParity3(arr)));
        System.out.println(pivoIndex(arr));
    }
}
