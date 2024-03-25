class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
            {
                result.add(index + 1);
            }

            nums[index] = -nums[index];
        }

        return result;
    }
}

// Beginner approach using HashTable

/*
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        List<Integer> result = new ArrayList<>();

        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val, 0) + 1);
            if(map.get(val) == 2)
            {
                result.add(val);
            }
        }

        return result;
    }
}
*/