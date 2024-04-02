class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int sFreq[] = new int[127];
        int tFreq[] = new int[127];

        for(int i = 0; i < s.length(); i++)
        {
            if(sFreq[s.charAt(i)] != tFreq[t.charAt(i)])
            {
                return false;
            }

            sFreq[s.charAt(i)] = i + 1;
            tFreq[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

// Time Complexity: O(N)
// Space Complexity : O(1)

/* Approach
Case 1: If both the lengths of s and t are not equal just simply return false;

Case 2:
Let s = "paper" and t = "title"

You can see that I can replace p --> t, a --> i, e --> l and r --> e
We can convert the t into s. 

Taka a HashMap or Array to maintain the characters last index so
we can check that we can replace or not.

sFreq = []
tFreq = []

Step 1: Iterate through the strings and and update the index.
Step 2: If both the indexs are not equal return false.
Step 3: End of the loop return true.

*/

/*

Dry Run:

Example 1:
s = "paper" and t = "title"

sFreq = []
tFreq = []

i = 0 
p == 0  and t == 0 (true)
update them to p = i + 1 and t = i + 1
sFreq = [p = 1] and tFreq = [t = 1]

i = 1
a == 0 and i == 0 (true)
update them to a = i + 1 and i = i + 1
sFreq = [p = 1, a = 2] and tFreq = [t = 1, i = 2]

i = 2
p == 1 and t == 1 (true)
update them to p = i + 1 and t = i + 1
sFreq = [a = 2, p = 3] and tFreq = [i = 2, t = 3]

i = 3
e == 0 and l == 0 (true)
update them to e = i + 1 and l = i + 1
sFreq = [a = 2, p = 3, e = 4] and tFreq = [i = 2, t = 3, l = 4]

i = 4
r == 0 and e == 0 (true)
update them to r = i + 1 and e = i + 1
sFreq = [a = 2, p = 3, e = 4, r = 5] and tFreq = [i = 2, t = 3, l = 4, e = 5]

Example 2:

s = "foo" and t = "car"

You can clearly see that we can't replace them and make s == t

sFreq = []
tFreq = []

i = 0
f == 0 and c == 0 (true)
update them to f = i + 1 and c = i + 1
sFreq = [f = 1] and tFreq = [c = 1]

i = 1
o == 0 and a == 0 (true)
update them to o = i + 1 and a = i + 1
sFreq = [f = 1, o = 2] and tFreq = [c = 1, a = 2]

i = 2
o == 2 and r == 0 (false)
return false. Because we can't replace the third of s with t.
Hence s and t are not 205. Isomorphic Strings

*/