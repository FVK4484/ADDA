package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class EjercicioExamen1 {
	
	public static void main(String[] args) {
		System.out.println(ejercicio2RecursivoFinal(20, "AsSSS"));
		System.out.println(ejercicio2RecursivoNoFinal(20, "AsSSS"));
	}
	
	public static List<String> ejercicio2RecursivoFinal (Integer a, String s) {
		return ejercicio2RecursivoFinal(a, s, new ArrayList<String>());
	}
	
	public static List<String> ejercicio2RecursivoFinal (Integer a, String s
			, List<String> ac) {
		if (a <= 3 || s.length() <= 2) {
			ac.add(0, s);
			ac.add(0, a.toString() + s);
		} else {
			
			ac.add(0, a.toString() + s.substring(0, a % s.length()));
			ac = ejercicio2RecursivoFinal(a - 3, s.substring(0, s.length() - 1), ac);
		}
		return ac;
	}
	
	public static List<String> ejercicio2RecursivoNoFinal (Integer a, String s) {
		List<String> ac = new ArrayList<String>();
		if (a <= 3 || s.length() <= 2) {
			ac.add(a.toString() + s);
			ac.add(s);
		} else {
			ac = ejercicio2RecursivoNoFinal(a - 3, s.substring(0, s.length() - 1));
			ac.add(a.toString() + s.substring(0, a % s.length()));
		}
		return ac;
	}
	
}
