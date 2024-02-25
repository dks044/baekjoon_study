package study;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			Integer num = sc.nextInt();
			q.add(num);
		}
		int sum =0;
		int answer = 0;
		while(q.size() != 1) {
			sum = 0;
			sum += q.poll();
			sum += q.poll();
			answer += sum;
			q.add(sum);
		}
		
		System.out.println(answer);
	}

}
