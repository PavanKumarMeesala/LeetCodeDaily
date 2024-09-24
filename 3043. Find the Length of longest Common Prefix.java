class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> arr1Prefixes = new HashSet<>();

        for (int value : arr1) {
            while (value > 0) {
                arr1Prefixes.add(value);
                value /= 10;
            }
        }

        int longestPrefix = 0;
        for (int value : arr2) {
            int originalValue = value;
            while (value > 0 && !arr1Prefixes.contains(value)) {
                value /= 10;
            }

            if (value > 0) {
                int prefixLength = (int)Math.log10(value) + 1;
                longestPrefix = Math.max(longestPrefix, prefixLength);
            }
        }
        return longestPrefix;
    }     
}