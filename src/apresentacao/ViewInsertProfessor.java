package apresentacao;

import persistencia.ProfessorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInsertProfessor extends JFrame {
    private JLabel mat_profLabel;
    private JTextField mat_profTF;
    private JLabel nomeLabel;
    private JTextField nomeTF;
    private JLabel idadeLabel;
    private JTextField idadeTF;
    private JLabel salaLabel;
    private JTextField salaTF;
    JLabel especialidadeLabel;
    JTextField especialidadeTF;

    public ViewInsertProfessor(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //panel.setSize();

        mat_profLabel = new JLabel("mat_prof ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(mat_profLabel, c);

        mat_profTF = new JTextField(JTextField.LEFT);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(mat_profTF, c);

        nomeLabel = new JLabel("nome ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(nomeLabel, c);

        nomeTF = new JTextField(JTextField.LEFT);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(nomeTF, c);

        idadeLabel = new JLabel("idade ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(idadeLabel, c);

        idadeTF = new JTextField(JTextField.LEFT);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(idadeTF, c);

        salaLabel = new JLabel("sala ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(salaLabel, c);

        salaTF = new JTextField(JTextField.LEFT);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(salaTF, c);

        especialidadeLabel = new JLabel("especialidade ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(especialidadeLabel, c);

        especialidadeTF = new JTextField(JTextField.LEFT);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(especialidadeTF, c);

        JButton adicionarButton = new JButton("Adicionar");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(adicionarButton, c);


        this.add(panel);
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
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        return professorDAO.insert(
                Integer.parseInt(mat_profTF.getText().toString()),
                nomeTF.getText().toString(),
                Integer.parseInt(idadeTF.getText().toString()),
                salaTF.getText().toString(),
                especialidadeTF.getText().toString()
        );
    }

    private void clearTF(){
        mat_profTF.setText("");
        nomeTF.setText("");
        idadeTF.setText("");
        salaTF.setText("");
        especialidadeTF.setText("");
    }
}
