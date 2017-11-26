//package hashing;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * https://leetcode.com/problems/repeated-dna-sequences
// * 问题：DNA 由一系列简写为 A,C,G,T 的碱基组成，例如 "ACGAATTCCG"。研究 DNA 时，识别 DNA 中的重复序列有时候会有用处。
// * 写一个函数找出 DNA 分子中所有不止一次出现的 10 字母长度的子串序列。
// * 思路：字典 + 位运算，或者进制转换。
// * 由于直接将字符串存入字典会导致 Memory Limit Exceeded，采用位操作将字符串转化为整数可以减少内存开销。
// */
//public class RepeatedDNASequences {
//    public static List<String> findRepeatedDnaSequences(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//    }
//}
//// http://blog.csdn.net/wzy_1988/article/details/44224749
//// http://www.cnblogs.com/grandyang/p/4284205.html
//// https://segmentfault.com/a/1190000003922976
