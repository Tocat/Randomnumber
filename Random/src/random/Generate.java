package random;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generate {
	 static int[] data = new int[624];
	 static int index = 0;
	 static void initialize_generator(int seed) {
	     int i = 0;
	     data[0] = seed;
	     for(i=1;i<624;i++){ 
	         data[i] = (int)(1812433253 * (data[i-1] ^ ((data[i-1])>>30)) + i);
	        System.out.println(data[i]);		 
	        		 
	     }
	 }
	 static int extract_number() {
	     if (index == 0) {
	         generate_numbers();
	     }
	     int y = data[index];
	     y = y ^ (y>>11);
	     y = y ^ ((y>>7) & ((int)2636928640.0)); 
	     y = y ^ ((y<<15) & ((int)4022730752.0)); 
	     y = y ^ ((y>>18));
	     index = (index + 1) % 624;
	     System.out.println(y);
	     return y;
	 }
	 static void generate_numbers() {
	     for(int i=0;i<624;i++){
	    	 int y = (data[i] & 0x80000000)                       
	                        + (data[(i+1) % 624] & 0x7fffffff) ; 
	         data[i] = data[(i + 397) % 624] ^ ((y>>1));
	         if ((y % 2) != 0) { 
	             data[i] = data[i] ^ ((int)2567483615.0); 
	         }
	     }
	 }

	public static void run(String url) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(url+"/result.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initialize_generator(2131231312);
		int t = 0;
		int s = extract_number();
		try {
			if (s % 2 == 1) {
				writer.write("1");
				t++;
			}else{
				writer.write("0");
			}
			for (int i = 1; i < 1000000000; i++) {
				s = extract_number();
				if (s % 2 == 1) {
					writer.write(",1");
					t++;
				}else{
					writer.write(",0");
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(t);
		
	}
}
