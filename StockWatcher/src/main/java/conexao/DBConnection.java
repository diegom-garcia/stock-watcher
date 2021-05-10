package conexao;

import com.mycompany.stockwatcher.GetCredentials;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        GetCredentials credentials = new GetCredentials();
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", credentials.getUser(), credentials.getPassword());
        } catch (SQLException ex) {
            System.out.println("deu erro no DBconnection");
            throw new RuntimeException(ex);
        }
    }

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

    private void abrirConexao() {
        GetCredentials credentials = new GetCredentials();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", credentials.getUser(), credentials.getPassword());
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("oie");

        }
    }

    public void fecharConexao() throws Exception {
        statement.close();
        connection.close();
    }

}
