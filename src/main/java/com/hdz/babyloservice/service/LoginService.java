package com.hdz.babyloservice.service;

import com.hdz.babyloservice.bean.QLogin;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;
import com.hdz.babyloservice.util.JsonUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginService extends BaseService {

	public static String doAction(String appName, int appType, String appId, String userName, String password)
			throws SQLException {
		boolean isLoginSuccess = false;
		boolean hasData = false;
		Connection connection = DBUtils.getConnection();
		String sql = "select " + Constants.USER_NAME + "," + Constants.PASSWORD + " from " + Constants.TB_USER;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet != null) {
			while (resultSet.next()) {
				String user = resultSet.getString(Constants.USER_NAME);
				String pass = resultSet.getString(Constants.PASSWORD);
				if (user.equals(userName) && pass.equals(password)) {
					isLoginSuccess = true;
					break;
				}
			}
		}
		if (isLoginSuccess) {
			String sql_ = "select * from " + Constants.TB_APP + " where " + Constants.APP_NAME + "='" + appId + "' and "
					+ Constants.APP_TYPE + "=" + appType + " and " + Constants.APP_APPID + "='" + appId + "';";
			PreparedStatement sta_ = connection.prepareStatement(sql_);
			ResultSet res_ = sta_.executeQuery();
			QLogin loginInfo = new QLogin();
			while (res_.next()) {
				String versionName = res_.getString(Constants.APP_VERSION_NAME);
				int versionCode = res_.getInt(Constants.APP_VERSION_CODE);
				String apkUrl = res_.getString(Constants.APP_APK_URL);
				boolean isForce = res_.getInt(Constants.APP_FORCE_STATUS) == 0;
				String tips = res_.getString(Constants.APP_TIPS);
				loginInfo.setApkUrl(apkUrl);
				loginInfo.setAppName(appName);
				loginInfo.setAppType(appType);
				loginInfo.setForceStatus(isForce);
				loginInfo.setTips(tips);
				loginInfo.setVersionCode(versionCode);
				loginInfo.setVersionName(versionName);
				hasData = true;
			}
			DBUtils.release(connection, sta_, res_);
			if (hasData) {
				return JsonUtils.createBaseJson(0, loginInfo, Constants.TIPS_LOGIN_SUCCESS);
			} else {
				return JsonUtils.createBaseJson(0, null, Constants.TIPS_LOGIN_SUCCESS);
			}
		} else {
			DBUtils.release(connection, statement, resultSet);
			return JsonUtils.createBaseJson(0, null, Constants.TIPS_LOGIN_NO_SUCH_USER);
		}

	}
}
