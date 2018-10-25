
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomKeyBorder extends JFrame {


    private JButton jbt[] = new JButton[12];
    private String str[] = new String[10];
    private Container cp;
    private JPanel jpn = new JPanel(new GridLayout(1, 1, 1, 1));
    private JPanel jpc = new JPanel(new GridLayout(3, 4, 3, 3));
    private JLabel jlb = new JLabel(" ");


    public RandomKeyBorder() {
        init();
    }


    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 400, 450);
        cp=this.getContentPane();

        cp.add(jpn, BorderLayout.NORTH);
        cp.add(jpc, BorderLayout.CENTER);

        jpn.add(jlb);

        for (int i = 0; i < 10; i++) {
            jbt[i] = new JButton(Integer.toString(i));
            jbt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbtn=(JButton) e.getSource();
                    jlb.setText(jlb.getText()+jbtn.getText());
                }
            });

            jpc.add(jbt[i]);
        }

        jbt[10] = new JButton("<-");
        jpc.add(jbt[10]);
        jbt[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jbtn =(JButton) e.getSource();
                jlb.setText(jlb.getText());
            }
        });

        jbt[11] = new JButton("submit");
        jpc.add(jbt[11]);
        jbt[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log=new Login();
                RandomKeyBorder.this.setVisible(false);

            }
        });

    }
    public void ex(){
        int i=0;
        Random rnd=new Random(System.currentTimeMillis());
        while(i<10){
            str[i]=Integer.toString(rnd.nextInt());
            int j=0;
            boolean flag=false;
            if(j<i){
                if(jbt[i].equals(jbt[j])){
                    flag=false;
                }j++;
            }
            if(flag){
                i++;
            }
        }
    }
}