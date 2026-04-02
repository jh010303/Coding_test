import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
		int[][] board = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(true) {
			int[][] vis = new int[N][N];
			boolean sumed = false;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(vis[i][j] != 0) continue;
					List<Integer> area = new ArrayList<>();
					Deque<Integer> Q = new ArrayDeque<>();
					Q.offer(i * N + j);
					int temp1 = i * N + j;
					vis[i][j] = 1;
					while(!Q.isEmpty()) {
						int temp = Q.poll();
						int row = temp / N;
						int col = temp % N;
						for(int q = 0; q<4; q++) {
							int nrow = row + dx[q];
							int ncol = col + dy[q];
							if(nrow >= N || nrow < 0 || ncol < 0 || ncol >= N) continue;
							if(vis[nrow][ncol] != 0) continue;
							int sub = Math.abs(board[row][col] - board[nrow][ncol]);
							if(sub >= L && sub <= R) {
								Q.offer(nrow * N + ncol);
								area.add(nrow * N + ncol);
								vis[nrow][ncol] = 1;
							}
						}
					}
					int temp3 = board[temp1 / N][temp1 % N];
					for(int q = 0; q<area.size(); q++) {
						int temp2 = area.get(q);
						temp3 += board[temp2 / N][temp2 % N];
					}
					for(int q = 0; q<area.size(); q++) {
						int temp2 = area.get(q);
						board[temp2 / N][temp2 % N] = temp3 / (area.size() + 1);

						board[temp1 / N][temp1 % N] = temp3 / (area.size() + 1);
						sumed = true;
					}
				}
			}
//			for(int z = 0; z<N; z++) {
//				for(int x = 0; x < N; x++) {
//					System.out.print(board[z][x] + "\t");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
//			
			if(!sumed) break;
			else ans++;
		}
		
		
		System.out.println(ans);
		
		
	}
}
