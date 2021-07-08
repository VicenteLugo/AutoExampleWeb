/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.AutoBean;
import conexionBD.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LugoD
 */
public class AutoDao {

    public boolean registrarAuto(AutoBean datos) {
        boolean status = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO auto (nombre,modelo,marca) "
                    + " VALUES (?,?,?) ";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, datos.getNombre());
            pstm.setInt(2, datos.getModelo());
            pstm.setString(3, datos.getMarca());
            if (pstm.executeUpdate() == 1) {
                status = true;
            }

            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

    public boolean ActualizarAutos(AutoBean datos) {
        boolean TF = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE agenda SET apellido=?, nombre=?, domicilio=?, Telefono=? WHERE clave=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, datos.getNombre());
            pstm.setInt(2, datos.getModelo());
            pstm.setString(3, datos.getMarca());
            pstm.setInt(4, datos.getClave());

            if (pstm.executeUpdate() == 1) {
                TF = true;
            }

            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TF;
    }

    public List<AutoBean> consultarAutos() {
        List<AutoBean> autos = new ArrayList<AutoBean>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "select * from auto";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                AutoBean auto = new AutoBean();
                auto.setClave(res.getInt(1));
                auto.setNombre(res.getString(2));
                auto.setModelo(res.getInt(3));
                auto.setMarca(res.getString(4));
                autos.add(auto);
            }

            res.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autos;
    }

    public AutoBean consultarAutosId(int id) {
        AutoBean auto = new AutoBean();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "select * from auto where clave=" + id + "";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {

                auto.setClave(id);
                auto.setNombre(res.getString(2));
                auto.setModelo(res.getInt(3));
                auto.setMarca(res.getString(4));
            }

            res.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auto;
    }

    public boolean EliminarAuto(int codigo) {
        boolean TF = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "delete from auto where clave=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, codigo);
            if (pstm.executeUpdate() == 1) {
                TF = true;
            }
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TF;
    }
}
