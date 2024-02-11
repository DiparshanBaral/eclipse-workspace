package users;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Admin extends User {
	
	private String adminName;
    private String adminEmail;
    private String adminPhone;
  
	
	
	

	public Admin() {
	}

	public Admin(int id, String name, String email, String phone) {
		super(id, name, email, phone);
	}

	

	public ArrayList<String> getAdminData(String email) {
		String select = "SELECT * FROM admin WHERE admin_email = '" + email + "'";
		ArrayList<String> admin = new ArrayList<String>();
		try {
			PreparedStatement state = connect.prepareStatement(select);
			ResultSet set = state.executeQuery(select);
			while (set.next()) {
				admin.add(set.getNString("admin_name"));

			}
			state.executeQuery();
			state.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return admin;
	}

	public void changePassword(String enteredEmail, String oldPassword, String newPassword) {
		try {
			
			

			// Verify the old password first
			PreparedStatement stmt = connect
					.prepareStatement("SELECT admin_password FROM admin WHERE admin_email = ?");
			stmt.setString(1, enteredEmail);
			ResultSet result = stmt.executeQuery();
			if (!result.next()) {
			    JOptionPane.showMessageDialog(null, "No matching email found!");
			    return;
			}

			if (!result.getString("admin_password").equals(oldPassword)) {
			    JOptionPane.showMessageDialog(null, "Incorrect old password!");
			    return;
			}


			// Update the password if the old password is correct
			stmt = connect.prepareStatement("UPDATE admin SET admin_password = ? WHERE admin_email = ?");
			stmt.setString(1, newPassword);
			stmt.setString(2, enteredEmail);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Password changed successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	
	
	
	
	public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }



}
