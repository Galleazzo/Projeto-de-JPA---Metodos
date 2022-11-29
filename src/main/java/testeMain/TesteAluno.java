package testeMain;

import controler.basico.alunoBanco;
import modelo.basico.Aluno;

public class TesteAluno {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		alunoBanco al = new alunoBanco();
		
		aluno.setNome("Daniel Augusto Galleazzo de Lima");
		aluno.setCpf("999999999/99");
		aluno.setEmail("danielgalleazzo@gmail.com");
		aluno.setDataNasc("06/06/2006");
		aluno.setDataMatri("29/05/2022");
		aluno.setPlano("1 Ano");
		aluno.setRg("999999999-9");
		
		//al.adicionarAluno(aluno);
		
		//al.buscaAlunoPorId(1);
		
		//al.verTodosAlunos();
		
		
		//al.alterarAluno(2, "Sandra Regina Galleazzo", "sangalleazzo@gmail.com", "888888888/88", "11/09/2022", "07/02/1974", "888888888-8");
		
		//al.removerAlunoPorId(2);
		
	}

}
