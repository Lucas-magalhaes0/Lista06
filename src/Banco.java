/* Disciplina MAC0321 - 2017
 * Escola Politecnica - USP
 * 
 * Lucas Magalhaes Cordeiro
 * Rafael Cabral Pili
 * 
 */

final class Banco {
	
	//hab e dano
	static final String [] nomeHab = {"Tapa", "Soco", "Abraco", "Beijo", "Abraco da Paz", "Beijo apaixonado", "Tapa maligno", "Soco do Ali", "Saudacao do Spock"};
	static final  String[] tipoHab = {"Pedra", "Papel", "Tesoura","Pedra", "Papel", "Tesoura","Pedra", "Papel", "Tesoura"};
	static final int[]	atkPrioridade = {1, 2, 2, 1, 2, 2, 1, 2, 2};
	static final int [] valAtk = {60, 40, 50, 75, 0, 80, 100, 120, 35};
	static  int indexHabAtk = 0;
	
	//pokemons
	static final String[] nomePoke = {"Glaucius","Chuchu", "Bilbu", "Morty", "Pipilup", "Rawor", "Rex", "Yugi", "Charlemander"};
	static int indexPoke = 0;
	static int v1 [] = {1,2,3,4};
	static int v2 [] = {1,7,5,4};
	static int v3 [] = {0,3,5,2};
	static int v4 [] = {1,2,3,7};
	static int v5 [] = {1,6,2,8};
	static int v6 [] = {1,2,4,6};
	static int v7 [] = {5,2,4,6};
	static int v8 [] = {7,8,4,6};
	
	final static Pokemon [] pokes = {
			new Pokemon (nomePoke[0], tipoHab[0], 130, v1 ),
			new Pokemon (nomePoke[1], tipoHab[2], 160, v2 ),
			new Pokemon (nomePoke[2], tipoHab[0], 180, v3 ),
			new Pokemon (nomePoke[3], tipoHab[1], 100, v4 ),
			new Pokemon (nomePoke[4], tipoHab[2], 90, v5 ),
			new Pokemon (nomePoke[5], tipoHab[2], 140, v6 ),
			new Pokemon (nomePoke[6], tipoHab[1], 170, v7 ),
			new Pokemon (nomePoke[7], tipoHab[0], 150, v8 )	
	};
	
	
	//itens
	static final Item [] itens = {
			new Item("Pocao",25)
	};
	static int indexItem = 0;
	
	
	public static void addHabAtk (String nome, int valAtk, String tipo, int prioridade) {
		if (indexHabAtk > 100) return;
		Banco.atkPrioridade[indexHabAtk] = prioridade;
		//Banco.nomeHab[indexHabAtk] = nome;
		Banco.tipoHab[indexHabAtk] = tipo;
		Banco.valAtk[indexHabAtk++] = valAtk;	
		
	} //
	
	public void addItens (String nomeItem, int valCura) {
		if (indexItem > 100) return;
		
		Item e = new Item(nomeItem, valCura);
		
		Banco.itens[indexItem++] = e;
	}
	
	public static void  main (String [] args) {
		
	}
	
}
