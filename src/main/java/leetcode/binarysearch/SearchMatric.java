package leetcode.binarysearch;

public class SearchMatric {
    public boolean searchMatrix(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (target > array[i][array[i].length - 1]) {
                continue;
            } else {
                return bSearch(array[i], 0, array[i].length - 1, target)!=-1;
            }
        }
        return false;
    }

    public int bSearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (target < nums[mid]) {
            return bSearch(nums, left, mid - 1, target);
        } else if (target > nums[mid]) {
            return bSearch(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        SearchMatric searchMatric = new SearchMatric();
        System.out.println(searchMatric.searchMatrix(array, 10));
    }
}
