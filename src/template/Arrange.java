package template;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Arrange {
    public static int count = 0;
    public static Set<String> all = new TreeSet();

    public static void swap(char[] arr, int x, int y) {
        if (x == y || arr[x] == arr[y]) {
            return;
        }
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void arrange(char[] arr, int begin, int end) {
        if (begin == end) {
            String str = "";
            if (arr[2] != '4') {//过滤4在第三位的元素
                for (int i = 0; i < arr.length; i++) {
                    str += arr[i];
                }//去除包含35,53的元素
                if (!str.contains("35") && !str.contains("53")) {
                    // System.out.println(++count + ":" +str);
                    all.add(str); //利用集合消除重复元素
                }
            }
        } else {
            for (int i = begin; i <= end; i++) {
                swap(arr, begin, i);
                arrange(arr, begin + 1, end);
                swap(arr, begin, i);
            }
        }
    }

    public static void print() {
        Iterator<String> it = all.iterator();
        System.out.println(all.size());
        int count = 0;
        while (it.hasNext()) {
            String string = (String) it.next();
            System.out.print(string + "  ");
            if (++count % 9 == 0) {
                System.out.println();
            }
        }
        System.out.print(all.size());
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'1', '2', '2', '0'};
        arrange(arr, 0, arr.length - 1);
        print();
    }
}