import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinChange {
    /*
    amount = 4
    coins = [1,2,3]

    return min coins required to meet amount

    (1,3),(2,2),(3,1) -> return 2 min coins
     */

    public static void main(String[] args) {
//        System.out.println(recursiveMinChange(4, Arrays.asList(1,2,3)));

        System.out.println(minChange(4, Arrays.asList(1,2,3), new HashMap<>()));

    }

    public static int recursiveMinChange(int amount, List<Integer> coins){
        /*
        amount = a
        coins = c

        time = O(c ^ a)
        space = O(a)
         */

        //base case
        if (amount == 0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        int minCoins = -1;

        for (int coin : coins){
            int subAmount = amount - coin;
            int subCoins = recursiveMinChange(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1){
                    minCoins = numCoins;
                }
            }
        }

        return minCoins;
    }

    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo){
        /*
        time = O(c * a)
        space = O(a)
         */

        //base case
        if (amount == 0)
            return 0;

        if(amount < 0)
            return -1;

        if (memo.containsKey(amount))
            return memo.get(amount);

        int minCoins = -1;

        for (int coin : coins){
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memo);
            if (subCoins != -1){
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1){
                    minCoins = numCoins;
                }
            }
        }

        memo.put(amount, minCoins);

        return minCoins;
    }
}
