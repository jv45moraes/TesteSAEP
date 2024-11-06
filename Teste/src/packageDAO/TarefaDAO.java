package packageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionFactory;
import packageModel.Tarefa;
import packageModel.Usuario;

public class TarefaDAO {
	public void create(Tarefa tarefa) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("insert into Tarefa values(?, ?, ?, ?, 'A fazer')");
			stmt.setString(1, tarefa.getIdUsuario());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setString(3, tarefa.getSetor());
			stmt.setString(4, tarefa.getNivel());
			
			stmt.executeUpdate();
			System.out.println("Cadastrado com çucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	
	public ArrayList<Tarefa> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Tarefa");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setIdTarefa(rs.getString(1));
				tarefa.setIdUsuario(rs.getString(2));
				tarefa.setDescricao(rs.getString(3));
				tarefa.setSetor(rs.getString(4));
				tarefa.setNivel(rs.getString(5));
				tarefa.setStatusTarefa(rs.getString(6));
				
				tarefas.add(tarefa);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return tarefas;
	}

	public void update(Tarefa tarefa) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("update Tarefa set descricao = ?, setor = ?, "
					+ "nivel = ?, idUsuario = ?  where idTarefa = ?");
			stmt.setString(1, tarefa.getDescricao());
			stmt.setString(2, tarefa.getSetor());
			stmt.setString(3, tarefa.getNivel());
			stmt.setString(4, tarefa.getIdUsuario());
			stmt.setString(5, tarefa.getIdTarefa());
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void updateStatus(Tarefa tarefa) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("update Tarefa set statusTarefa = ?  where idTarefa = ?");
			stmt.setString(1, tarefa.getStatusTarefa());
			stmt.setString(2, tarefa.getIdTarefa());
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
	public void delete(String idTarefa) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("delete from Tarefa where idTarefa = ?");
			stmt.setString(1, idTarefa);
			
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public Tarefa search(Tarefa tarefaS) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Tarefa tarefa = new Tarefa();

		try {
			stmt = con.prepareStatement("SELECT * FROM Tarefa where descricao = ? and setor = ?");
			stmt.setString(1, tarefaS.getDescricao());
			stmt.setString(2, tarefaS.getSetor());
			rs = stmt.executeQuery();

			while(rs.next()) {
				tarefa.setIdTarefa(rs.getString(1));
				tarefa.setIdUsuario(rs.getString(2));
				tarefa.setDescricao(rs.getString(3));
				tarefa.setSetor(rs.getString(4));
				tarefa.setNivel(rs.getString(5));
				tarefa.setStatusTarefa(rs.getString(6));
				
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return tarefa;
	}
	
	
	
}
