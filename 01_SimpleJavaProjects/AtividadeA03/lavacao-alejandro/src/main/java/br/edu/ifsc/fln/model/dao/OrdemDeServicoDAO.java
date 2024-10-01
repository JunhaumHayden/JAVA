package br.edu.ifsc.fln.model.dao;

import br.edu.ifsc.fln.model.domain.OrdemDeServico;
import br.edu.ifsc.fln.model.domain.Cliente;
import br.edu.ifsc.fln.model.domain.EStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    private Connection connection;

    public OrdemDeServicoDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void inserir(OrdemDeServico ordemDeServico) throws SQLException {
        String sql = "INSERT INTO ordem_servico (numero, total, agenda, desconto, status, id_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, ordemDeServico.getNumero());
            stmt.setDouble(2, ordemDeServico.getTotal());
            stmt.setDate(3, new java.sql.Date(ordemDeServico.getAgenda().getTime())); 
            stmt.setDouble(4, ordemDeServico.getDesconto());
            stmt.setString(5, ordemDeServico.getStatus().name());
            stmt.setLong(6, ordemDeServico.getCliente().getId()); 
        }
    }

   
    public void alterar(OrdemDeServico ordemDeServico) throws SQLException {
        String sql = "UPDATE ordem_servico SET total = ?, agenda = ?, desconto = ?, status = ?, id_cliente = ? WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, ordemDeServico.getTotal());
            stmt.setDate(2, new java.sql.Date(ordemDeServico.getAgenda().getTime()));
            stmt.setDouble(3, ordemDeServico.getDesconto());
            stmt.setString(4, ordemDeServico.getStatus().name());
            stmt.setLong(5, ordemDeServico.getCliente().getId());
            stmt.setLong(6, ordemDeServico.getNumero());
            stmt.executeUpdate();
        }
    }

    
    public void remover(long numero) throws SQLException {
        String sql = "DELETE FROM ordem_servico WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, numero);
            stmt.executeUpdate();
        }
    }

   
    public List<OrdemDeServico> listar() throws SQLException {
        String sql = "SELECT * FROM ordem_servico";
        List<OrdemDeServico> ordens = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ordens.add(mapToOrdemDeServico(rs));
            }
        }
        return ordens;
    }

   
    public OrdemDeServico buscar(long numero) throws SQLException {
        String sql = "SELECT * FROM ordem_servico WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToOrdemDeServico(rs);
                }
            }
        }
        return null;
    }

  
    private OrdemDeServico mapToOrdemDeServico(ResultSet rs) throws SQLException {
        OrdemDeServico ordem = new OrdemDeServico(
            rs.getLong("numero"),
            rs.getDouble("desconto"),
            EStatus.valueOf(rs.getString("status"))
        );
        ordem.setTotal(rs.getDouble("total"));
        ordem.setAgenda(rs.getDate("agenda")); 
        
   
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.setConnection(connection);
        Cliente cliente = clienteDAO.buscarPorId(rs.getLong("id_cliente"));
        ordem.setCliente(cliente);

        return ordem;
    }
}