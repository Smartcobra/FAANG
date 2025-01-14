package template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchAllUsersOperation extends DatabaseOperation {

    @Override
    protected String createQuery() {
        return "SELECT * FROM users";
    }

    @Override
    protected void setParameters(PreparedStatement statement) {
        // No parameters to set for this query
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
