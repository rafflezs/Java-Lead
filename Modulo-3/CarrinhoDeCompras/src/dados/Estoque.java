package dados;

import java.util.ArrayList;
import java.util.List;

import entidades.Produto;

public class Estoque {

	private static List<Produto> produtos = popular();

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public static List<Produto> listar() {
		return produtos;
	}

	public void remover(int index) {
		produtos.remove(index);
	}
	
	private static List<Produto> popular(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("01", "Arroz", 2.49f));
		produtos.add(new Produto("02", "Maçã", 7.99f));
		produtos.add(new Produto("03", "Tomate", 2.79f));
		produtos.add(new Produto("04", "Cenoura", 2.19f));
		produtos.add(new Produto("05", "Feijão", 3.59f));
		produtos.add(new Produto("06", "Batata", 2.98f));
		produtos.add(new Produto("07", "Cebola", 1.89f));
		
		return produtos;
	}

}
