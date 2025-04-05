package leetcode.interview;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int m = l + (r - l) / 2;
        while (l < r) {
            if (!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }

        }
        return l;
    }
    boolean isBadVersion(int m){
        return true;
    }

    public static void main(String[] args) {

    }
}
