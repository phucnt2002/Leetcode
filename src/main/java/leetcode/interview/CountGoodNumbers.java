package leetcode.interview;


public class CountGoodNumbers {
    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2; // số vị trí chẵn
        long oddPos = n / 2; // số vị trí lẻ

        long evenCount = modPow(5, evenPos, MOD);
        long oddCount = modPow(4, oddPos, MOD);


        return (int) ((evenCount * oddCount) % MOD);
    }

    // Hàm tính (base^exp) % mod bằng phương pháp lũy thừa nhị phân
    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
