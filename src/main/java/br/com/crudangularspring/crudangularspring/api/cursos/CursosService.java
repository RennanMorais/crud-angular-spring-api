package br.com.crudangularspring.crudangularspring.api.cursos;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.crudangularspring.crudangularspring.api.cursos.dto.CursoRequestDTO;
import br.com.crudangularspring.crudangularspring.api.cursos.dto.CursoResponseDTO;
import br.com.crudangularspring.crudangularspring.api.cursos.entity.CursoEntity;
import br.com.crudangularspring.crudangularspring.api.cursos.repository.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	CursosRepository cursosRepository;

	public List<CursoEntity> listarCursos() {
		List<CursoEntity> cursos = new ArrayList<>();
		cursos = cursosRepository.findAll();
		
		return cursos;
	}
	
	public CursoResponseDTO incluirCurso(CursoRequestDTO request) {
		
		if(request != null && (!request.getCurso().isEmpty() & !request.getCategoria().isEmpty())) {
			CursoEntity curso = new CursoEntity();
			curso.setCurso(request.getCurso());
			curso.setCategoria(request.getCategoria());
			try {
				cursosRepository.save(curso);
			} catch(InvalidParameterException ex) {
				CursoResponseDTO response = new CursoResponseDTO();
				response.setCodigo("400");
				response.setMensagem("Não foi possivel salvar o curso. Tente novamente.");
				return response;
			}
			
			CursoResponseDTO response = new CursoResponseDTO();
			response.setCodigo("200");
			response.setMensagem("Curso incluido com sucesso.");
			
			return response;
		}
		
		CursoResponseDTO response = new CursoResponseDTO();
		response.setCodigo("400");
		response.setMensagem("Não foi possivel salvar o curso. Tente novamente.");
		return response;
	}
	
	public ResponseEntity<CursoEntity> buscarCurso(Long id) {
		Optional<CursoEntity> curso = Optional.empty();
		if(id != null) {
			try {
				curso = cursosRepository.findById(id);
			} catch(InvalidParameterException ex) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(curso.get());
	}
	
}
