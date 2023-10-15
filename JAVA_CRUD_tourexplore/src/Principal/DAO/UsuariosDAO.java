package Principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Principal.Conexao;
import Principal.Usuarios;


public class UsuariosDAO {
	

	private Connection conexao;

	 

    public UsuariosDAO() {

        try {

            conexao = Conexao.conectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void criarUsuario(Usuarios usuario) {


        String sql = "INSERT INTO usuarios (nomeUsuario, cpfUsuario, emailUsuario, telefoneUsuario) VALUES (?, ?, ?, ? )";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeUsuario());		

            stmt.setString(2, usuario.getCpfUsuario());
            
            stmt.setString(3, usuario.getEmailUsuario());	
            
            stmt.setString(4, usuario.getTelefoneUsuario());

            stmt.executeUpdate();
            
            

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public List<Usuarios> listarUsuarios() {

        List<Usuarios> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Usuarios usuario = new Usuarios();
                
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setNomeUsuario(resultado.getString("nomeUsuario"));
                usuario.setCpfUsuario(resultado.getString("cpfUsuario"));
                usuario.setEmailUsuario(resultado.getString("emailUsuario"));
                usuario.setTelefoneUsuario(resultado.getString("telefoneUsuario"));
                
                usuarios.add(usuario);
                

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return usuarios;

    }
    
    public void excluirUsuario(int idUsuario) {

        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            stmt.executeUpdate();
            
            

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public Usuarios buscarUsuario(int idUsuario) {


        Usuarios usuario = null;

        String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                usuario = new Usuarios();
                
                usuario.setIdUsuario(resultado.getInt("idUsuario"));

                usuario.setNomeUsuario(resultado.getString("nomeUsuario"));
                
                usuario.setCpfUsuario(resultado.getString("cpfUsuario"));

                usuario.setEmailUsuario(resultado.getString("emailUsuario"));
                
                usuario.setTelefoneUsuario(resultado.getString("telefoneUsuario"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return usuario;

    }

    public void atualizarUsuario(Usuarios usuario) {

    	String sql = "UPDATE usuarios SET nomeUsuario = ?, cpfUsuario = ?, emailUsuario = ?, telefoneUsuario = ? WHERE idUsuario = ?";

    	try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

    		stmt.setString(1, usuario.getNomeUsuario());
    		
    		stmt.setString(2, usuario.getCpfUsuario());
    		
    		stmt.setString(3, usuario.getEmailUsuario());
    		
    		stmt.setString(4, usuario.getTelefoneUsuario());
    		
    		stmt.setInt(5, usuario.getIdUsuario());
    		

    		stmt.executeUpdate();

    	} catch (SQLException e) {

    		e.printStackTrace();

    	}

    }
    
    public void fecharConexao() {

        try {

            if (conexao != null && !conexao.isClosed()) {

                conexao.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
