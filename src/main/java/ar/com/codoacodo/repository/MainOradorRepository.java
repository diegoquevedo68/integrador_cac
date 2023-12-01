package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {

	 public static void main(String[] args) {
		
		 //Interface i = new ClaseQueImplementa();
		 OradorRepository repository = new MySqlOradorRepository();
		 
//		 Orador newOrador = new Orador("carlos", "lopez", "email@email.com", "java", LocalDate.now());
//		 repository.save(newOrador);
		 
		 Orador newOrador = repository.getById(3L);
		 System.out.println(newOrador);
		 
		 /*
		 AdministradorDeConexiones adm_con = new AdministradorDeConexiones();
		 adm_con.getConnection();
		 */
		 
		 /*
			String sql = "delete from oradores where id_orador = ?";
			
			//try with resources
			try(Connection con = AdministradorDeConexiones.getConnection()) {
				
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setLong(1, newOrador.getId());
				statement.executeUpdate();
			}catch (Exception e) {
				throw new IllegalArgumentException("No se pudo eliminar el orador:", e);
			}
			*/
	}
}