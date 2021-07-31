package apresentacao;

import dados.EstudantePos;
import persistencia.DepartamentoDAO;
import persistencia.EstudantePosDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewEstudantePos extends JFrame {
    public ViewEstudantePos(){
        JPanel topPanel = new JPanel();
        JPanel btnPanlel = new JPanel();

        this.add(topPanel, BorderLayout.CENTER);
        this.add(btnPanlel, BorderLayout.SOUTH);

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

        topPanel.add(new JScrollPane(table));

        JButton adicionarDepartamento = new JButton("Adicionar Estudante");
        btnPanlel.add(adicionarDepartamento);

        JButton deletar = new JButton("Deletar");
        btnPanlel.add(deletar);

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        adicionarDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInsertEstudantePos();
            }
        });

        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!table.getSelectionModel().isSelectionEmpty()){
                    int row = table.getSelectedRow();
                    int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                    if(deletar(id)){
                        dispose();
                        new ViewEstudantePos();
                    }
                }
            }
        });
    }
    private boolean deletar(int id){
        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
        return estudantePosDAO.delete(id);
    }
}
