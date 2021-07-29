package apresentacao;

import dados.Departamento;
import dados.Professor;
import persistencia.DepartamentoDAO;
import persistencia.ProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewDepartamento extends JFrame {
    public ViewDepartamento() {
        String[] colums = new String[]{
                "num_dep", "nome", "escritorio", "mat_prof"
        };
        DefaultTableModel model = new DefaultTableModel(0, colums.length);
        model.setColumnIdentifiers(colums);
        JTable table = new JTable(model);

        DepartamentoDAO departamentoDAO = DepartamentoDAO.getInstance();
        List<Departamento> departamentos = departamentoDAO.selectAll();

        departamentos.forEach(departamento ->{
            model.addRow(new Object[]{
                    departamento.getNum_dep(),
                    departamento.getNome(),
                    departamento.getEscritorio(),
                    departamento.getMat_prof()
            });
        });

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
