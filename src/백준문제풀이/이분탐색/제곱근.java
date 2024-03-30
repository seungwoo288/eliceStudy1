package 백준문제풀이.이분탐색;

import java.math.BigInteger;
import java.util.Scanner;

public class 제곱근 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger((sc.next()));
        System.out.println(binarySearch(n));
    }

    public static BigInteger binarySearch(BigInteger n) {
        BigInteger l = BigInteger.ONE;
        BigInteger r = n;
        BigInteger mid;

        while (true) {
            mid = l.add(r).divide(BigInteger.TWO);
            int result = mid.multiply(mid).compareTo(n);
            if (result == 0) {
                break;
            } else if (result == 1){
                r = mid.subtract(BigInteger.ONE);
            } else {
                l = mid.add(BigInteger.ONE);
            }
        }
        return mid;
    }
}
