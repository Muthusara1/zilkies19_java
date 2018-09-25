package io.ztech.autorate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.ztech.autorate.beans.Specification;
import io.ztech.autorate.beans.Statistics;
import io.ztech.autorate.constants.SQLConstants;
import io.ztech.autorate.dbutils.DBUtils;

public class AddStatisticsDAO {
	private Connection con = null;
	private PreparedStatement pst = null;

	public boolean addStatistics(Specification specification, Statistics statistics) throws SQLException {
		try {
			con = DBUtils.getConnection();
			pst = con.prepareStatement(SQLConstants.INSERT_STATISTICS);
			pst.setInt(1, specification.getCarId());
			pst.setInt(2, statistics.getStatisticsYear());
			pst.setInt(3, statistics.getSaleCount());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			DBUtils.closeConnection(con, pst, null);
		}
		return true;
	}
}
