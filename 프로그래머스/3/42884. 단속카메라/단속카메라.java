import java.util.*;

class Solution {
    class Car implements Comparable<Car>{
        int s;
        int e;
        public Car(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Car c){
            return Integer.compare(this.e,c.e);
        }
        
    }
    List<Car> cars = new ArrayList<>();
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        initCar(routes);
        
        for(int i=0; i<cars.size(); i++){
            Car c = cars.get(i);
            int cs = c.s; int ce = c.e;
            for(int j=i+1; j<cars.size(); j++){
                Car n = cars.get(j);
                int ns = n.s; int ne = n.e;
                if(ns<=ce && ce<=ne){
                    cars.remove(j);
                    j--;
                }
            }
            answer++;
            cars.remove(i);
            i--;
        }
        return answer;
    }
    
    void initCar(int[][] routes){
        for(int i=0; i<routes.length; i++){
            int s = routes[i][0]; int e = routes[i][1];
            cars.add(new Car(s,e));
        }
        Collections.sort(cars);
    }
}