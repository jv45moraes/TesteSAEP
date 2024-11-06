package packageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import packageConnection.ConnectionFactory;
import packageModel.Usuario;

public class UsuarioDAO {
	public void create(Usuario usuario) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("insert into Usuario values(?, ?)");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());

			
			stmt.executeUpdate();
			System.out.println("Cadastrado com çucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	
	public ArrayList<Usuario> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Usuario");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return usuarios;
	}

		
	public void update(Usuario usuario) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("update Usuario set nome = ?, email = ? where idUsuario = ?");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	
	public void delete(String idUsuario) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("delete from Usuario where idUsuario = ?");
			stmt.setString(1, idUsuario);
			
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public ObservableList<String> readNomeUser(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ObservableList<String> usuario = FXCollections.observableArrayList();
		
		try {
			stmt = con.prepareStatement("select nome from Usuario");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String user = rs.getString(1);
				usuario.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return usuario;
		
	}
	
	public Usuario searchByNome(String search) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();

		try {
			stmt = con.prepareStatement("SELECT * FROM Usuario where nome = ?");
			stmt.setString(1, search);
			rs = stmt.executeQuery();

			while (rs.next()) {

				usuario.setIdUsuario(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return usuario;
	}
	
	public Usuario searchByID(String search) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();

		try {
			stmt = con.prepareStatement("SELECT * FROM Usuario where idUsuario = ?");
			stmt.setString(1, search);
			rs = stmt.executeQuery();

			while(rs.next()) {
				usuario.setIdUsuario(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return usuario;
	}
	
	
	
}
