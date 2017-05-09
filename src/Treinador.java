
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
	public boolean alteraPokePrincipal (int indexPoke) {
		
		if (pokes[indexPoke].isAlive == true) { //criar metodo para retornar isAlive, quando mudar para private
			int [] vecInt = {};
			Pokemon e = new Pokemon("","", 1, vecInt); //aqui deveria ser static, mas o eclipse nao aceita (?)
			e = pokes[1];
			pokes[1] = pokes[indexPoke];
			pokes[indexPoke] = e;
			
			return true;
		}
		
		return false;
	}
	
	//imprime dados sobre pokemons
	public void dados () {
		for (int i = 0; i <= 0; i++ ) {
			System.out.println("Indice do Pokemon: " + i);
			pokes[i].dados();
			for (int j = 0; j < (pokes[i].golpes).length; j++) {
				//Banco.indexHabAtk; // ************** como acessar o banco a partir de um metodo? *************
			}
		}
	}
	
	public static void main (String [] args) {
		Treinador ash = new Treinador("Ash");
		Banco bank = new Banco();
		
		int [] a= {0, 1};
		bank.addPoke("Pikachu", "Eletrico", a, 100);
		bank.addHabAtk("Choque do Trovao", 60);
		bank.addHabAtk("Para raios", 0);
		
		ash.addPoke(0);
		
		ash.dados();		
		System.out.println(Banco.nomeHab[0]); // como acessar o banco a partir de um metodo?
		System.out.println(Banco.valAtk[0]);
		System.out.println(Banco.nomeHab[1]); 
		System.out.println(Banco.valAtk[1]);
	}
}
