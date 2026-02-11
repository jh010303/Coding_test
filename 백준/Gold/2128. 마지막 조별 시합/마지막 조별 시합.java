import java.io.*;
import java.util.*;

public class Main {
    static int n,d,k,ans;
    static List<Integer> students = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int studentBit = 0;
            for(int j=0; j<cnt; j++) {
            	int bitOn = Integer.parseInt(st.nextToken());
            	studentBit |= (1<<(bitOn-1));
            }
            students.add(studentBit);
        }

        int count=0;
        for(int i=1; i<(1<<d); i++) {
            if(countOnBit(i)==k) {
                count=0;
                for(int j=0; j<n; j++) {
                	int studentsBit = students.get(j);
                    if((i&studentsBit)==studentsBit) {
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
}