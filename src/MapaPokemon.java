import java.util.Random;

public class MapaPokemon {
	int [][] mapa;
	int ladoMapa;
	public void setMap(int ladoMapa){
		this.mapa = new int[ladoMapa][ladoMapa];
		Random randomGenerator = new Random();
		this.ladoMapa = ladoMapa;
		
		for(int i=0; i<ladoMapa; i++){
			for(int j=0; j<ladoMapa; j++){
				int random = randomGenerator.nextInt(2);
				this.mapa[i][j] = random;
			}
		}
	}
	
	public void printMap(int[] playerPosition, Treinador[] players){
		System.out.print(" ");
		for(int bordaSup = 0; bordaSup < ladoMapa; bordaSup++)
			System.out.print("___");
		System.out.println("");
		
		for(int i=0; i<ladoMapa; i++){
			System.out.print("|");
			
			for(int j=0; j<ladoMapa; j++){
				int q=0;
				
				if(i == playerPosition[0] && j == playerPosition[1]){
					System.out.print("Ash");
					continue;
				}
				for (int k=0; k<6;k++){
					if (i == (players[k]).position[0] && j == (players[k]).position[1] && players[k].estaNoJogo()) {
						System.out.print(" P ");
						q=k;
						break;
					}
				}
				if (i == (players[q]).position[0] && j == (players[q]).position[1] && players[q].estaNoJogo())
					continue;
	
				else if (mapa[i][j] == 1)
						System.out.print(" * ");
					else
						System.out.print("   ");
			}
			System.out.println("|");
		}
		
		System.out.print("|");
		for(int bordaInf = 0; bordaInf < 20; bordaInf++)
			System.out.print("___");
		System.out.println("|");
	}
	
	
	
}
