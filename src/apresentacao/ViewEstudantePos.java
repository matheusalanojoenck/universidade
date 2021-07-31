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

        JButton update = new JButton("Update");
        btnPanlel.add(update);

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        adicionarDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
                        JOptionPane.showConfirmDialog(null, "Remoção realizada com sucesso", "", JOptionPane.DEFAULT_OPTION);
                        new ViewEstudantePos();
                    } else{
                        JOptionPane.showConfirmDialog(null, "Remoção não realizada", "", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!table.getSelectionModel().isSelectionEmpty()){
                    int row = table.getSelectedRow();
                   boolean result = update(
                           Integer.parseInt(table.getValueAt(row, 0).toString()),
                           table.getValueAt(row, 1).toString(),
                           Integer.parseInt(table.getValueAt(row, 2).toString()),
                           table.getValueAt(row, 3).toString(),
                           Integer.parseInt(table.getValueAt(row, 4).toString()),
                           Integer.parseInt(table.getValueAt(row, 5).toString())
                   );
                    if(result){
                        dispose();
                        JOptionPane.showConfirmDialog(null, "Update realizado com sucesso", "", JOptionPane.DEFAULT_OPTION);
                        new ViewEstudantePos();
                    } else{
                        JOptionPane.showConfirmDialog(null, "Update não realizado", "", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });
    }
    private boolean deletar(int id){
        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
        return estudantePosDAO.delete(id);
    }

    private boolean update(int mat_est, String nome, int idade,  String tipo_curso, int num_dep,int mat_est_aconselhador){
        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
        return estudantePosDAO.update(mat_est, nome, idade, tipo_curso, num_dep, mat_est_aconselhador);
    }
}
