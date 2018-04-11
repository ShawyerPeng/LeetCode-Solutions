package array;

/**
 * Created by ShawyerPeng on 2018/4/4.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //减1预处理数组，简化映射关系
        for(int i = 0; i < nums.length; i++){
            nums[i]--;
        }
        for(int i = 0; i < nums.length;i++){
            while(nums[i]!=i && nums[i] >=0 && nums[i]<nums.length && nums[i]!=nums[nums[i]]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        //找出第一个不在对应位置的数
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=i) return i+1;
        }
        //都没找到说明是最后一个数
        return nums.length+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();

    }
}
