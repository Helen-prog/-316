package org.ee.jakarta.hospital_system.dao;

import org.ee.jakarta.hospital_system.entity.Specialist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDao {
    private Connection con;

    public SpecialistDao(Connection con) {
        this.con = con;
    }

    public boolean addSpecialist(String spec) {
        boolean flag = false;

        try{
            String sql = "insert into specialist(spec_name) values(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, spec);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Specialist> getAllSpecialist() {
        List<Specialist> list = new ArrayList<Specialist>();
        Specialist specialist = null;

        try{
            String sql = "select * from specialist";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                specialist = new Specialist();
                specialist.setId(rs.getInt(1));
                specialist.setSpecialistName(rs.getString(2));
                list.add(specialist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
