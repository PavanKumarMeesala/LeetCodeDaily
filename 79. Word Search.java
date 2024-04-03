class Solution {
    public boolean exist(char[][] board, String word) {
        char wordArr[] = word.toCharArray();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(solveBoard(board, i, j, wordArr, 0))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solveBoard(char[][] board, int i, int j, char[] word, int index)
    {
        if(index == word.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) return false;

        if(board[i][j] != word[index]) return false;
        char temp = board[i][j];
        board[i][j] = '.';

        boolean exist = solveBoard(board, i, j + 1, word, index + 1)
                    ||  solveBoard(board, i, j - 1, word, index + 1)
                    ||  solveBoard(board, i + 1, j, word, index + 1)
                    ||  solveBoard(board, i - 1, j, word, index + 1);

        board[i][j] = temp;
        return exist;
    }
}

// Time complexity: O(N ^ 2)
// Space complexity: O(1)


/* Approach

Iterate throught the array and find the each characters of the word. 

|A|B|C|E|
|S|F|C|S|
|A|D|E|E|

word = "ABCCED"

we have to iterate throught the array and find the each word on found
each character increment the index of word.

*/

/*
Dry Run:

|A|B|C|E|
|S|F|C|S|    ABCCED
|A|D|E|E|    |
            index

On found first character

|.|B|C|E|
|S|F|C|S|   ABCCED
|A|D|E|E|    |
            index

|.|.|C|E|
|S|F|C|S|   ABCCED
|A|D|E|E|     |
             index

|.|.|.|E|
|S|F|C|S|   ABCCED
|A|D|E|E|      |
              index

|.|.|.|E|
|S|F|.|S|   ABCCED
|A|D|E|E|      |
              index

|.|.|.|E|
|S|F|.|S|   ABCCED
|A|D|.|E|       |
               index

|.|.|.|E|
|S|F|.|S|   ABCCED
|A|.|.|E|        |
                index

If our index is equal to length of word then we can see word exists in the grid. (return true)
Else not (return false)

*/