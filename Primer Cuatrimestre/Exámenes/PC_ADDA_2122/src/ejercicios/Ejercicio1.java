package ejercicios;

public class Ejercicio1 {
	
	//	a) Proporcione una solución eficiente recursiva no final.
	public static String fRecursivaNoFinal(int a, int b, int c) {
		String res = "";
		if (a < 3 || b < 3 || c < 3) {
			res = (a + b + c) + "y";
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			res = (a * b * c) + "z";
		} else  if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			res = fRecursivaNoFinal(a - 1, b / 2, c - 3) + "+";
		} else {
			res = fRecursivaNoFinal(a - 4, b / 3, c - 4) + "#";
		}
		return res;
	}
	
	
	//	b) Proporcione una solución eficiente recursiva final.
	
	
	//	c) Solución en notación funcional
	
	
	//	d) Solución iterativa con while
	
	
}
