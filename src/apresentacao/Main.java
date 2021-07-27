package apresentacao;

import dados.Professor;
import persistencia.ProfessorDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();

        //professorDAO.insert(2, "Matheus", 24, "F-101", "computacao");

        List p = professorDAO.selectAll();

        //System.out.println(p.toString());

        professorDAO.delete(2);

        System.out.println(p.toString());

    }
}
