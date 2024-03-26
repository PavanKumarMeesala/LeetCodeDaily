class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean isContainsOne = false;
        int size = nums.length;

        for(int i = 0; i < size; i++)
        {
            if(nums[i] == 1) 
            {
                isContainsOne = true;
                break;
            }
        }

        if(!isContainsOne) return 1;

        for(int i = 0; i < size; i++)
        {
            if(nums[i] > size || nums[i] <= 0)
            {
                nums[i] = 1;
            }
        }

        for(int i = 0; i < size; i++)
        {
            nums[(nums[i] - 1) % size] += size;
        }

        for(int i = 0; i < size; i++)
        {
            if(nums[i] <= size) return i + 1;
        }

        return size + 1;
    }
}