import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		String temp = "";
		for(; i<3; i++) {
			temp = br.readLine();
			if(checkDigit(temp)) {
				break;
			}
		}
		int d = Integer.parseInt(temp)+3-i;
		if(d%3==0 && d%5==0) {
			System.out.print("FizzBuzz");
		}
		else if(d%3==0 && d%5!=0) {
			System.out.print("Fizz");
		}else if(d%3!=0 && d%5==0) {
			System.out.print("Buzz");
		}
		else if(d%3!=0 && d%5!=0) {
			System.out.print(d);
		}
		
	}
	
	static boolean checkDigit(String temp) {
		char t = temp.charAt(0);
		if('0'<= t && t<='9') {
			return true;
		}
		return false;
	}
}