package apresentacao;

import dados.Departamento;
import dados.Professor;
import persistencia.DepartamentoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInsertDepartamento extends JFrame {
    private JLabel num_depLabel;
    private JTextField num_depTF;
    private JLabel nomeLabel;
    private JTextField nomeTF;
    private JLabel escritorioLabel;
    private JTextField escritorioTF;
    private JLabel mat_profLabel;
    private JTextField mat_profTF;

    public ViewInsertDepartamento(){
        this.setTitle("Adicionar Novo Departamento");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        num_depLabel = new JLabel("num_dep ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(num_depLabel, c);

        num_depTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(num_depTF, c);

        nomeLabel = new JLabel("nome ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(nomeLabel, c);

        nomeTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(nomeTF, c);

        escritorioLabel = new JLabel("estritorio ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(escritorioLabel, c);

        escritorioTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(escritorioTF, c);

        mat_profLabel = new JLabel("mat_prof", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(mat_profLabel, c);

        mat_profTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(mat_profTF, c);

        JButton adicionarButton = new JButton("Adicionar");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(adicionarButton, c);

        this.add(panel, BorderLayout.CENTER);
        this.add(new JLabel("Adicionar Novo Departamento", JLabel.CENTER), BorderLayout.NORTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adicionar()){
                    clearTF();
                    JOptionPane.showConfirmDialog(null, "Inserção realizada com sucesso", "", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showConfirmDialog(null, "Inserção não realizada", "", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
    }

    private boolean adicionar(){
        DepartamentoDAO departamentoDAO = DepartamentoDAO.getInstance();

        return departamentoDAO.insert(
                Integer.parseInt(num_depTF.getText()),
                nomeTF.getText(),
                escritorioTF.getText(),
                Integer.parseInt(mat_profTF.getText())
        );
    }

    private void clearTF(){
        num_depTF.setText("");
        nomeTF.setText("");
        escritorioTF.setText("");
        mat_profTF.setText("");
    }
}
