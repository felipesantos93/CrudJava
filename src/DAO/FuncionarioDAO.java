    
package DAO;

import DTO.FuncionarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;


/**
 *
 * @author Felipe
 */
public class FuncionarioDAO extends ConexaoDAO{
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();
    FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();

         public boolean  cadastrarFuncionario(FuncionarioDTO objfuncionariodto){
        
   
        String sql= "INSERT INTO funcionario (nome_funcionario, cpf_funcionario, telefone_funcionario, salario_funcionario, endereco_funcionario,cargo_funcionario) VALUES(?,?,?,?,?,?)";
        
     conn = new ConexaoDAO().conectarBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getCpf_funcionario());
            pstm.setString(3, objfuncionariodto.getTelefone_funcionario());
            pstm.setDouble(4, objfuncionariodto.getSalario());
            pstm.setString(5, objfuncionariodto.getEndereco_funcionario());
            pstm.setString(6,objfuncionariodto.getCargo_funcionario());
            
            pstm.executeUpdate();
            pstm.close();
            return true;
          
            
            
        } catch (SQLException erro) {
            System.out.println("DAO.FuncionarioDAO.cadastrarFuncionario()");
            return false;
        }
       
    }
    
  
        public  ArrayList<FuncionarioDTO> pesquisarFuncionario(){
            String sql = "SELECT * FROM funcionario";
            conn = new ConexaoDAO().conectarBD();
            
            try {
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                   objFuncionarioDTO = new FuncionarioDTO();
                   objFuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                   objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                   objFuncionarioDTO.setCpf_funcionario(rs.getString("cpf_funcionario"));
                   objFuncionarioDTO.setTelefone_funcionario(rs.getString("telefone_funcionario"));
                   objFuncionarioDTO.setSalario(rs.getDouble("salario_funcionario"));
                   objFuncionarioDTO.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                   objFuncionarioDTO.setCargo_funcionario(rs.getString("cargo_funcionario"));
                  
                   lista.add(objFuncionarioDTO);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Funcionario DAO PesquisarFuncionario: " + erro);
            }
            return lista;
    }
    public FuncionarioDTO selecionarFuncionarioDAO(int codigoUsuario) {
        conn = new ConexaoDAO().conectarBD();
        String sql = " SELECT * FROM funcionario WHERE id_funcionario =  '" + codigoUsuario + "'";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDTO.setCpf_funcionario(rs.getString("cpf_funcionario"));
                objFuncionarioDTO.setTelefone_funcionario(rs.getString("telefone_funcionario"));
                objFuncionarioDTO.setSalario(rs.getDouble("salario_funcionario"));
                objFuncionarioDTO.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                objFuncionarioDTO.setCargo_funcionario(rs.getString("cargo_funcionario"));
               
            }
        } catch (SQLException erro) {
            System.out.println("DAO.UsuarioDAO.selecionarFuncionarioDAO()" + erro);
            
        }
        return objFuncionarioDTO ;
    }
    

    public boolean alterarFuncionario(FuncionarioDTO objfuncionarioDTO) {
        conn = new ConexaoDAO().conectarBD();
        String sql = " UPDATE Funcionario set nome_funcionario = ?, cpf_funcionario = ? , telefone_funcionario = ? , salario_funcionario = ?, endereco_funcionario = ?,cargo_funcionario = ? WHERE id_funcionario = '" +objfuncionarioDTO.getId_funcionario() + "' ";
        
        
        try {
            pstm =conn.prepareStatement(sql);
            pstm.setString(1,objfuncionarioDTO.getNome_funcionario() );
            pstm.setString(2,objfuncionarioDTO.getCpf_funcionario());
            pstm.setString(3, objfuncionarioDTO.getTelefone_funcionario());
            pstm.setDouble(4,objfuncionarioDTO.getSalario());
            pstm.setString(5, objfuncionarioDTO.getEndereco_funcionario());
            pstm.setString(6, objfuncionarioDTO.getCargo_funcionario());
            
            
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (Exception erro) {
            System.out.println("DAO.FuncionarioDAO.alterarFuncionario()" + erro);
             return false;
        }
        
    }
   
    public void excluirFuncionario(int id_funcionario){
        
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ? ";
        conn= new ConexaoDAO().conectarBD();
        try {
            pstm = conn.prepareStatement(sql);  
            pstm.setInt(1, id_funcionario);
            pstm.executeUpdate();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Funcionario DAO excluirFuncionario: " + erro);
        }
        
    }
    
}
