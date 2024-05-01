class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder(word);

        int left = 0, right = 0;
        right = word.indexOf(ch);

        if(right == -1) return word;

        reverse(sb, right);

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int right)
    {
        int left = 0;
        while(left < right)
        {
            swap(sb, left, right);
            left++;
            right--;
        }
    }
    private void swap(StringBuilder sb, int left, int right)
    {
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, temp);
    }
}

// Time complexity: O(N)
// Space complexity: O(N)