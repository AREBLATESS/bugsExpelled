import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MainFrame extends JFrame {
    private Container cp;
//    private bugs b = new bugs();
    private JPanel jpn1 = new JPanel();
//    private JButton jbtnMusic = new JButton("音樂");
    private JButton jbtn1 =new JButton("圖鑑");
    private int score =0;
    public int combo = 0;
    private JLabel jlabPoint = new JLabel(Integer.toString(score));
//    String data[]={"蚊種圖鑑","積分欄列","特殊成就","開發名單"};
//    private JComboBox jcb = new JComboBox(data);

    private JPanel jpn2 = new JPanel();
    private JLabel jlabCeil = new JLabel("");
//    private JLabel jlabHouse = new JLabel();

    private ImagePanel jlabHouse = new ImagePanel();
    private JLabel jlabEnding = new JLabel();
    private JPanel jpn3=new JPanel(new GridLayout(1,5,3,3));
    private JButton jbtnClap =new JButton("");


    private JButton jbtnCatch = new JButton("");


    private JButton jbtnFire = new JButton("3");
    private JButton jbtnfun4 = new JButton("4");
    public int flyList=0;
    public int fly =0;
    private JButton jbtnfun5 = new JButton("");
    private Boolean tool =new Boolean(false);
    private int flag=0;
    private bugs selectedBug;
    private boolean selectedBugFlag = false;
    private boolean musicstart = false;
    public  boolean chArt = true;
    java.util.Timer tMain = new java.util.Timer(true);
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
//            if (chArt == true) {
            if (fly <= 10) {
                    bugsList.add(new bugs(MainFrame.this, imgH + 200, imgW, MainFrame.this));
                    jlabHouse.add(bugsList.get(bugsList.size() - 1));
                    threadList.add(new Thread(bugsList.get(bugsList.size() - 1)));
                    threadList.get(threadList.size() - 1).start();
                    flyList++;
                    fly++;
                    if (combo > 5) {
                        jbtnfun5.setEnabled(true);
                    } else {
                        jbtnfun5.setEnabled(false);
                    }
                    System.out.println("蚊子數量:"+fly);
                    System.out.println("flyList:" + flyList);
                    System.out.println("連擊:"+combo);
//                    System.out.println(chArt);
                } else {
                    JOptionPane.showMessageDialog(null, "you lose");
                    for (int i = 1; i < flyList + 1; i++) {
                        jlabHouse.remove(bugsList.get(bugsList.size() - i));
                        threadList.remove(new Thread(bugsList.get(bugsList.size() - i)));
                        jlabHouse.repaint();
                    }
                    flyList = 0;
                    fly = 0;
                    score = 0;
                    combo = 0;
                    jlabPoint.setText("0");
                }

            }
//        }
    };


    private int  imgW, imgH;
    private int bugsIndex = 0;
    private ArrayList<bugs> bugsList=new ArrayList<bugs>();
    private ArrayList<Thread> threadList=new ArrayList<Thread>();

//    public AudioPlayer(File file){
//        this.music=file;
//    }



    public MainFrame(){
        initComp();
    }
    private void initComp() {
        //

//        new Player(new BufferedInputStream(new FileInputStream(new File("../JLayer/BGM.mp3"))));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        imgW = jlabHouse.getImgWidth();
        imgH = jlabHouse.getImgHeight();
        this.setBounds(350,100,imgW,imgH);
        this.setResizable(false);  //視窗放大縮小
        jlabHouse.setLayout(null);

        if(fly<=10) {
            tMain.schedule(task, 1000, 1000);
        }else{
            JOptionPane.showMessageDialog(null,"you lose");
            for(int i=1;i<flyList+1;i++){
                jlabHouse.remove(bugsList.get(bugsList.size()-i));
                threadList.remove(new Thread(bugsList.get(bugsList.size()-i)));
                jlabHouse.repaint();
            }
            flyList=0;
            fly=0;
            combo=0;
        }


        jbtnfun4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fly<=10){
                    bugsList.add(new   bugs(MainFrame.this,imgH+200,imgW,MainFrame.this));
                    jlabHouse.add(bugsList.get(bugsList.size()-1));
                    threadList.add(new Thread(bugsList.get(bugsList.size()-1)));
                    threadList.get(threadList.size()-1).start();
                    flyList ++;
                    fly++;
                }else{
                    JOptionPane.showMessageDialog(null,"you lose");
                    for(int i=1;i<flyList+1;i++){
                        jlabHouse.remove(bugsList.get(bugsList.size()-i));
                        threadList.remove(new Thread(bugsList.get(bugsList.size()-i)));
                        jlabHouse.repaint();
                    }
                    flyList=0;
                    fly=0;
                    score = 0;
                    combo = 0;
                    jlabPoint.setText("0");
                }
            }
        });
        this.setBounds(0,0,600,1000);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setTitle("滅蚊行動");

        jlabPoint.setOpaque(true);
        jlabPoint.setBackground(new Color(184,200, 76));
        jlabPoint.setPreferredSize(new Dimension(400,30));

        jpn1.add(jlabPoint);
        jpn1.add(jbtn1);
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

        jbtnFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent fire) {
                jlabHouse.remove(bugsList.get(bugsList.size()-1));
                threadList.remove(new Thread(bugsList.get(bugsList.size()-1)));
                jlabHouse.repaint();

            }
        });
        //測試
        ImageIcon iconfire = new ImageIcon("graphic/fire.png");
        Image imgT3;
        imgT3=iconfire.getImage();
        imgT3=imgT3.getScaledInstance(100,150,Image.SCALE_DEFAULT);
        iconfire=new ImageIcon(imgT3);
        jbtnfun5.setIcon(iconfire);
        jbtnfun5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (score > 50) {
                    ImageIcon iconExplosion = new ImageIcon("graphic/ending.png");
                    Image imgE;
                    imgE = iconExplosion.getImage();
                    imgE = imgE.getScaledInstance(600, 1000, Image.SCALE_DEFAULT);
                    iconExplosion = new ImageIcon(imgE);
                    jlabEnding.setIcon(iconExplosion);
                    jpn2.remove(jlabHouse);
                    jpn2.remove(jlabCeil);
                    jpn2.add(jlabEnding, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(null, "Bad Ending, you explore your house");
                    for (int i = 1; i < flyList + 1; i++) {
                        jlabHouse.remove(bugsList.get(bugsList.size() - i));
                        threadList.remove(new Thread(bugsList.get(bugsList.size() - i)));
                        jlabHouse.repaint();
                    }
                    flyList = 0;
                    fly = 0;
                    combo = 0;
                    score = 0;
                    repaint();
                } else {
                    for (int i = 1; i < flyList + 1; i++) {
                        jlabHouse.remove(bugsList.get(bugsList.size() - i));
                        threadList.remove(new Thread(bugsList.get(bugsList.size() - i)));
                        jlabHouse.repaint();
                    }
                    flyList = 0;
                    fly = 0;
                    combo = 0;
                }
            }

        });


        jpn3.add(jbtnFire);
        jpn3.add(jbtnfun4);
        jpn3.add(jbtnfun5);
        jbtnfun5.setEnabled(false);
        cp.add(jpn3,BorderLayout.SOUTH);

        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Illustrated illustrated = new Illustrated();
                illustrated.setVisible(true);
//                MainFrame.this.setVisible(false);

            }
        });

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

    }


    class ImagePanel extends JPanel{
        private BufferedImage image;
        private int imgW,imgH;
        public ImagePanel(){
            try{
//                if(score==0){
//                    image = ImageIO.read(new File("graphic/enddddddd.png"));
//                }else {
                    image = ImageIO.read(new File("graphic/house.png"));
//                }
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
    public int getScore(){
        return score;
    }
    public void setScore(int score1){
       this.score=score1;
    }

    public int getfly(){ return fly;}
    public void setfly(int fly1){this.fly=fly1;}

    public int getCombo(){return combo;}
    public void setCombo(int combo1){this.combo = combo1; }

    public JLabel getJlbPoint(){
        return jlabPoint;
    }

//    public void play() throws  FileNotFoundException, JavaLayerException{
//
//        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
//        player = new Player(buffer);
//        player.play();
//    }
}
