
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
	public void useItem (int indexPoke, int indexItem) {  
		pokes[indexPoke].pVida += itens[indexItem].use();
		
		if(pokes[indexPoke].pVida > pokes[indexPoke].pVidaMax)
			pokes[indexPoke].pVida = pokes[indexPoke].pVidaMax;
	}
	
		
	//alterar pokemon principal
	public void alteraPokePrincipal (int indexPoke) {
		if (pokes[indexPoke].isAlive == true) { //criar metodo para retornar isAlive, quando mudar para private
			int [] vecInt = {};
			Pokemon e = new Pokemon("","", 1, vecInt);
			e = pokes[0];
			pokes[0] = pokes[indexPoke];
			pokes[indexPoke] = e;
			
		}
	}
	
	public int numPokesVivos () {
		int numAlive = 0;
		
		for (int i = 0; i < index; i++){
			if (pokes[i].isAlive){
				numAlive++;
			}
		}
		return numAlive;
	}
}
