package dao;
import model.Usuario;
import java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
     private Connection conn;
     private PreparedStatement stmt;
     private ResultSet rs;
     
     public UsuarioDAO(){
        conn= new Conexao().getConexao();
        
     }
    public boolean result = false;
    public String nome = "";
    
    public boolean verificarUsuario(Usuario usuario){
        String sql ="SELECT nome_usuario FROM tb_usuario "
                +"WHERE login_usuario = ? AND senha_usuario = ?";
        try{
         
           stmt=conn.prepareStatement(sql);
           stmt.setString(1, usuario.getLogin_usuario());
           stmt.setString(2,usuario.getSenha_usuario());
           rs= stmt.executeQuery();
           if(rs.next()){
               result = true;
               nome = rs.getString("nome_usuario");
           }
        }catch(Exception erro){
            throw new  RuntimeException ("Erro 2- verificar :"+erro);
        }
        return result;
                
   
    }
}
