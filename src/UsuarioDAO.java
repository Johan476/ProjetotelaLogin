
import br.com.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class UsuarioDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    Result rs = null;
    private Object Exception;
    private String e;
    
    public void inserirUsuario(usuarioDTO objUsuarioDTO) throws SQLException {
        String sql = "insert into tb_usuarios (id_usuario, usuario, login, senha,perfil)"
                + " values (?, ?, ?, ?, ?)";
        conexao = new conexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            pst.setString(2, objUsuarioDTO.getNome_usuario());
            pst.setString(3, objUsuarioDTO.getLogin_usuario());
            pst.setString(4, objUsuarioDTO.getSenha_usuario());
            pst.setInt(5, objUsuarioDTO.getPerfil_usuario());
            
            pst.execute();
            pst.close();
            
        } catch.() Exception = null e
{
        
            JOptionPane.showMessageDialog(null, "UsuarioDAO "+ e);
    }
        }
    }

    private static class usuarioDTO {

        public usuarioDTO() {
        }

        private int getId_usuario() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getNome_usuario() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getLogin_usuario() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getSenha_usuario() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private int getPerfil_usuario() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        //Método editar
        public void editar (UsuarioDTO objUsuarioDTO) {
            String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ?, perfil = ? where id_usuario = ?";
            conexao = conexaoDAO.conector();
            try {
                pst = conexao.prepareStatement (sql);
                pst.setInt(5, objUsuarioDTO.getId_usuario());
                pst.setString(4, 0bjUsuarioDTO.getPerfil_usuario());
                pst.setString(3, 0bjUsuarioDTO.getSenha_usuario());
                pst.setString(2, 0bjUsuarioDTO.getLogin_usuario());
                pst.setString(1, 0bjUsuarioDTO.getNome_usuario());
                int add = pst.executeUpdate ();
                if (add > 0) {
                    JOptionPane,showMessageDialog(null, "usuário editado com sucesso!");
                    pesquisaAuto();
                    conexao.close();
                    limparCampos();
                }
            } catch (Exception e)  {
                JOptionPane.showMessageDialog(null, "método editar " + e);
            }
        }

        //Método deletar 
        public void deletar (UsuarioDTO objUsuarioDTO) {
            String sql = "delete from tb_usuarios where id_usuario = ?";
            conexao = conexaoDAO.conector();
            
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, objUsuarioDTO.getId_usuario());
                int del = pst.executeUpdate();
                if (del > 0) {
                    JOptionPane.showMessageDialog(null, " Usuário deletado com sucesso!");
                    pesquisaAuto();
                    conexao.close();
                    limparCampos();
                }
            } catch (Exception e)  {
                JOptionPane.showMessageDialog(null, " Método deletar " + e)
            }
        }
    }
    