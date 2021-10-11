package com.hdz.babyloservice.service;

import com.hdz.babyloservice.bean.QProtocol;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;
import com.hdz.babyloservice.util.JsonUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProtocolService {

	public static String doAction(int type) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "select * from " + Constants.TB_PROTOCOL + ";";
		PreparedStatement sta = conn.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
		while (res.next()) {
			if (res.getInt(Constants.PROTOCOL_TYPE) == type) {
				String name = res.getString(Constants.PROTOCOL_NAME);
				int id = res.getInt(Constants.PROTOCOL_ID);
				String url = res.getString(Constants.PROTOCOL_URL);
				String title = res.getString(Constants.PROTOCOL_TITLE);
				String author = res.getString(Constants.PROTOCOL_AUTHOR);
				String createTime = res.getString(Constants.PROTOCOL_CREATETIME);
				QProtocol protocol = new QProtocol(id, name, type, url, title, author, createTime);
				return JsonUtils.createBaseJson(0, protocol, Constants.TIPS_PROTOCOL_SUCCESS);
			}
		}
		return JsonUtils.createBaseJson(0, null, Constants.TIPS_PROTOCOL_FAIL);
	}
}
