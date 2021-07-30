package persistencia;

import dados.Departamento;
import dados.EstudantePos;
import dados.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudantePosDAO {
    private static EstudantePosDAO instance = null;
    private PreparedStatement selectEstudantePos;
    private PreparedStatement selectAllEstudantePos;
    private PreparedStatement insertEstudantePos;
    private PreparedStatement deleteEstudantePos;

    public static EstudantePosDAO getInstance() {
        if (instance == null) instance = new EstudantePosDAO();
        return instance;
    }

    private EstudantePosDAO() {
        Connection connection = DBConnection.getConnection();
        try {
            selectEstudantePos = connection.prepareStatement(
                    "SELECT * " +
                            "FROM estudante_pos " +
                            "WHERE mat_est = ?");

            selectAllEstudantePos = connection.prepareStatement(
                    "SELECT * " +
                            "FROM estudante_pos");

            insertEstudantePos = connection.prepareStatement(
                    "INSERT INTO estudante_pos (mat_est, nome, idade, tipo_curso, num_dep, mat_est_aconselhador)" +
                            "VALUES (?, ?, ?, ?, ?, ?)");

            deleteEstudantePos = connection.prepareStatement(
                    "DELETE FROM estudante_pos " +
                            "WHERE mat_est = ?");

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            //System.out.println(e.toString());
        }
    }

    public EstudantePos select(int mat_est) {
        EstudantePos est = null;
        ResultSet rs;
        try {
            selectEstudantePos.setInt(1, mat_est);
            rs = selectEstudantePos.executeQuery();
            if (rs.next()) {
                est = new EstudantePos();
                est.setMat_est(rs.getInt("mat_est"));
                est.setNome(rs.getString("nome"));
                est.setIdade(rs.getInt("idade"));
                est.setTipo_curso(rs.getString("tipo_curso"));
                est.setNum_dep(rs.getInt("num_dep"));
                est.setMat_est_aconselhador(rs.getInt("mat_est_aconselhador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return est;
    }


    public List<EstudantePos> selectAll(){
        List<EstudantePos> estudantesPos = new ArrayList<>();
        ResultSet rs;

        try{
            rs = selectAllEstudantePos.executeQuery();
            while (rs.next()){
                estudantesPos.add(select(rs.getInt(1)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantesPos;
    }

    public boolean insert(int mat_est, String nome, int idade,  String tipo_curso, int num_dep,int mat_est_aconselhador){
        try {
            insertEstudantePos.setInt(1, mat_est);
            insertEstudantePos.setString(2, nome);
            insertEstudantePos.setInt(3, idade);
            insertEstudantePos.setString(4, tipo_curso);
            insertEstudantePos.setInt(5, num_dep);
            insertEstudantePos.setInt(6, mat_est_aconselhador);

            insertEstudantePos.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(int mat_est){
        try {
            deleteEstudantePos.setInt(1, mat_est);

            deleteEstudantePos.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
