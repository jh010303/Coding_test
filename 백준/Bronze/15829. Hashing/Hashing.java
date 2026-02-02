import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l;
	static long sum = 0;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			sum+=((str.charAt(i)-'a'+1)*(long)Math.pow(31, i))%1234567891;
		}
		System.out.print(sum);
	}
}
