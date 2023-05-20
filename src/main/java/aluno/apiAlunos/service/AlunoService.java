package aluno.apiAlunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import aluno.apiAlunos.model.AlunoModel;
import aluno.apiAlunos.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	public void salvar(AlunoModel aluno) {
		try {
			alunoRepository.saveAndFlush(aluno);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao salvar no banco: " + e.getMessage());
		}
	}
	
	public List<AlunoModel> buscarTodos(){
		try {
		return alunoRepository.findAll();
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao buscar alunos no banco: " + e.getMessage());
		}
	}
	
	public Optional<AlunoModel> buscarPorId(long id){
		try {
			return alunoRepository.findById(id);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao buscar alunos por ID no banco: " + e.getMessage());
		}
		
	}
	
	public void removerPorId(long id) {
		try {
			alunoRepository.deleteById(id);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao remover aluno por ID no banco: " + e.getMessage());
		}
	}
	
	public List<AlunoModel> buscarPorNome(String nome) {
		try {
			return alunoRepository.findByNomeContainingIgnoreCase(nome);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao buscar alunos por Nome no banco: " + e.getMessage());
		}
	}
	
	public List<AlunoModel> buscarPorCurso(String curso) {
		try {
			return alunoRepository.findByCursoContainingIgnoreCase(curso);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao buscar alunos por Curso no banco: " + e.getMessage());
		}
	}
	
	public List<AlunoModel> buscarPorCampus(String campus) {
		try {
			return alunoRepository.findTop10ByCampus(campus);
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao buscar alunos por Campus no banco: " + e.getMessage());
		}
	}
}
