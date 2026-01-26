
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());
        
        int[][] shape = new int[6][2];
        int maxW = 0, maxH = 0;
        int wIdx = -1, hIdx = -1; 

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            shape[i][0] = Integer.parseInt(st.nextToken());
            shape[i][1] = Integer.parseInt(st.nextToken());

            if (shape[i][0] == 1 || shape[i][0] == 2) {
                if (shape[i][1] > maxW) {
                    maxW = shape[i][1];
                    wIdx = i;
                }
            } else {
                if (shape[i][1] > maxH) {
                    maxH = shape[i][1];
                    hIdx = i;
                }
            }
        }


        int smallW = Math.abs(shape[(wIdx + 5) % 6][1] - shape[(wIdx + 1) % 6][1]);
        int smallH = Math.abs(shape[(hIdx + 5) % 6][1] - shape[(hIdx + 1) % 6][1]);

        int bigArea = maxW * maxH;
        int smallArea = smallW * smallH;
        int ans = (bigArea - smallArea) * k;

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}