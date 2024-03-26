package br.com.fiap.springpgdeposito.repository;

import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import br.com.fiap.springpgdeposito.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEstocadoRepository extends JpaRepository<ItemEstocado, Long> {
    List<ItemEstocado> findByProdutoAndDepositoAndSaidaIsNull(Produto produto, Deposito deposito);
}
