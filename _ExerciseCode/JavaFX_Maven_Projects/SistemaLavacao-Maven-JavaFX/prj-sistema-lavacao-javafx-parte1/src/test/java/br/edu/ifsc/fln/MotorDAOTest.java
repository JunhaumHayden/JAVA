package br.edu.ifsc.fln;

import br.edu.ifsc.fln.model.dao.veiculos.MotorDAO;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import br.edu.ifsc.fln.model.database.Database;
import br.edu.ifsc.fln.model.database.DatabaseFactory;
import br.edu.ifsc.fln.model.domain.veiculos.*;

class MotorDAOTest {

    private static MotorDAO motorDAO;
    private static Connection connection;

    @BeforeAll
    static void setup() {
        // Configuração do banco em memória para teste
        Database database = DatabaseFactory.getDatabase("mysql"); // Use H2 ou outro para testes reais
        connection = database.conectar();
        motorDAO = new MotorDAO();
        motorDAO.setConnection(connection);
    }

    @AfterAll
    static void tearDown() {
        if (connection != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testInserirMotor() {
        // Arrange
        Motor motor = new Motor();
        motor.setPotencia(200);
        motor.setTipoCombustivel(ETipoCombustivel.FLEX);

        // Act
        boolean generatedId = motorDAO.inserir(motor);

        // Assert
        assertTrue(generatedId > 0, "O ID gerado deveria ser maior que 0.");

        // Verifica se o motor foi inserido corretamente no banco de dados
        String sql = "SELECT * FROM motor WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, generatedId);
            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next(), "O registro deveria existir no banco de dados.");
                assertEquals(200, rs.getInt("potencia"));
                assertEquals("FLEX", rs.getString("tipo_combustivel"));
            }
        } catch (SQLException e) {
            fail("Erro ao verificar a inserção no banco de dados: " + e.getMessage());
        }
    }

    @Test
    void testInserirMotorInvalido() {
        // Arrange
        Motor motor = new Motor();
        motor.setPotencia(-1); // Valor inválido
        motor.setTipoCombustivel(null); // Tipo de combustível inválido

        // Act
        int generatedId = motorDAO.inserir(motor);

        // Assert
        assertEquals(-1, generatedId, "O ID deveria ser -1 para um motor inválido.");
    }

    @Test
    void testExcluirMotor() {
        // Arrange
        Motor motor = new Motor();
        motor.setPotencia(150);
        motor.setTipoCombustivel(ETipoCombustivel.GASOLINA);
        int motorId = motorDAO.inserir(motor);
        assertTrue(motorId > 0, "O ID gerado deveria ser maior que 0.");

        // Act
        boolean deleted = motorDAO.excluir(motorId);

        // Assert
        assertTrue(deleted, "O motor deveria ser excluído com sucesso.");

        // Verifica se o motor foi realmente removido do banco
        String sql = "SELECT * FROM motor WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, motorId);
            try (ResultSet rs = stmt.executeQuery()) {
                assertFalse(rs.next(), "O registro não deveria mais existir no banco de dados.");
            }
        } catch (SQLException e) {
            fail("Erro ao verificar a exclusão no banco de dados: " + e.getMessage());
        }
    }
}

