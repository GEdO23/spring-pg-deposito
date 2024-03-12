package br.com.fiap.springpgdeposito.repository;

import br.com.fiap.springpgdeposito.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
