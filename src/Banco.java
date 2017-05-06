
public class Banco {
	//hab e dano
	static String [] nomeHab = new String[100];
	static int [] valAtk = new int[100];
	static int indexHabAtk = 0;
	
	//pokemons
	static Pokemon [] poke = new Pokemon[100];
	static int indexPoke = 0;
	
	//itens
	static Item [] itens = new Item[100];
	static int indexItem = 0;
	
	
	public void addHabAtk (String nome, int valAtk) {
		if (indexHabAtk > 100) return;
		
		Banco.nomeHab[indexHabAtk] = nome;
		Banco.valAtk[indexHabAtk] = valAtk;
		indexHabAtk++;
		
	}
	
	public void addPoke (String nome, String tipo, int [] HabAtk, int pVida) {
		if (indexPoke > 100) return;
		
		Pokemon e = new Pokemon(nome, tipo, pVida, HabAtk);
		
		Banco.poke[indexPoke++] = e;
	}
	
	public void addItens (String nomeItem, int valCura) {
		if (indexItem > 100) return;
		
		Item e = new Item(nomeItem, valCura);
		
		Banco.itens[indexItem++] = e;
	}
	
}
