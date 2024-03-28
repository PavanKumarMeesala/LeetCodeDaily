class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int result = 0;
        for(left = 0; left < nums.length; left++)
        {
            map.put(nums[left], map.getOrDefault(nums[left], 0) + 1);

            while(map.get(nums[left]) > k)
            {
                map.put(nums[right], map.get(nums[right]) - 1);
                right++;
            }

            result = Math.max(result, left - right + 1);
        }

        return result;
    }
}