import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int k, widthMax = Integer.MIN_VALUE, heightMax = Integer.MIN_VALUE
			,widthMaxIndex=0, heightMaxIndex=0;
	static int[][] shape = new int[6][2];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			shape[i][0] = dir;
			shape[i][1] = length;
		}

		for(int i=0; i<6; i++) {
			if((shape[i][0] == 1 || shape[i][0]==2) && shape[i][1]>widthMax) {
				widthMax = shape[i][1];
				widthMaxIndex = i;
			}
			else if((shape[i][0] == 3 || shape[i][0]==4) && shape[i][1]>heightMax) {
				heightMax = shape[i][1];
				heightMaxIndex = i;
			}
		}
		int ans = heightMax*widthMax - 
				(Math.abs(shape[(heightMaxIndex+1)%6][1] - shape[(heightMaxIndex+5)%6][1]))*
				(Math.abs(shape[(widthMaxIndex+1)%6][1] - shape[(widthMaxIndex+5)%6][1]));
		bw.write(ans * k + "");
		bw.flush();
	}
}
