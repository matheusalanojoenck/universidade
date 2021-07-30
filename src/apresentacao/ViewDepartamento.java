package apresentacao;

import dados.Departamento;
import dados.Professor;
import persistencia.DepartamentoDAO;
import persistencia.ProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewDepartamento extends JFrame {
    public ViewDepartamento() {
        JPanel topPanel = new JPanel();
        JPanel btnPanlel = new JPanel();

        this.add(topPanel, BorderLayout.CENTER);
        this.add(btnPanlel, BorderLayout.SOUTH);

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

        topPanel.add(new JScrollPane(table));

        JButton adicionarDepartamento = new JButton("Adicionar Departamento");
        btnPanlel.add(adicionarDepartamento);

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        adicionarDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInsertDepartamento();
            }
        });
    }
}
