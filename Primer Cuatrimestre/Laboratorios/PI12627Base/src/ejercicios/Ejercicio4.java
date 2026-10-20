package ejercicios;

import java.math.BigInteger;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		System.out.println(funcRecDouble(15));
		System.out.println(funcItDouble(15));
		System.out.println(funcRecBig(15));
		System.out.println(funcItBig(15));
	}
	
	public static Double funcRecDouble(Integer a) { 
		if (a < 10) {
			return 5.;
		} else {
			return Math.sqrt(3 * a) * funcRecDouble(a - 2);
		}
	}
	
	public static Double funcItDouble(Integer a) {
	    double res = 5.;
	    while(a >= 10) {
	    	res = Math.sqrt(3 * a) * res;
	    	a-=2;
	    }
	    return res;
	}
	
	public static BigInteger funcRecBig(Integer a) {
		if (a < 10) {
			return BigInteger.valueOf(5L);
		} else {
			return BigInteger.valueOf((long) Math.sqrt(3 * a))
					.multiply(funcRecBig(a - 2));
		}
	}

	public static BigInteger funcItBig(Integer a) {
	    BigInteger res = BigInteger.valueOf(5L);
	    while(a >= 10) {
	    	res = BigInteger.valueOf((long) Math.sqrt(3 * a))
					.multiply(res);
	    	a-=2;
	    }
	    return res;
	}

}