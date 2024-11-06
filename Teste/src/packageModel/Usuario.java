package packageModel;

public class Usuario {
	private String idUsuario;
	private String nome;
	private String email;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String idUsuario, String nome, String email) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}

	public String getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
