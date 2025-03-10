package projeto.curso.springdata.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.curso.springdata.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
