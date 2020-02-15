import java.util.Arrays;
public class Test {
    //实现函数 ToLowerCase() ，该函数接收一个字符串参数 str ，并将该字符串中的大写字母转换成小写字母，
    //之后返回新的字符串

    public static String ToLowerCase(String str) {
        char[] st = new char[str.length()];
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char)(c + 32);
            }
            st[i] = c;
        }
        return new String(st);
    }

    public static void main(String[] args) {
//        System.out.println(ToLowerCase("STR"));;
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    //暴力旋转 时间复杂度O(n * k) 空间复杂度O(1)
    public static void rotate(int[] nums, int k) {
        int temp,prev;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }



    //给定一个数组 nums  和一个值 val ，你需要原地移除所有数值等于  val  的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成




    //5、给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它
    //将会被按顺序插入的位置,你可以假设数组中无重复元素.
}
