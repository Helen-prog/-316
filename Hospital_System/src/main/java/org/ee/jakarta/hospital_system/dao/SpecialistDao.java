package org.ee.jakarta.hospital_system.dao;

import org.ee.jakarta.hospital_system.entity.Specialist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
