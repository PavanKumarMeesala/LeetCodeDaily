class Solution {
    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (char ch : tasks) {
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        int maxCount = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq)
                maxCount++;
        }

        return Math.max((n + 1) * (maxFreq - 1) + maxCount, tasks.length);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)