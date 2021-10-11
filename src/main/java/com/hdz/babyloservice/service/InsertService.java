package com.hdz.babyloservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdz.babyloservice.bean.Data;
import com.hdz.babyloservice.doc.Content;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;

public class InsertService extends BaseService {
    public static void doAction() throws SQLException {
        final JSONObject obj = JSON.parseObject(Content.content);
        final List<Data> dataList = JSON.parseArray(obj.getString("data"), Data.class);
        System.out.println(dataList.size());
        final Connection conn = DBUtils.getConnection();

        // final String sql = "insert into " + Constants.TB_ANIMAL + "(" + Constants.ANIMAL_ID + ","
        // + Constants.ANIMAL_NAME + "," + Constants.ANIMAL_DESC + "," + Constants.ANIMAL_EN_NAME + ","
        // + Constants.ANIMAL_IMG_COUNT + ") values(?,?,?,?,?)";

        final String sql =
            "insert into " + Constants.TB_ANIMAL + "(" + Constants.ANIMAL_NAME + "," + Constants.ANIMAL_DESC + ","
                + Constants.ANIMAL_EN_NAME + "," + Constants.ANIMAL_IMG_COUNT + ") values(?,?,?,?)";
        System.out.println(sql);
        final PreparedStatement statement = conn.prepareStatement(sql);
        for (final Data data : dataList) {
            // final String animalId = UUID.randomUUID().toString();
            // statement.setString(1, animalId);
            // statement.setString(2, data.getName());
            // statement.setString(3, data.getDesc());
            // statement.setString(4, data.getImage());
            // statement.setInt(5, data.getImageCount());

            statement.setString(1, data.getName());
            statement.setString(2, data.getDesc());
            statement.setString(3, data.getImage());
            statement.setInt(4, data.getImageCount());
            statement.addBatch();
        }
        statement.executeBatch();
        DBUtils.release(conn, statement, null);
    }
}
