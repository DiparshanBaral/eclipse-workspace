package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class activities {
    private Connection connection;  // Assume this is your database connection

    public activities(Connection connection) {
        this.connection = connection;
    }

    public void displayActivities(JTable table) {
        String query = "SELECT activity_id, CONCAT(activity_name, ' on ', activity_date, '  at  ', activity_time) AS activity_details FROM activity";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  // Clear existing rows

            while (resultSet.next()) {
                int id = resultSet.getInt("activity_id");
                String activityDetails = resultSet.getString("activity_details");

                model.addRow(new Object[]{id, activityDetails});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
