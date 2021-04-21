
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBConnection {
    
    private Connection connection;
    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    protected void finalize() throws Throwable {
        statement.close();
        connection.close();
    }
    
     public void abrirConexao() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", "root", "123");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fecharConexao() throws Exception {
        statement.close();
        connection.close();
    }
   
}
