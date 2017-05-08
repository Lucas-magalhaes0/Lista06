
public class Treinador {
	String nome;	
	
	Pokemon [] pokes = new Pokemon[6];
	int index = 0;
	
	Item [] itens = new Item[100];
	int indexItem = 0;
		
	Treinador (String nome) {
		this.nome = nome;
		
	}	
	
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
	
	
	public int useItem (int indexItem) { //tornei as variaveis privadas em Item, assim so da para acessar valores por metodos 
		if (itens[indexItem].canUse() == false) return -1;
		
		pokes[1].pVida += itens[indexItem].use();
		itens[indexItem].subtract();
		
		return 1;
	}
	
	public void defineNumItem (int indexItem, int qtd) {
		itens[indexItem].defineNumItens(qtd);
	}
	
	//alterar pokemon principal. Retorna true quando a troca foi efetuada
	public boolean alteraPokePrincipal (int indexPoke) {
		
		if (pokes[indexPoke].isAlive == true) { //criar metodo para retornar isAlive, quando mudar para private
			int [] vecInt = {};
			Pokemon e = new Pokemon("","", 1, vecInt);
			e = pokes[1];
			pokes[1] = pokes[indexPoke];
			pokes[indexPoke] = e;
			
			return true;
		}
		
		return false;
	}
}
