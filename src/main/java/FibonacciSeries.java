import java.util.HashMap;

public class FibonacciSeries {

    /*
    Fibonacci series : n     -> 0,1,2,3,4,5,6
                      fib(n) -> 0,1,1,2,3,5,8
     */

    public static void main(String[] args) {
        int n = 35;
//        System.out.println(recursiveFib(n));
        System.out.println(fib(n, new HashMap<>()));
    }

    public static int recursiveFib(int n){
        // time = O(2^n)
        // space = O(n)

        //base case
        if (n == 1 || n == 0){
            return n;
        }
        return recursiveFib(n-1) + recursiveFib(n-2);
    }


    public static int fib(int n, HashMap<Integer,Integer> memo){
        // time = O(n)
        // space = O(n)

        //base case
        if (n == 1 || n == 0){
            return n;
        }

        if (memo.containsKey(n)){
            return memo.get(n);
        }

        int result = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, result);
        return result;
    }
}
