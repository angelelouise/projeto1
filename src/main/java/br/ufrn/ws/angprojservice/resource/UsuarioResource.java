package br.ufrn.ws.angprojservice.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.ws.angprojservice.dominio.Usuario;
import br.ufrn.ws.angprojservice.repository.UsuarioRepository;

@RestController//indica que é um controlador Rest 
@RequestMapping("/usuario") //mapeia a uri /tarefa para ser processada por esse controlador
public class UsuarioResource {
	
	@Autowired //Injeção de dependencia
	private UsuarioRepository usuarioRepository;

	@GetMapping //irá processar requisições que utilizam o método GET do HTTP
	//retorna todos os usuários
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	@PostMapping(consumes="application/json",produces="application/json") //adiciona um usuário
	@ResponseStatus(code=HttpStatus.CREATED)
	public Usuario inserir (@Valid @RequestBody Usuario usuario) {//verifica se os dados foram enviados corretamente
		return usuarioRepository.save(usuario);
	}
	@GetMapping("/{idUsuario}")//busca usuario por id
	public Usuario listarId (@PathVariable Long idUsuario) {
		return usuarioRepository.findById(idUsuario).get();
	}
	@GetMapping("list/{usuario}")//busca usuario por user
	public Usuario listarUser (@PathVariable String usuario) {
		return  (Usuario) usuarioRepository.findByUser(usuario);
	}
	@PutMapping//atualizando um usuario existente
	@ResponseStatus(code=HttpStatus.OK)
	public Usuario atualizar (@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	@DeleteMapping //excluindo um usuário
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
}
