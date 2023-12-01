package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MySqlOradorRepository implements OradorRepository {

	@Override
	public void save(Orador orador) {
		// get del orador para obtener datos

		// 1 - obtener conexion
		Connection con = AdministradorDeConexiones.getConnection();

		// 2 - preparo sql: sql injeciton!
		String sql = "insert into oradores (nombre, apellido, tema, email, fecha_alta) values (?,?,?,?,?)";

		try {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getTema());
			statement.setString(4, orador.getMail());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));// tph: ver como pasar de LocalDate a
																				// java.sql.Date

			statement.executeUpdate();// INSERT/UPDATE/DELETE

			ResultSet res = statement.getGeneratedKeys();
			if (res.next()) {
				Long id = res.getLong(1);// aca esta el id
				orador.setId(id);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
	}

	@Override
	public Orador getById(Long id) {
		Connection con = AdministradorDeConexiones.getConnection();

		String sql = "select id_orador, nombre, apellido, tema, mail, fecha_alta from oradores where id_orador = ?";

		Orador orador = null;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet res = statement.executeQuery();// SELECT

			if (res.next()) {
				Long dbId = res.getLong(1);  
				String nombre = res.getString(2);  
				String apellido = res.getString(3);  
				String tema = res.getString(4);  
				String email = res.getString(5);  
				Date fechaAlta = res.getDate(6);  
				
			orador = new Orador(dbId, nombre, apellido, email, tema,LocalDate.now());//tph: !!!
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		return orador;
	}

	@Override
	public void update(Orador orador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Orador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}