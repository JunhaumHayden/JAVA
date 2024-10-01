package br.edu.ifsc.fln.model.dao;

import br.edu.ifsc.fln.model.domain.ECategoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ECategoriaDAO {
    
    private Connection connection;

    public ECategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<ECategoria> getAll() throws SQLException {
        String sql = "SELECT id, descricao FROM categoria";
        List<ECategoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categorias.add(mapToCategoria(rs));
            }
        }
        return categorias;
    }

    public void Inserir(ECategoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (id, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getDescricao());
            stmt.executeUpdate();
        }
    }

    public void Modificar(ECategoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        }
    }

    public void Deletar(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ECategoria BuscarporId(int id) throws SQLException {
        String sql = "SELECT id, descricao FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToCategoria(rs);
                }
            }
        }
        return null;
    }

    private ECategoria mapToCategoria(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String descricao = rs.getString("descricao");
        for (ECategoria categoria : ECategoria.values()) {
            if (categoria.getId() == id) {
                categoria.setDescricao(descricao);
                return categoria;
            }
        }
        return null;
    }
}