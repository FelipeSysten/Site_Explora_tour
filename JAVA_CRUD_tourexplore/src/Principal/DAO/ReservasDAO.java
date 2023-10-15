package Principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Principal.Conexao;
import Principal.Reservas;

public class ReservasDAO {


	private Connection conexao;

	    UsuariosDAO usuariosDAO = new UsuariosDAO();

	    DestinosDAO destinosDAO = new DestinosDAO();

	 

	    public ReservasDAO() {

	        try {

	            conexao = Conexao.conectar();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }
	    
	    public void criarReservas(Reservas reserva) {

	        String sql = "INSERT INTO reservas (idReserva, dataDestino, statusReserva, idUsuario, idDestinos) VALUES (?, ?, ?, ?, ?)";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, reserva.getIdReserva());
	            
	            stmt.setTimestamp(2, new java.sql.Timestamp(reserva.getDataDestino().getTime()));
	            
	            stmt.setString(3, reserva.getStatusReserva());
	            
	            stmt.setInt(4,reserva.getUsuarios().getIdUsuario());

	            stmt.setInt(5, reserva.getDestinos().getIdDestino());


	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }

	    public Reservas buscarReserva(int idReserva) {
	        Reservas reserva = null;
	        String sql = "SELECT * FROM reservas WHERE idReserva = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, idReserva);
	            ResultSet resultado = stmt.executeQuery();
	            if (resultado.next()) {
	                reserva = new Reservas();
	                reserva.setIdReserva(resultado.getInt("idReserva"));
	                reserva.setDataDestino(resultado.getTimestamp("dataDestino"));
	                reserva.setStatusReserva(resultado.getString("statusReserva"));
	                reserva.setUsuarios(usuariosDAO.buscarUsuario(resultado.getInt("idUsuario")));
	                reserva.setDestinos(destinosDAO.buscarDestino(resultado.getInt("idDestinos")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reserva;
	    }
	
	    public List<Reservas> listarReservas() {
	        List<Reservas> reservas = new ArrayList<>();
	        String sql = "SELECT * FROM reservas";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            ResultSet resultado = stmt.executeQuery();
	            while (resultado.next()) {
	                Reservas reserva = new Reservas();
	                
	                reserva.setIdReserva(resultado.getInt("idReserva"));
	                reserva.setDataDestino(resultado.getTimestamp("dataDestino"));
	                reserva.setStatusReserva(resultado.getString("statusReserva"));
	                reserva.setUsuarios(usuariosDAO.buscarUsuario(resultado.getInt("idUsuario")));
	                reserva.setDestinos(destinosDAO.buscarDestino(resultado.getInt("idDestinos")));
	              
	                reservas.add(reserva);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reservas;
	    }

	    public void atualizarReservas(Reservas reserva) {
	        String sql = "UPDATE reservas SET dataDestino = ?, statusReserva = ?, idUsuario = ?, idDestinos = ?   WHERE idReserva = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        	
	        	
	        	stmt.setTimestamp(1, new java.sql.Timestamp(reserva.getDataDestino().getTime()));
	        	stmt.setString(2, reserva.getStatusReserva());
	        	stmt.setInt(3, reserva.getUsuarios().getIdUsuario());
	        	stmt.setInt(4, reserva.getDestinos().getIdDestino());
	            stmt.setInt(5, reserva.getIdReserva());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void excluirConsulta(int idReserva) {
	        String sql = "DELETE FROM reservas WHERE idReserva = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, idReserva);
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
