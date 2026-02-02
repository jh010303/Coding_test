import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans = 0;
	static String str;
	static boolean fail;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		str = br.readLine();
		int s = 0, e = 2 * n;

		while (e < str.length()) {
			if (!(str.charAt(s) == 'O')) {
				char bef = 'I';
				fail = false;
				for (int i = s + 1; i <= e; i++) {
					char cur = str.charAt(i);
					if (bef == 'I' && cur == 'O') {
						bef = 'O';
					} else if (bef == 'O' && cur == 'I') {
						bef = 'I';
					} else {
						fail = true;
						break;
					}
				}
				if (!fail) {
					ans++;
				}
			}
			s++;
			e++;
		}

		System.out.print(ans);
	}
}
