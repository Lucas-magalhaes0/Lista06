/* Disciplina MAC0321 - 2017
 * Escola Politecnica - USP
 * 
 * Lucas Magalhaes Cordeiro
 * Rafael Cabral Pili
 * 
 */
abstract public class TurnoDaBatalha {
	int prioridade;
	protected boolean atacou;
	protected boolean fugiu;
	TurnoDaBatalha(int i, boolean j, boolean k){
		fugiu = k;
		atacou = j;
		prioridade = i;
	}
	
	abstract public Treinador action(Treinador a, Treinador b);
	abstract public void descricao(Treinador a, Treinador b);
}
