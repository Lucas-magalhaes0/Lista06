
public class TreinadorEsqueleto {
	int [] position = new int[2];
	public void setPosition (int x, int y){ 
		position[0] = x;
		position[1] = y;
	}
	public void moveUp (){
		if (position[0] > 0 )
			position[0] = position[0]-1;
	}
	public void moveDown (){
		if (position[0] < 19 )
			position[0] = position[0]+1;
	}
	public void moveLeft (){
		if (position[1] > 0)
			position[1] = position[1]-1;
	}
	public void moveRight (){
		if (position[1] < 19)
			position[1] = position[1]+1;
	}
	
	public int [] getPosition (){
		return position;
	}
}
