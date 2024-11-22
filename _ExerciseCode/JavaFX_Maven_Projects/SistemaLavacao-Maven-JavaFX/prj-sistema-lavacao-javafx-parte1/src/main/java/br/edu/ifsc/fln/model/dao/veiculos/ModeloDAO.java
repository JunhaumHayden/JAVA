package br.edu.ifsc.fln.model.dao.veiculos;

import br.edu.ifsc.fln.model.domain.ECategoria;
import br.edu.ifsc.fln.model.domain.veiculos.ETipoCombustivel;
import br.edu.ifsc.fln.model.domain.veiculos.Marca;
import br.edu.ifsc.fln.model.domain.veiculos.Modelo;
import br.edu.ifsc.fln.model.domain.veiculos.Motor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloDAO {

    private Connection connection;
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Modelo modelo) {
        String sqlModelo = "INSERT INTO modelos (descricao, id_marca, id_motor, categoria) VALUES (?, ?, ?, ?)";
        String sqlMotor = "INSERT INTO motor (potencia, tipo_combustivel) VALUES (?, ?)";
        // Insere o motor
        try {
            if (modelo.getMotor().getId() == 0) { // Verifica se o ID do motor é zero, indicando que ainda não foi inserido
                try (PreparedStatement stmtMotor = connection.prepareStatement(sqlMotor, Statement.RETURN_GENERATED_KEYS)) { //instrui o banco de dados a retornar as chaves primárias
                    stmtMotor.setInt(1, modelo.getMotor().getPotencia());
                    stmtMotor.setString(2, modelo.getMotor().getTipoCombustivel().name());
                    if (stmtMotor.executeUpdate() > 0) {
                        try (ResultSet rs = stmtMotor.getGeneratedKeys()) { //retorna um objeto ResultSet contendo as chaves primárias geradas durante a última execução de um INSERT
                            if (rs.next()) {
                                modelo.getMotor().setId(rs.getInt(1)); // Define o ID gerado no objeto Motor
                            }
                        }
                    }
                }
            }
            // Insere o modelo
            try (PreparedStatement stmtModelo = connection.prepareStatement(sqlModelo, Statement.RETURN_GENERATED_KEYS)){
                stmtModelo.setString(1, modelo.getDescricao());
                stmtModelo.setInt(2, modelo.getMarca().getId());
                stmtModelo.setInt(3, modelo.getMotor().getId());
                stmtModelo.setString(4, modelo.getCategoria().name());
                if (stmtModelo.executeUpdate() > 0) {
                    try (ResultSet rs = stmtModelo.getGeneratedKeys()) {
                        if (rs.next()) {
                            modelo.setId(rs.getInt(1)); // Define o ID gerado no objeto Modelo
                        }
                    }
                }
            }
            connection.commit(); // Finaliza a transação
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Modelo modelo) {
        String sql = "UPDATE modelos SET descricao = ?, id_marca = ?, id_motor = ?, categoria = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, modelo.getDescricao());
            stmt.setInt(2, modelo.getMarca().getId());
            stmt.setInt(3, modelo.getMotor().getId());
            stmt.setString(4, modelo.getCategoria().name());
            stmt.setInt(5, modelo.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Modelo modelo) {
        String sql = "DELETE FROM modelos WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getId());
            stmt.execute();
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Modelo> listar() {
        String sql = "SELECT m.id, m.descricao, m.id_marca, ma.nome AS nome_marca, m.id_motor, mo.potencia, " +
                "mo.tipo_combustivel, m.categoria " +
                "FROM modelos m " +
                "JOIN marcas ma ON m.id_marca = ma.id " +
                "JOIN motor mo ON m.id_motor = mo.id";
        List<Modelo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Marca marca = new Marca(resultado.getInt("id_marca"), resultado.getString("nome_marca"));
                Motor motor = new Motor(resultado.getInt("id_motor"), resultado.getInt("potencia"),
                        ETipoCombustivel.valueOf(resultado.getString("tipo_combustivel")));
                ECategoria categoria = ECategoria.valueOf(resultado.getString("categoria"));

                retorno.add(new Modelo(resultado.getInt("id"), resultado.getString("descricao"), marca, motor, categoria));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Modelo buscar(Modelo modelo) {
        String sql = "SELECT m.id, m.descricao, m.id_marca, ma.nome AS nome_marca, m.id_motor, mo.potencia, " +
                "mo.tipo_combustivel, m.categoria " +
                "FROM modelos m " +
                "JOIN marca ma ON m.id_marca = ma.id " +
                "JOIN motor mo ON m.id_motor = mo.id " +
                "WHERE m.id = ?";
        Modelo retorno = new Modelo();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getId());
            try (ResultSet resultado = stmt.executeQuery()){
            if (resultado.next()) {
                    Marca marca = new Marca(resultado.getInt("id_marca"), resultado.getString("nome_marca"));
                    Motor motor = new Motor(resultado.getInt("id_motor"), resultado.getInt("potencia"),
                            ETipoCombustivel.valueOf(resultado.getString("tipo_combustivel")));
                    ECategoria categoria = ECategoria.valueOf(resultado.getString("categoria"));

                    return new Modelo(resultado.getInt("id"), resultado.getString("descricao"), marca, motor, categoria);
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
