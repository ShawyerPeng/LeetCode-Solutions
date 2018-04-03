public class Cable {
    public static void getSingleMaxLength(int n, double[] lens, int m) {
        double left = 0, right = Double.MAX_VALUE;
        while (right - left > 1e-5) {
            double mid = (left + right) / 2;
            if (ok(mid, n, lens, m))
                left = mid;
            else
                right = mid;
        }
        System.out.println((int) right);
    }

    private static boolean ok(double x, int n, double[] lens, int m) {
        int num = 0;
        for (int i = 0; i < n; i++)
            num += (int) (lens[i] / x);
        return num >= m;
    }

    public static void main(String[] args) {
        int n = 4, m = 11;
        double[] lens = new double[4];
        lens[0] = 8.02;
        lens[1] = 7.43;
        lens[2] = 4.57;
        lens[3] = 5.39;
        Cable.getSingleMaxLength(n, lens, m);
    }
}
