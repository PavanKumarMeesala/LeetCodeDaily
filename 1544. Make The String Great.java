class Solution {
    public String makeGood(String s) {
        if(s.length() <= 1) return s;

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(stack.isEmpty())
            {
                stack.push(ch);
            }
            else if(Math.abs(ch - stack.peek()) == 32)
            {
                stack.pop();
            }
            else
            {
                stack.push(ch);
            }
        } 

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty())
        {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}

/* 
2nd Approach

class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder(s);

        int index = 0;
        while(index < result.length() - 1)
        {
            char left = result.charAt(index);
            char right = result.charAt(index + 1);
            
            if(Math.abs(left - right) == 32)
            {
                result.delete(index, index + 2);
                if(index > 0)
                {
                    index--;
                }
            }
            else
            {
                index++;
            }
        }

        return result.toString();
    }
}

*/