package puzzle;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words,
 * find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */

public class Puzzle3 {
    public static void main(String[] args) {
        //List<Integer> in = Arrays.asList(-7,-8,0);
        //List<Integer> in = Arrays.asList(1,2,0);
        List<Integer> in = Arrays.asList(3,4,-1,1);

        Integer maxVal = in.stream().max(Integer::compareTo).get();
        Integer r = in.stream().filter(val -> val > 0).sorted()
                .reduce((i1, i2) -> i2-i1>1 ? i1 : -1)
                .map(i -> i < 0 ? maxVal : i)
                .map(i -> i+1)
                .orElse(1);

        System.out.println(r);
    }
}
