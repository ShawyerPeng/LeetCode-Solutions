package math;

/**
 * https://leetcode.com/problems/excel-sheet-column-number
 * 问题：Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 思路：处理 26 进制，逐个读入字符串中的每一个字符进行处理转换即可。和 Excel Sheet Colum Title 这道题目互逆。
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            int tmp = s.charAt(i) - 'A' + 1;
            sum = 26 * sum + tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        System.out.println(obj.titleToNumber("AB"));
    }
}
// http://blog.csdn.net/feliciafay/article/details/42332281