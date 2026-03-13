import java.util.*;
import java.io.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = replaceSharp(m);
        int musicInfosLength = musicinfos.length; int maxPlayTime = 0;
        StringTokenizer st;
        for(int i=musicInfosLength-1; i>=0; i--){
            st = new StringTokenizer(musicinfos[i]);
            String[] musicinfo = new String[4];
            for(int j=0; j<4; j++){
                musicinfo[j] = st.nextToken(",");
            }
            String s = musicinfo[0], e = musicinfo[1], title = musicinfo[2], info = replaceSharp(musicinfo[3]);
            int playTime = getTime(s,e);
            
            // 문자열 확장
            StringBuilder playMusicInfo = new StringBuilder();
            for(int j=0; j<playTime; j++){
                char add = info.charAt(j%info.length());
                playMusicInfo.append(info.charAt(j%info.length()));
            }
            
            // 문자열 비교
            if(playMusicInfo.toString().contains(m)){
                if(playTime >= maxPlayTime){
                    maxPlayTime = playTime;
                    answer = title;
                }
            }      
        }
        if(answer==""){
            answer="(None)";
        }
        return answer;
    }
    
    static String replaceSharp(String info){
        info = info.replace("C#","c");
        info = info.replace("D#","d");
        info = info.replace("F#","f");
        info = info.replace("G#","g");
        info = info.replace("A#","a");
        info = info.replace("B#","b");
        
        return info;
    }
    
    static int getTime(String s, String e){
        int eh = Integer.parseInt(e.substring(0,2)); int sh = Integer.parseInt(s.substring(0,2));
        int em = Integer.parseInt(e.substring(3)); int sm = Integer.parseInt(s.substring(3));
        if(eh==sh){
            return em-sm;
        }
        else{
            int h = eh-sh-1;
            int m = 60-sm+em;
            return h*60+m; 
        }
    }
}