package ejercicios;

public class Ejercicio1 {
	
	private static Monedas monedasPrueba;
	
	public static int monedaFalsa(Monedas monedas) { 
		monedasPrueba = monedas;
		return monedaFalsaRecursivo(0, monedas.size(), monedas); 
	} 

	private static int monedaFalsaSi3(int i, int j) {
		for (int k = i; k < j; k++) {
			if (monedasPrueba.isFalsa(k)) {
				return k;
			}
		}
		return -1; 
	}
	
	// b) Desarrollar el algoritmo descrito en su versión recursiva.
	private static int monedaFalsaRecursivo(int i, int j, Monedas monedas) { 
		int indiceMonedaFalsa = -1; 
		if (j-i <= 3) { 
			indiceMonedaFalsa = monedaFalsaSi3(i, j); 
		} else { 
			if (monedas.pesar(i, i+(j-i)/4, i+(j-i)/4, i+2*((j-i)/4)) != 0) {
				indiceMonedaFalsa = monedaFalsaRecursivo(i, i+2*((j-i)/4), monedas); 
			} else { 
				indiceMonedaFalsa = monedaFalsaRecursivo(i+2*((j-i)/4), j, monedas); 
			} 
		} 
		return indiceMonedaFalsa; 
	}
	
	// c) Implementación del algoritmo en su versión iterativa imperativa: // WHILE
		public static int monedaFalsaIterativa(Monedas monedas) {
			monedasPrueba = monedas;
			int i = 0;
			int j = monedas.size();
			while (j - i > 3) {
				if (monedas.pesar(i, i+(j-i)/4, i+(j-i)/4, i+2*((j-i)/4)) != 0) {
					j = i+2*((j-i)/4);
				} else {
					i = i+2*((j-i)/4);
				}
			}
			return monedaFalsaSi3(i, j);
		}
}
