package pe.edu.upeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.dao.FacultadDao;
import pe.edu.upeu.entity.Facultad;

public class FacultadDaoImpl implements FacultadDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;

	@Override
	public int create(Facultad t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO facultad (nombre) VALUES(?)";
		int x = 0;
		try {
			cx = pe.edu.upeu.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombre());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return x;
	}

	@Override
	public int update(Facultad t) {
		// TODO Auto-generated method stub
				String SQL = "UPDATE facultad SET nombre=? WHERE idfacultad=?";
				int x = 0;
				try {
					cx = pe.edu.upeu.config.Conexion.getConexion();
					ps = cx.prepareStatement(SQL);
					ps.setString(1, t.getNombre());
					ps.setInt(2, t.getIdfacultad());
					x = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("Error: " + e);
				}
				return x;
	}

	@Override
	public int delete(int id) {
		String SQL = "DELETE FROM facultad WHERE idfacultad=?";
		int x = 0;
		try {
			cx = pe.edu.upeu.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return x;
	}

	@Override
	public Facultad read(int id) {
		String SQL = "SELECT * FROM facultad WHERE idfacultad=?";
		int x = 0;
		Facultad esc = new Facultad();
		try {
			cx = pe.edu.upeu.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				esc.setIdfacultad(rs.getInt("idfacultad"));
				esc.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return esc;
	}

	@Override
	public List<Facultad> readAll() {
		String SQL = "SELECT * FROM facultad ORDER BY idfacultad";
		int x = 0;
		List<Facultad> lista = new ArrayList<>();
		try {
			cx = pe.edu.upeu.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Facultad esc = new Facultad();
				esc.setIdfacultad(rs.getInt("idfacultad"));
				esc.setNombre(rs.getString("nombre"));
				lista.add(esc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return lista;
	}
}
