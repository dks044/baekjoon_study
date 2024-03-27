package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(); //나무의 수
		long m = sc.nextLong(); //자를
		long[] arr = new long[(int)n];
		long left = 0;
		long right = -1;
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextLong();
			right = Math.max(arr[i], right);
		}
		while(left<=right) {
			long mid = (left+right)/2;
			long tree = 0; //자르고 얻을 수 있는 나무의 총 길이
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>mid) tree += arr[i]-mid;
			}
			if(tree >= m) {
				left = mid+1;
			}
			if(tree < m) {
				right = mid-1;
			}
			
		}
		System.out.println(right);
	}

}
