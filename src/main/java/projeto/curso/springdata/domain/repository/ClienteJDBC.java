package projeto.curso.springdata.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import projeto.curso.springdata.domain.model.Cliente;

@Repository
public class ClienteJDBC {
	
	private static String INSERT = "insert into cliente (nome) values (?)";
	private static String SELECT_ALL = "select * from cliente";
	private static String SELECT_BY_ID = "select * from cliente where id = ?";
	private static String SELECT_BY_NAME = "select * from cliente where nome = ?";
	private static String UPDATE = "update cliente set nome = ? where id = ?";
	private static String DELETE = "delete from cliente where id = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(	INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public Cliente atualizar(Cliente cliente) {
		jdbcTemplate.update(UPDATE, new Object[] { cliente.getNome(), cliente.getId() });
		return cliente;
	}
	
	public List<Cliente> obterTodos() {
		return jdbcTemplate.query(SELECT_ALL, obterClienteRowMapper());
	}
	
	public Cliente obterPorId(Integer id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[] { id }, obterClienteRowMapper()); 
	}
	
	public List<Cliente> obterPorNome(String nome) {
		return jdbcTemplate.query(SELECT_BY_NAME, new Object[] { nome }, obterClienteRowMapper());
	}
	
	public void deletar(Integer id) {
		jdbcTemplate.update(DELETE, new Object[] { id });
	}
	
	private RowMapper<Cliente> obterClienteRowMapper() {
		return new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				return cliente;
			}
		};
	}
	
}
