package leetcode.interview;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int r = num;
        int l = 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long compare = (long) mid * mid;
            if (compare < num) {
                l = mid + 1;
            } else if (compare > num) {
                r = mid;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(808201));
    }


}
