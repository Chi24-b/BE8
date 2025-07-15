package homework;

public class question3 {
	public static int solution(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        int cost = 0;
        int i = 0;

        while (i < n) {
            int day = A[i];

            // Option 1: Buy a 30-day ticket (covers all remaining days)
            int remainingDays = n - i;
            if (remainingDays > 12) { // heuristic: if a lot of days left
                cost += 25;
                break; 
            }

            // Option 2: Buy a 7-day ticket if it covers >3 days
            int j = i;
            while (j < n && A[j] <= day + 6) {
                j++;
            }
            int coveredBy7Day = j - i;

            if (coveredBy7Day >= 4) {
                // If it covers 4 or more days, it's cheaper than buying 4 singles
                cost += 7;
                i = j; // skip all covered days
            } else {
                // Otherwise just buy 1-day ticket
                cost += 2;
                i++; // move to next day
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 5, 7, 29, 30};
        System.out.println(solution(A)); 
    }
}
