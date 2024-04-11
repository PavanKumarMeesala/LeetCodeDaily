class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        Stack<Character> monotonicStack = new Stack<>();

        for(char ch : num.toCharArray())
        {
            while(!monotonicStack.isEmpty() && k > 0 && monotonicStack.peek() > ch)
            {
                monotonicStack.pop();
                k--;
            }

            monotonicStack.push(ch);
        }

        while(k > 0 && !monotonicStack.isEmpty())
        {
            monotonicStack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!monotonicStack.isEmpty())
        {
            sb.insert(0, monotonicStack.pop());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}