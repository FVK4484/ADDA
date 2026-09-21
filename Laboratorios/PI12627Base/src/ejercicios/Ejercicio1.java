package ejercicios;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Ejercicio1 {
	
	public static void tests(List<ParEnteros> ls) {
		ls.forEach(t -> {
			System.out.println("1) Solucion Funcional: " + funcional(t.a(), t.b()));
			System.out.println("2) Solucion Iterativo: " + iterativo(t.a(), t.b()));
			System.out.println("3) Solucion Rec. Final: " + recFinal(t.a(), t.b()));
		});
		
	}
	
	public static String funcional(Integer varA, Integer varB) {
		
		UnaryOperator<EnteroCadena> nx = elem -> { 
			return EnteroCadena.of(elem.a() + 3, elem.a() % 2 == 0 ? elem.a() + "*" : elem.a() + "!");
			
		};
		
		return Stream.iterate(EnteroCadena.of(varA,"A"), 
				elem -> elem.a() < varB, nx)
				.filter(elem -> elem.a() % 10 != 0)
				.map(elem -> elem.s())
				.collect(Collectors.joining("-"));
		
		} 
	
	public static String iterativo(Integer varA, Integer varB) {
		
	    List<String> res = new ArrayList<>();
	    EnteroCadena elem = EnteroCadena.of(varA, "A");
	    
	    while (elem.a() < varB) {
	        if (elem.a() % 10 != 0) {
	            res.add(elem.s());
	        }
	        
	        int nextA = elem.a() + 3;
	        String nextS = (elem.a() % 2 == 0) ? elem.a() + "*" : elem.a() + "!";
	        elem = EnteroCadena.of(nextA, nextS);
	        
	    }
	    
	    return String.join("-", res);
	    
	}
	
	public static String recFinal(Integer varA, Integer varB) {
		
		return recFinal(varA, varB, new EnteroCadena(varA, "A"), "");
		
	}
	
	private static String recFinal(Integer varA, Integer varB, EnteroCadena elem, String ac) {
		
		if (elem.a() < varB) {
			
			if (elem.a() % 10 != 0) {
				
				ac = ac.isEmpty() ? elem.s() : ac + "-" + elem.s();;
	            
	        }
			
        	int nextA = elem.a() + 3;
	        String nextS = (elem.a() % 2 == 0) ? elem.a() + "*" : elem.a() + "!";
	        elem = EnteroCadena.of(nextA, nextS);
	        return recFinal(nextA, varB, elem, ac);
	        
		}
		
		return ac;
		
	}

}
