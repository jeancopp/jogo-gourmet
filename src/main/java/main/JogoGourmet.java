package main;

import static commons.AcaoAoEncontrar.CATEGORIA_OUTROS;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import commons.Acao;
import commons.AcaoAoEncontrar;
import commons.Interador;
import commons.Mensagens;
import factory.Fabrica;
import model.Categoria;
import model.Prato;

public class JogoGourmet {
	public static void main(String[] args) {
		boolean desejaContinuar = true;

		Map<Categoria, List<Prato>> indice = Fabrica.produzirIndice();
		
		Acao acaoAoEncontrar = () -> Mensagens.exibirMensagem("Acertei novamente!");
		
		Interador<Categoria> interador = new Interador<Categoria>();
		Interador<Prato> interadorDePratos = new Interador<Prato>();
		do{
			Mensagens.exibirMensagem("Pense num prato que você gosta");
			
			List<Categoria> itensParaPerguntar = indice.keySet()
													.stream()
													.filter( c -> ! CATEGORIA_OUTROS.equals(c) )
													.collect( Collectors.toList() );
			
			Categoria retorno = interador.percorrer(itensParaPerguntar, Mensagens::perguntar);
			Categoria chaveDoIndice = Optional.ofNullable(retorno).orElse(CATEGORIA_OUTROS);
			List<Prato> pratosParaPerguntar = indice.get(chaveDoIndice);

			Optional<Prato> pratoSelecionado = Optional.ofNullable(interadorDePratos.percorrer(pratosParaPerguntar, Mensagens::perguntar));
			
			( pratoSelecionado.isPresent() ? acaoAoEncontrar : new AcaoAoEncontrar(indice, chaveDoIndice) ).executar();
			
			desejaContinuar = Mensagens.perguntar("Deseja continuar?");
		}while(desejaContinuar);
		
		System.exit(0);

	}

	
	
}
