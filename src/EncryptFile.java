import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EncryptFile extends JFrame {

    private Container cp;
    private JLabel jlb1=new JLabel("加密法");
    private String[] cb=new String[]{"DES","AES","Casear","XOR"};
    private JComboBox jcb=new JComboBox(cb);
    private JLabel jlb2=new JLabel("Key");
    private JTextField jtf1=new JTextField();
    private JButton run=new JButton("Run");
    private JButton exit=new JButton("Close");
    private JLabel jlb3=new JLabel("原始檔");
    private JTextField jtf2=new JTextField();
    private JButton jbtc1=new JButton("Choose");
    private JLabel jlb4=new JLabel("加密檔");
    private JTextField jtf3=new JTextField();
    private JButton jbtc2=new JButton("Choose");
    private JProgressBar jps=new JProgressBar();
    private JPanel jpN=new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpC=new JPanel(new GridLayout(2,2,3,3));
    private JFileChooser jfc=new JFileChooser();
    private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    private int scW=screenSize.width,scH=screenSize.height;
    private int frW=500,frH=150;
    private String loadFileName="";

    public EncryptFile(){
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(scW/2 - frW/2,scH/2 - frH/2,frW,frH);

        cp=this.getContentPane();
        cp.add(jpN,BorderLayout.NORTH);
        cp.add(jpC,BorderLayout.CENTER);
        cp.add(jps,BorderLayout.SOUTH);

        jpN.add(jlb1);
        jpN.add(jcb);
        jpN.add(jlb2);
        jpN.add(jtf1);
        jpN.add(run);
        jpN.add(exit);

        jpC.add(jlb3);
        jpC.add(jtf2);
        jpC.add(jbtc1);
        jpC.add(jlb4);
        jpC.add(jtf3);
        jpC.add(jbtc2);

        jbtc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jfc.showOpenDialog(EncryptFile.this)==JFileChooser.APPROVE_OPTION){
                    loadFileName = jfc.getSelectedFile().getPath();
                    jtf2.setText(jfc.getSelectedFile().getPath());
                    jtf3.setText(jtf2 + ".src");
                }
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadFileName.equals("")){
                    JOptionPane.showMessageDialog(EncryptFile.this,"file no selected");
                }else{
                    try{
                        File selectedFile = new File(loadFileName);
                        long fileLength=selectedFile.length();
                        jps.setMaximum(100);
                        char key[]=jtf1.getText().toCharArray();

                        FileReader fr=new FileReader(selectedFile);
                        BufferedReader br=new BufferedReader(fr);

                        FileWriter fw = null;
                        fw = new FileWriter(selectedFile);
                        BufferedWriter bfw = new BufferedWriter(fw);

                        int data;
                        int i=0;
                        while((data=br.read()) != -1){
                            data =data ^ key[i % key.length];
                            bfw.write(data);
                            i++;
                            jps.setValue(Math.round(((float)i/fileLength)*100));
                        }
                        bfw.close();
                        fr.close();
                        JOptionPane.showMessageDialog(EncryptFile.this,"Finish!");
                    } catch (FileNotFoundException e1) {
                        JOptionPane.showMessageDialog(EncryptFile.this,"file no selecte");
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(EncryptFile.this,"file no selecte");
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
    }
}
