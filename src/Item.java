
public class Item {
	String nome;
	int valCura;
	int qtd; //quantidade do tipo de item em questao
	
	Item (String nome, int valCura, int qtd) {
		this.nome = nome;
		this.valCura = valCura;
	}
	
	//funcao de uso. Retorna valCura para adicionar ao hp do pokemon, caso qtd > 0
	public int use() {
		if (qtd > 0) {
			qtd--;
			return valCura;
		}
		return 0;
	}
	
}

/* Variaveis: tornar tudo privado depois */