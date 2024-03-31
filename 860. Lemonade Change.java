class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, tens = 0;

        for(int bill : bills)
        {
            if(bill == 5)
            {
                five++;
            }
            else if(bill == 10)
            {
                five--;
                tens++;
            }
            else if(tens > 0 && five > 0)
            {
                tens--;
                five--;
            }
            else
            {
                five -= 3;
            }

            if(five < 0) return false;
        }

        return true;
    }
}