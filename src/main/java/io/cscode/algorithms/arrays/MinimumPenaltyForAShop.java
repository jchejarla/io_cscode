package io.cscode.algorithms.arrays;

public class MinimumPenaltyForAShop {

    static int bestClosingTimeUsingPrefixPostfixSumArrays(String customers) {
        int n = customers.length();
        int[] prefix = new int[n+1];
        int[] postfix = new int[n+1];

        // customers = "YYNY" , prefix[0] = 0 since there will not be any N's before this
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1];
            if(customers.charAt(i-1) == 'N') {
                prefix[i] += 1;
            }
        }

        //postfix[n] = 0 since there will not be any Y's after this
        // in postfix, we are  counting Y's until now + current one
        for(int i=postfix.length-2; i>=0; i--) {
            postfix[i] = postfix[i+1];
            if(customers.charAt(i) == 'Y') {
                postfix[i] += 1;
            }
        }
        int minPenalty = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<prefix.length; i++) {
            int penalty = prefix[i] + postfix[i];
            if(penalty < minPenalty) {
                minPenalty = penalty;
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * First, calculate the penalty, what if the shop is closed at 0th hour, that means count all Y's,
     * because customer showed up and the shop is closed. This becomes the maximum penalty possible
     * since the shop is closed at 0th hour.
     *
     * Now, try to reduce the penalty by going through the input string again and
     * if the element is 'Y' at index i, that means we can reduce the penalty by not closing the store at that hour
     * so reduce the penalty calculated above, if it is 'N' increment the penalty, as the shop is opened but no customers
     * showed up. Track minimum and minimum index while doing this  (for index, take i+1, because we want to close shop after
     * that hour)
     *
     *
     *
     * @param customers
     * @return
     */
    static int bestClosingTimeMemoryOptimized(String customers) {
        int penalty = 0;
        int n = customers.length();
        for(int i=0; i<n; i++) {
            if(customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int index = 0;

        for(int i=0; i<n; i++) {
            if(customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if(penalty < minPenalty) {
                minPenalty = penalty;
                index = i+1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println("############### Using prefix and postfix sums ######################");
        System.out.println(bestClosingTimeUsingPrefixPostfixSumArrays("YYNY"));
        System.out.println(bestClosingTimeUsingPrefixPostfixSumArrays("NNNNN"));
        System.out.println(bestClosingTimeUsingPrefixPostfixSumArrays("YYYY"));

        System.out.println("############### Memory optimized ######################");
        System.out.println(bestClosingTimeMemoryOptimized("YYNY"));
        System.out.println(bestClosingTimeMemoryOptimized("NNNNN"));
        System.out.println(bestClosingTimeMemoryOptimized("YYYY"));
    }
}
