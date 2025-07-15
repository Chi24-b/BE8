package homework;

import java.util.ArrayList;
import java.util.List; 

public class question1 {
	public String solution(int A, int B, int C, int D, int E, int F) {
       
        int[] digits = {A, B, C, D, E, F};
        
       
        List<int[]> allPermutations = new ArrayList<>();
        generatePermutations(digits, 0, allPermutations);

        String earliest = null; // Track the earliest valid time

        // Check each permutation
        for (int[] perm : allPermutations) {
            int hour = perm[0] * 10 + perm[1];
            int minute = perm[2] * 10 + perm[3];
            int second = perm[4] * 10 + perm[5];

            
            if (hour < 24 && minute < 60 && second < 60) {
                String time = String.format("%02d:%02d:%02d", hour, minute, second);

                // Keep the smallest (earliest) time
                if (earliest == null || time.compareTo(earliest) < 0) {
                    earliest = time;
                }
            }
        }

       
        return earliest != null ? earliest : "NOT POSSIBLE";
    }

    
    private void generatePermutations(int[] arr, int index, List<int[]> result) {
        if (index == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generatePermutations(arr, index + 1, result);
            swap(arr, index, i); // backtrack
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Test the function
    public static void main(String[] args) {
    	question1 sol = new question1();
        System.out.println(sol.solution(1,8,3,2,6,4)); // -> 12:36:48
        System.out.println(sol.solution(0,0,0,0,0,0)); // -> 00:00:00
        System.out.println(sol.solution(0,0,0,7,8,9)); // -> 07:08:09
        System.out.println(sol.solution(2,4,5,9,5,9)); // -> NOT POSSIBLE
    }	

}
