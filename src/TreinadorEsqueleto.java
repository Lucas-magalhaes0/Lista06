
public class TreinadorEsqueleto {
	int [] position = new int[3];
	int ladoMapa;//limite lado mapa
	
	public void setPosition (int x, int y, int ladoMapa){ 
		this.position[0] = x;
		this.position[1] = y;
		this.ladoMapa = ladoMapa;
	}
	public void moveUp (){
		if (position[0] > 0 )
			this.position[0]--;
	}
	public void moveDown (){
		if (position[0] < ladoMapa-1 )
			this.position[0]++;
		
	}
	public void moveLeft (){
		if (position[1] > 0)
			this.position[1]--;
	}
	public void moveRight (){
		if (position[1] < ladoMapa-1)
			this.position[1]++;
	}
	
	public int [] getPosition (){
		return position;
	}
}
