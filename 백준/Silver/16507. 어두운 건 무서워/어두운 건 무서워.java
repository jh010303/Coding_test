import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r, c, q, r1, c1, r2, c2;
	static int[][] pixel;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		pixel = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				pixel[i][j] = Integer.parseInt(st.nextToken());
				pixel[i][j] += (i - 1 >= 0 ? pixel[i - 1][j] : 0) + (j - 1 >= 0 ? pixel[i][j - 1] : 0)
						- (i - 1 >= 0 && j - 1 >= 0 ? pixel[i - 1][j - 1] : 0);
			}
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken()) - 1;
			c1 = Integer.parseInt(st.nextToken()) - 1;
			r2 = Integer.parseInt(st.nextToken()) - 1;
			c2 = Integer.parseInt(st.nextToken()) - 1;

			sb.append((pixel[r2][c2] - (r1 - 1 >= 0 ? pixel[r1 - 1][c2] : 0) - (c1 - 1 >= 0 ? pixel[r2][c1 - 1] : 0)
					+ (r1 - 1 >= 0 && c1 - 1 >= 0 ? pixel[r1 - 1][c1 - 1] : 0)) / ((r2 - r1 + 1) * (c2 - c1 + 1)))
					.append('\n');
		}
		System.out.print(sb);
	}
}
