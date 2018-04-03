package binary_search;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (isBadVersion(left)) return left;
        return right;
    }

    private Boolean isBadVersion(int version) {
        return false;
    }
}
