package br.com.fiap.springpgdeposito.repository;

import br.com.fiap.springpgdeposito.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
