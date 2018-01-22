package array;

/**
 * https://leetcode.com/problems/remove-element
 * 问题：
 * 思路：
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i <nums.length; i++){

            if(nums[i] != val){
                nums[m] = nums[i];
                m++;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        System.out.println(obj.removeElement(new int[]{3,2,2,3}, 3));
    }
}
