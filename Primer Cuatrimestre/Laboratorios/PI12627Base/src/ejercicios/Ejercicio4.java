package ejercicios;

import java.math.BigInteger;

public class Ejercicio4 {
	
	public static Double funcRecDouble(Integer a) { 
		if (a < 10) {
			double n = 5.;
			return n;
		} else {
			double n =  Math.sqrt(3 * a) * funcRecDouble(a - 2);
			return n;
		}
	}
	
	public static BigInteger funcRecBig(Integer a) {
		if (a < 10) {
			BigInteger n = BigInteger.valueOf(5L);
			return n;
		} else {
			BigInteger n1 = BigInteger.valueOf((int) Math.sqrt(3 * a));
			BigInteger n2 = funcRecBig(a - 2);
			return n1.multiply(n2);
		}
	}
	
	public static Double funcItDouble(Integer a) {
		while (a >= 10) {
//			double n = Math.sqrt(3 * a);
			a = a - 2;
		}
		double d = 5.;
        return d;
	}
	
	public static BigInteger funcItBig(Integer a) {
		while (a >= 10) {
//			double n = Math.sqrt(3 * a);
			a = a - 2;
		}
		int d = 5;
        return BigInteger.valueOf(d);
	}

}