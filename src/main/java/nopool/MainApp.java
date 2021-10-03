package nopool;

import utils.ConfigParams;

import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        final int N = Integer.parseInt(ConfigParams.getConfig("N_RUN"));
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            Connection connection = null;
            try {
                connection = MySqlConnection.getConnection();
            } catch (Exception e) {

            } finally {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("Sum time / total = " + (endTime - startTime) + " / " + N);
    }
}
