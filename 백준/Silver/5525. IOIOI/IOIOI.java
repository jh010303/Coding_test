import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans = 0,count=0;
	static String str;
	static boolean fail, firstFind = true;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		str = br.readLine();
		for(int i=0; i<str.length()-2; i++) {
			if(str.charAt(i)=='I' && str.charAt(i+1)=='O' && str.charAt(i+2)=='I') {
				count++;
				i++;
				if(count>=n) {
					ans++;
					count--;
				}
			}
			else {
				count=0;
			}
		}

		System.out.print(ans);
	}
}
