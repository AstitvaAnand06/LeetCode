class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, we can just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0, and we carry over the 1 to the next iteration
            digits[i] = 0;
        }
        
        // If we exit the loop, it means all digits were 9 (e.g., [9, 9, 9])
        // We need a new array with an extra length, where the first digit is 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}