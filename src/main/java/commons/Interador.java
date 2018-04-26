package commons ;

import java.util.List;
import java.util.function.Function;

import model.TipoAbstrato;

public class Interador<T extends TipoAbstrato>{
	
	public T percorrer(List<T> items, Function<T, Boolean> perguntador){
		for (T item : items) {
			boolean resposta = perguntador.apply(item);
			if(resposta){
				return (T)item;
			}
		}
		return null;
	}
	
	
}