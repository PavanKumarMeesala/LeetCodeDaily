class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentSquare = 0;
        int studentCricle = 0;

        for(int value : students)
        {
            if(value == 1)
            {
                studentSquare++;
            }
            else
            {
                studentCricle++;
            }
        }

        for(int sandwich : sandwiches)
        {
            if(sandwich == 1)
            {
                studentSquare--;
            }
            else
            {
                studentCricle--;
            }

            if(studentCricle < 0) return studentSquare;
            if(studentSquare < 0) return studentCricle;
        }

        return 0;
    }
}