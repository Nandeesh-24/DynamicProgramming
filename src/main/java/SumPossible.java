import java.util.*;

public class SumPossible {
    /*
    amount = 4
    numbers = [1,2,3]


    possible combinations -> (1+2+1), (1+3),(2+2)

    return true if combination exists
     */

    static HashSet<List<Integer>> set = new HashSet<>();


    public static void main(String[] args) {
//        System.out.println(recursiveSum(15, Arrays.asList(4,6,10)));
        System.out.println(sumPossible(15, Arrays.asList(4,6,10),new HashMap<>(),new ArrayList<>()));
//        System.out.println(sumPossible(4, Arrays.asList(1,2,3),new HashMap<>(),new ArrayList<>()));
        System.out.println(set);

    }

    public static boolean recursiveSum(int amount , List<Integer> numbers){
        /*
        Brute force method :
         a = amount
         n = length of numbers

         time = O(n ^ a)
         space = O(a)

         */

        if (amount < 0) {
            return false;
        }

        if (amount == 0) {
            return true;
        }

        for (int num : numbers){
            int subAmount = amount - num;
            if(recursiveSum(subAmount, numbers)){
                return true;
            }
        }

        return false;
    }


    public static boolean sumPossible(int amount , List<Integer> numbers, HashMap<Integer,Boolean> memo,List<Integer> combinations){
        /*
         a = amount
         n = length of numbers

         time = O(n * a)
         space = O(a)

         */

        if (amount < 0) {
            return false;
        }

        if (amount == 0) {
            combinations = combinations.stream().sorted().toList();
            set.add(combinations);
            combinations = new ArrayList<>();
            return true;
        }

        if (memo.containsKey(amount))
            return memo.get(amount);

        boolean result = false;
        for (int num : numbers){
            combinations.add(num);
            if(sumPossible(amount - num, numbers, memo, combinations)){
                result = true;
            }
            combinations.remove(combinations.size()-1);
        }

        memo.put(amount, result);

        return false;
    }
}
