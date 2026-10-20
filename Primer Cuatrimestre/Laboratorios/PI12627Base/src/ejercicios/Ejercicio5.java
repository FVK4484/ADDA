package ejercicios;

import java.math.BigInteger;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		System.out.println(ejercicio5ItDouble(10));
		System.out.println(ejercicio5RecDouble(10));
		System.out.println(ejercicio5RecBigInteger(10));
		System.out.println(ejercicio5ItBigInteger(10));
	}

	public static Double ejercicio5ItDouble(Integer n) {
	    double res = 1.;
	    for (int i = 7; i <= n; i++) {
	        res = 1 + res * log2(i - 1);
	    }
	    return res;
	}
	
	public static Double ejercicio5RecDouble(Integer n) {
		if (n <= 6) {
			return 1.;
		}
		return 1 + ejercicio5RecDouble(n - 1) * log2(n - 1);
	}
	
	public static BigInteger ejercicio5RecBigInteger(Integer n) {
		if (n <= 6) {
			return BigInteger.ONE;
		}
		return BigInteger.ONE.add(ejercicio5RecBigInteger(n - 1)
				.multiply(BigInteger.valueOf(log2(n - 1))));
	}
	
	public static BigInteger ejercicio5ItBigInteger(Integer n) {
		BigInteger res = BigInteger.ONE;
	    for (int i = 7; i <= n; i++) {
	    	res = BigInteger.ONE.add(res.
	    			multiply(BigInteger.valueOf(log2(i - 1))));
	    }
	    return res;
	}
	
	public static int log2(int n){
	    if(n <= 0) throw new IllegalArgumentException();
	    return 31 - Integer.numberOfLeadingZeros(n);
	}
	
}