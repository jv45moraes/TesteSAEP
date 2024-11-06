package packageController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import packageDAO.UsuarioDAO;
import packageModel.Usuario;

public class controllerCadUsuario {

    @FXML
    private Button btnCadTarefas;

    @FXML
    private Button btnCadUsuario;

    @FXML
    private Button btnGerTarefas;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textNome;

    @FXML
    void btnCadTarefas(ActionEvent event) throws IOException {
    	Main.TelaCadTarefa();
    }

    @FXML
    void btnCadUsuario(ActionEvent event) {
    	
    }

    @FXML
    void btnGerTarefas(ActionEvent event) throws IOException {
    	Main.TelaMain();
    }
    
    @FXML
    void btnCadUser(ActionEvent event) {
    	if(textNome.getText()!= null && textEmail.getText() != null) {
    		if(validarEmail(textEmail.getText())) {
    			
    			Usuario usuario = new Usuario();
    			usuario.setNome(textNome.getText());
    			usuario.setEmail(textEmail.getText());
    			
    			UsuarioDAO usuarioDAO = new UsuarioDAO();
    			usuarioDAO.create(usuario);
    			
    			Alert msgConfirmacao = new Alert(AlertType.CONFIRMATION);
    			msgConfirmacao.setHeaderText("Cadastro realizado!");
    			msgConfirmacao.setTitle("Usuario cadastrado");
    			msgConfirmacao.setContentText("O usuario foi cadastrado com sucesso!");
    			msgConfirmacao.show();
    			
    			textNome.setText("");
    			textEmail.setText("");
    			
    		}else {
    			Alert msgErroEmail = new Alert(AlertType.ERROR);
    			msgErroEmail.setHeaderText("Erro!");
    			msgErroEmail.setTitle("Endereço de email inválido!");
    			msgErroEmail.setContentText("Verifique se o endereço de e-mail está correto e tente novamente!");
    			msgErroEmail.show();
    		}
    		
    		
    	}else {
    		Alert msgErro = new Alert(AlertType.ERROR);
    		msgErro.setHeaderText("Falha ao cadastrar Usuário");
    		msgErro.setTitle("Informações incompletas!");
    		msgErro.setContentText("Verifique se as informações foram preenchidas corretamente e tente novamente!");
    		msgErro.show();
    	}
    	
    }
    
    
    public static boolean validarEmail(String email) {
    	String validador = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    	Pattern pattern = Pattern.compile(validador);
    	Matcher matcher = pattern.matcher(email);
    	
    	
		return matcher.matches();
    }
    
    
    
    
    

}
