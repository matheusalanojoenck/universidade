package apresentacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMain extends JFrame {
    public ViewMain(){
        JPanel panel = new JPanel();
        JButton listarProfessorButton = new JButton("Listar Professor");
        JButton listarEstudantePosButton = new JButton("Listar Estudante Pos");
        JButton listarDepartamentoButton = new JButton("Listar Departamento");

        panel.add(listarProfessorButton);
        panel.add(listarEstudantePosButton);
        panel.add(listarDepartamentoButton);

        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        listarProfessorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewProfessor();
            }
        });

        listarDepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDepartamento();
            }
        });

        listarEstudantePosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEstudantePos();
            }
        });
    }
}
