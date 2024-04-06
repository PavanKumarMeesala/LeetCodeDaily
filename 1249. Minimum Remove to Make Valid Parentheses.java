class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++)
        {
            char ch = sb.charAt(i);
            if(ch == '(')
            {
                stack.push(i);
            }
            else if(ch == ')')
            {
                if(stack.isEmpty())
                {
                    sb.deleteCharAt(i);
                    i--;
                }
                else
                {
                    stack.pop();
                }
            }  
        }

        while(!stack.isEmpty())
        {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}
// Time complexity: O(N)
// Space complexity: O(N + stack)

/* Approach 2
class Solution {
    public String minRemoveToMakeValid(String s) {
         StringBuilder sb = new StringBuilder(s);

        int parentheses = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                parentheses++;
            } else if (sb.charAt(i) == ')') {
                if (parentheses > 0) {
                    parentheses--;
                } else {
                    sb.deleteCharAt(i);
                    i--; // Decrement i to recheck the current index after deletion
                }
            }
        }
        
        // Remove any extra opening parentheses if any
        for (int i = sb.length() - 1; i >= 0 && parentheses > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                parentheses--;
            }
        }

        return sb.toString();
    }
}

// Time complexity: O(N)
// Space complexity: O(N + stack)

*/