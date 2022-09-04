package com.santiago.AppDisney.security.repository;

import com.santiago.AppDisney.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUserName(String userName);
}
