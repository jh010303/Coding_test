import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int next = (~n+1) ^ n;
		int count = 0;
		for(int i=0; i<32; i++) {
			if((next & 1) == 1) {
				count++;
			}
			next = next >> 1;
		}
		System.out.println(count);
	}

}
