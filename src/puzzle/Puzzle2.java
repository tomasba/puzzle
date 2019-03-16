package puzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */

public class Puzzle2 {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        //int[] input = {3,2,1};
        Arrays.stream(calculateReuslt(input)).forEach(System.out::println);
    }

    private static int[] calculateReuslt(int[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = leftMultiply(input, i) * rightMultiply(input, i);
        }
        return output;
    }

    private static int leftMultiply(int[] in, int i) {
        return Arrays.stream(in).limit(i).reduce((i1, i2) -> i1 * i2).orElseGet(() -> 1);
    }

    private static int rightMultiply(int[] in, int i) {
        return IntStream.of(in).skip(i+1).reduce((i1, i2) -> i1 * i2).orElseGet(() -> 1);
    }


    // reverse order
//    public static <T> Stream<T> reverse(Stream<T> stream) {
//        LinkedList<T> stack = new LinkedList<>();
//        stream.forEach(stack::push);
//        return stack.stream();
//    }

    // commented-out as no required.
//    private static int[] reverse(int[] input) {
//        int[] result = new int[input.length];
//        for (int i = input.length-1; i >= 0; i--) {
//            result[input.length-1-i] = input[i];
//        }
//        return result;
//    }
}
