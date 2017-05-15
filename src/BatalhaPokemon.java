/* Disciplina MAC0321 - 2017
 * Escola Politecnica - USP
 * 
 * Lucas Magalhaes Cordeiro
 * Rafael Cabral Pili
 * 
 */
public class BatalhaPokemon extends EventBattle {
	 class Atacar extends TurnoDaBatalha{
		int ataqueIndice;
		Atacar(int i){
			super(Banco.atkPrioridade[i],true,false);
			ataqueIndice = i;
		}
		public Treinador action(Treinador a, Treinador b){
			b.pokes[0].pVida -= Banco.valAtk[ataqueIndice];
			if(b.pokes[0].pVida <= 0) {
				b.pokes[0].pVida = 0;
				b.pokes[0].isAlive = false;
			}
			return b;
		}
		public void descricao(Treinador a, Treinador b){
			if(a.ehTreinador == true && b.ehTreinador == true)
				System.out.println("O "+ a.pokes[0].nome +" do "+ a.nome + " usou o golpe "+ Banco.nomeHab[ataqueIndice] + " no "+b.pokes[0].nome+ " do "+ b.nome);
			else if (a.ehTreinador == true && b.ehTreinador == false) 
				System.out.println("O "+ a.pokes[0].nome +" do "+ a.nome + " usou o golpe "+ Banco.nomeHab[ataqueIndice] + " no "+b.pokes[0].nome);
				else 
					System.out.println("O "+ a.pokes[0].nome + " usou o golpe "+ Banco.nomeHab[ataqueIndice] + " no "+b.pokes[0].nome + " do " + b.nome );
		}
	}
	 class UsarItem extends TurnoDaBatalha{
		UsarItem(){
			super(3,false,false);
		}
		public Treinador action(Treinador a, Treinador b){
			a.useItem(0, 0);
			return a;
		}
		public void descricao(Treinador a, Treinador b){
			if(a.ehTreinador)
				System.out.println("O treinador "+a.nome + " curou seu pokemon!");
			else
				System.out.println("O pokemon "+a.pokes[0].nome+" se curou");
		}
	}
	 class TrocarPokemon extends TurnoDaBatalha{
		 int index;
		 TrocarPokemon(int i){
			 super(3,false,false);
			 index = i;
		 }
		 public Treinador action(Treinador a, Treinador b) {
			 a.alteraPokePrincipal(index);
			 return a;
		 }
		 public void descricao(Treinador a, Treinador b){
			 System.out.println("O treinador "+a.nome+" trocou o seu pokemon "+ a.pokes[index] + " pelo pokemon " +a.pokes[0].nome);
		 }
	 }
	 
	//metodo fugir. Caso necessario, alterar retorno como treinador
	 class FugirDaBatalha extends TurnoDaBatalha {	
		FugirDaBatalha(){
			super(4,false,true); //maxima prioridade
		}
		
		public Treinador action (Treinador a, Treinador b){
			descricao(a, b);
			
			return a;
		}
		
		public void descricao (Treinador a, Treinador b){
			if (a.ehTreinador)
				System.out.println("O treinador " + a.nome + " fugiu da batalha");
			else
				System.out.println("O Pokemon selvagem " + a.pokes[0].nome + " fugiu da batalha");
		}
	 }
}
