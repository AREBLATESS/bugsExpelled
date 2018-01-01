import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


public class MainFrame extends JFrame {
    private Container cp;

    private JPanel jpn1 = new JPanel();
    private JButton jbtnFulscreen =new JButton("全銀幕");
    private JLabel jlabPoint = new JLabel("0");
//    private int Score =0;
    String data[]={"蚊種圖鑑","積分欄列","特殊成就","開發名單"};
    private JComboBox jcb = new JComboBox(data);

    private JPanel jpn2 = new JPanel();
    private JLabel jlabCeil = new JLabel("");
//    private JLabel jlabHouse = new JLabel();
    private ImagePanel jlabHouse = new ImagePanel();

    private JPanel jpn3=new JPanel(new GridLayout(1,5,3,3));
    private JButton jbtnClap =new JButton("");


    private JButton jbtnCatch = new JButton("");


    private JButton jbtnFire = new JButton("");
    private JButton jbtnfun4 = new JButton("4");
    private JButton jbtnfun5 = new JButton("5");
    private Boolean tool =new Boolean(false);
    private int flag=0;
    private bugs selectedBug;
    private boolean selectedBugFlag = false;

    private int  imgW, imgH;
    private int bugsIndex = 0;
    private ArrayList<bugs> bugsList=new ArrayList<bugs>();
//    private ArrayList<bugs2> bugsList2=new ArrayList<bugs2>();
    private ArrayList<Thread> threadList=new ArrayList<Thread>();
//    private Timer maintime;

//    public MainFrame(){

//
////        //
////        bugsList.add(new   bugs(imgH,imgW));
////        jlabHouse.add(bugsList.get(bugsList.size()-1));
////        threadList.add(new Thread(bugsList.get(bugsList.size()-1)));
////        threadList.get(threadList.size()-1).start();
////        //
//    }


//    public void mousePressed(MouseEvent e){
//        //實做滑鼠的點擊事件
//        Graphics g = getGraphics();
//        int x = e.getX();
//        int y = e.getY();
//        bugs.setIcon(imgeB);
//        g.drawImage("graphic/blood.png",x,y,null);
//    }


    public MainFrame(){
        initComp();
    }
    private void initComp(){
        //
        imgW = jlabHouse.getImgWidth();
        imgH = jlabHouse.getImgHeight();
        this.setBounds(350,100,imgW,imgH);
        this.setResizable(true);  //視窗放大縮小
        jlabHouse.setLayout(null);

        jbtnfun4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bugsList.add(new   bugs(MainFrame.this,imgH+200,imgW));
                jlabHouse.add(bugsList.get(bugsList.size()-1));
                threadList.add(new Thread(bugsList.get(bugsList.size()-1)));
                threadList.get(threadList.size()-1).start();
            }
        });
        this.setBounds(0,0,600,1000);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setTitle("滅蚊行動");
        jpn1.add(jbtnFulscreen);

        jlabPoint.setOpaque(true);
        jlabPoint.setBackground(new Color(184,200, 76));
        jlabPoint.setPreferredSize(new Dimension(400,30));
        jpn1.add(jlabPoint);
        jpn1.add(jcb);
        cp.add(jpn1,BorderLayout.NORTH);

        jpn2.setLayout(new BorderLayout());

        ImageIcon iconCeil = new ImageIcon("graphic/Ceil.jpg");
        Image imgC;
        imgC = iconCeil.getImage();
        imgC = imgC.getScaledInstance(600,200,Image.SCALE_DEFAULT);
        iconCeil=new ImageIcon(imgC);
        jlabCeil.setIcon(iconCeil);

        jlabCeil.setOpaque(true);
        jlabCeil.setBackground(Color.orange);
        jlabCeil.setPreferredSize(new Dimension(0,100));
        jlabCeil.setHorizontalAlignment(jlabCeil.CENTER);
        jpn2.add(jlabCeil,BorderLayout.NORTH);

        jpn2.add(jlabHouse,BorderLayout.CENTER);
        cp.add(jpn2,BorderLayout.CENTER);

        jbtnClap.setPreferredSize(new Dimension(0,70));
        jpn3.add(jbtnClap);
        ImageIcon iconClap = new ImageIcon("graphic/clap.png");
        Image imgT1;
        imgT1= iconClap.getImage();
        imgT1= imgT1.getScaledInstance(100,150,Image.SCALE_DEFAULT);
        iconClap=new ImageIcon(imgT1);
        jbtnClap.setIcon(iconClap);
        jbtnClap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tool ==false){
                    jbtnClap.setEnabled(false);
                }else{
                    jbtnCatch.setEnabled(true);
                    jbtnClap.setEnabled(false);
                }
                tool = true;
                flag = 1;
                ImageIcon imgClap = new ImageIcon("graphic/clap.png");


                Cursor cr = Toolkit.getDefaultToolkit().createCustomCursor(imgClap.getImage(), new Point(0,0) ,"MyCursor" );
                cp.setCursor(cr);

            }
        });
        jpn3.add(jbtnCatch);
        ImageIcon iconCatch = new ImageIcon("graphic/catch.png");
        Image imgT2;
        imgT2=iconCatch.getImage();
        imgT2=imgT2.getScaledInstance(100,150,Image.SCALE_DEFAULT);
        iconCatch=new ImageIcon(imgT2);
        jbtnCatch.setIcon(iconCatch);
        jbtnCatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tool == false){
                    jbtnCatch.setEnabled(false);
                }else{
                    jbtnClap.setEnabled(true);
                    jbtnCatch.setEnabled(false);
                }
                tool = true;
                flag = 2;
                ImageIcon imgCatch = new ImageIcon("graphic/catch.png");
                Cursor cr = Toolkit.getDefaultToolkit().createCustomCursor(imgCatch.getImage(), new Point(0,0) ,"MyCursor" );

                cp.setCursor(cr);
            }
        });
        //火燒
        ImageIcon iconfire = new ImageIcon("graphic/fire.png");
        Image imgT3;
        imgT3=iconfire.getImage();
        imgT3=imgT3.getScaledInstance(100,150,Image.SCALE_DEFAULT);
        iconfire=new ImageIcon(imgT3);
        jbtnFire.setIcon(iconfire);
        jbtnFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent fire) {
//                bugsList.remove(new   bugs(MainFrame.this,imgH+200,imgW));
                jlabHouse.remove(bugsList.get(bugsList.size()-1));
//                ImageIcon imgB =new ImageIcon("graphic/blood.png");
//                bugsList.get(bugsList.size()-1).setIcon(imgB);
                threadList.remove(new Thread(bugsList.get(bugsList.size()-1)));


//                selectedBug.setFreeze();
            }
        });
        //

        jpn3.add(jbtnFire);
        jpn3.add(jbtnfun4);
        jpn3.add(jbtnfun5);
        cp.add(jpn3,BorderLayout.SOUTH);


//        maintime= new Timer(8000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                bugsList.add(new   bugs(imgH,imgW));
//                jlabHouse.add(bugsList.get(bugsList.size()-1));
//                threadList.add(new Thread(bugsList.get(bugsList.size()-1)));
//                threadList.get(threadList.size()-1).start();
////                maintime.start();
//            }
//        });
        //

//        ///
//        jlabHouse.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                ImageIcon imgB =new ImageIcon("graphic/blood.png");
//                bugs.this.setIcon(imgB);
////                isContinue=false;  //測試中
//                //程式的小睡
////                try {
////                    Thread.sleep(9999);
////                }
////                catch(InterruptedException out) {
////                    System.out.println("I am interrupted....");
////                }
//            }
//        });
        ///



//        ImageIcon iconHouse = new ImageIcon("graphic/house.jpg");
//        Image imgH;
//        imgH = iconHouse.getImage();
//        imgH = imgH.getScaledInstance(600,700,Image.SCALE_DEFAULT);
//        iconHouse = new ImageIcon(imgH);
//        jlabHouse.setIcon(iconHouse);
//        jlabHouse.setOpaque(true);
//        jlabHouse.setBackground(Color.YELLOW);
//        jlabHouse.setHorizontalAlignment(jlabHouse.CENTER);
////測試中
        jlabHouse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if(selectedBugFlag){
                    ImageIcon imgB =new ImageIcon("graphic/blood.png");
//                    bugs.this.setSleep();
                    threadList.remove(this);
                    selectedBugFlag = false;
//                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
//        jlabHouse.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                selectedBug.setSleep();
//                selectedBugFlag = false;
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

    }


    class ImagePanel extends JPanel{
        private BufferedImage image;
        private int imgW,imgH;
        public ImagePanel(){
            try{
                image = ImageIO.read(new File("graphic/house.jpg"));
                imgW=image.getWidth();
                imgH=image.getHeight();
            }catch (IOException ex){
                javax.swing.JOptionPane.showMessageDialog(this,"IOException:"+ex.toString());
            }
        }


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }
    public int getImgWidth(){
        return imgW;
    }
    public int getImgHeight(){ return imgH; }
    //影片中
    }
    public void setSelectedBug(bugs bug1){
        selectedBug = bug1; selectedBugFlag= true;
    }
}
