package com.hdz.babyloservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;

public class AnimalService extends BaseService {
    public void doAction() throws SQLException {
        final Connection conn = DBUtils.getConnection();
        final String sql = "select * from " + Constants.TB_ANIMAL;
        final PreparedStatement stat = conn.prepareStatement(sql);
        final ResultSet reset = stat.executeQuery();
        while (reset.next()) {
            final int imgCount = reset.getInt(Constants.ANIMAL_IMG_COUNT);
            reset.getString(Constants.ANIMAL_NAME);
            reset.getString(Constants.ANIMAL_EN_NAME);
            reset.getString(Constants.ANIMAL_DESC);

        }
    }

}
