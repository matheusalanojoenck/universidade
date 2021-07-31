package persistencia;

import dados.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private static ProfessorDAO instance = null;
    private PreparedStatement selectProfessor;
    private PreparedStatement selectAllProfessor;
    private PreparedStatement insertProfessor;
    private PreparedStatement deleteProfessor;
    private PreparedStatement updateProfessor;

    public static ProfessorDAO getInstance() {
        if (instance == null) instance = new ProfessorDAO();
        return instance;
    }

    private ProfessorDAO(){
        Connection connection = DBConnection.getConnection();
        try {
            selectProfessor = connection.prepareStatement(
                    "SELECT * " +
                        "FROM professor " +
                        "WHERE mat_prof = ?");

            selectAllProfessor = connection.prepareStatement(
                    "SELECT * " +
                        "FROM professor");

            insertProfessor = connection.prepareStatement(
                    "INSERT INTO professor (mat_prof, nome, idade, sala, especialidade)" +
                        "VALUES (?, ?, ?, ?, ?)");

            deleteProfessor = connection.prepareStatement(
                    "DELETE FROM professor " +
                        "WHERE mat_prof = ?");

            updateProfessor = connection.prepareStatement(
                    "UPDATE professor " +
                            "SET nome = ?," +
                                "idade = ?," +
                                "sala = ?," +
                                "especialidade = ? " +
                            "WHERE mat_prof = ?"
            );



        } catch (SQLException  | NullPointerException e){
            e.printStackTrace();
            //System.out.println(e.toString());
        }
    }

    public Professor select(int mat_prof) {
        Professor p = null;
        ResultSet rs;
        try {
            selectProfessor.setInt(1, mat_prof);
            rs = selectProfessor.executeQuery();
            if (rs.next()){
                p = new Professor();
                p.setMat_prof(rs.getInt("mat_prof"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setSala(rs.getString("sala"));
                p.setEspecialidade(rs.getString("especialidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public List<Professor> selectAll(){
        List<Professor> professores = new ArrayList<>();
        ResultSet rs;

        try{
            rs = selectAllProfessor.executeQuery();
            while (rs.next()){
                professores.add(select(rs.getInt(1)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public boolean insert(int mat_prof, String nome, int idade, String sala, String especialidade){
        try {
            insertProfessor.setInt(1, mat_prof);
            insertProfessor.setString(2, nome);
            insertProfessor.setInt(3, idade);
            insertProfessor.setString(4, sala);
            insertProfessor.setString(5, especialidade);

            insertProfessor.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int mat_prof){
        try {
            deleteProfessor.setInt(1, mat_prof);
            deleteProfessor.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int mat_prof, String nome, int idade, String sala, String especialidade){
        try {
            updateProfessor.setString(1, nome);
            updateProfessor.setInt(2, idade);
            updateProfessor.setString(3, sala);
            updateProfessor.setString(4, especialidade);
            updateProfessor.setInt(5, mat_prof);

            updateProfessor.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
