package apresentacao;

import dados.Professor;
import persistencia.DepartamentoDAO;
import persistencia.ProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewProfessor extends JFrame {
    public ViewProfessor(){
        JPanel topPanel = new JPanel();
        JPanel btnPanlel = new JPanel();

        this.add(topPanel, BorderLayout.CENTER);
        this.add(btnPanlel, BorderLayout.SOUTH);

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

        topPanel.add(new JScrollPane(table));

        JButton adicionarProfessor = new JButton("Adicionar Professor");
        btnPanlel.add(adicionarProfessor);

        JButton deletar = new JButton("Deletar");
        btnPanlel.add(deletar);

        JButton update = new JButton("Update");
        btnPanlel.add(update);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        adicionarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewInsertProfessor();
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
                        new ViewProfessor();
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
                            table.getValueAt(row, 4).toString()
                    );
                    if (result){
                        dispose();
                        new ViewProfessor();
                    }
                }
            }
        });
    }
    private boolean deletar(int id){
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        return professorDAO.delete(id);
    }

    private boolean update(int mat_prof, String nome, int idade, String sala, String especialidade){
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        return professorDAO.update(
                mat_prof,
                nome,
                idade,
                sala,
                especialidade
        );
    }
}
