package apresentacao;

import dados.Professor;
import persistencia.ProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewProfessor extends JFrame {
    public ViewProfessor(){
        String[] colums = new String[]{
            "mat_prof", "nome", "idade", "sala", "especiliadade"
        };
        DefaultTableModel model = new DefaultTableModel(0, colums.length);
        model.setColumnIdentifiers(colums);
        JTable table = new JTable(model);

        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        List<Professor> professores = professorDAO.selectAll();

        professores.forEach(professor ->{
            model.addRow(new Object[]{
                    professor.getMat_prof(),
                    professor.getNome(),
                    professor.getIdade(),
                    professor.getSala(),
                    professor.getEspecialidade()
            });
        });

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}