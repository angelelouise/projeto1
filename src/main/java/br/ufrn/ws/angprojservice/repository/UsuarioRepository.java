package br.ufrn.ws.angprojservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.ws.angprojservice.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
