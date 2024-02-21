import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long money = 0;
		long n = sc.nextLong();
		long[] dists = new long[(int)n];
		dists[dists.length-1] = 1;
		long[] gas = new long[(int)n];
		for(int i=0;i<dists.length-1;i++) {
			dists[i] = sc.nextLong();
		}
		for(int i=0;i<dists.length;i++) {
			gas[i] = sc.nextLong();
		}
		
		
		long minGas = Long.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			minGas = Math.min(minGas, gas[i]);
			money += dists[i] * minGas;
		}
		System.out.println(money);
	}

}
