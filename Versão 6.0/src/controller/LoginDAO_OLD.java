package controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

public class LoginDAO_OLD {
    
  public boolean checkLogin(String login, String senha) {

        Connection con = ConexaoBD.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
       // List<Login> login = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM login WHERE login =? and senha = ?");
            stmt.setString(1,login);
            stmt.setString(2,senha);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                check = true;
                

             /*   Login login = new Login();
                login.setId_login(rs.getInt("id"));
                login.setLogin(rs.getString("Descrição"));
                login.setSenha(rs.getString("qtd"));
               */
                //logins.add(login);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO_OLD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.Desconectar(con, stmt, rs);
        }

        return check;

    }
    public List<Login> readForDesc(String desc) {

        Connection con = ConexaoBD.Conectar();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Login> logins = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM login WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Login login = new Login();

                login.setId(rs.getInt("id"));
                login.setDescricao(rs.getString("descricao"));
                login.setQtd(rs.getInt("qtd"));
                login.setPreco(rs.getDouble("preco"));
                logins.add(login);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO_OLD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.Desconectar(con, stmt, rs);
        }

        return logins;

    }
   
}
