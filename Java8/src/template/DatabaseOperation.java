package template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DatabaseOperation {

    private Connection connectToDatabase() throws Exception {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "password";
        System.out.println("Connecting to database...");
        return DriverManager.getConnection(url, username, password);
    }
    protected abstract String createQuery();
    protected abstract void setParameters(PreparedStatement statement) throws Exception;
    protected abstract void processResult(ResultSet resultSet) throws Exception;

    protected void handleException(Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
    }



    public final void executeDatabaseOperation() {
        try (Connection connection = connectToDatabase()) {
            String query = createQuery();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                setParameters(statement);
                ResultSet resultSet = statement.executeQuery();
                processResult(resultSet);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }
}
