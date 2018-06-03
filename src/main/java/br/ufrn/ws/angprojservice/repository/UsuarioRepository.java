package br.ufrn.ws.angprojservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufrn.ws.angprojservice.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value= "SELECT * FROM usuario u WHERE u.user = user LIMIT 1", nativeQuery=true)
	public Usuario findByUser(String user);
	
	@Query(value= "SELECT * FROM usuario u WHERE LOWER(u.nome) = LOWER(nome)", nativeQuery=true)
	public List<Usuario> findByNome (String nome);

}
