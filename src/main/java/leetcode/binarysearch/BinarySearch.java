package leetcode.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length-1, target);
    }

    public int bSearch(int[] nums, int left, int right, int target) {
        if(left>right)
            return -1;
        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            return bSearch(nums, left, mid-1, target);
        } else if (target > nums[mid]) {
            return bSearch(nums, mid+1, right, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(array, 4));
    }
}
