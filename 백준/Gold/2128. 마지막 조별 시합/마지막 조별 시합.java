import java.io.*;
import java.util.*;

public class Main {
    static int n,d,k,ans;
    static List<List<Integer>> students = new ArrayList<List<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        init();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            for(int j=0; j<index; j++) {
                students.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int temp = 0,count=0;
        for(int i=1; i<(1<<d); i++) {
            if(countOnBit(i)==k) {
                count=0;
                for(int j=0; j<n; j++) {
                    temp = 0;
                    for(int k=0; k<students.get(j).size(); k++) {
                        temp+=(1 << (students.get(j).get(k)-1));
                    }
                    if((i&temp)==temp) {
                        count++;
                    }
                }
                ans = Math.max(count, ans);
            }
        }

        System.out.print(ans);
    }

    static int countOnBit(int n) {
        int count = 1;
        while(n>1) {
            if(n%2==1) {
                count++;
            }
            n/=2;
        }
        return count;
    }

    static void init() {
        students.clear();
        for(int i=0; i<n; i++) {
            students.add(new ArrayList<>());
        }
    }
}