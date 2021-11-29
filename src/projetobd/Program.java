package projetobd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projetobd.dbconfig.DBconfig;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DBconfig.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select "
								+ "cl.id, cl.nome, cl.cpf "
								+ "from "
								+ "tb_client cl");
			
			System.out.println("---- Lista de Pessoas ----\n");
			
			while (rs.next()) {
				System.out.println("[id= "+rs.getInt("id")
									+ ", nome= "
									+ rs.getString("nome")
									+", cpf= "
									+ rs.getString("cpf")
									+" ]");
			}
		  }
			catch(SQLException e) {
				e.printStackTrace();
			}
		System.out.println("\n---------------------------------------------------");
		DBconfig.closeConnection();
	}

}
