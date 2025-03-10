package projeto.curso.springdata.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import projeto.curso.springdata.domain.entity.ClienteJPA;

@Repository
public class ClienteJPARepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public ClienteJPA salvar(ClienteJPA cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	@Transactional
	public ClienteJPA atualizar(ClienteJPA cliente) {
		entityManager.merge(cliente);
		return cliente;
	}

	@Transactional(readOnly = true)
	public List<ClienteJPA> obterTodos() {
		String jpql = "select c from ClienteJPA c";
		return entityManager.createQuery(jpql, ClienteJPA.class).getResultList();
	}

	@Transactional(readOnly = true)
	public ClienteJPA obterPorId(Integer id) {
		ClienteJPA cliente = entityManager.find(ClienteJPA.class, id);
		return cliente;
	}

	@Transactional(readOnly = true)
	public List<ClienteJPA> obterPorNome(String nome) {
		String jpql = "select c from ClienteJPA c where c.nome like :nome";
//		TypedQuery<ClienteJPA> query = entityManager.createQuery(jpql, ClienteJPA.class);
//		query.setParameter("nome", "%"+nome+"%");
//		return query.getResultList();

		return entityManager.createQuery(jpql, ClienteJPA.class).setParameter("nome", "%" + nome + "%").getResultList();
	}

	@Transactional
	public void deletar(Integer id) {
		ClienteJPA cliente = entityManager.find(ClienteJPA.class, id);
		if (!entityManager.contains(cliente)) {
			cliente = entityManager.merge(cliente);
		}
		entityManager.remove(cliente);
	}

}
