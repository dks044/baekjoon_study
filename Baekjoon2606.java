
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {

    static int getWormComputerCountByDfs(List<List<Integer>> network, int computerEA) {
        int wormComputerCount = 0;
        boolean[] visited = new boolean[computerEA + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 1번 컴퓨터부터 시작

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                wormComputerCount++;

                for (int connectedComputer : network.get(current)) {
                    if (!visited[connectedComputer]) {
                        stack.push(connectedComputer);
                    }
                }
            }
        }

        return wormComputerCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerEA = sc.nextInt();
        int computerForConnected = sc.nextInt();

        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= computerEA; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < computerForConnected; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            network.get(a).add(b);
            network.get(b).add(a); 
        }
        
        System.out.println(getWormComputerCountByDfs(network, computerEA)-1);
    
    }
}
