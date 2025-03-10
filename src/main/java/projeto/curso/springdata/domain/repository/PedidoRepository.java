package projeto.curso.springdata.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.curso.springdata.domain.model.Pedido;
import projeto.curso.springdata.domain.entity.ClienteJPA;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByCliente(ClienteJPA cliente);
}
