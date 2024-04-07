class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stackOpen = new Stack<>();
        Stack<Integer> stackStar = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
            {
                stackOpen.push(i);
            }
            else if(ch == '*')
            {
                stackStar.push(i);
            }
            else
            {
                if(!stackOpen.isEmpty())
                {
                    stackOpen.pop();
                }
                else if(!stackStar.isEmpty())
                {
                    stackStar.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        while(!stackOpen.isEmpty())
        {
            if(stackStar.isEmpty())
            {
                return false;
            }
            else if(stackOpen.peek() < stackStar.peek())
            {
                stackStar.pop();
                stackOpen.pop();
            }
            else 
            {
                return false;
            }
        }

        return true;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)

/*
Approach 2

class Solution {
    public boolean checkValidString(String s) {
        int omin=0;
        int omax=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                omax++;
                omin++;
            }
            else if(s.charAt(i)==')'){
                omax--;
                omin--;
            }
            else{
                omax++;
                omin--;
            }
            if(omax<0){
                return false;
            }
            omin=Math.max(0,omin);
        }
        return omin==0;
    }
}

// Time complexity: O(N)
// Space complexity: O(1)

*/