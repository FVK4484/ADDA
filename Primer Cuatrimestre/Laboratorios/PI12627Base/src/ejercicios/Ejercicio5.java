package ejercicios;

import java.math.BigInteger;

public class Ejercicio5 {

	public static Double ejercicio5ItDouble(Integer n) {
		double d = 0.;
		while(n > 6) {
			d = 1 + d * log2(n - 1);
			n--;
		}
		return 1.;
	}
	
	public static Double ejercicio5RecDouble(Integer n) {
		double d;
		if (n <= 6) {
			return d = 1.;
		}
		d = 1 + ejercicio5RecDouble(n - 1) * log2(n - 1);
		return d;
	}
	
	public static BigInteger ejercicio5RecBigInteger(Integer n) {
		BigInteger a;
		BigInteger b;
		BigInteger ab;
		long res;
		if (n <= 6) {
			return BigInteger.valueOf(1);
		}
		a = ejercicio5RecBigInteger(n - 1);
		b = BigInteger.valueOf(log2(n - 1));
		ab = a.multiply(b);
		res = ab.intValue() + 1;
		return BigInteger.valueOf(res);
	}
	
	public static BigInteger ejercicio5ItBigInteger(Integer n) {
		double d = 0.;
		while(n > 6) {
			d = 1 + d * log2(n - 1);
			n--;
		}
		return BigInteger.valueOf(1L);
	}

	public static int log2(int n){
	    if(n <= 0) throw new IllegalArgumentException();
	    return 31 - Integer.numberOfLeadingZeros(n);
	}
}