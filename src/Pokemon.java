
public class Pokemon {
	String nome;
	String tipo;
	int pVida;
	int pVidaMax; /* parece ser necessario adicionar essa variavel, pois caso use itens de cura, 
				   * existe um limite que pode ser recuperado */
	
	int [] Golpes; // indice das hab/dano
	boolean isAlive = true;
	
	
	Pokemon (String nome, String tipo, int pVida, int [] Golpes){
		this.nome = nome;
		this.tipo = tipo;
		this.pVida = pVida;
		this.pVidaMax = pVida; // na declaracao do pokemon, o pVida acaba sendo o pVidaMax
		this.Golpes = Golpes;
	}
	
	//
	public boolean useItem (Item i) {
		if ((isAlive == true) && (i.canUse() == true)) {
			pVida = i.use();
			if (pVida > pVidaMax) {
				pVida = pVidaMax; // corrige, caso o item recupere mais do que a vida maxima do Pokemon
			}
			return true;
		}
		return false;
	}
}
