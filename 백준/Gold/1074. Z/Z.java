import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, n), numberRange = (int)Math.pow(size, 2);
		int ans = divideFour(size,r,c,numberRange);
		bw.write(ans+"");
		bw.flush();
	}
	
	static int divideFour(int size, int r, int c, int numberRange) {
		int divideSize = size/2;
		if(divideSize==1) {
			if(r==0 && c==0) {
				numberRange-=4;
			}
			else if(r==0 && c==1) {
				numberRange-=3;
			}
			else if(r==1 && c==0) {
				numberRange-=2;
			}
			else {
				numberRange-=1;
			}
			return numberRange;
		}
		
		int diff = (int)Math.pow(divideSize, 2);
		if(r<divideSize && c<divideSize) {
			numberRange = numberRange-diff*3;
		}else if(r<divideSize && c>=divideSize) {
			numberRange = numberRange-diff*2;
			c%=divideSize;
		}
		else if(r>=divideSize && c<divideSize) {
			numberRange = numberRange-diff*1;
			r%=divideSize;
		}else if(r>=divideSize && c>=divideSize) {
			numberRange = numberRange-diff*0;
			c%=divideSize;
			r%=divideSize;
		}
		
		return divideFour(divideSize,r,c,numberRange);
	}
}
