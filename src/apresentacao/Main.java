package apresentacao;

import dados.Departamento;
import dados.EstudantePos;
import dados.Professor;
import persistencia.DepartamentoDAO;
import persistencia.EstudantePosDAO;
import persistencia.ProfessorDAO;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
//        professorDAO.insert(2, "Matheus", 24, "F-101", "computacao");

//
//        System.out.println(p.toString());
//
//        professorDAO.delete(2);
//
//        System.out.println(p.toString());
//
//        DepartamentoDAO departamentoDAO = DepartamentoDAO.getInstance();
//        Departamento d = departamentoDAO.select(1);
//        System.out.println(d.toString());
//
//        departamentoDAO.insert(4, "dep4", "escrt4", 1);
//        departamentoDAO.delete(4);
//        List d = departamentoDAO.selectAll();
//        System.out.println(d.toString());

//        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
//        EstudantePos estudantePos = estudantePosDAO.select(1);
//        System.out.println(estudantePos.toString());

//        estudantePosDAO.insert(4, "ALuno4", 18, "Tipo_curso_1", 1, 1);

//        estudantePosDAO.delete(4);
//        List e = estudantePosDAO.selectAll();
//        System.out.println(e.toString());

//        ViewProfessor viewProfessor = new ViewProfessor();
//        ViewEstudantePos viewEstudantePos = new ViewEstudantePos();
//        ViewDepartamento viewDepartamento = new ViewDepartamento();
//        ViewInsertProfessor viewInsertProfessor = new ViewInsertProfessor();
        new ViewMain();
//        new ViewInsertDepartamento();
//        new ViewInsertEstudantePos();
    }
}
