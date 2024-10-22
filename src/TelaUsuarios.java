
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class TelaUsuarios extends javax.swing.JFrame {
    
    Connection conexao = null;
    preparedStatement pst = null;
    ResultSet rs = null;
    private Object txtIdUsu;
    /**
     * creates new form TelaUsuarios
     */
    public TelaUsuarios () {
        initComponents() ;
        conexao = conexaoDAO.conector();
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void subMenuUsuariosActionperformed(java.awt.event.ActionEvent evt) {
        TelaUsuarios tusuarios = new TelaUsuarios();
        tusuarios.setVisible(true);
    }

    //pesquisa
    
    public void pesquisa() throws SQLException{
        String sql = "select * from tbusuarios where id_usuarios = ?";
        try {
            pst = (preparedStatement) conexao.prepareStatement(sql);
            pst.setString(1, txtIdUsu.getText());
            rs = pst.executeQuery();
            if(rs.next());
                txtNomeUsu.setText(rs.getString(2));
        }else{
        JOptionPane.showMessageDialog(null, "usuário não encontrado!");
                limpar();
    }
    } catch (Exception e) {
    
    JOptionPane.showMessageDialog(null, e);
}
    
   public void limpar (){
       txtIdUsu.setText(null);
       txtNomeUsu.setText(null);
   }
   
   private void bntInserirActionPerformed(java.awt.event.ActionEvent evt) {
       //captura de dados na tela usuario
       int id_usuario = Integer.parseInt(txtIDUusuario.getText());
       String nome_usuario = txtNomeUsuario.getText();
       String login_usuario = txtLogin.getText();
       String senha_usuario = txtSenha.getText();
       
       //tranferencia de dados para UsuarioDTO
       UsuarioDTO objUsuarioDTO = new UsuarioDTO();
       objUsuarioDTO.setId_usuario(id_usuario);
       objUsuarioDTO.setNomeUsuario(nome_usuario);
       objUsuarioDTO.setLoginUsuario(login_usuario);
       objUsuarioDTO.setSenhaUsuario(senha_usuario);
       
       //Criação do objeto da classe UsuarioDAO ára inseriro usuario
       UsuarioDAO objUsuarioDAO = new UsuarioDAO();
       objUsuarioDAO.inserirUsuario(objUsuarioDTO);
   }
}
