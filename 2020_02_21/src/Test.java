import java.util.Arrays;

public class Test {
    //4、实现函数 ToLowerCase() ，该函数接收一个字符串参数 str ，并将该字符串中的大写字母转换成小写字母，
    //之后返回新的字符串
    public static String ToLowerCase(String str) {
        //思路：创建一个新的字符数组进行转换
        char[] st = new char[str.length()];
        char n;
        for (int i = 0; i < str.length(); i++) {
            n = str.charAt(i);
            if (n >= 65 && n <= 90) {
                n = (char)(n + 32);
            }
            st[i] = n;
        }
        return new String(st);
    }

    public static String ToLowerCase2(String str) {
        String str1 = str.toLowerCase();
        return str1;
    }

    //5、给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public static void rotate(int[] nums, int k) {
        //a. 暴力
        for (int i = 0; i < k; i++) {
            int cur = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = cur;
                cur = temp;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        //b. 旋转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotate3(int[] nums, int k) {
        //c. 使用额外数组
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    //4、给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成

    public static int removeElement(int[] nums, int val) {
        //原地删除所有数值等于val的元素
        //使用双指针的形式删除
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if(nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[n - 1];
                n--;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回//将会被按顺序插入的位置,你可以假设数组中无重复元素

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

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

    public static int getValue(int i){
        int result = 0;
        switch(i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
    //4、赎金信

    public static boolean canConstruct(String ranSomNote, String magazine) {
        char c;
        boolean flag = false;
        for (int i = 0; i < ranSomNote.length(); i++) {
            c = ranSomNote.charAt(i);
            flag = false;
            for (int j = 0; j < magazine.length(); j++) {
                if (c == magazine.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                break;
            }
        }
        return flag;
    }
    //给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中
    //每个元素都不相同，则返回 false。
    public static boolean containsDuplicate(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }

    //5、判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public static boolean isPalindrome(int x) {
        
    }
    public static void main(String[] args) {
//        System.out.println(ToLowerCase2("SDfvGG"));
//        int[] arr = {1, 2, 3, 4, 6, 7};
//        rotate3(arr, 3);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(removeElement2(arr, 4));
//        System.out.println(searchInsert2(arr, 7));
//        int i = 7;
//        do{
//            System.out.println(i--);
//            i--;
//        }while(i != 0);
//        System.out.println(i);
//        System.out.println(getValue(2));
//        System.out.println(canConstruct("aax", "aaxxx"));
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(containsDuplicate(arr));
    }
}
