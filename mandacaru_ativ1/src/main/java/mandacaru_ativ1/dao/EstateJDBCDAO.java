package mandacaru_ativ1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mandacaru_ativ1.entities.Estate;

public class EstateJDBCDAO implements EstateDAO{
	@Override
	public void save(Estate entity) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			//title, address, area, areaBuilt, rooms, bathrooms, parking_spaces, price
			String insert_sql = "insert into estates (title, address, area, areaBuilt, rooms, bathrooms,"
					+" parking_spaces, price) values (?, ?, ?, ?, ?, ?, ?, ?)";
			String update_sql = "update estates set title = ?, address = ?, area = ?, areaBuilt = ?, rooms = ?,"
					+" bathrooms = ?, parking_spaces = ?, price = ? where id = ?";
			PreparedStatement pst;
			if (entity.getId() == 0) {
				pst = con.prepareStatement(insert_sql);
			} else {
				pst = con.prepareStatement(update_sql);
				pst.setInt(9, entity.getId());
			}
			pst.setString(1, entity.getTitle());
			pst.setString(2, entity.getAddress());
			pst.setDouble(3, entity.getArea());
			pst.setDouble(4, entity.getAreaBuilt());
			pst.setInt(5, entity.getRooms());
			pst.setInt(6, entity.getBathrooms());
			pst.setInt(7, entity.getParking_spaces());
			pst.setDouble(8, entity.getPrice());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from estates where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Estate find(int id) {
		Connection con = null;
		Estate est = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from estates where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				est = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return est;
	}

	@Override
	public List<Estate> findAll() {
		Connection con = null;
		List<Estate> result = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from estates";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Estate>();
			while (rs.next()) {
				Estate cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Estate findByName(String str) {
		Connection con = null;
		Estate est = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from estates where title = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, str);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				est = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return est;

	}

	@Override
	public List<Estate> findAllByName(String str) {
		Connection con = null;
		List<Estate> result = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from estates where title = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, str);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Estate>();
			while (rs.next()) {
				Estate cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//title, address, area, areaBuilt, rooms, bathrooms, parking_spaces, price
	private Estate map(ResultSet rs) throws SQLException {
		Estate est = new Estate();
		est.setId(rs.getInt("id"));
		est.setTitle(rs.getString("title"));
		est.setAddress(rs.getString("address"));
		est.setArea(rs.getDouble("area"));
		est.setAreaBuilt(rs.getDouble("areaBuilt"));
		est.setRooms(rs.getInt("rooms"));
		est.setBathrooms(rs.getInt("bathrooms"));
		est.setParking_spaces(rs.getInt("parking_spaces"));
		est.setPrice(rs.getDouble("price"));
		return est;
	}
}
