import java.io.*;
import java.util.*;

public class Main {
	static class City implements Comparable<City> {
		int num;
		int cost;

		public City(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(City c) {
			return this.cost - c.cost;
		}
	}

	static int n, m, start, end;
	static List<List<City>> map = new ArrayList<>();
	static PriorityQueue<City> que = new PriorityQueue<>();
	static int[] sct;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		init();
		sct = new int[n + 1];
		Arrays.fill(sct, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map.get(n).add(new City(m, c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		sct[start] = 0;
		que.offer(new City(start, 0));
		while (!que.isEmpty()) {
			City cur = que.poll();
			int curCity = cur.num, curCost = cur.cost;
			if(sct[curCity]<curCost)continue;
			for (int i = 0; i < map.get(curCity).size(); i++) {
				City next = map.get(curCity).get(i);
				int nextCity = next.num, nextCost = curCost + next.cost;
				if (nextCost < sct[nextCity]) {
					sct[nextCity] = nextCost;
					que.offer(new City(nextCity, nextCost));
				}
			}
		}
		System.out.print(sct[end]);
	}

	static void init() {
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}
	}
}
