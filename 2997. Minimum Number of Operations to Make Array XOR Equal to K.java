class Solution {
    public int minOperations(int[] nums, int k) {
        int XOR = 0;

        for(int value : nums)
        {
            XOR ^= value;
        }

        if(XOR == k) return 0;

        int count = 0;
        int value = XOR ^ k;
        
        while(value > 0)
        {
            count += (value & 1);
            value = value >> 1;
        }

        return count;
    }
}

// Time complexity : O(N)
// Space complexity: O(1)