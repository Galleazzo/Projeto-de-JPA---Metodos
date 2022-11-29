package controler.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Aluno;

public class alunoBanco {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("academia-estudo");
	EntityManager em = emf.createEntityManager();
	
	
	public void adicionarAluno(Aluno aluno) {
		
		Aluno alunoSalvo = new Aluno();
		
		alunoSalvo.setNome(aluno.getNome());
		alunoSalvo.setCpf(aluno.getCpf());
		alunoSalvo.setEmail(aluno.getEmail());
		alunoSalvo.setDataNasc(aluno.getDataNasc());
		alunoSalvo.setDataMatri(aluno.getDataMatri());
		alunoSalvo.setPlano(aluno.getPlano());
		alunoSalvo.setRg(aluno.getRg());
		
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
	public void buscaAlunoPorId( Integer id) {
		
		Aluno alunoEncontrado = em.find(Aluno.class, id);
		
		System.out.println("Nome: "+alunoEncontrado.getNome()+" 	Email: "+alunoEncontrado.getEmail());
		
		em.close();
		emf.close();
	}
	
	public void verTodosAlunos(){
		
		String jpql = "select a from Aluno a";
		
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		
		List<Aluno> alunos = query.getResultList();
		
		alunos.forEach(alu ->{
			System.out.println(alu.getNome());
		});
		
		em.close();
		emf.close();
	}
	
	public void alterarAluno(Integer id, String nome, String email, String cpf, String dataMatri, String dataNasc, String rg) {
		
		Aluno alu = em.find(Aluno.class, id);
		alu.setNome(nome);
		alu.setEmail(email);
		alu.setCpf(cpf);
		alu.setDataMatri(dataMatri);
		alu.setDataNasc(dataNasc);
		alu.setRg(rg);
		
		if(alu.getId() == id) {
			em.getTransaction().begin();
			
			em.merge(alu);
			
			System.out.println("USUARIO ALTERADO COM SUCESSO!");
			
			em.getTransaction().commit();
		}else {
			System.out.println("NÃO FOI POSSIVEL ENCONTRAR ESSE USUARIO!");
		}
		
		em.close();
		emf.close();
	}
	
	
	public void removerAlunoPorId(Integer id) {
		
		Aluno alunoExcluido = em.find(Aluno.class, id);
		
		
		if(alunoExcluido.getId() == id) {
			em.getTransaction().begin();
		
			em.remove(alunoExcluido);
		
			System.out.println("Aluno excluido");
			
			em.getTransaction().commit();
		}else {
			System.out.println("Não foi possivel encontrar aluno");
		}
		
		
		em.close();
		emf.close();
	}

}
