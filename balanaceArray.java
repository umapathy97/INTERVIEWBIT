/*
Problem Description

Given an integer array A of size N. You need to count the number of special elements in the given array.

A element is special if removal of that element make the array balanced.

Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the count of special elements.



Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1
Explanation 2:

 If we delete A[0] or A[1] , array will be balanced
    (5+5) = (2+8)
 So A[0] and A[1] are special elements, so count is 2.
 */
 
 public class Solution {
    public int solve(int[] A) {
        
        int oddSum[] = new int[A.length];
        int evenSum[] = new int[A.length];
        
        // populate odd and even sums
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 1) {
                if (i - 1 >= 0)
                    evenSum[i] = evenSum[i - 1] + A[i];
                else 
                   evenSum[i] = A[i];
                   
                oddSum[i] = oddSum[i - 1];
            }
            
            else {
                if (i == 0) {
                    oddSum[i] = A[i];
                }
                
                else {
                    oddSum[i] = oddSum[i - 1] + A[i];
                    evenSum[i] = evenSum[i - 1];
                }
            }
        }
        
        int count = 0;
        int maxOddSum = oddSum[oddSum.length - 1];
        int maxEvenSum = evenSum[evenSum.length - 1];
        

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 1) {
               int currentOdd = maxEvenSum - evenSum[i] + oddSum[i];
               int currentEven =  maxOddSum - oddSum[i] + evenSum[i] - A[i];

               if ( currentOdd == currentEven)
                    count++;
            }
            
            else {
                int currentEven = maxOddSum - oddSum[i] + evenSum[i];
               int currentOdd =  maxEvenSum - evenSum[i] + oddSum[i] - A[i];
               
               if ( currentOdd == currentEven)
                    count++;
            }
                
        }
        return count;
    }
}
