package br.edu.ifsc.fln;

import org.junit.jupiter.api.Test;

import br.edu.ifsc.fln.model.database.Database;
import br.edu.ifsc.fln.model.database.DatabaseConfig;
import br.edu.ifsc.fln.model.database.DatabaseFactory;
import br.edu.ifsc.fln.model.database.DatabaseMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A classe DatabaseConfigTest foi criada especificamente para testar a configuração do banco.
 * 
 * @author  Carlos Hayden
 * @version 1.0
 * @since   16/11/2024
 */
public class DatabaseConfigTest {

    /** 
     * @metodo testDatabaseConnection utiliza o @método getConnection da classe DatabaseConfig.
     * Verifica se a conexão retornada não é nula usando o método assertNotNull.
     * Mensagens e exceções:
     * - Se a conexão for bem-sucedida, exibe uma mensagem no console.
     * - Caso contrário, lança uma exceção com detalhes do erro.
     */
    @Test
    public void testDatabaseConnection() {
        try (Connection connection = DatabaseConfig.getConnection()) {
            // Verifica se a conexão não é nula
            assertNotNull(connection, "A conexão com o banco de dados falhou!");
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Teste de conexão com credenciais corretas (cenário positivo)
    @Test
    public void testConexaoMySQL() {
        // Obter a implementação do banco de dados (MySQL)
        Database database = DatabaseFactory.getDatabase("mysql");
        
        // Verificar se o objeto Database não é nulo
        assertNotNull(database, "A instância do banco de dados é nula!");

        // Conectar ao banco de dados
        Connection connection = database.conectar();
        
        // Verificar se a conexão foi bem-sucedida
        assertNotNull(connection, "Falha ao estabelecer a conexão com o banco de dados!");
        
        // Desconectar e verificar se não há exceções
        try {
            database.desconectar(connection);
            System.out.println("Conexão desconectada com sucesso.");
        } catch (Exception e) {
            fail("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }

    // Teste de falha de conexão com credenciais incorretas
    @Test
    public void testConexaoMySQLCredenciaisErradas() {
        // Criar uma classe DatabaseMySQL com credenciais incorretas
        Database database = new DatabaseMySQL() {
            @Override
            public Connection conectar() {
                try {
                    final String DRIVER = "com.mysql.cj.jdbc.Driver";
                    final String URL = "jdbc:mysql://localhost:3306/db_lava_jato?useTimezone=true&serverTimezone=UTC";
                    final String USER = "wrongUser";  // Usuário errado
                    final String PASS = "wrongPass";  // Senha errada
                    Class.forName(DRIVER);
                    return DriverManager.getConnection(URL, USER, PASS);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        };

        Connection connection = database.conectar();
        assertNull(connection, "A conexão deveria ter falhado com as credenciais incorretas!");
    }

    // Teste de falha de conexão quando o serviço de banco de dados está indisponível
    @Test
    public void testConexaoBancoIndisponivel() {
        // Criar uma classe DatabaseMySQL com um URL inválido (indisponível)
        Database database = new DatabaseMySQL() {
            @Override
            public Connection conectar() {
                try {
                    final String DRIVER = "com.mysql.cj.jdbc.Driver";
                    final String URL = "jdbc:mysql://localhost:9999/db_lava_jato";  // Porta errada (indisponível)
                    final String USER = "java";
                    final String PASS = "java";
                    Class.forName(DRIVER);
                    return DriverManager.getConnection(URL, USER, PASS);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        };

        Connection connection = database.conectar();
        assertNull(connection, "A conexão deveria ter falhado devido ao banco de dados indisponível!");
    }
    
}

