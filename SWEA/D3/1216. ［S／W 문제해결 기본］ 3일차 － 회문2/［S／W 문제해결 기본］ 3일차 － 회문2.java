import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{

	static int t,n,ans=1;
	static char[][] arr = new char[101][101];
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++) {
			ans = 1;
			t = Integer.parseInt(br.readLine());
			for(int i=0; i<100; i++) {
				String temp = br.readLine();
				for(int j=0; j<temp.length(); j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					for(int r=j+1; r<100; r++) { // end 값
						// 가로
						if(palindrome1(i,j,r)) { 
							ans = Math.max(ans, r-j+1);
						}
					}
					for(int r=i+1; r<100; r++) { // end 값
						if(palindrome2(i,j,r)) { 
							ans = Math.max(ans, r-i+1);
						}
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	// 가로
	static boolean palindrome1(int i, int j, int r) {
		int start = j, end = r;
		while(start<end) {
			if(arr[i][start]!=arr[i][end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	// 세로
	static boolean palindrome2(int i, int j, int r) {
		int start = i, end = r;
		while(start<end) {
			if(arr[start][j]!=arr[end][j]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}