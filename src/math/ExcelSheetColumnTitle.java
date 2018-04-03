package math;

/**
 * https://leetcode.com/problems/excel-sheet-column-title
 * 问题：Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.
 * 思路：本质上就是将一个 10 进制数转换为一个 26 进制的数
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, (char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
        System.out.println(obj.convertToTitle(28));
    }
}
