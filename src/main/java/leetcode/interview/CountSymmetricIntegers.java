package leetcode.interview;

public class CountSymmetricIntegers {

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (checkSymmetric(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static int countSymmetricIntegersOption2(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String str = i + "";

            int mid = str.length()/2;
            if (mid % 2 != 0) {
                continue;
            }
            int left = 0;
            int right = 0;
            for (int j = 0; j < mid; j++) {
                char a = str.charAt(j);
                char b = str.charAt(j + mid);

                left = left + (int) a;
                right = right + (int) b;
            }
            if (left == right)
                count++;

        }
        return count;
    }


    private static boolean checkSymmetric(int number) {

        int temp = number;


        int digitNumber = 0;
        while (number != 0) {
            number = number / 10;
            digitNumber++;
        }
        if (digitNumber % 2 != 0)
            return false;
        int div = digitNumber / 2;

        int leftNumber = (int) (temp / (Math.pow(10, div)));
        int rightNumber = (int) (temp % (Math.pow(10, div)));

        int sumLeft = 0;
        while (leftNumber != 0) {
            sumLeft += leftNumber % 10;
            leftNumber = leftNumber / 10;
        }


        int sumRight = 0;
        while (rightNumber != 0) {
            sumRight += rightNumber % 10;
            rightNumber = rightNumber / 10;
        }

        return sumLeft == sumRight;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegersOption2(1, 4));
    }
}
