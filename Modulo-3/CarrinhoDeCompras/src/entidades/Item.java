package entidades;

public class Item {

	private Produto produto;
	private float quantidade;

	public Item() {
		super();
	}

	public Item(Produto produto, float quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item [produto=" + produto + ", quantidade=" + quantidade + "]";
	}

}
