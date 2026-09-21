package ejercicios;

public class Monedas {
	
    private int[] pesos;
    private int indiceFalsa;

    // Constructor para preparar la prueba
    public Monedas(int numMonedas, int indiceFalsa, boolean esMasPesada) {
        this.pesos = new int[numMonedas];
        this.indiceFalsa = indiceFalsa;
        
        for (int i = 0; i < numMonedas; i++) {
            pesos[i] = 10; // Peso normal de una moneda
        }
        // La moneda falsa pesa distinto (12 si es más pesada, 8 si es más ligera)
        pesos[indiceFalsa] = esMasPesada ? 12 : 8; 
    }

    public int size() {
        return pesos.length;
    }

    public int pesar(int i1, int j1, int i2, int j2) {
        int peso1 = 0;
        for (int k = i1; k < j1; k++) peso1 += pesos[k];
        
        int peso2 = 0;
        for (int k = i2; k < j2; k++) peso2 += pesos[k];
        
        // Devuelve negativo si peso1 < peso2, 0 si son iguales, positivo si peso1 > peso2
        return Integer.compare(peso1, peso2);
    }

    // Método de ayuda exclusivo para simular el caso base fácilmente
    public boolean isFalsa(int indice) {
        return indice == this.indiceFalsa;
    }
    
}