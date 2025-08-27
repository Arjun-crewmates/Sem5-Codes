import java.util.*;

public class Rearranging_pos_neg_in_arr{

    public static int[] rearrangeAlternate(int[] arr) {
        // Step 1: Split into positives and negatives
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for (int num : arr) {
            if (num >= 0) pos.add(num); 
            else neg.add(num);
        }

        // Step 2: Merge alternately
        int[] result = new int[arr.length];
        int p = 0, n = 0, i = 0;

        while (p < pos.size() && n < neg.size()) {
            // First place positive, then negative
            result[i++] = pos.get(p++);
            result[i++] = neg.get(n++);
        }

        // Step 3: Append leftovers
        while (p < pos.size()) result[i++] = pos.get(p++);
        while (n < neg.size()) result[i++] = neg.get(n++);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeAlternate(arr);
        System.out.println(Arrays.toString(result));
        // Expected: [3, -2, 1, -5, 2, -4]
    }
}
