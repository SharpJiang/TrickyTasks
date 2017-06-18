/**
 * Created by Victor on 12.06.2014.
 */
public class PrimitiveTypes {

    public static long swapBits(long x, int i, int j) {
        // Extract the i-th and j-th bits, and see if they differ.
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // i-th and j-th bits differ. Swap them by flipping their values.
    /* Select the bits to flip with bitMask. Since x^l = 0 when x = 1 and 1
     when x = 0, perform the flip XOR . */
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }

    // COMPUTE X * Y WITHOUT ARITHMETICAL OPERATORS
    public static long multiply(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Examines each bit of x.
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return sum;
    }

    private static long add(long a, long b) {
        long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            carryin = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        return sum | carryin;
    }

    /*COMPUTE x/y
    Task: Given two positive integers, compute their quotient, using only the addition,
    substraction, and shifting operators. */
    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1L << power;
            x -= yPower;
        }
        return result;
    }

    //REVERSE DIGITS
    public static long reverse(int x) {
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining /= 10;
        }
        return x < 0 ? -result : result;
    }

}
