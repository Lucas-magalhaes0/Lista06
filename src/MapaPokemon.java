import java.util.Random;

public class MapaPokemon {
	
	public int[][] setMap(){
		int[][] Map = new int[20][20];
		Random randomGenerator = new Random();
		
		
		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				int random = randomGenerator.nextInt(1);
				Map[i][j] = random;
				
			}
		}
		return Map;
	}
	public void printMap(int[] playerPosition){
		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				if(i == playerPosition[0] && j == playerPosition[1])
					System.out.print(" P ");
				else
					System.out.print(" * ");
			}
			System.out.println("");
		}
	}
	
	
	
}
