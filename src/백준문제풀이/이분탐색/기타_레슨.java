package 백준문제풀이.이분탐색;

import java.util.Scanner;

public class 기타_레슨 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        int l = 0;
        int r =0;

        for(int i=0; i<n; i++) {
            list[i] = sc.nextInt();
            if(l < list[i]) l = list[i];
            r += list[i];
        }

        while(l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if(sum + list[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += list[i];
            }

            if(sum != 0) {
                count++;
            }

            if(count > m) {
                l = mid + 1;
            }
            else {
                r = mid -1;
            }
        }
        System.out.println(l);
    }
}
