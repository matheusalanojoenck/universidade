package apresentacao;

import dados.Departamento;
import dados.Professor;
import persistencia.DepartamentoDAO;
import persistencia.ProfessorDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        DepartamentoDAO departamentoDAO = DepartamentoDAO.getInstance();

//        professorDAO.insert(2, "Matheus", 24, "F-101", "computacao");
//
//        List p = professorDAO.selectAll();
//
//        System.out.println(p.toString());
//
//        professorDAO.delete(2);
//
//        System.out.println(p.toString());

//        Departamento d = departamentoDAO.select(1);
//        System.out.println(d.toString());

//        departamentoDAO.insert(4, "dep4", "escrt4", 1);
        departamentoDAO.delete(4);
        List d = departamentoDAO.selectAll();
        System.out.println(d.toString());

    }
}
