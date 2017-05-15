/* Disciplina MAC0321 - 2017
 * Escola Politecnica - USP
 * 
 * Lucas Magalhaes Cordeiro
 * Rafael Cabral Pili
 * 
 */
public class Item {
	private String nome;
	private int valCura;
	//private int qtd; //quantidade do tipo de item em questao
	
	Item (String nome, int valCura) {
		this.nome = nome;
		this.valCura = valCura;
	}
	
	//funcao de uso. Retorna valCura para adicionar ao hp do pokemon, caso qtd > 0
	public int use() {
		return valCura;
	}
	
	
	public void dados () {
		System.out.println("Item: " + nome);
		System.out.println("Recupera :" + valCura + " PV");
	}
}

