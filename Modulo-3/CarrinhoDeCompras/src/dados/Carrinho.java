package dados;

import java.util.ArrayList;
import java.util.List;

import entidades.Item;

public class Carrinho {

	private static List<Item> carrinho = new ArrayList<Item>();

	public void adicionar(Item item) {
		carrinho.add(item);
	}

	public static List<Item> listar() {
		return carrinho;
	}

	public void remover(int indice) {
		carrinho.remove(indice);
	}

	public static float getValor() {
		float valor = 0;
		for (Item item : carrinho) {
			valor += item.getQuantidade() * item.getProduto().getPreco();
		}

		return valor;
	}

}
