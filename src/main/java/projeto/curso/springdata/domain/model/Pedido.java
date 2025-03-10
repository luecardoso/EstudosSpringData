package projeto.curso.springdata.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import projeto.curso.springdata.domain.entity.ClienteJPA;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//many to one: muitos pedidos para um cliente
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteJPA cliente;
	
	@Column(name = "data_pedido")
	private LocalDate dataPedido;
	
	//precision: quantidade de digitos
	//scale: quantidade de casas decimais
	@Column(name = "total", precision = 20, scale = 2)
	private BigDecimal total;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;
	
	public Pedido() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteJPA getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJPA cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", dataPedido=" + dataPedido + ", total=" + total + "]";
	}
	
	
}
