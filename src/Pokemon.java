
public class Pokemon {
	String nome;
	String tipo;
	int pVida;
	int pVidaMax; /* parece ser necessario adicionar essa variavel, pois caso use itens de cura, 
				   * existe um limite que pode ser recuperado */
	
	int [] golpes; // indice das hab/dano
	boolean isAlive = true;
	
	
	Pokemon (String nome, String tipo, int pVida, int [] golpes){
		this.nome = nome;
		this.tipo = tipo;
		this.pVida = pVida;
		this.pVidaMax = pVida; // na declaracao do pokemon, o pVida acaba sendo o pVidaMax
		this.golpes = golpes;
	}
	
	//imprime dados sobre pokemons
	public void dados () {
		
		System.out.println("Nome: " + nome);
		System.out.println("Tipo: " + tipo);
		System.out.println("PV: " + pVida + "\n");
		
	}
}
