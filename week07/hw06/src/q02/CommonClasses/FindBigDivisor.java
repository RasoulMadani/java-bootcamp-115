package q02.CommonClasses;

public class FindBigDivisor {
    public static int find(int x, int y) {
        int[] divisorsX = findDivisors(x);
        int[] divisorsY = findDivisors(y);
        int bitDivisor = 1;
        for (int i = 0; i < divisorsY.length; i++) {
            for (int j = 0; j < divisorsX.length; j++) {
                if (
                        (divisorsY[i] != 0 || divisorsX[j] != 0) &&
                        divisorsY[i] == divisorsX[j] &&
                        divisorsY[i] > bitDivisor)
                {
                    bitDivisor = divisorsY[i];
                }
            }
        }
        return bitDivisor;
    }

    public static int[] findDivisors(int digit) {
        int[] divisor = new int[digit];
        int index = 0;
        for (int i = 1; i <= digit; i++) {
            if (digit % i == 0) {
                divisor[index] = i;
                index++;
            }
        }
        return divisor;
    }
}
