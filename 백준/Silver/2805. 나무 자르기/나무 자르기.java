import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
	static int n,m,start,end,mid,ans;
	static long cut_trees;
	static List<Integer> trees = new ArrayList<>();
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			trees.add(Integer.parseInt(st.nextToken()));
		}
		
		start = 0; end=Collections.max(trees);
		mid = (start+end)/2;
		while(start<=end) {
			mid = (start+end)/2;
			cut_trees = cut(mid);
			if(cut_trees>=m) {
				ans = mid;
				start=mid+1;
				
			}else{
				end=mid-1;
			}
		}
		System.out.println(ans);
	}
	
	static long cut(int mid) {
		long sum = 0;
		for(Integer tree:trees) {
			if(mid<tree) {
				sum+=tree-mid;
			}
		}
		return sum;
	}
}