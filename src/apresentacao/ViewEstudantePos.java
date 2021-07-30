package apresentacao;

import dados.EstudantePos;
import persistencia.EstudantePosDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewEstudantePos extends JFrame {
    public ViewEstudantePos(){
        String[] colums = new String[]{
                "mat_est", "nome", "idade", "tipo_curso", "num_dep", "mat_est_aconselhador"
        };
        DefaultTableModel model = new DefaultTableModel(0, colums.length);
        model.setColumnIdentifiers(colums);
        JTable table = new JTable(model);

        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
        List<EstudantePos> estudantes = estudantePosDAO.selectAll();

        estudantes.forEach(estudante ->{
            model.addRow(new Object[]{
                    estudante.getMat_est(),
                    estudante.getNome(),
                    estudante.getIdade(),
                    estudante.getTipo_curso(),
                    estudante.getNum_dep(),
                    estudante.getMat_est_aconselhador()
            });
        });
        table.setEnabled(false);
        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
}
