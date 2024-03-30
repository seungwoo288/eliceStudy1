package 백준문제풀이.이분탐색;

import java.util.*;
import java.util.Scanner;

public class 로봇_프로젝트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()*10000000;
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        int l = 0, r = n-1;
        boolean flag = false;

        while(l < r) {
            int sum = list[l] + list[r];
            if(sum == x) {
                System.out.println("yes " + list[l] + " " + list[r]);
                flag = true;
                break;
            }
            else if(sum > x) {
                r--;
            }
            else {
                l++;
            }
        }
        if(!flag){
            System.out.println("danger");
        }
        sc.close();
    }
}
