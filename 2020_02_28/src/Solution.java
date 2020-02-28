import java.util.Arrays;

public class Solution {
    //5、给定一个整数类型的数组 nums ，请编写一个能够返回数组“中心索引”的方法。我们是这样定义数组中心索引
    //的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。如果数组不存在中心索引，那么我们应该
    //返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int nums1 = 0;
        int nums2 = 0;
        while (left <= right) {
            nums1 += nums[left];
            nums2 += nums[right];

            left++;
            right--;
        }
        if (nums1 == nums2) {
            return left;
        } else {
            return -1;
        }
    }

    public int privotIndex2(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    //4、给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数
    //组中每个元素只存储单个数字。(注意：你要防止的是第一个数字是9或者最后一个是9哈！这种情况会有进位滴)

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    //5、给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必
    //须是O(n)
    public int thirdMax(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        if (size == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        }
        Arrays.sort(nums);
        return nums[size - 3];
    }

    //4、给定一个整数数组 nums 和一个目标值 target ，请你在该数组中找出和为目标值的那 两个 整数，并返回他
    //们的数组下标。 要求时间复杂度 O(n) ，当然你可以选择使用暴力的 O(n^2) 的解法.
    public int[] twoSum(int[] nums, int target) {
        //暴力
        int[] newNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == val) {
                    continue;
                } else {
                    if (val + nums[j] == target) {
                        newNums[0] = i;
                        newNums[1] = j;
                        return newNums;
                    }
                }
            }
        }
        return null;
    }
    //删除链表的所有元素
    static class ListNode{
        public int data;
        public ListNode next = null;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode removeAllkey(ListNode head, int key) {
        if (head == null) {
            return null;
        }
        
    }
    }
