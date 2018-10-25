
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JLabel jid=new JLabel("ID");
    private JLabel jpw=new JLabel("Password");
    private JTextField jtf=new JTextField();
    private JPasswordField jps=new JPasswordField();
    private JButton key=new JButton("KeyBorder");
    private JButton log=new JButton("Login");
    private JButton exit=new JButton("Exit");
    private Container cp;
    private JPanel jpn=new JPanel(new GridLayout(2,2,2,2));
    private JPanel jns=new JPanel(new GridLayout(1,3,1,1));
    private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    private int scW=screenSize.width,scH=screenSize.height;
    private int frW=300,frH=180;


    public Login(){
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(scW/2 - frW/2,scH/2 - frH/2,frW,frH);

        cp=this.getContentPane();
        cp.add(jpn,BorderLayout.NORTH);
        cp.add(jns,BorderLayout.SOUTH);

        jpn.add(jid);
        jpn.add(jtf);
        jpn.add(jpw);
        jpn.add(jps);

        jns.add(key);
        jns.add(log);
        jns.add(exit);

        key.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomKeyBorder rkb=new RandomKeyBorder();
                rkb.setVisible(true);
            }
        });

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtf.getText().equals("h304") && jps.getPassword().equals("23323456")){
                    Frame frm=new Frame();
                    frm.setVisible(true);
                    Login.this.dispose();
                }else{
                    JOptionPane.showMessageDialog(Login.this,"Error");
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}