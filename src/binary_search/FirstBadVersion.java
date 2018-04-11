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

    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 原则2：不存在lo=mid的情况，所以这样就可以，不需+1
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                // 原则1：第一个bad version可能在mid之前或mid本身，所以不用mid-1
                right = mid;
            else
                // 第一个bad version一定在mid之后，所以用mid+1
                left = mid + 1;
        }
        return left; // 原则4：最后总是返回lo，不做判断
    }

    private Boolean isBadVersion(int version) {
        return false;
    }
}
