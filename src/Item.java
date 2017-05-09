
public class Item {
	private String nome;
	private int valCura;
	private int qtd; //quantidade do tipo de item em questao
	
	Item (String nome, int valCura) {
		this.nome = nome;
		this.valCura = valCura;
	}
	
	//funcao de uso. Retorna valCura para adicionar ao hp do pokemon, caso qtd > 0
	public int use() {
		if (this.qtd > 0) {
			return valCura;
		}
		return 0;
	}
	
	public void defineNumItens (int qtd) { // serve para definir o numero de itens, a partir de um obj treinador
		if (qtd > 0 && qtd < 100) { //maximo de 99 itens por tipo
			this.qtd = qtd;
		}
		else {
			this.qtd = 0;
		}
	}
	
	// indica se eh possivel usar o item em questao (se ha pelo menos 1)
	public boolean canUse () {
		if (this.qtd > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void add () { // adicionar 1 unidade
		this.qtd++;
	}
	
	public void subtract () { // subtrair 1 unidade
		if (this.qtd > 0) {
			this.qtd--;
		}
	}	
	
	public void dados () {
		System.out.println("Item: " + nome);
		System.out.println("Recupera :" + valCura + " PV");
	}
}

