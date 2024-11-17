package br.edu.ifsc.fln.model.dao;

import br.edu.ifsc.fln.model.domain.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

    /**
     * Classe responsável por interagir com o banco de dados, ele vai realizar as operações de inserção, consulta, atualização e remoção (CRUD) dos dados no banco de dados. 
     * Possui um atributo que é um objeto do tipo Connection que usa o padrão Factory para obter a conexão com o banco de dados permitindo que a implementação de diferentes bancos de dados (como MySQL, PostgreSQL, etc.) seja alterada facilmente, sem modificar o código do DAO.
     *
     * @author  Carlos Hayden
     * @version 1.0
     * @since   16/11/2024
     * 
     */

public class MarcaDAO {

    private Connection connection;

    // Getters e Setters
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma nova marca no banco de dados
    public boolean inserir(Marca marca) {
        String query = "INSERT INTO marcas (nome) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
             stmt.setString(1, marca.getNome());
             stmt.execute();
             return true;
        } catch (SQLException e) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // Método para buscar todas as marcas no banco de dados
    public List<Marca> listar() {
        List<Marca> marcas = new ArrayList<>();
        String query = "SELECT * FROM marcas";
        try (Statement stmt = connection.createStatement();
             ResultSet resultado = stmt.executeQuery(query)) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                Marca marca = new Marca(id, nome);
                marcas.add(marca);
            }
        } catch (SQLException e) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return marcas;
    }

    // Método para buscar marca por ID
    public Marca buscarPorId(int id) {
        String query = "SELECT * FROM marcas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    String nome = resultado.getString("nome");
                    return new Marca(id, nome);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    // Método para buscar marca
    public Marca buscar(Marca marca) {
        String sql = "SELECT * FROM marcas WHERE id=?";
        Marca retorno = new Marca();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                marca.setNome(resultado.getString("nome"));
                retorno = marca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Método para alterar dados de uma marca no banco de dados
    public boolean alterar(Marca marca) {
        String query = "UPDATE marcas SET nome=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, marca.getNome());
            stmt.setInt(2, marca.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // Método para excluir uma marca
    public boolean remover(Marca marca) {
        String query = "DELETE FROM marcas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, marca.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
