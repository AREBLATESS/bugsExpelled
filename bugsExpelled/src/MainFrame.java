import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Container cp;

    private JPanel jpn1 = new JPanel();
    private JButton jbtnFulscreen =new JButton("全銀幕");
    private JLabel jlabPoint = new JLabel("0");
    private JButton jbtnSetting = new JButton("--\n--\n--");

    private JPanel jpn2 = new JPanel();
    private JLabel jlabCeil = new JLabel("天花板");
    private JLabel jlabHouse = new JLabel("屋內");

    private JPanel jpn3=new JPanel(new GridLayout(1,5,3,3));
    private JButton jbtnClap =new JButton("打");
    private JButton jbtnCatch = new JButton("抓");
    private JButton jbtnFire = new JButton("燒");
    private JButton jbtnfun4 = new JButton("4");
    private JButton jbtnfun5 = new JButton("5");

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(0,0,600,1000);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        jpn1.add(jbtnFulscreen);
        jlabPoint.setOpaque(true);
        jlabPoint.setBackground(new Color(184,200, 76));
        jlabPoint.setPreferredSize(new Dimension(400,30));
        jpn1.add(jlabPoint);
        jpn1.add(jbtnSetting);
        cp.add(jpn1,BorderLayout.NORTH);

        jpn2.setLayout(new BorderLayout());

        jlabCeil.setOpaque(true);
        jlabCeil.setBackground(Color.orange);
        jlabCeil.setPreferredSize(new Dimension(0,100));
        jlabCeil.setHorizontalAlignment(jlabCeil.CENTER);
        jpn2.add(jlabCeil,BorderLayout.NORTH);

        jlabHouse.setOpaque(true);
        jlabHouse.setBackground(Color.YELLOW);
        jpn2.add(jlabHouse,BorderLayout.CENTER);
        cp.add(jpn2,BorderLayout.CENTER);

        jbtnClap.setPreferredSize(new Dimension(70,100));
        jpn3.add(jbtnClap);
        jpn3.add(jbtnCatch);
        jpn3.add(jbtnFire);
        jpn3.add(jbtnfun4);
        jpn3.add(jbtnfun5);
        cp.add(jpn3,BorderLayout.SOUTH);


    }
}
