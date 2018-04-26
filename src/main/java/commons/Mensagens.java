package commons;

import javax.swing.JOptionPane;

import model.TipoAbstrato;

public class Mensagens {
	public static String perguntarComEntrada(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	public static void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public static boolean perguntar(TipoAbstrato item) {
		return perguntar(String.format("Sua comida é %s?", item.getNome()));
	}
	
	public static boolean perguntar(String pergunta) {
		return JOptionPane.showConfirmDialog(null, pergunta, "Jogo Gourmet", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
	}
}
