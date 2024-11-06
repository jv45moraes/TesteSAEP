package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import packageDAO.TarefaDAO;
import packageDAO.UsuarioDAO;
import packageModel.Tarefa;
import packageModel.Usuario;

public class controllerItemTarefa implements Initializable{

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private ChoiceBox<String> choiceStatus;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelPrioridade;

    @FXML
    private Label labelSetor;

    @FXML
    private Label labelUsuario;
    
    Tarefa itemTarefa = new Tarefa();
    
    
    public void setData(Tarefa tarefa) {
    	itemTarefa = tarefa;
    	labelDescricao.setText(itemTarefa.getDescricao());
    	labelSetor.setText(itemTarefa.getSetor());
    	labelPrioridade.setText(itemTarefa.getNivel());
    	
    	Usuario usuario = new Usuario();
    	UsuarioDAO usuarioDAO = new UsuarioDAO();
    	
    	usuario = usuarioDAO.searchByID(tarefa.getIdUsuario());
    	
    	labelUsuario.setText(usuario.getNome());
    }
    
    @FXML
    void btnAlterarStatusTarefa(ActionEvent event) throws IOException {
    	
    	Tarefa tarefa = new Tarefa();
    	TarefaDAO tarefaDAO = new TarefaDAO();
    	
    	Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
    	mensagemDeAviso.setContentText("Deseja realmente alterar o Stats da tarefa? ");
 
    	Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

 		if( resultado.isPresent() && resultado.get() == ButtonType.OK) {
 			
 			tarefa.setDescricao(labelDescricao.getText());
 			tarefa.setSetor(labelSetor.getText());
 			tarefa = tarefaDAO.search(tarefa);
 			tarefa.setStatusTarefa(choiceStatus.getValue().toString());
 			tarefaDAO.updateStatus(tarefa);
 			Main.TelaMain();
 			
 		}
    	
    	
    }

    static Tarefa tarefaEditar = new Tarefa();

    @FXML
    void btnEditarTarefa(ActionEvent event) throws IOException {
    	tarefaEditar.setDescricao(labelDescricao.getText());
    	tarefaEditar.setSetor(labelSetor.getText());
    	Main.TelaCadTarefa();
    }

    @FXML
    void btnExcluirTarefa(ActionEvent event) throws IOException {
    	
    	Tarefa tarefa = new Tarefa();
    	TarefaDAO tarefaDAO = new TarefaDAO();
    	
    	Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
    	mensagemDeAviso.setContentText("Deseja realmente excluir a tarefa? ");
 
    	Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
		
 		if( resultado.isPresent() && resultado.get() == ButtonType.OK) {
 			
 			tarefa.setDescricao(labelDescricao.getText());
 			tarefa.setSetor(labelSetor.getText());
 			tarefa = tarefaDAO.search(tarefa);
 			tarefaDAO.delete(tarefa.getIdTarefa());
 			Main.TelaMain();
 			
 		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		choiceStatus.getItems().add("A Fazer");
		choiceStatus.getItems().add("Fazendo");
		choiceStatus.getItems().add("Pronto");

	}

}
