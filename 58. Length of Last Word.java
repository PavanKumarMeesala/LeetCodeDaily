class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        while(s.charAt(end) == ' ')
        {
            end--;
        }

        int result = 0;
        while(end >= 0 && s.charAt(end) != ' ')
        {
            result++;
            end--;
        }

        return result;
    }
}

// Time complexity : O(N)
// Space complexity : O(1)

/* Approach:

Step 1: Initailize the variable end to the last character of the string.
Step 2: Elminate the spaces(end-- if(character == ' '))
Step 3: Initailze the result varible
Step 4: Count the characters(result++) and iterate throught the characters(end--)
        until you encounter another space.
Step 5: Return result.

*/

/* Example: 

"hello moon   "
             |
             end

Eliminate the spaces
        <---
"hello moon   "
          |
          end

count the characters until you encounter another space.
end is at n: result = 1
end is at o: result = 2
end is at o: result = 3
end is at m: reuslt = 4
end is at ' ': terminate the loop.

return result.
*/