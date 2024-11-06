package packageModel;

public class Tarefa {
	private String idTarefa;
	private String idUsuario;
	private String descricao;
	private String setor;
	private String nivel;
	private String statusTarefa;
	
	public Tarefa() {
		super();
	}
	
	public Tarefa(String idTarefa, String idUsuario, String descricao, String setor, String nivel,
			String statusTarefa) {
		super();
		this.idTarefa = idTarefa;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.setor = setor;
		this.nivel = nivel;
		this.statusTarefa = statusTarefa;
	}
	
	public String getIdTarefa() {
		return idTarefa;
	}
	
	public void setIdTarefa(String idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public String getStatusTarefa() {
		return statusTarefa;
	}
	
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
	
	
	
	

}
