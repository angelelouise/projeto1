package br.ufrn.ws.angprojservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufrn.ws.angprojservice.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value= "SELECT * FROM public.usuario u WHERE u.usuario = :usuario LIMIT 1", nativeQuery=true)
	public Usuario findByUser(@Param("usuario") String usuario);
	
	@Query(value= "SELECT * FROM public.usuario u WHERE LOWER(u.nome) = LOWER(:nome)", nativeQuery=true)
	public List<Usuario> findByNome (@Param("nome")String nome);

}
