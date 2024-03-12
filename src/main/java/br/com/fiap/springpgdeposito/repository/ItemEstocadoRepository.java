package br.com.fiap.springpgdeposito.repository;

import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEstocadoRepository extends JpaRepository<ItemEstocado, Long> {
}
