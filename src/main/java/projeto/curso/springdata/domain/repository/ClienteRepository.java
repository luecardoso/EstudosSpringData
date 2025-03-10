package projeto.curso.springdata.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.curso.springdata.domain.entity.ClienteJPA;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteJPA, Integer> {

//	List<ClienteJPA> findByNomeLike(String nome);
//	
//	List<ClienteJPA> findByNomeOrIdOrderById(String nome, Integer id);
	
	@Query("SELECT c FROM ClienteJPA c WHERE c.nome LIKE :nome")
	List<ClienteJPA> encontrarPorNome(@Param("nome") String nome);
	
//	@Query(value = "SELECT * FROM cliente c WHERE c.nome LIKE '%:nome'", nativeQuery = true)
//	List<ClienteJPA> encontrarNome(@Param("nome") String nome);
	
	@Query(value = "SELECT * FROM cliente c WHERE c.nome LIKE '%:nome'", nativeQuery = true)
	@Modifying // obrigatório para operações de atualização e exclusão
	void deleteByNome(@Param("nome") String nome);
	
	boolean existsByNome(String nome);
	
	// retorna o cliente e os pedidos associados a ele
	// o fetch é usado para carregar a coleção de pedidos
	@Query("SELECT c FROM ClienteJPA c LEFT JOIN FETCH c.pedidos WHERE c.id = :id")
	ClienteJPA findClienteFetchPedidos(@Param("id") Integer id);
	
	
}
