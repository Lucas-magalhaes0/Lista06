
public class Treinador {
	String nome;	
	
	Pokemon [] pokes = new Pokemon[6];
	int index = 0;
	
	Treinador (String nome) {
		this.nome = nome;
		
	}
	
	Item [] itens = new Item[100];
	int indexItem = 0;
	
	public void addPoke (int indexPokeBanco) {
		if (index <= 6) {
			pokes[index++] = Banco.poke[indexPokeBanco];			
		}
	}
	
	public boolean estaNoJogo () {
		for (Pokemon poke : pokes) {
			if (poke.isAlive) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addItens (int indexItemBanco) {
		if (indexItem < 100) {
			itens[indexItem++] = Banco.itens[indexItemBanco];			
		}
	}
	
	public int useItem (int indexItem) {
		if (itens[indexItem].isUsed == true) return -1;
		
		pokes[1].pVida += itens[indexItem].valCura;
		itens[indexItem].isUsed = true;
		return 1;
	}
}
