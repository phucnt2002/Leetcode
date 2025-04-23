package leetcode.pointer;

public class CountHiddenSequences {
    //    Dùng a[0] = 0 để tính mảng mẫu
//
//    Tìm max và min của mảng đó
//
//    Tính được đoạn giá trị x mà a[0] có thể có
//
//    Đếm số lượng x hợp lệ
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int curr = 0;
        for (int i = 0; i < differences.length; i++) {
            curr += differences[i];
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }
        long result = (upper - lower) - (max - min) + 1;
        return result > 0 ? (int) result : 0;
    }

    public static void main(String[] args) {

    }
}
