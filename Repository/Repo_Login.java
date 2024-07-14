package Repository;

import Model.Model_login;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class Repo_Login {
   public boolean checkCredential(String username, String password) {
        String sql = "SELECT Username , Password FROM Login WHERE Username = ? AND Password = ?";
        try(Connection con = DB_conect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    }
   

