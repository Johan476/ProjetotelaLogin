
package br.com.DTO;

/**
 * 
 * @author aluno.saolucas
 */
public class UsuarioDTO {
private int id_usuario;
private String nome_usuario, login_usuario, senha,_usuario, perfil_usuario;

public String getPerfil_usuario() {
    return perfil_usuario;
}
    
    public void setPerfil_usuario(String perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }
}
