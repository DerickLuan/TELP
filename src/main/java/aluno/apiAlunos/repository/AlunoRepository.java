package aluno.apiAlunos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluno.apiAlunos.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
	//public List<AlunoModel> findByNome(String nome);
	public List<AlunoModel> findByNomeContainingIgnoreCase(String nome);

	
	//public List<AlunoModel> findByCurso(String curso);
	public List<AlunoModel> findByCursoContainingIgnoreCase(String curso);
	
	public List<AlunoModel> findTop10ByCampus(String campus);
}
