package factory;

import static commons.AcaoAoEncontrar.CATEGORIA_OUTROS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Categoria;
import model.Prato;

public class Fabrica {

	public static Map<Categoria, List<Prato>> produzirIndice() {
		Map<Categoria,List<Prato>> map = new HashMap<Categoria, List<Prato>>();
		map.put(new Categoria("Massa"), new ArrayList<>(Arrays.asList(new Prato("Lasanha"))));
		map.put(CATEGORIA_OUTROS, new ArrayList<>(Arrays.asList(new Prato("Bolo de chocolate"))));
		return map;
	}

}
