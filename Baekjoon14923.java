package study2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int dist;
    int crush; //벽 부순 여부
    Point(int x,int y,int dist,int crush){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.crush = crush;
    }
}
public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 추가
        //시작위치
        int hx = sc.nextInt();
        int hy = sc.nextInt();
        sc.nextLine(); // 추가
        //해당위치
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        sc.nextLine(); // 추가

        //행렬
        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];
        for(int i=0;i<n;i++) {
            String row = sc.nextLine();
            row = row.replace(" ", "");
            char[] numRow = row.toCharArray();
            for(int j=0;j<numRow.length;j++) {
                map[i][j] = numRow[j] - '0';
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(hx-1,hy-1,0,0));
        visited[hx-1][hy-1][0] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int answer = -1;
        while(!q.isEmpty()) {
        	Point p = q.poll();
        	if(p.x == ex-1 && p.y == ey-1) {
        		answer = p.dist;
        		break;
        	}
        	for(int i=0;i<4;i++) {
        		int moveX = p.x + dx[i];
        		int moveY = p.y + dy[i];
        		if(moveX >= 0 && moveY >= 0 && moveX < n && moveY < m) {
        			if(map[moveX][moveY] ==0 && !visited[moveX][moveY][p.crush]) {
        				visited[moveX][moveY][p.crush] = true;
        				q.add(new Point(moveX,moveY,p.dist+1,p.crush));
        			}
        			if(map[moveX][moveY] ==1 && !visited[moveX][moveY][1] && p.crush ==0) {
        				visited[moveX][moveY][1] = true;
        				q.add(new Point(moveX,moveY,p.dist+1,1));
        			}
        		}
        	}
        }
        System.out.println(answer);
    }
}
