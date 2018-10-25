
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOGame extends JFrame {
    private Container cp;
    private JLabel jlb = new JLabel("game");
    private JPanel jpnc = new JPanel(new GridLayout(3, 3, 3, 3));
    private JButton jbt1 = new JButton();
    private JButton jbt2 = new JButton();
    private JButton jbt3 = new JButton();
    private JButton jbt4 = new JButton();
    private JButton jbt5 = new JButton();
    private JButton jbt6 = new JButton();
    private JButton jbt7 = new JButton();
    private JButton jbt8 = new JButton();
    private JButton jbt9 = new JButton();
    private int x;

    public XOGame() {
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 500, 450);

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        cp.add(jlb, BorderLayout.NORTH);
        cp.add(jpnc, BorderLayout.CENTER);
        jlb.setOpaque(true); //要設定這個才能改字型
        jlb.setBackground(new Color(255, 180, 69));
        jlb.setFont(new FontUIResource(null, java.awt.Font.BOLD, 20));
        jpnc.add(jbt1);
        jpnc.add(jbt2);
        jpnc.add(jbt3);
        jpnc.add(jbt4);
        jpnc.add(jbt5);
        jpnc.add(jbt6);
        jpnc.add(jbt7);
        jpnc.add(jbt8);
        jpnc.add(jbt9);

        jbt1.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt2.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt3.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt4.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt5.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt6.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt7.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt8.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));
        jbt9.setFont(new FontUIResource(null, java.awt.Font.PLAIN, 64));

        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });


        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });


        jbt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

        jbt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton temp = (JButton) e.getSource();
                if (x % 2 == 0) {
                    temp.setText("O");
                } else {
                    temp.setText("X");
                }
                temp.setEnabled(false);
                status();
                x++;
            }
        });

    }
    public void status(){
        if(jbt1.getText().equals(jbt2.getText()) && jbt2.getText().equals(jbt3.getText()) && jbt3.getText().equals(jbt1.getText()) && !jbt1.equals(" ")) {
            if (jbt1.getText().equals("O")) {
                jlb.setText("Play 1 WIN");
            } else {
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt4.getText().equals(jbt5.getText()) && jbt5.getText().equals(jbt6.getText()) && jbt6.getText().equals(jbt4.getText()) && !jbt4.equals(" ")){
            if (jbt4.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt7.getText().equals(jbt8.getText()) && jbt8.getText().equals(jbt9.getText()) && jbt9.getText().equals(jbt7.getText()) && !jbt7.equals(" ")){
            if (jbt7.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt1.getText().equals(jbt4.getText()) && jbt4.getText().equals(jbt7.getText()) && jbt7.getText().equals(jbt1.getText()) && !jbt1.equals(" ")){
            if (jbt1.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt2.getText().equals(jbt5.getText()) && jbt5.getText().equals(jbt8.getText()) && jbt8.getText().equals(jbt2.getText()) && !jbt2.equals(" ")){
            if (jbt2.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt3.getText().equals(jbt6.getText()) && jbt6.getText().equals(jbt9.getText()) && jbt9.getText().equals(jbt3.getText()) && !jbt3.equals(" ")){
            if (jbt3.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt1.getText().equals(jbt5.getText()) && jbt5.getText().equals(jbt9.getText()) && jbt9.getText().equals(jbt1.getText()) && !jbt1.equals(" ")){
            if (jbt1.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
        if(jbt3.getText().equals(jbt5.getText()) && jbt5.getText().equals(jbt7.getText()) && jbt7.getText().equals(jbt3.getText()) && !jbt3.equals(" ")){
            if (jbt3.getText().equals("O")){
                jlb.setText("Play 1 WIN");
            }else{
                jlb.setText("Play 2 WIN");
            }
        }
    }

}
