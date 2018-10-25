
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Encrypt extends JFrame {

    private JLabel jlb1=new JLabel("Method");
    private String[] cb=new String[]{"DES","AES","Casear","XOR"};
    private JComboBox jcb=new JComboBox(cb);
    private JLabel jps=new JLabel("Key");
    private JTextField jtf=new JTextField();
    private JRadioButton jen=new JRadioButton("Encrypt");
    private JRadioButton jde=new JRadioButton("Decrypt");
    private ButtonGroup btg=new ButtonGroup();
    private JButton run=new JButton("Run");
    private JButton exit=new JButton("Exit");
    private JButton clear=new JButton("Clear");
    private JTextArea jtaL=new JTextArea();
    private JTextArea jtaR=new JTextArea();
    private JScrollPane jsL=new JScrollPane(jtaL);
    private JScrollPane jsR=new JScrollPane(jtaR);
    private Container cp;
    private JPanel jpC=new JPanel(new GridLayout(9,1,1,1));
    private JFileChooser jfc=new JFileChooser();
    private JMenuBar jmb=new JMenuBar();
    private JMenu file=new JMenu("File");
    private JMenu help=new JMenu("Heip");
    private JMenuItem jmO=new JMenuItem("Open");
    private JMenuItem jmS=new JMenuItem("Save");
    private JMenuItem jmE=new JMenuItem("Exit");

    public Encrypt(){
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100,100,700,500);

        jtaL.setPreferredSize(new Dimension(300,500));
        jtaR.setPreferredSize(new Dimension(300,500));

        this.setJMenuBar(jmb);
        jmb.add(file);
        jmb.add(help);
        file.add(jmO);
        file.add(jmS);
        file.add(jmE);

        cp=this.getContentPane();
        cp.add(jsL,BorderLayout.WEST);
        cp.add(jsR,BorderLayout.EAST);
        cp.add(jpC,BorderLayout.CENTER);
        jpC.add(jlb1);
        jpC.add(jcb);
        jpC.add(jps);
        jpC.add(jtf);
        jpC.add(jen);
        jpC.add(jde);
        jpC.add(clear);
        jpC.add(run);
        jpC.add(exit);

        btg.add(jen);
        btg.add(jde);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jen.isSelected()){
                    switch (jcb.getSelectedIndex()){
                        case 0:
                            JOptionPane.showMessageDialog(Encrypt.this,"sorry not finish");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(Encrypt.this,"sorry not finish");
                        case 2:
                            char dataC[]=jtaL.getText().toCharArray();
                            char keyC[]=jtf.getText().toCharArray();
                            for(int i=0;i<dataC.length;i++){
                                char c=dataC[i];
                                if(c >= 'a' && c <= 'z'){
                                    c += keyC[i%keyC.length]%26;
                                    if(c < 'a'){
                                        c += 26;
                                    }else if(dataC[i] > 'z'){
                                        c -= 26;
                                    }
                                }else if (c >='A' && c <='Z'){
                                    c += keyC[i%keyC.length]%26;
                                    if(c <'A'){
                                        c += 26;
                                    }else if(c > 'Z'){
                                        c -= 26;
                                    }
                                }
                                jtaR.setText(new String(dataC));
                            }
                        case 3:
                            char dataX[]=jtaL.getText().toCharArray();
                            char keyX[]=jtf.getText().toCharArray();

                            for(int i=0;i<dataX.length;i++){
                                dataX[i] = (char)((int)dataX[i] ^ (int)keyX[i%keyX.length]);
                            }
                            jtaR.setText(new String(dataX));
                    }
                }else if(jde.isSelected()){
                    switch (jcb.getSelectedIndex()){
                        case 0:
                            JOptionPane.showMessageDialog(Encrypt.this,"no select!");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(Encrypt.this,"no select!");
                        case 2:
                            char dataC[]=jtaR.getText().toCharArray();
                            char keyC[]=jtf.getText().toCharArray();
                            for(int i=0;i<dataC.length;i++){
                                char c=dataC[i];
                                if(c >= 'a' && c <= 'z'){
                                    c += keyC[i%keyC.length]%26;
                                    if(c < 'a'){
                                        c += 26;
                                    }else if(dataC[i] > 'z'){
                                        c -= 26;
                                    }
                                }else if (c >='A' && c <='Z'){
                                    c += keyC[i%keyC.length]%26;
                                    if(c <'A'){
                                        c += 26;
                                    }else if(c > 'Z'){
                                        c -= 26;
                                    }
                                }
                                jtaL.setText(new String(dataC));
                            }
                        case 3:
                            char dataX[]=jtaR.getText().toCharArray();
                            char keyX[]=jtf.getText().toCharArray();

                            for(int i=0;i<dataX.length;i++){
                                dataX[i] = (char)((int) dataX[i] ^(int)keyX[i%keyX.length]);
                            }
                            jtaL.setText(new String(dataX));
                    }
                }

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jmO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(jfc.showOpenDialog(Encrypt.this) == JFileChooser.APPROVE_OPTION){
                        jtaL.setText(" ");    //清空檔案
                        String str=" ";
                        File selectFile=jfc.getSelectedFile();            //選擋
                        FileReader fr=new FileReader(selectFile);         //讀檔
                        BufferedReader br=new BufferedReader(fr);         //緩衝
                        while ((str = br.readLine()) != null){
                            jtaL.append(str);
                        }
                        fr.close();                                       //關閉檔案
                    }
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(Encrypt.this,"file not true");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(Encrypt.this,"file not true");
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(Encrypt.this,"file not true");
                }
            }
        });

        jmS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(jtaR.getText().length() > 0) {
                        if (jfc.showSaveDialog(Encrypt.this) == JFileChooser.APPROVE_OPTION) {
                            File selectFile = jfc.getSelectedFile();
                            FileWriter fw = null;
                            fw = new FileWriter(selectFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(jtaR.getText());
                            bfw.close();
                        }
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(Encrypt.this,"Nothing to Save");
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(Encrypt.this,"Nothing to Save");
                }
            }
        });

        jmE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}