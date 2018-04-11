//package dynamic_programming;
//
///**
// * https://leetcode.com/problems/house-robber
// */
//public class HouseRobber {
//    public int rob(int[] nums) {
//        int prevNo = 0;
//        int prevYes = 0;
//        for (int num : nums) {
//            int temp = prevNo;
//            prevNo = Math.max(prevNo, prevYes);
//            prevYes = num + temp;
//        }
//        return
//    }
//
//    public static void main(String[] args) {
//        HouseRobber obj = new HouseRobber();
//        System.out.println(obj.rob(new int[]{}));
//    }
//}
