class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int size = s.length();

        int dp[] = new int[size + 1];

        Arrays.fill(dp, size);
        dp[0] = 0;
        for(int i = 1; i <= size; i++)
        {
            for(int j = 0; j < i; j++)
            {
                String substr = s.substring(j, i);
                if(isContains(dictionary, substr))
                {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        return dp[size];
    }

    private boolean isContains(String[] dictionary, String word)
    {
        for(String str : dictionary)
        {
            if(str.equals(word))
            {
                return true;
            }
        }

        return false;
    }
}