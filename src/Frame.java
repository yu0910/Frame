
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private JMenuBar Jmb=new JMenuBar();
    private JMenu Jmf=new JMenu("File");
    private JMenu Jmt=new JMenu("Tool");
    private JMenu Jmg=new JMenu("Game");
    private JMenu Jmh=new JMenu("Help");
    private JMenuItem Jmo=new JMenuItem("Open");
    private JMenuItem Jmc=new JMenuItem("Close");
    private JMenuItem Jme=new JMenuItem("Exit");
    private JMenuItem Jmx=new JMenuItem("XO Game");
    private JMenuItem Jmn=new JMenuItem("Encrypt");
    private JMenuItem Jmnf=new JMenuItem("Encrypt File");
    private Container cp;
    private JPanel jpN=new JPanel();

    public Frame(){
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100,100,700,500);

        cp=this.getContentPane();
        cp.add(jpN,null);

        this.setJMenuBar(Jmb);
        Jmb.add(Jmf);
        Jmb.add(Jmt);
        Jmb.add(Jmg);
        Jmb.add(Jmh);
        Jmf.add(Jmo);
        Jmf.add(Jmc);
        Jmf.add(Jme);
        Jmg.add(Jmx);
        Jmt.add(Jmn);
        Jmt.add(Jmnf);

        Jme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Jmx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XOGame xo=new XOGame();
                xo.setVisible(true);
                Frame.this.setVisible(false);
            }
        });

        Jmn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encrypt en=new Encrypt();
                en.setVisible(true);
                Frame.this.setVisible(false);
            }
        });

        Jmnf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptFile enf=new EncryptFile();
                enf.setVisible(true);
                Frame.this.dispose();
            }
        });
    }

}