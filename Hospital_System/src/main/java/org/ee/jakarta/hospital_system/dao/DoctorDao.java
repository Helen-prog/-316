package org.ee.jakarta.hospital_system.dao;

import org.ee.jakarta.hospital_system.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    private Connection conn;

    public DoctorDao(Connection conn) {
        this.conn = conn;
    }

    public boolean registerDoctor(Doctor doctor) {
        boolean flag = false;

        try {
            String sql = "insert into doctor(full_name, dob, qualificetion, specialist, email, mobno, password) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getDob());
            ps.setString(3, doctor.getQualification());
            ps.setString(4, doctor.getSpeciality());
            ps.setString(5, doctor.getEmail());
            ps.setString(6, doctor.getMobNo());
            ps.setString(7, doctor.getPassword());

            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        Doctor doctor = null;

        try {
            String sql = "select * from doctor order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt(1));
                doctor.setFullName(rs.getString(2));
                doctor.setDob(rs.getString(3));
                doctor.setQualification(rs.getString(4));
                doctor.setSpeciality(rs.getString(5));
                doctor.setEmail(rs.getString(6));
                doctor.setMobNo(rs.getString(7));
                doctor.setPassword(rs.getString(8));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        Doctor doctor = null;

        try {
            String sql = "select * from doctor where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt(1));
                doctor.setFullName(rs.getString(2));
                doctor.setDob(rs.getString(3));
                doctor.setQualification(rs.getString(4));
                doctor.setSpeciality(rs.getString(5));
                doctor.setEmail(rs.getString(6));
                doctor.setMobNo(rs.getString(7));
                doctor.setPassword(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    public boolean updateDoctor(Doctor doctor) {
        boolean flag = false;

        try {
            String sql = "update doctor set full_name=?, dob=?, qualificetion=?, specialist=?, email=?, mobno=?, password=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getDob());
            ps.setString(3, doctor.getQualification());
            ps.setString(4, doctor.getSpeciality());
            ps.setString(5, doctor.getEmail());
            ps.setString(6, doctor.getMobNo());
            ps.setString(7, doctor.getPassword());
            ps.setInt(8, doctor.getId());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean deleteDoctor(int id) {
        boolean flag = false;

        try {
            String sql = "delete from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Doctor login(String email, String password) {
        Doctor doctor = null;

        try {
            String sql = "select * from doctor where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt(1));
                doctor.setFullName(rs.getString(2));
                doctor.setDob(rs.getString(3));
                doctor.setQualification(rs.getString(4));
                doctor.setSpeciality(rs.getString(5));
                doctor.setEmail(rs.getString(6));
                doctor.setMobNo(rs.getString(7));
                doctor.setPassword(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public int countDoctor() {
        int count = 0;
        try {
            String sql = "select * from doctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countUser() {
        int count = 0;
        try {
            String sql = "select * from user_dtls";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countAppointment() {
        int count = 0;
        try {
            String sql = "select * from appointment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countSpecialist() {
        int count = 0;
        try {
            String sql = "select * from specialist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countAppointmentByDoctorId(int did) {
        int count = 0;
        try {
            String sql = "select * from appointment where doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean checkOldPassword(int userId, String oldPassword) {
        boolean flag = false;

        try {
            String sql = "select * from doctor where id = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean changePassword(int userId, String newPassword) {
        boolean flag = false;

        try {
            String sql = "update doctor set password = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean editDoctorProfile(Doctor doctor) {
        boolean flag = false;

        try{
            String sql = "update doctor set full_name = ?, dob = ?, qualificetion = ?, specialist = ?," +
                    "email = ?, mobno = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getDob());
            ps.setString(3, doctor.getQualification());
            ps.setString(4, doctor.getSpeciality());
            ps.setString(5, doctor.getEmail());
            ps.setString(6, doctor.getMobNo());
            ps.setInt(7, doctor.getId());

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
