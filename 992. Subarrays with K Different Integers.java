class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int value = atMost(nums, k);
        int value2 = atMost(nums, k - 1);

        // System.out.println(value + " " + value2);
        return value - value2;
    }

    private int atMost(int[] nums, int k)
    {
        if(k == 0) return k;
        int left = 0, right = 0;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < nums.length)
        {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k)
            {
                map.put(nums[left], map.get(nums[left]) - 1);

                if(map.get(nums[left]) == 0)
                {
                    map.remove(nums[left]);
                }
                left++;
            }

            result += right - left + 1;
            right++;
        }

        return result;
    }
}