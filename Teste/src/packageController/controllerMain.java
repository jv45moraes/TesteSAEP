package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import packageDAO.TarefaDAO;
import packageModel.Tarefa;

public class controllerMain implements Initializable{

    @FXML
    private Button btnCadTarefas;

    @FXML
    private Button btnCadUsuario;

    @FXML
    private Button btnGerTarefas;

    @FXML
    private GridPane gridAFazer;

    @FXML
    private GridPane gridFazendo;

    @FXML
    private GridPane gridPronto;

    @FXML
    private ScrollPane scrolAfazer;

    @FXML
    private ScrollPane scrolFazendo;

    @FXML
    private ScrollPane scroolPronto;
    
    @FXML
    void btnCadTarefas(ActionEvent event) throws IOException {
    	Main.TelaCadTarefa();
    }

    @FXML
    void btnCadUsuario(ActionEvent event) throws IOException {
    	Main.TelaCadUsuario();
    }

    @FXML
    void btnGerTarefas(ActionEvent event) throws IOException {
    	Main.TelaMain();
    }
    
    
    private List<Tarefa> tarefas = new ArrayList<>();
    TarefaDAO tarefaDAO = new TarefaDAO();
    
    private void Iniciar() {
    	tarefas.addAll(tarefaDAO.read());
    	int column = 0;
    	int row = 0;
    	try {
    		
    		for(int i = 0; i < tarefas.size(); i++) {
    			
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("/packageView/viewItemTarefa.fxml"));
		AnchorPane pane = fxmlLoader.load();
		controllerItemTarefa controllerTarefa = fxmlLoader.getController();
		controllerTarefa.setData(tarefas.get(i));
		
		Tarefa tarefa = new Tarefa();
		tarefa = tarefas.get(i);
		
		if(tarefa.getStatusTarefa().equals("A fazer")) {
			gridAFazer.add(pane, column, row++);
			GridPane.setMargin(pane, new Insets(10));
			
		}else if(tarefa.getStatusTarefa().equals("Fazendo")) {
			gridFazendo.add(pane, column, row++);
			GridPane.setMargin(pane, new Insets(10));
			
		}else if(tarefa.getStatusTarefa().equals("Pronto")) {
			gridPronto.add(pane, column, row++);
			GridPane.setMargin(pane, new Insets(10));
		}
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Iniciar();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
