package br.edu.ifsc.fln.model.dao.ordenservicos;

import br.edu.ifsc.fln.model.domain.ordemServicos.Servico;
import br.edu.ifsc.fln.model.domain.ECategoria;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe DAO para gerenciar as operações no banco de dados relacionadas à entidade Servico.
 * @Attribute connection é um objeto do tipo Connection
 *
 * @author  Carlos
 * @version 1.2
 * @since   30/11/2024
 */
public class ServicoDAO {

    private Connection connection;

    public ServicoDAO(Connection connection) {
        this.connection = connection;
    }
    // Getters e Setters
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Adicionar um novo serviço
    public boolean inserir(Servico servico){
        String sql = "INSERT INTO Servicos (descricao, valor, categoria, pontos) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setBigDecimal(2, servico.getValor());
            stmt.setString(3, servico.getCategoria().name());
            stmt.setInt(4, servico.getPontos());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Atualizar um serviço existente
    public boolean alterar(Servico servico){
        String sql = "UPDATE Servicos SET descricao = ?, valor = ?, categoria = ?, pontos = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setBigDecimal(2, servico.getValor());
            stmt.setString(3, servico.getCategoria().name());
            stmt.setInt(4, servico.getPontos());
            stmt.setInt(5, servico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Remover um serviço pelo ID
    public boolean remover(Servico servico) {
        String sql = "DELETE FROM Servicos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Buscar um serviço pelo ID
    public Servico buscarPorId(int id){
        String sql = "SELECT * FROM Servicos WHERE id = ?";
        Servico retorno = new Servico();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return criarServico(rs);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Buscar um serviço pelo ID
    public Servico buscar(Servico servico) {
        String sql = "SELECT * FROM Servicos WHERE id = ?";
        Servico retorno = new Servico();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servico.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarServico(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Listar todos os serviços
    public List<Servico> listar() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM Servicos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                servicos.add(criarServico(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicos;
    }

    // Método auxiliar para criar um objeto Servico a partir do ResultSet
    private Servico criarServico(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String descricao = rs.getString("descricao");
        BigDecimal valor = rs.getBigDecimal("valor");
        ECategoria categoria = ECategoria.valueOf(rs.getString("categoria"));
        int pontos = rs.getInt("pontos");

        return new Servico(id, descricao, valor, pontos, categoria);
    }
}

