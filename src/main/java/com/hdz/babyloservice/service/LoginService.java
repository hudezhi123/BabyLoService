package com.hdz.babyloservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdz.babyloservice.bean.QLogin;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;
import com.hdz.babyloservice.util.JsonUtils;

public class LoginService extends BaseService {

    public static String doAction(final String appName, final int appType, final String appId, final String userName, final String password)
        throws SQLException {
        boolean isLoginSuccess = false;
        boolean hasData = false;
        final Connection connection = DBUtils.getConnection();
        final String sql = "select " + Constants.USER_NAME + "," + Constants.PASSWORD + " from " + Constants.TB_USER;
        final PreparedStatement statement = connection.prepareStatement(sql);
        final ResultSet resultSet = statement.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                final String user = resultSet.getString(Constants.USER_NAME);
                final String pass = resultSet.getString(Constants.PASSWORD);
                if (user.equals(userName) && pass.equals(password)) {
                    isLoginSuccess = true;
                    break;
                }
            }
        }
        if (isLoginSuccess) {
            final String sql_ = "select * from " + Constants.TB_APP + " where " + Constants.APP_NAME + "='" + appId + "' and "
                + Constants.APP_TYPE + "=" + appType + " and " + Constants.APP_APPID + "='" + appId + "';";
            final PreparedStatement sta_ = connection.prepareStatement(sql_);
            final ResultSet res_ = sta_.executeQuery();
            final QLogin loginInfo = new QLogin();
            while (res_.next()) {
                final String versionName = res_.getString(Constants.APP_VERSION_NAME);
                final int versionCode = res_.getInt(Constants.APP_VERSION_CODE);
                final String apkUrl = res_.getString(Constants.APP_APK_URL);
                final boolean isForce = res_.getInt(Constants.APP_FORCE_STATUS) == 0;
                final String tips = res_.getString(Constants.APP_TIPS);
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
                return JsonUtils.createBaseJson(Constants.CODE_SUCCESS, loginInfo, Constants.TIPS_LOGIN_SUCCESS);
            } else {
                return JsonUtils.createBaseJson(Constants.CODE_SUCCESS, null, Constants.TIPS_LOGIN_SUCCESS);
            }
        } else {
            DBUtils.release(connection, statement, resultSet);
            return JsonUtils.createBaseJson(Constants.CODE_SUCCESS, null, Constants.TIPS_LOGIN_NO_SUCH_USER);
        }

    }
}
