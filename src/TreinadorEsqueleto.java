
public class TreinadorEsqueleto {
	int [] position = new int[2];
	int ladoMapa;//limite lado mapa
	
	public void setPosition (int x, int y, int ladoMapa){ 
		this.position[0] = x;
		this.position[1] = y;
		this.ladoMapa = ladoMapa;
	}
	public void moveUp (){
		if (position[0] > 0 )
			position[0] = position[0]-1;
	}
	public void moveDown (){
		if (position[0] < ladoMapa )
			position[0] = position[0]+1;
	}
	public void moveLeft (){
		if (position[1] > 0)
			position[1] = position[1]-1;
	}
	public void moveRight (){
		if (position[1] < ladoMapa)
			position[1] = position[1]+1;
	}
	
	public int [] getPosition (){
		return position;
	}
}
