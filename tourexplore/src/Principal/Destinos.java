package Principal;

public class Destinos {
	
	private int idDestino;

	private String nomeDestino;
	
	private String descricaoDestino;

	
	
	
	public Destinos(int idDestino, String nomeDestino, String descricaoDestino) {
		super();
		this.idDestino = idDestino;
		this.nomeDestino = nomeDestino;
		this.descricaoDestino = descricaoDestino;
	}

	public Destinos() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getDescricaoDestino() {
		return descricaoDestino;
	}

	public void setDescricaoDestino(String descricaoDestino) {
		this.descricaoDestino = descricaoDestino;
	}

}
