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
	    double res = 5.0; // Partimos del valor base
	    while (a >= 10) {
	        res = res * Math.sqrt(3 * a); // Acumulamos la multiplicación
	        a = a - 2;
	    }
	    return res;
	}

	public static BigInteger funcItBig(Integer a) {
	    BigInteger res = BigInteger.valueOf(5L); // Partimos del valor base
	    while (a >= 10) {
	        // Calculamos el factor truncándolo a entero, igual que en tu versión recursiva
	        BigInteger factor = BigInteger.valueOf((int) Math.sqrt(3 * a));
	        res = res.multiply(factor); // Acumulamos la multiplicación
	        a = a - 2;
	    }
	    return res;
	}

}