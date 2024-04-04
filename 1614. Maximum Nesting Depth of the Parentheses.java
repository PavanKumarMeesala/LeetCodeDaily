class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int Parentheses = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                Parentheses++;
            }
            else if(ch == ')')
            {
                Parentheses--;
            }

            max = Math.max(max, Parentheses);
        }

        return max;
    }
}

// Time complexity: O(N)
// Space complexity: O(1)