
public class Treinador extends TreinadorEsqueleto {
	String nome;	
	
	Pokemon [] pokes = new Pokemon[6];
	int index = 0;
	
	Item [] itens = new Item[100];
	int indexItem = 0;
	
	boolean ehTreinador;
	
	Treinador (String nome, boolean EhTreinador) {
		this.nome = nome;
		ehTreinador = EhTreinador;
	}	
	
	public void addPoke (Pokemon e) {
		if (index <= 6) {
			pokes[index++] = e;			
		}
	}
	
	public int getPokeN(){
		return index-1;
	}
	public boolean estaNoJogo () {
		for (int npoke = 0; npoke < index; npoke++) {
			if (pokes[npoke].isAlive) {
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
	
	/* usa item no pokes[0]
	 * tornei as variaveis privadas em Item, assim so da para acessar valores por metodos */
	public int useItem (int indexItem) {  
		if (itens[indexItem].canUse() == false) return -1;
		
		pokes[1].pVida += itens[indexItem].use();
		itens[indexItem].subtract();
		
		return 1;
	}
	
	public void defineNumItem (int indexItem, int qtd) {
		itens[indexItem].defineNumItens(qtd);
	}
	
	//alterar pokemon principal. Retorna true caso a troca for efetuada com sucesso
	
	
	public void alteraPokePrincipal (int indexPoke) {
		if (pokes[indexPoke].isAlive == true) { //criar metodo para retornar isAlive, quando mudar para private
			int [] vecInt = {};
			Pokemon e = new Pokemon("","", 1, vecInt); //aqui deveria ser static, mas o eclipse nao aceita (?)
			e = pokes[0];
			pokes[0] = pokes[indexPoke];
			pokes[indexPoke] = e;
			
		}
	}
}
