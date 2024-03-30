package 백준문제풀이.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 예산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
            max = Math.max(max,list[i]);
        }
        int m = Integer.parseInt(br.readLine());

        if(sum <= m) {
            System.out.println(max);
            return;
        }

        int l = 0, r = max;
        int mid = 0;

        while(l <= r) {
            mid = (l + r)/2;
            long budget =0;
            for(int i = 0; i < n; i++) {
                if(list[i] > mid) {
                    budget += mid;
                }
                else {
                    budget += list[i];
                }
            }
            if(budget <= m) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }
}
