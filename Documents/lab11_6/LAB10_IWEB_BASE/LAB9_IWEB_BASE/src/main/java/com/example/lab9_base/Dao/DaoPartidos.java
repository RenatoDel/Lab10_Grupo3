package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Partido;

import java.sql.*;
import java.util.ArrayList;

public class DaoPartidos extends DaoBase{
    public ArrayList<Partido> listaDePartidos() {

        ArrayList<Partido> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from partido")) {

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                partido.setFecha(rs.getString(2));
                partido.setNumeroJornada(rs.getInt(3));
                list.add(partido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return list;
    }

    public void crearPartido(String part, String jobTitle, int minSalary, int maxSalary) {
        String sql = "INSERT INTO Partido (IdPartido,job_title,min_salary,max_salary) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, part);
            pstmt.setString(2, jobTitle);
            pstmt.setInt(3, minSalary);
            pstmt.setInt(4, maxSalary);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Partido obtenerTrabajo(String IdPartido) {


        Partido partido = null;

        String sql = "SELECT * FROM jobs WHERE idPartido = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, IdPartido);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    partido = new Partido();
                    partido.setSeleccionLocal(rs.getString(1));
                    partido.setJobTitle(rs.getString(2));
                    partido.setMinSalary(rs.getInt(3));
                    partido.setMaxSalary(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return job;

        return partido;
    }
    public void guardarPartido(Partido partido) {

        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setPartidoData(partido, pstmt);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void setPartidoData(Partido partido, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, partido.getIdPartido());
        pstmt.setString(2, partido.getSeleccionLocal());
        pstmt.setString(3, partido.getSeleccionVisitante());
        pstmt.setString(4, partido.getArbitro());
        pstmt.setString(5, partido.getFecha());
        pstmt.setString(6, partido.getNumeroJornada());
        }
    }
}
