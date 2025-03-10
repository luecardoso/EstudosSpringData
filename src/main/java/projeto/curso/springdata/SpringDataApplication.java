package projeto.curso.springdata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projeto.curso.springdata.domain.entity.ClienteJPA;
import projeto.curso.springdata.domain.model.Cliente;
import projeto.curso.springdata.domain.model.Pedido;
import projeto.curso.springdata.domain.repository.ClienteJDBC;
import projeto.curso.springdata.domain.repository.ClienteJPARepository;
import projeto.curso.springdata.domain.repository.ClienteRepository;
import projeto.curso.springdata.domain.repository.PedidoRepository;
import projeto.curso.springdata.domain.repository.ProdutoRepository;

@SpringBootApplication
public class SpringDataApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteJDBC repository, 
			@Autowired ClienteJPARepository jpaRepository,
			@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository) {
		return args -> {
			// Teste de conexão com o banco de dados e operações CRUD com JDBC
			// utiliza o arquivo data.sql para criar a tabela cliente
//            Cliente cliente = new Cliente();
//            cliente.setNome("Fulano");
//            repository.salvar(cliente);
//            repository.salvar(new Cliente("Ciclano"));
//            System.out.println("Clientes Cadastrados:");
//            repository.obterTodos().forEach(System.out::println);
//            
//            repository.obterPorNome("Fulano").forEach(System.out::println);
//            repository.atualizar(new Cliente(1, "Fulano da Silva"));
//            
//            System.out.println("Clientes Cadastrados:");
//            repository.obterTodos().forEach(System.out::println);
//            
//            System.out.println("Deletando cliente de id 1");
//            repository.deletar(1);
//            
//            System.out.println("Clientes Cadastrados:");
//            repository.obterTodos().forEach(System.out::println);

			// Teste de conexão com o banco de dados e operações CRUD com JPA
			//cria a tabela cliente automaticamente com base na classe ClienteJPA
//			ClienteJPA cliente = new ClienteJPA();
//			cliente.setNome("Beltrano");
//			jpaRepository.salvar(cliente);
//
//			jpaRepository.salvar(new ClienteJPA("Ciclano"));
//			System.out.println("Clientes Cadastrados:");
//			jpaRepository.obterTodos().forEach(System.out::println);
//
//			jpaRepository.obterPorNome("Fulano").forEach(System.out::println);
//			jpaRepository.atualizar(new ClienteJPA(1, "Fulano da Silva"));
//
//			System.out.println("Clientes Cadastrados:");
//			jpaRepository.obterTodos().forEach(System.out::println);
//
//			System.out.println("Deletando cliente de id 1");
//			jpaRepository.deletar(1);
//
//			System.out.println("Clientes Cadastrados:");
//			jpaRepository.obterTodos().forEach(System.out::println);
			
			// Teste de conexão com o banco de dados e operações CRUD com JPA
			// cria a tabela cliente automaticamente com base na classe ClienteJPA
			// utiliza a interface ClienteRepository para realizar as operações	CRUD
			ClienteJPA cliente = new ClienteJPA();
			cliente.setNome("Beltrano");
			clienteRepository.save(cliente);
			
			
			clienteRepository.save(new ClienteJPA("Ciclano"));
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setDataPedido(LocalDate.now());
			pedido.setTotal(new BigDecimal(100));
			
			pedidoRepository.save(pedido);
			System.out.println("Cliente e Produtos:");
//			ClienteJPA beltrano = clienteRepository.findClienteFetchPedidos(cliente.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());
			
			pedidoRepository.findByCliente(cliente).forEach(System.out::println);
			
			
//			clienteRepository.findById(cliente.getId()).ifPresent(System.out::println);
			//clienteRepository.findAll().forEach(System.out::println);

			System.out.println("Buscando Clientes:");
			//clienteRepository.findByNomeLike("Fulano").forEach(System.out::println);
			clienteRepository.encontrarPorNome("Fulano").forEach(System.out::println);
			clienteRepository.save(new ClienteJPA(1, "Fulano da Silva"));

			System.out.println("Clientes Cadastrados:");
			clienteRepository.findAll().forEach(System.out::println);

//			System.out.println("Deletando cliente");
//			clienteRepository.deleteById(cliente.getId());
//			clienteRepository.deleteByNome(cliente.getNome());
//
//			System.out.println("Clientes Cadastrados:");
//			clienteRepository.findAll().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
