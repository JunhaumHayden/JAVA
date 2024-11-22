package br.edu.ifsc.fln.model.dao.veiculos;

import br.edu.ifsc.fln.model.domain.veiculos.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    // Crud - Metodo para inserir uma nova marca no banco de dados

    public boolean inserir(Marca marca) {
        String sql = "INSERT INTO marcas (nome) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca.getNome());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // cRud - Metodo para buscar todas as marcas no banco de dados
    public List<Marca> listar() {
        String sql = "SELECT * FROM marcas";
        List<Marca> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Marca marca = new Marca();
                marca.setId(resultado.getInt("id"));
                marca.setNome(resultado.getString("nome"));
                retorno.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    // Metodo para buscar marca
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
    // crUd- Metodo para alterar dados de uma marca no banco de dados
    public boolean alterar(Marca marca) {
        String sql = "UPDATE marcas SET nome=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca.getNome());
            stmt.setInt(2, marca.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // cruD - Metodo para excluir uma marca
    public boolean remover(Marca marca) {
        String sql = "DELETE FROM marcas WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
