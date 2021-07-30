package apresentacao;

import dados.EstudantePos;
import persistencia.EstudantePosDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInsertEstudantePos extends JFrame{
    private JLabel mat_estLabel;
    private JLabel nomeLabel;
    private JLabel idadeLabel;
    private JLabel tipo_cursoLabel;
    private JLabel num_depLabel;
    private JLabel mat_est_aconselhadorLabel;
    private JTextField mat_estTF;
    private JTextField nomeTF;
    private JTextField idadeTF;
    private JTextField tipo_cursoTF;
    private JTextField num_depTF;
    private JTextField mat_est_aconselhadorTF;

    public ViewInsertEstudantePos(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        mat_estLabel = new JLabel("mat_est ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(mat_estLabel, c);

        mat_estTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(mat_estTF, c);

        nomeLabel = new JLabel("nome ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(nomeLabel, c);

        nomeTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(nomeTF, c);

        idadeLabel = new JLabel("idade ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(idadeLabel, c);

        idadeTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(idadeTF, c);

        tipo_cursoLabel = new JLabel("tipo_curso ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(tipo_cursoLabel, c);

        tipo_cursoTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(tipo_cursoTF, c);


        num_depLabel = new JLabel("num_dep ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(num_depLabel, c);

        num_depTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(num_depTF, c);

        mat_est_aconselhadorLabel = new JLabel("mat_est_aconselhador ", JLabel.RIGHT);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(mat_est_aconselhadorLabel, c);

        mat_est_aconselhadorTF = new JTextField(JTextField.RIGHT);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(mat_est_aconselhadorTF, c);

        JButton adicionarButton = new JButton("Adicionar");
        c.gridx = 0;
        c.gridy = 6;
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
        EstudantePosDAO estudantePosDAO = EstudantePosDAO.getInstance();
         return estudantePosDAO.insert(
                 Integer.parseInt(mat_estTF.getText()),
                 nomeTF.getText(),
                 Integer.parseInt(idadeTF.getText()),
                 tipo_cursoTF.getText(),
                 Integer.parseInt(num_depTF.getText()),
                 Integer.parseInt(mat_est_aconselhadorTF.getText())
         );
    }

    private void clearTF(){
        mat_estTF.setText("");
        nomeTF.setText("");
        idadeTF.setText("");
        tipo_cursoTF.setText("");
        num_depTF.setText("");
        mat_est_aconselhadorTF.setText("");
    }
}
