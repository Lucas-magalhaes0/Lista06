
abstract public class TurnoDaBatalha {
	int prioridade;
	protected boolean atacou;
	TurnoDaBatalha(int i, boolean j){
		atacou = j;
		prioridade = i;
	}
	
	abstract public Treinador action(Treinador a, Treinador b);
	abstract public void descricao(Treinador a, Treinador b);
}
