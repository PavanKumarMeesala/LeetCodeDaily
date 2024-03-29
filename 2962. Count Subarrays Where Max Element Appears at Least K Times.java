class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;

        for(int value : nums)
        {
            maxElement = Math.max(maxElement, value);
        }

        int count = 0;
        int left = 0, right = 0;
        long result = 0;
        while(right < nums.length)
        {
            if(nums[right] == maxElement) count++;

            while(count >= k)
            {
                result += nums.length - right;
                if(nums[left] == maxElement) count--;
                left++;
            }

            right++;
        }

        return result;
    }
}

// Time complexity : O(N)
// Space complexity : O(1)

// Approach 2 using HashMap

/* class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;

        for(int value : nums)
        {
            maxElement = Math.max(maxElement, value);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        long result = 0;
        while(right < nums.length)
        {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if(map.containsKey(maxElement))
            {
                 while(map.get(maxElement) >= k)
                {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    result += nums.length - right;
                    left++;
                }
            }

            right++;
        }

        return result;

    }
} */

// Time complexity : O(N)
// Space complexity : O(N)