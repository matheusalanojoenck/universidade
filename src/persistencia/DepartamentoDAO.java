package persistencia;

import dados.Departamento;
import dados.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    private static DepartamentoDAO instance = null;
    private PreparedStatement selectDepartamento;
    private PreparedStatement selectAllDepartamento;
    private PreparedStatement insertDepartamento;
    private PreparedStatement deleteDepartamento;
    private PreparedStatement updateDepartamento;

    public static DepartamentoDAO getInstance() {
        if (instance == null) instance = new DepartamentoDAO();
        return instance;
    }

    private DepartamentoDAO(){
        Connection connection = DBConnection.getConnection();
        try {
            selectDepartamento = connection.prepareStatement(
                    "SELECT * " +
                        "FROM departamento " +
                        "WHERE num_dep = ?");

            selectAllDepartamento = connection.prepareStatement(
                    "SELECT * " +
                        "FROM departamento");

            insertDepartamento = connection.prepareStatement(
                    "INSERT INTO departamento (num_dep, nome, escritorio, mat_prof)" +
                        "VALUES (?, ?, ?, ?)");

            deleteDepartamento = connection.prepareStatement(
                    "DELETE FROM departamento " +
                        "WHERE num_dep = ?");

            updateDepartamento = connection.prepareStatement(
                    "UPDATE departamento " +
                            "SET nome = ?," +
                                "escritorio = ?," +
                                "mat_prof = ? " +
                            "WHERE num_dep = ?"
            );

        } catch (SQLException  | NullPointerException e){
            e.printStackTrace();
            //System.out.println(e.toString());
        }
    }

    public Departamento select(int num_dep) {
        Departamento d = null;
        ResultSet rs;
        try {
            selectDepartamento.setInt(1, num_dep);
            rs = selectDepartamento.executeQuery();
            if (rs.next()){
                d = new Departamento();
                d.setNum_dep(rs.getInt("num_dep"));
                d.setNome(rs.getString("nome"));
                d.setEscritorio(rs.getString("escritorio"));
                d.setMat_prof(rs.getInt("mat_prof"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }
    public List<Departamento> selectAll(){
        List<Departamento> departamentos = new ArrayList<>();
        ResultSet rs;

        try{
            rs = selectAllDepartamento.executeQuery();
            while (rs.next()){
                departamentos.add(select(rs.getInt(1)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    public boolean insert(int num_dep, String nome, String escritorio, int mat_prof){
        try {
            insertDepartamento.setInt(1, num_dep);
            insertDepartamento.setString(2, nome);
            insertDepartamento.setString(3, escritorio);
            insertDepartamento.setInt(4, mat_prof);

            insertDepartamento.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int num_dep){
        try {
            deleteDepartamento.setInt(1, num_dep);
            deleteDepartamento.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int num_dep, String nome, String escritorio, int mat_prof){
        try {
            updateDepartamento.setString(1, nome);
            updateDepartamento.setString(2, escritorio);
            updateDepartamento.setInt(3, mat_prof);
            updateDepartamento.setInt(4, num_dep);
            updateDepartamento.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
