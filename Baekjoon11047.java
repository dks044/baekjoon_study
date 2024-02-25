package study;
import java.util.*;

public class Main {

	public static void main(String[] args) {
//		준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//
//		동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] bank = new int[n];
		
		for(int i=0;i<n;i++) {
			int money = sc.nextInt();
			bank[i] = money;
		}
		Arrays.sort(bank);
		int wallet = 0;
		int index = bank.length-1;
		int count = 0;
		while(wallet <= k) {
			wallet += bank[index];
			if(wallet > k) {
				wallet -= bank[index];
				index--;
			}else {
				count++;
				if(wallet == k) break;
			}
		}
		System.out.println(count);
		
	}

}
