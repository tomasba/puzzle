package puzzle;

import java.util.stream.IntStream;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */

public class Puzzle1 {

    private static final int[] numbers = {10, 15, 3, 7};
    private static final int k = 17;

    public static void main(String[] args) {

        IntStream.of(10,15,3,7).forEach(i -> {
            if (IntStream.range(0,i).filter(j -> i+j==k).findFirst().isPresent()) {
                return true;
            }
            return false;
        });

        System.out.println(satisfiesRequirement(numbers, k));
    }

    private static boolean satisfiesRequirement(int[] numbers, int k) {
        for (int n1 : numbers) {
            for (int n2 : numbers) {
                if (n1 + n2 == k) {
                    System.out.println(n1 + " + " + n2 + " = " + k);
                    return true;
                }
            }
        }
        return false;
    }

}
