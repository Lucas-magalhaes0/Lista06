import java.util.Random;
public class Pokemon {
	final Banco bank = new Banco ();
	String nome;
	String tipo;
    int pVida;
	int pVidaMax; /* parece ser necessario adicionar essa variavel, pois caso use itens de cura, 
				   * existe um limite que pode ser recuperado */
	int pAtaque;
	int pDefesa;
	int pVelocidade;
	int [] golpes; // indice das hab/dano
	boolean isAlive = true;
	
	
	Pokemon (String nome, String tipo, int pVida, int [] golpes){
		this.nome = nome;
		this.tipo = tipo;
		this.pVida = pVida;
		this.pVidaMax = pVida; // na declaracao do pokemon, o pVida acaba sendo o pVidaMax
		if(golpes.length <= 4)
		this.golpes = golpes;
	}
	
	public int comparaTipos(Pokemon x) {
		if(this.isAlive == false)
			return -1;
			String[] tipos = {"Pedra","Papel","Tesoura"};
			if(this.tipo.compareTo(tipos[0]) == 0 && x.tipo.compareTo(tipos[2]) == 0)
				return 1;
			if(this.tipo.compareTo(tipos[1]) == 0 && x.tipo.compareTo(tipos[0]) == 0)
				return 1;
			if(this.tipo.compareTo(tipos[2]) == 0 && x.tipo.compareTo(tipos[1]) == 0)
				return 1;
			if(this.tipo.compareTo(tipos[0]) == 0 && x.tipo.compareTo(tipos[1]) == 0)
				return -1;
			if(this.tipo.compareTo(tipos[1]) == 0 && x.tipo.compareTo(tipos[2]) == 0)
				return -1;
			if(this.tipo.compareTo(tipos[2]) == 0 && x.tipo.compareTo(tipos[0]) == 0)
				return -1;
			else return 0;
	}
	//imprime dados sobre pokemons
	public static void dados () {
				
		System.out.println(Banco.nomeHab[0]); // como acessar o banco a partir de um metodo?
		System.out.println(Banco.valAtk[0]);
		System.out.println(Banco.nomeHab[1]); 
		System.out.println(Banco.valAtk[1]);
		
	}
	
	public static void main (String [] args) {
		EventBattle gc = new EventBattle();
		Treinador Ash = new Treinador("Ash",true);
		int v[] = {1, 2, 3};
		Pokemon [] poke =
			{
					new Pokemon("Pikachu","Pedra",100,v),
					new Pokemon("Pikachu","Pedra",100,v),
					new Pokemon("Pipilupi","Tesoura",150,v),
					new Pokemon("Pipilupi","Tesoura",150,v)
					
					
			};
		MapaPokemon map = new MapaPokemon();
		map.setMap();
		Ash.setPosition(10, 10);
		Ash.addPoke(poke[0]);
		Ash.addItens(0);
		Ash.addPoke(poke[2]);
		Random RandomGenerator = new Random();
		while(Ash.estaNoJogo()){
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			int randomMove = RandomGenerator.nextInt(4);
			switch(randomMove){
				case(0) : Ash.moveUp();
				case(1) : Ash.moveDown();
				case(2) : Ash.moveRight();
				case(3) : Ash.moveLeft();
			}
			map.printMap(Ash.getPosition());
			int randomPokemonSelvagemAparece = RandomGenerator.nextInt(100);
			if(randomPokemonSelvagemAparece < 70)
				continue;
			int randomPokes = RandomGenerator.nextInt(Banco.pokes.length);
			Treinador PokemonSelvagem = new Treinador("",false);
			PokemonSelvagem.addPoke(Banco.pokes[randomPokes]);
			gc.run(Ash, PokemonSelvagem);
			
			
			/*recupera o hp do pokemon que morreu, para nao ficar nula no banco*/
			PokemonSelvagem.pokes[0].isAlive = true;
			PokemonSelvagem.pokes[0].pVida = PokemonSelvagem.pokes[0].pVidaMax;
		}
	}
}

