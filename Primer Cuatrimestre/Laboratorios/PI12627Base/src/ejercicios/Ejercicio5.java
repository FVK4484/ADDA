package ejercicios;

import java.math.BigInteger;

public class Ejercicio5 {

//	public static Double ejercicio5ItDouble(Integer n) {
//		double res = 1.;
//		while (n > 6) {
//			res = 1 + res * log2(n - 1);
//			n--;
//		}
//		return res;
//	}
	
	public static Double ejercicio5RecDouble(Integer n) {
		if (n <= 6) {
			return 1.;
		}
		return 1 + ejercicio5RecDouble(n - 1) * log2(n - 1);
	}
	
	public static BigInteger ejercicio5RecBigInteger(Integer n) {
		BigInteger a;
		BigInteger b;
		if (n <= 6) {
			return BigInteger.ONE;
		}
		a = ejercicio5RecBigInteger(n - 1);
		b = BigInteger.valueOf(log2(n - 1));
		return a.multiply(b).add(BigInteger.ONE);
	}
	
//	public static BigInteger ejercicio5ItBigInteger(Integer n) {
//		long d = 0L;
//		while(n > 6) {
//			d = 1 + d * log2(n - 1);
//			n--;
//		}
//		return BigInteger.ONE;
//	}
//
	public static int log2(int n){
	    if(n <= 0) throw new IllegalArgumentException();
	    return 31 - Integer.numberOfLeadingZeros(n);
	}
	
}