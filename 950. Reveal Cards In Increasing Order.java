class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int size = deck.length;
        int result[] = new int[size];
        Deque<Integer> indices = new LinkedList<>();

        for(int i = 0; i < size; i++)
        {
            indices.add(i);
        }

        for(int card : deck)
        {
            int index = indices.poll();

            result[index] = card;
            if(!indices.isEmpty())
            {
                indices.add(indices.poll());
            }
        }

        return result;
    }
}

/*

Let's use the input [17, 13, 11, 2, 3, 5, 7] and go through each step of the simulation to reveal the cards in increasing order.

Input:
Deck: [17, 13, 11, 2, 3, 5, 7]

Step-by-Step Simulation:
Sort the Deck:

Sorted Deck: [2, 3, 5, 7, 11, 13, 17]
Initialize Variables:

deck: [2, 3, 5, 7, 11, 13, 17]
n (size of deck): 7
result: [0, 0, 0, 0, 0, 0, 0] (initialized with zeros)
indices: deque([0, 1, 2, 3, 4, 5, 6])

Simulation Process:
1st Card (2):
card: 2
idx (popped from indices): 0
result after assigning 2 at idx: [2, 0, 0, 0, 0, 0, 0]
indices after moving next index: 1 to the end: deque([2, 3, 4, 5, 6, 1])

2nd Card (3):
card: 3
idx (popped from indices): 2
result after assigning 3 at idx: [2, 0, 3, 0, 0, 0, 0]
indices after moving next index: 3 to the end: deque([4, 5, 6, 1, 3])

3rd Card (5):
card: 5
idx (popped from indices): 4
result after assigning 5 at idx: [2, 0, 3, 0, 5, 0, 0]
indices after moving next index: 5 to the end: deque([6, 1, 3, 5])

4th Card (7):
card: 7
idx (popped from indices): 6
result after assigning 7 at idx: [2, 0, 3, 0, 5, 0, 7]
indices after moving 3 to the end: deque([3, 5, 1])

5th Card (11):
card: 11
idx (popped from indices): 3
result after assigning 11 at idx: [2, 0, 3, 11, 5, 0, 7]
indices after moving 4 to the end: deque([1, 5])

6th Card (13):
card: 13
idx (popped from indices): 1
result after assigning 13 at idx: [2, 13, 3, 11, 5, 0, 7]
indices after moving 5 to the end: deque([5])

7th Card (17):
card: 17
idx (popped from indices): 6
result after assigning 17 at idx: [2, 13, 3, 11, 5, 17, 7]
indices after moving 6 to the end: deque([])

Final Result:
The result array after simulating the process will be [2, 13, 3, 11, 5, 17, 7], which represents the deck of cards revealed in increasing order.

*/