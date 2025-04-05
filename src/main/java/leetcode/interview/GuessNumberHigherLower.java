package leetcode.interview;

public class GuessNumberHigherLower {

    int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(true){
            int mid = l + (r -l)/2;
            if(guess(mid)==0)
                return mid;
            if(guess(mid)>0){
                l = mid+1;
            }else{
                r = mid;
            }
        }
    }
    int guess(int num){
        return 0;
    }

    public static void main(String[] args) {

    }
}
