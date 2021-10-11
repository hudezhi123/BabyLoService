package com.hdz.babyloservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hdz.babyloservice.bean.Animal;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.DBUtils;
import com.hdz.babyloservice.util.JsonUtils;

public class AnimalService extends BaseService {

    public static String doAction() throws SQLException {
        final Connection conn = DBUtils.getConnection();
        final String sql = "select * from " + Constants.TB_ANIMAL;
        final PreparedStatement stat = conn.prepareStatement(sql);
        final ResultSet reset = stat.executeQuery();
        final ArrayList<Animal> animalList = new ArrayList<>();
        while (reset.next()) {
            final int imgCount = reset.getInt(Constants.ANIMAL_IMG_COUNT);
            final String enName = reset.getString(Constants.ANIMAL_EN_NAME);
            final List<String> imgList = new ArrayList<>();
            for (int i = 1; i <= imgCount; i++) {
                imgList.add(Constants.IMG_DIR + enName + i + ".jpeg");
            }
            animalList.add(new Animal(reset.getString(Constants.ANIMAL_NAME), reset.getString(Constants.ANIMAL_DESC),
                enName, imgList));
        }
        DBUtils.release(conn, stat, reset);
        return JsonUtils.createBaseJson(0, animalList, Constants.TAG_ANIMAL);
    }

}
