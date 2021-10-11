package com.hdz.babyloservice.service;

import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;
import com.hdz.babyloservice.util.JsonUtils;
import com.hdz.babyloservice.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;


public class RegisterService extends BaseService {

	public String doAction(String userName, String password) throws SQLException {
		// TODO Auto-generated method stub
		String check_sql = "select " + Constants.USER_ID + "," + Constants.USER_NAME + "," + Constants.PASSWORD
				+ " from " + Constants.TB_USER + ";";
		Connection conn = DBUtils.getConnection();
		PreparedStatement sta_search = conn.prepareStatement(check_sql);
		ResultSet res_search = sta_search.executeQuery();
		if (res_search != null) {
			while (res_search.next()) {
				String name = res_search.getString(Constants.USER_NAME);
				String pass = res_search.getString(Constants.PASSWORD);
				if (!StringUtils.IsEmpty(name) && !StringUtils.IsEmpty(pass)) {
					if (name.equals(userName)) {
						return JsonUtils.createBaseJson(0, false, Constants.TIPS_RESITER_NAME_DULPLICATE);
					}
				}
			}
		}
		DBUtils.release(null, sta_search, res_search);
		String userId = UUID.randomUUID().toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String createTime = format.format(System.currentTimeMillis());
		String sql_insert = "insert into " + Constants.TB_USER + "(" + Constants.USER_ID + "," + Constants.USER_NAME
				+ "," + Constants.PASSWORD + "," + Constants.LOGIN_STATUS + "," + Constants.LOGIN_TIME + ")values('"
				+ userId + "','" + userName + "','" + password + "'," + 0 + ",'" + createTime + "');";
		PreparedStatement sta_insert = conn.prepareStatement(sql_insert);
		try {
			sta_insert.execute();
			return JsonUtils.createBaseJson(0, true, Constants.TIPS_REGISTER_SUCCESS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return JsonUtils.createBaseJson(0, false, Constants.TIPS_REGISTER_FAIL);
		} finally {
			DBUtils.release(conn, sta_insert, null);
		}

	}

}
