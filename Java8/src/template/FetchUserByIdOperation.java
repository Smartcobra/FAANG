package template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchUserByIdOperation extends DatabaseOperation {

    private int userId;

    public FetchUserByIdOperation(int userId) {
        this.userId = userId;
    }

    @Override
    protected String createQuery() {
        return "SELECT * FROM users WHERE id = ?";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws Exception {
        statement.setInt(1, userId);
    }

    @Override
    protected void processResult(ResultSet resultSet) throws Exception {
        while (resultSet.next()) {
            System.out.println("User ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Email: " + resultSet.getString("email"));
        }
    }
}
