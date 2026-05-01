import java.util.*;

class Solution {
    class Genre implements Comparable<Genre>{
        int genre;
        int sum;
        
        public Genre(int genre, int sum){
            this.genre = genre;
            this.sum = sum;
        }
        
        void addSum(int s){
            this.sum+=s;
        }
        
        @Override
        public int compareTo(Genre g){
            return Integer.compare(g.sum,this.sum);
        }
    }
    
    class Play implements Comparable<Play>{
        int i;
        int p;
        
        public Play(int i, int p){
            this.p = p;
            this.i = i;
        }
        
        @Override
        public int compareTo(Play p){
            if(p.p!=this.p){
                return Integer.compare(p.p,this.p);
            }
            return Integer.compare(this.i,p.i);
        }
    }
    
    
    HashMap<String,Integer> genreMap = new HashMap<>();
    
    int[] topGenre;
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        initMap(genres);
        selectGenre(genres,plays);
        
        PriorityQueue<Play> playQ = new PriorityQueue<>();
        
        for(int i=0; i<topGenre.length; i++){
            playQ.clear();
            int topG = topGenre[i];
            for(int j=0; j<plays.length; j++){
                if(genreMap.get(genres[j]) == topG){
                    playQ.add(new Play(j,plays[j]));
                }
            }
            for(int j=0; j<2; j++){
                if(playQ.isEmpty()){
                    break;
                }
                answer.add(playQ.poll().i);
            }
        }
        return answer;
    }
    
    void selectGenre(String[] genres, int[] plays){
        Genre[] genrePlay = new Genre[genreMap.size()];

        for(int i=0; i<genrePlay.length; i++){
            genrePlay[i] = new Genre(i,0);
        }
    
        for(int i=0; i<plays.length; i++){
            int g = genreMap.get(genres[i]); int p = plays[i];
            genrePlay[g].addSum(p);
        }
        
        Arrays.sort(genrePlay);
        
        for(int i=0; i<genreMap.size(); i++){
            topGenre[i] = genrePlay[i].genre;
        }
    }
    
    void initMap(String[] genres){
        int genreIndex = 0;
        for(int i=0; i<genres.length; i++){
            String g = genres[i];
            if(!genreMap.containsKey(g)){
                genreMap.put(g,genreIndex++);
            }
        }
        topGenre = new int[genreMap.size()];
    }
}