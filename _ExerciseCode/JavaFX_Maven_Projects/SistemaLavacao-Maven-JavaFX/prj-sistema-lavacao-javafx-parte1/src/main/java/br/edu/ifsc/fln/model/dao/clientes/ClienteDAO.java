package br.edu.ifsc.fln.model.dao.clientes;

import br.edu.ifsc.fln.model.dao.veiculos.CorDAO;
import br.edu.ifsc.fln.model.dao.veiculos.ModeloDAO;
import br.edu.ifsc.fln.model.domain.clientes.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe ClienteDAO para manipulação de dados da tabela Cliente no banco de dados.
 *
 * @author
 * @version 1.0
 * @since 27/11/2024
 */
public class ClienteDAO {

    private final Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um cliente no banco de dados
    public Cliente inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            if (stmt.executeUpdate() > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) { //retorna um objeto ResultSet contendo as chaves primárias geradas durante a última execução de um INSERT
                    if (rs.next()) {
                        cliente.setId(rs.getInt(1));
                        return cliente; // Retorna o cliente com o ID atualizado
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Método para atualizar um cliente existente no banco de dados
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para excluir um cliente do banco de dados
    public boolean remover(Cliente cliente){
        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar um cliente por ID
    public Cliente buscar(Cliente cliente) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente retorno = new Cliente();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Método para buscar um cliente por ID
    public Cliente buscarPorId(int id){
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente retorno = new Cliente();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Método para listar todos os clientes
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> retorno = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"));
                retorno.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}

