package sort;

public class InsertionSort {
    public static void selectSort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            for (int j = i; (j > 0) && (source[j] < source[j - 1]); j--) {
                swap(source, j, j - 1);
            }
        }
    }

    private static void swap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 6, 3, 6, 0, 5, 1, 1};
        int i;
        InsertionSort.selectSort(a);
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
// 参考：http://www.voidcn.com/article/p-tbudabuy-bnu.html