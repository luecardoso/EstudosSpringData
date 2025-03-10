package projeto.curso.springdata.domain.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import projeto.curso.springdata.domain.model.Pedido;

@Entity
@Table(name = "cliente")
public class ClienteJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;

	// one to many: um cliente para muitos pedidos
	// mappedBy: indica que o mapeamento foi feito na classe Pedido
	// com o atributo cliente 
	// fetch: indica que a coleção de pedidos será carregada somente
	// quando for acessada
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Pedido> pedidos;
	
	public ClienteJPA() {
	}

	public ClienteJPA(String nome) {
		this.nome = nome;
	}

	public ClienteJPA(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}
}
