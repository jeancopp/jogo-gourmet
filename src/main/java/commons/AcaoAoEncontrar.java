package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Categoria;
import model.Prato;

public class AcaoAoEncontrar implements Acao {
	public static final Categoria CATEGORIA_OUTROS = new Categoria("Outros");

	private Map<Categoria, List<Prato>> indice;
	private Categoria categoriaAtual;

	public AcaoAoEncontrar(Map<Categoria, List<Prato>> indice, Categoria categoriaAtual) {
		this.indice = indice;
		this.categoriaAtual = categoriaAtual;
	}

	@Override
	public void executar() {
		String nomeDoPrato = Mensagens.perguntarComEntrada("Qual é o seu prato?");
		Categoria categoriaNoIndice = null;
		
		if( categoriaAtual.equals(CATEGORIA_OUTROS)){
			String nomeCategoriaDoNovoPrato = Mensagens.perguntarComEntrada("Qual é a categoria seu prato?");
	
			Categoria categoriaDoNovoPrato = new Categoria(nomeCategoriaDoNovoPrato);
			categoriaNoIndice = indice.keySet().stream().filter(cat -> cat.equals(categoriaDoNovoPrato))
					.findFirst().orElse(categoriaDoNovoPrato);
		}else 
			categoriaNoIndice = categoriaAtual;
		
		List<Prato> pratos = indice.getOrDefault(categoriaNoIndice, new ArrayList<>());

		pratos.add(new Prato(nomeDoPrato));
		indice.put(categoriaNoIndice, pratos);
	}

}
