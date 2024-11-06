package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import packageDAO.TarefaDAO;
import packageDAO.UsuarioDAO;
import packageModel.Tarefa;
import packageModel.Usuario;

public class controllerCadTarefa implements Initializable{

    @FXML
    private Button btnCadTarefas;

    @FXML
    private Button btnCadUsuario;

    @FXML
    private Button btnCadTarefa;

    @FXML
    private Button btnGerTarefas;

    @FXML
    private ChoiceBox<String> choiceNivel;

    @FXML
    private ChoiceBox<String> choiceUser;

    @FXML
    private TextField textDescricao;

    @FXML
    private TextField textSetor;

    @FXML
    void btnCadTarefas(ActionEvent event) throws IOException {

    }

    @FXML
    void btnCadUsuario(ActionEvent event) throws IOException {
    	Main.TelaCadUsuario();
    }


    @FXML
    void btnGerTarefas(ActionEvent event) throws IOException {
    	Main.TelaMain();
    }
    
    
    @FXML
    void btnCadTarefa(ActionEvent event) throws IOException {
    	if(textDescricao.getText()!= null && textSetor.getText()!=null && choiceUser.getValue()!= null && choiceNivel.getValue()!= null){
    		if(controllerItemTarefa.tarefaEditar!= null) {
    			Tarefa tarefa = new Tarefa();
        		TarefaDAO tarefaDAO = new TarefaDAO();
        		
        		
        		tarefa.setDescricao(textDescricao.getText());
        		tarefa.setSetor(textSetor.getText());
        		tarefa.setNivel(choiceNivel.getValue().toString());
        		
        		Usuario usuario = new Usuario();
        		UsuarioDAO usuarioDAO = new UsuarioDAO();
        		
        		usuario = usuarioDAO.searchByNome(choiceUser.getValue().toString());
        		
        
        		tarefa.setIdUsuario(usuario.getIdUsuario());
        		tarefa.setIdTarefa(tarefaEditar.getIdTarefa());
        		tarefaDAO.update(tarefa);
        		
        		Alert msgCadastro = new Alert(AlertType.CONFIRMATION);
        		msgCadastro.setTitle("Tarefa atulizada");
        		msgCadastro.setContentText("A tarefa foi atualizada com sucesso!");
        		msgCadastro.setHeaderText("Atualização realizada com sucesso!");
        		msgCadastro.show();
        		controllerItemTarefa.tarefaEditar = null;
        		Main.TelaCadTarefa();
    		
    		} else {
    		Tarefa tarefa = new Tarefa();
    		TarefaDAO tarefaDAO = new TarefaDAO();
    		
    		
    		tarefa.setDescricao(textDescricao.getText());
    		tarefa.setSetor(textSetor.getText());
    		tarefa.setNivel(choiceNivel.getValue().toString());
    		
    		Usuario usuario = new Usuario();
    		UsuarioDAO usuarioDAO = new UsuarioDAO();
    		
    		usuario = usuarioDAO.searchByNome(choiceUser.getValue().toString());
    		
    
    		tarefa.setIdUsuario(usuario.getIdUsuario());
    		
    		tarefaDAO.create(tarefa);
    		
    		Alert msgCadastro = new Alert(AlertType.CONFIRMATION);
    		msgCadastro.setTitle("Tarefa cadastrada");
    		msgCadastro.setContentText("A tarefa foi cadastrado com sucesso!");
    		msgCadastro.setHeaderText("Cadastro realizado com sucesso!");
    		msgCadastro.show();
    		
    		Main.TelaCadTarefa();
    		}
    		
    	}else {

    		Alert erroCadastro = new Alert(Alert.AlertType.ERROR);
    		erroCadastro.setTitle("Falha ao cadastrar tarefa");
    		erroCadastro.setContentText("Falha ao cadastrar. verifique se todas as informações foram preenchidas corretamento e tente novamente.");
    		erroCadastro.setHeaderText("Cadastro não realizado");
    		erroCadastro.show();
    		
    	}
    	
    	
    }

    Tarefa tarefaEditar = new Tarefa();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		choiceNivel.getItems().add("Baixo");
		choiceNivel.getItems().add("Médio");
		choiceNivel.getItems().add("Alto");
	
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		choiceUser.setItems(usuarioDAO.readNomeUser());
		
		if(controllerItemTarefa.tarefaEditar!=null) {
			textDescricao.setText(controllerItemTarefa.tarefaEditar.getDescricao());
			textSetor.setText(controllerItemTarefa.tarefaEditar.getSetor());
			TarefaDAO tarefaDAO = new TarefaDAO();
			tarefaEditar = tarefaDAO.search(controllerItemTarefa.tarefaEditar);
		}

		
		
	}

}
