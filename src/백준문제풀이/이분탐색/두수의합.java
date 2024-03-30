package 백준문제풀이.이분탐색;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            int[] list = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list);

            int l = 0, r = n-1;
            int count = 0;
            int closest_number = Integer.MAX_VALUE;

            while(l < r) {
                int sum = list[l] + list[r];
                int diff = Math.abs(sum-k);
                if(diff <= closest_number) {
                    if(diff < closest_number) count = 0;
                    closest_number = diff;
                    count++;
                }

                if(sum == k) {
                    l++;
                    r--;
                }
                else if(sum > k){
                    r--;
                }
                else {
                    l++;
                }
            }
            System.out.println(count);
        }
    }
}
