package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import DTO.UsuarioDTO;
import java.sql.SQLException;


public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuarioutil){
        conn = new ConexaoDAO().conectarBD();
        
        try {
            String sql = "SELECT * FROM usuario WHERE login_usuario= ? and senha_usuario = ?";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, objusuarioutil.getLogin_usuario());
            prst.setString(2, objusuarioutil.getSenha_usuario());
            
            ResultSet rs = prst.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO: " + erro);
            return null;
        }
    }
    
}
