package Principal;

import java.util.Date;

public class Reservas {

	private int idReserva;
	
	private Date dataDestino;
	
	private String statusReserva;

	private Usuarios usuarios;

	private Destinos destinos;
	
	
	

	public Reservas(int idReserva, Date dataDestino, String statusReserva, Usuarios usuarios, Destinos destinos) {
		super();
		this.idReserva = idReserva;
		this.dataDestino = dataDestino;
		this.statusReserva = statusReserva;
		this.usuarios = usuarios;
		this.destinos = destinos;
	}

	public Reservas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getDataDestino() {
		return dataDestino;
	}

	public void setDataDestino(Date dataDestino) {
		this.dataDestino = dataDestino;
	}

	public String getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	public void getIdReserva(int int1) {
		// TODO Auto-generated method stub
		
	}



	public void getStatusReserva(String string) {
		// TODO Auto-generated method stub
		
	}



	
	
	
}
