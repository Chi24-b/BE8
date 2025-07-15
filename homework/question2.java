package homework;

public class question2 {
	
	public static int countSqrtOps(long n) {
        int count = 0;
        while (true) {
            long root = (long) Math.sqrt(n);
            if (root * root == n) { 
                count++;
                n = root; 
            } else {
                break; 
            }
        }
        return count;
    }

    
    public static int solution(long A, long B) {
        int maxOps = 0;

        for (long num = A; num <= B; num++) {
            int ops = countSqrtOps(num);
            if (ops > maxOps) {
                maxOps = ops;
            }
        }

        return maxOps;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 20));      // should return 2 (16 -> 4 -> 2)
        System.out.println(solution(6000, 7000)); // should return 3 (6561 -> 81 -> 9 -> 3)
        System.out.println(solution(2, 3));       // should return 0
    }
}
