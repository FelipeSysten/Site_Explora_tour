package Principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Principal.Conexao;
import Principal.Destinos;





public class DestinosDAO {
	

	private Connection conexao;

	 

    public DestinosDAO() {

        try {

            conexao = Conexao.conectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void criarDestino(Destinos destino) {


        String sql = "INSERT INTO destinos (nomeDestino, descricaoDestino) VALUES (?, ? )";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, destino.getNomeDestino());		

            stmt.setString(2, destino.getDescricaoDestino());
            

            stmt.executeUpdate();
            
         

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public List<Destinos> listarDestinos() {

        List<Destinos> destinos = new ArrayList<>();

        String sql = "SELECT * FROM destinos";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Destinos destino = new Destinos();
                
                destino.setIdDestino(resultado.getInt("idDestinos"));
                
                destino.setNomeDestino(resultado.getString("nomeDestino"));
                
                destino.setDescricaoDestino(resultado.getString("descricaoDestino"));


                destinos.add(destino);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return destinos;

    }
    
    public void excluirDestino(int id) {

        String sql = "DELETE FROM destinos WHERE idDestinos = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
            
            System.out.println("Excluido com Sucesso");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void atualizarDestino(Destinos destino) {

        String sql = "UPDATE destinos SET nomeDestino = ?, descricaoDestino = ? WHERE idDestinos = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, destino.getNomeDestino());

            stmt.setString(2, destino.getDescricaoDestino());

            stmt.setInt(3, destino.getIdDestino());

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public Destinos buscarDestino(int idDestinos) {
		Destinos destino = null;

        String sql = "SELECT * FROM destinos WHERE idDestinos = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idDestinos);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                destino = new Destinos();
                
                destino.setIdDestino(resultado.getInt("idDestinos"));
                
                destino.setNomeDestino(resultado.getString("nomeDestino"));

                destino.setDescricaoDestino(resultado.getString("descricaoDestino"));
                

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return destino;
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
