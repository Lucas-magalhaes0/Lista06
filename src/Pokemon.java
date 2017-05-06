
public class Pokemon {
	String nome;
	String tipo;
	int pVida;
	int [] Golpes; // indice das hab/dano
	boolean isAlive = true;
	
	Pokemon (String nome, String tipo, int pVida, int [] Golpes){
		this.nome = nome;
		this.tipo = tipo;
		this.pVida = pVida;
		this.Golpes = Golpes;
	}
}
