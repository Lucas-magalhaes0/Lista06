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
	
	public static Treinador tentaCurarPokeDoTreinador (Treinador a) {
		Random RandomGenerator = new Random();
		int chanceCura = RandomGenerator.nextInt(100);
		
		if (chanceCura < 70) { //chance de cura de 70%
			for (int i = 0; i < a.getPokeN(); i++)
				if (a.pokes[i].isAlive && a.pokes[i].pVida < 50){
					a.useItem(i, 0);
					System.out.println("O treinador " + a.nome + " curou o seu pokemon " + a.pokes[i].nome);
				}
		}
		
		return a;
	}
	
	public static void main (String [] args) {
		EventBattle gc = new EventBattle();
		Treinador Ash = new Treinador("Ash",true);
		int v[] = {1, 2, 3};
		int v1 [] = {1,2,3,4};
		int v2 [] = {1,7,5,4};
		int v3 [] = {0,3,5,2};
		int v4 [] = {1,2,3,7};
		int v5 [] = {1,6,2,8};
		int v6 [] = {1,2,4,6};
		int v7 [] = {5,2,4,6};
		int v8 [] = {7,8,4,6};
		Pokemon [] poke =
			{
					new Pokemon("Pikachu","Pedra",100,v),
					new Pokemon("Pipilupi","Tesoura",150,v),
					new Pokemon ("Pernilongo", "Papel", 130, v1 ),
					new Pokemon ("Rato", "Pedra", 130, v2 ),
					new Pokemon ("Sapo voador", "Papel", 140, v3 ),
					new Pokemon ("Minhoca alada", "Tesoura", 100, v4 ),
					new Pokemon ("Cerbezourus", "Papel", 90, v5 ),
					new Pokemon ("Serpente vulcanica", "Pedra", 140, v6 ),
					new Pokemon ("Pombo", "Tesoura", 170, v7 ),
					new Pokemon ("Peixe cachorro", "Pedra", 150, v8 ),
					new Pokemon ("Rato", "Pedra", 130, v2 ),
					new Pokemon ("Sapo voador", "Papel", 130, v3 ),
					new Pokemon ("Minhoca alada", "Tesoura", 100, v4 ),
					new Pokemon ("Cerbezourus", "Papel", 90, v5 )	
			};
		
		MapaPokemon map = new MapaPokemon();
		int ladoMapa = 12;//define 12 como sendo o lado do mapa
		
		map.setMap(ladoMapa); 
		Ash.setPosition(6, 6, ladoMapa); //x,y, lado maximo do mapa
		Ash.addPoke(poke[0]);
		Ash.addPoke(poke[1]);
		Ash.addPoke(poke[6]);
		Ash.addPoke(poke[3]);
		Ash.addItens(0);
		Random RandomGenerator = new Random();
		
		/*gerador de players aleatorios no mapa*/
		Treinador [] players = {
				new Treinador("Trash",true),
				new Treinador("Joseph",true),
				new Treinador("Michael",true),
				new Treinador("Lila",true),
				new Treinador("Mew",true),
				new Treinador("Isild",true),
		};
		
		for (int i=0; i<6; i++){
			int j = 2;
			players[i].addPoke(poke[j]);
			players[i].addPoke(poke[j+1]);
			players[i].addItens(0);
			j+=2;
		}
		
		players[0].setPosition(1, 2, ladoMapa);
		players[1].setPosition(8, 5, ladoMapa);
		players[2].setPosition(6, 4, ladoMapa);
		players[3].setPosition(3, 6, ladoMapa);
		players[4].setPosition(7, 7, ladoMapa);
		players[5].setPosition(9, 1, ladoMapa);
			
		
		while(Ash.estaNoJogo()){
			try {
			    Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			
			//gera movimento aleatorio
			int randomMove = RandomGenerator.nextInt(4);
			switch(randomMove){
				case(0) : Ash.moveUp(); break;
				case(1) : Ash.moveDown(); break;
				case(2) : Ash.moveRight(); break;
				case(3) : Ash.moveLeft(); break;
			}
			
			map.printMap(Ash.getPosition(), players);
			
			//checa possiveis batalhas contra outros players
			for (int k=0; k<6; k++){
				if (Ash.position[0] == players[k].position[0] && Ash.position[1] == players[k].position[1] && players[k].estaNoJogo())
					gc.run(Ash, players[k]);
			}
			
			
			/*checa a probabilidade de aparecer um pokemon no mapa*/
			int randomPokemonSelvagemAparece = RandomGenerator.nextInt(100);
			int [] vec = Ash.getPosition();
			if(map.mapa[vec[0]][vec[1]] == 0) {
				Ash = tentaCurarPokeDoTreinador(Ash);// 0 eh equivalente a nao-grama. Entao nao ha probabilidade de aparecer pokemon
				continue;
			}
			if (randomPokemonSelvagemAparece < 50) {
				Ash = tentaCurarPokeDoTreinador(Ash);//50% de chance de aparecer um pokemon selvagem caso o mapa contenha o valor 1
				continue;
			}
			
			/*gera um pokemon aleatorio para aparecer no mapa e inicia a batalha*/
			
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

