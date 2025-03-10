package projeto.curso.springdata.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// many to one: muitos itens de pedido para um pedido
	// indica que o mapeamento foi feito na classe Pedido
	// com o atributo itens
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	// many to one: muitos itens de pedido para um produto
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	public ItemPedido() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", produto=" + produto + ", quantidade=" + quantidade
				+ "]";
	}
	
	
	
}
