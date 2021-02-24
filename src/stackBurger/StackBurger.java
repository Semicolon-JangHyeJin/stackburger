package stackBurger;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class StackBurger extends JFrame {
	
	public String stageTime = "";
	private Image screenImage;
	private Graphics screenGraphic;
	/* ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �̹��� */

	// ��ư �̹��� ���� : �����ư (ȭ�� ������ ���), Ÿ��Ʋȭ�� ���� & �����ư, �ڷΰ����ư, ����Ȯ�ι�ư, Ÿ��Ʋȭ�� ���ư��� ��ư
	private ImageIcon exitButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon statisticButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/statisticButtonEntered.png"));
	private ImageIcon statisticButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/statisticButtonBasic.png"));
	private ImageIcon goTitleButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/goTitleButtonEntered.png"));
	private ImageIcon goTitleButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/goTitleButtonBasic.png"));
	// ��ư �̹��� ����: �ΰ��� ȭ�� �� ������ư, ���� ��ư 
	private ImageIcon goButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/goButtonBasic.png"));
	private ImageIcon goButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/goButtonEntered.png")); //goActionListener���� ����
	private ImageIcon tryButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/tryButtonBasic.png"));
    private ImageIcon tryButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/tryButtonEntered.png")); //tryActionListener���� ����
	
	//Stage ��ȣ 1~20������ �⺻�̹����� ���õɶ� �ٲ�� �̹��� �Ѵ� ����
	private ImageIcon stage1ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S1Entered.png"));
	private ImageIcon stage1ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S1.png"));
	private ImageIcon stage2ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S2Entered.png"));
	private ImageIcon stage2ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S2.png"));
	private ImageIcon stage3ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S3Entered.png"));
	private ImageIcon stage3ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S3.png"));
	private ImageIcon stage4ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S4Entered.png"));
	private ImageIcon stage4ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S4.png"));
	private ImageIcon stage5ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S5Entered.png"));
	private ImageIcon stage5ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S5.png"));
	private ImageIcon stage6ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S6Entered.png"));
	private ImageIcon stage6ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S6.png"));
	private ImageIcon stage7ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S7Entered.png"));
	private ImageIcon stage7ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S7.png"));
	private ImageIcon stage8ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S8Entered.png"));
	private ImageIcon stage8ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S8.png"));
	private ImageIcon stage9ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S9Entered.png"));
	private ImageIcon stage9ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S9.png"));
	private ImageIcon stage10ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S10Entered.png"));
	private ImageIcon stage10ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S10.png"));
	private ImageIcon stage11ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S11Entered.png"));
	private ImageIcon stage11ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S11.png"));
	private ImageIcon stage12ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S12Entered.png"));
	private ImageIcon stage12ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S12.png"));
	private ImageIcon stage13ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S13Entered.png"));
	private ImageIcon stage13ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S13.png"));
	private ImageIcon stage14ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S14Entered.png"));
	private ImageIcon stage14ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S14.png"));
	private ImageIcon stage15ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S15Entered.png"));
	private ImageIcon stage15ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S15.png"));
	private ImageIcon stage16ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S16Entered.png"));
	private ImageIcon stage16ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S16.png"));
	private ImageIcon stage17ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S17Entered.png"));
	private ImageIcon stage17ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S17.png"));
	private ImageIcon stage18ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S18Entered.png"));
	private ImageIcon stage18ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S18.png"));
	private ImageIcon stage19ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S19Entered.png"));
	private ImageIcon stage19ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S19.png"));
	private ImageIcon stage20ButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/S20Entered.png"));
	private ImageIcon stage20ButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/S20.png"));
	
	//��ü ����
	private Image background = new ImageIcon(SMain.class.getResource("../images/introBackground.jpg")).getImage();  // ���ȭ�� �ҷ� �� �� �ִ� ��ü 
	private JLabel menuBar = new JLabel(new ImageIcon(SMain.class.getResource("../images/menuBar.png"))); // �޴��� �ҷ����� ��ü
	private JLabel newRecordimage = new JLabel(new ImageIcon(SMain.class.getResource("../images/newRecord.png"))); // �ֱٱ�� ������ �ҷ����� ��ü
	private JLabel bestRecordimage = new JLabel(new ImageIcon(SMain.class.getResource("../images/bestRecord.png"))); // �ִܱ�� ������ �ҷ����� ��ü
	private JLabel newRecordimage_success = new JLabel(new ImageIcon(SMain.class.getResource("../images/newRecord.png"))); //�ֱٱ�� ������ (����ȭ��)�� ��ü  
	private JLabel bestRecordimage_success = new JLabel(new ImageIcon(SMain.class.getResource("../images/bestRecord.png"))); //�ִܱ�� ������ (����ȭ��)�� ��ü 

	//RECORD�۾�
	private JLabel reco = new JLabel("RECORD");
	private JLabel title = new JLabel("TITLE");
	
	//��ư�̹����� ����� ��ư ��ü ����
	private JButton exitButton = new JButton(exitButtonBasicImage); //ȭ�� ������ ��ܿ� ��ġ�� x��� ��ư ��ü
	private JButton startButton = new JButton(startButtonBasicImage); //Ÿ��Ʋ ȭ�� ���� ��ư ��ü
	private JButton quitButton = new JButton(quitButtonBasicImage); //Ÿ��Ʋ ȭ�� ���� ��ư ��ü
	private JButton s1Button = new JButton(stage1ButtonBasicImage); //����ȭ�� s1 ��ư ~ 
	private JButton s2Button = new JButton(stage2ButtonBasicImage);
	private JButton s3Button = new JButton(stage3ButtonBasicImage);
	private JButton s4Button = new JButton(stage4ButtonBasicImage);
	private JButton s5Button = new JButton(stage5ButtonBasicImage);
	private JButton s6Button = new JButton(stage6ButtonBasicImage);
	private JButton s7Button = new JButton(stage7ButtonBasicImage);
	private JButton s8Button = new JButton(stage8ButtonBasicImage);
	private JButton s9Button = new JButton(stage9ButtonBasicImage);
	private JButton s10Button = new JButton(stage10ButtonBasicImage);
	private JButton s11Button = new JButton(stage11ButtonBasicImage);
	private JButton s12Button = new JButton(stage12ButtonBasicImage);
	private JButton s13Button = new JButton(stage13ButtonBasicImage);
	private JButton s14Button = new JButton(stage14ButtonBasicImage);
	private JButton s15Button = new JButton(stage15ButtonBasicImage);
	private JButton s16Button = new JButton(stage16ButtonBasicImage);
	private JButton s17Button = new JButton(stage17ButtonBasicImage);
	private JButton s18Button = new JButton(stage18ButtonBasicImage);
	private JButton s19Button = new JButton(stage19ButtonBasicImage);
	private JButton s20Button = new JButton(stage20ButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage); //�ΰ��� ȭ��, ����ȭ�鿡 �ִ� �ڷΰ��� ��ư ��ü 
	private JButton backButton_leaderBoard = new JButton(backButtonBasicImage); //����Ȯ�� ȭ�鿡�� �������� ���ư��� ����� �ڷΰ��� ��ư ��ü
	private JButton statisticButton = new JButton(statisticButtonBasicImage); // ����ȭ�鿡�� ����Ȯ�� ȭ������ ���� ���� ���� ����Ȯ�� ��� ��ư ��ü
	private JButton goTitleButton = new JButton(goTitleButtonBasicImage); // ����ȭ�鿡�� Ÿ��Ʋ ȭ������ ���ư��� ���� �ʿ��� ��ư ��ü
	
	private int mouseX, mouseY; //���α׷��� ���콺�� x�� y��ġ 
	
	private boolean isMainScreen = false; //ó�� ������ ������ ���� ���� ȭ������ �˷��� �ʿ䰡 ����. 
	//�ش� ���� �ȿ��� ���� ȭ���� = �������� ���� ȭ���� �ǹ��Ѵ�. 
	//The value of the field StackBurger.isMainScreen is not used
	//���� ������, �� ������ �������� ȭ�� ��ȯ �޼ҵ忡�� ���ǰ� �ִ�. 
	
	//�������� ���� ����
	ArrayList<Stage> stageList = new ArrayList<Stage>(); 
	public int stageNumber; //���� ������ �� ��������
	public int nowSelected = 0; //���� ������ �� �������� �ʱ�ȭ 

	
	/*
	 * �ش�κ��� RecordDAO Ŭ���� �ȿ���, 
	 * recordInit()�� �Ұ�� ����������� ���� 2���迭�� �ʱ�ȭ �ϴ� �۾��� �ϱ⿡
	 * ���̻� ��� ���ϹǷ� �ּ� ó���� 
	 * ��ε� �ڵ� Ȯ���ϰ���
	 * �� �� ���� ���� 
	//�������� ��� ����
	public String[][] stageTimeList = new String[20][3]; //��� stage ��� ���� ����Ʈ
	{for(int i=0;i<20;i++) {
		stageTimeList[i][0]=(i+1)+" stage";
		stageTimeList[i][1]="0";
		stageTimeList[i][2]="0";
	}}//�迭�� �������̶� null���� �ȵ���. �׷��Ƿ� 0�� �� ������ null ���
	*/	
	
	//���������� ������ �ʱ�ȭ �ϴ� ������ �� �Լ��� 
	RecordDAO rdao = new RecordDAO();
	//���� ������ ������
	//RecordDAOŬ������ recordInit()�Լ��� ���� 
	//StackBurger_DB.txt���� �����͸� �ҷ��� 2���迭�� �����ϰ� 
	//stageTimeList�� �������ش�.
	public String[][] stageTimeList = rdao.recordInit();  
	
	//��� GUI ǥ �����
	String header[]= {"Stage","�ֱ� ���","�ִ� �ð� ���"}; //ǥ�� ����ν��� ������ �ؾ�������, ������ �𸣰����� �۵� ����
	public JTable recordTable = new JTable(stageTimeList, header); //JTable�� ���ο� ��ü ����
	//��� ����ȭ�鿡 �����ֱ�
	JLabel stageString = new JLabel(); //����ȭ�鿡 �� ���� ���������� �����ߴ��� �˷��� ���̺� ��ü ����
	JLabel recordBest = new JLabel(); //����ȭ�鿡 ������ ���������� �ִܱ���� ǥ���� ���̺� ��ü ����
	JLabel recordRecent = new JLabel(); //����ȭ�鿡 ������ ���������� �ֱٱ���� ǥ���� ���̺� ��ü ����

	
	public JTextArea ta = new JTextArea(); //�ΰ��� ȭ�鳻�� �� ���ӻ��¸� ǥ���� �ؽ�Ʈ ����� ��ü ����
	////������ī�� ArrayStackŬ���� ����ϱ�
	public ArrayStack recipe= new ArrayStack(100);
		
	////���� �� ī��  ArrayStackŬ���� ���
	public ArrayStack selected= new ArrayStack(100);
	    	    
	//����������
	public int stage =1; //������ ī��� �¹����� �ش� ���������� �´� ������ ī�带 �ҷ����� ���� ����
	private RecipeCard rcp=new RecipeCard(stage);
	public RecipeCard rcpcard=rcp.getRecipe(stage);
	    
	//���Ӹ��: ���� ��&���� ���� ī�� ������� ��Ȳ=1, ������Ȳ=2
	public int mode=1;

		//�ΰ��� �������
		JButton Go = new JButton("�ϼ�!");
		JButton Try = new JButton("����!");
		JPanel TimerPanel = new JPanel();
		JScrollPane TextArea = new JScrollPane(ta);
		JLabel num = new JLabel("0");
		JPanel Seek = new JPanel();
		JPanel Buttons = new JPanel();
		JPanel Compare = new JPanel();
		JPanel RecipePanel = new JPanel();
		JLabel[] r = new JLabel[13];
		String rFile;
		//Ÿ�̸�
		Timer timer = new Timer(1000, new ActionListener() {
	        int count=0;
	       @Override
	        public void actionPerformed(ActionEvent e) {
	    	   count=Integer.parseInt(num.getText()); //Ÿ�̸� ������� ���� �ʿ��� �ڵ�
	    	   count++;
	          if (count < 100000) {
	             num.setText(Integer.toString(count));
	          } else {
	            ((Timer) (e.getSource())).stop();
	          }
	        }
	      });
	
	//StackBurger������
	public StackBurger() {
		setUndecorated(true); //���� ǥ������ ���� �������� �����Ѵ�. 
		setTitle("Stack Burger"); //���� ����ǥ������ �ִٸ� Ÿ��Ʋ�� Stack Burger�� �߰� �Ѵ�. 
		setSize(SMain.SCREEN_WIDTH, SMain.SCREEN_HEIGHT); //SMain�� ���ǵ� â�� �ִ� ���ο� ���α��̸� ���� â�� ����� �����Ѵ�. 
		setResizable(false); //����â�� ����ڰ� ���������� ���� �� ���� 
		setLocationRelativeTo(null);  // �������� �� ����â�� ��ǻ���� �߾�â�� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â�� �������� �� ����â�� ���� ��
		setVisible(true); //���� ����â�� ���̰� ��  
		setBackground(new Color(0,0,0,0)); //���ȭ�� ���� ���� 
		setLayout(null); //���밪���� ȭ�鳻 ��ü�� ��ġ�� �迭���� �� �̱� ����
		
		for (int i=1; i<22; i++) {
			stageList.add(new Stage(i)); //stage�� �� 20�����̹Ƿ� 1���� 20���� �������� �߰�
		}
		
		//�޴��� �� ������ x�� ���� ��ư ����
		exitButton.setBounds(1245, 0, 30, 30); //��ư�� ��ġ 
		exitButton.setBorderPainted(false); //��ư�� �ܰ����� �����ش�.
		exitButton.setContentAreaFilled(false); //��ư�� ���뿵�� ä��� ���Ѵ�.
		exitButton.setFocusPainted(false); //��ư�� ���õǾ����� ����� �׵θ� �����Ѵ�. 
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); //���콺�� �ö����� enteredImage�� �ٲ���
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö����� Ŀ���� �հ��� ������� �ٲ��� 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� ������ ��  Ŀ���� �⺻ ������� �ٲ��� 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� �������� buttonPressedMusic�� ������ ��ü ����, �ݺ�����.
				buttonPressedMusic.start(); //���� ��� 
				try {
					Thread.sleep(1200); //�Ҹ��� ���´����� 1������ �ִٰ� ���α׷� �����. 
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit��ư�� Ŭ���ϸ� ���α׷��� ���ᰡ �ȴ�. 
				
			}
		});
		add(exitButton); 
		
		//Ÿ��Ʋ â start ��ư ����
		startButton.setBounds(170, 400, 300, 124); //���� ��ư�� ��ġ 
		startButton.setBorderPainted(false); //��ư�� �ܰ����� �����ش�.
		startButton.setContentAreaFilled(false); //��ư�� ���뿵�� ä��� ���Ѵ�.
		startButton.setFocusPainted(false); //��ư�� ���õǾ����� ����� �׵θ� �����Ѵ�. 
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); //���콺�� �ö����� enteredImage�� �ٲ���
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö����� Ŀ���� �հ��� ������� �ٲ��� 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); //���콺�� �������� �ٽ� �⺻�̹����� �ٲ��ش�. 
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� ������ ��  Ŀ���� �⺻ ������� �ٲ��� 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //���콺�� �������� ������ ���� ��ü ����, �ݺ� ����
				buttonPressedMusic.start(); //���� ���
				//���� ���� �̺�Ʈ ����
				enterMain();
			}
		});
		add(startButton);
		
		//titleâ quit ��ư ����
		quitButton.setBounds(810, 400, 300, 124); //��ư�� ��ġ
		quitButton.setBorderPainted(false); //��ư �ܰ��� ǥ�þ���.
		quitButton.setContentAreaFilled(false); //��ư ���� ä���� ����.
		quitButton.setFocusPainted(false); //��ư ���õǾ����� ���� �׵θ� ǥ������ �ʴ´�. 
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); //���콺�� �ö����� enteredImage�� �ٲ���
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö����� Ŀ���� �հ��� ������� �ٲ��� 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); //���콺 �������� �⺻�̹����� �ٲ���
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� ������ ��  Ŀ���� �⺻ ������� �ٲ��� 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //����Ǳ����� ��ư ������ �Ҹ������ ��ü ����, �ݺ� ����
				buttonPressedMusic.start(); //���� ���
				try {
					Thread.sleep(1200); //�Ҹ��� ���´����� 1������ �ִٰ� ���α׷� �����. 
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit��ư�� Ŭ���ϸ� ���α׷��� ���ᰡ �ȴ�. 
			}
		});
		add(quitButton);
		
		//stage����â s1 ��ư ���� 
		//1���� 20�� ���� �ϴ�. 
		s1Button.setVisible(false); //�ϴ� �����Ҷ� ���� ������ �ʰ� �Ѵ�. 
		s1Button.setBounds(475, 105, 100,100); //��ư�� ��ġ 
		s1Button.setBorderPainted(false); //��ư�� �ܰ��� ǥ�� ����
		s1Button.setContentAreaFilled(false); // ��ư ���� ä���� ����.
		s1Button.setFocusPainted(false); //��ư ���� �Ҷ� ������ �׵θ� ǥ������ ����. 
		s1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s1Button.setIcon(stage1ButtonEnteredImage); //���콺�� ������ �� ���� �������� EnteredImage�� �ٲ���. 
				s1Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� Ŀ�� �ø��� Ŀ���� �հ��� ������� �ٲ� .
				nowSelected = 1; //���� ������ ���������� 1���� �˷��� ����
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s1Button.setIcon(stage1ButtonBasicImage); //���콺�� �������� �������� �ٽ� �⺻ �̹����� �ٲ۴�.
				s1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �������� Ŀ���� �̹����� �⺻ ȭ��ǥ�� ���� 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //���� ����� ���� ��ü ����, �ݺ� x
				buttonEnteredMusic.start(); //��ư�� ���� ��  ������ ����Ѵ�. 
				selectedStage(nowSelected); //mouseEntered�� �Ҷ� �Էµ� nowSelected =1�� Ȱ����, ���� ������ ���������� 1���� �˷��ְ��Ѵ� .
				gameStart(nowSelected); //���õ� stage��ȣ�� �ΰ��� ȭ�鿡 ���� ������ ������ �ϰ�, �׿� �ɸ´� �����Ǹ� �ҷ��ͼ� ������ �����ϰ� �Ѵ� .
			}
		});
		add(s1Button); //��ư�� �߰��Ѵ�. 
		
		//stage����â s2 ��ư ����
		s2Button.setVisible(false);
		s2Button.setBounds(600, 105, 100, 100);
		s2Button.setBorderPainted(false);
		s2Button.setContentAreaFilled(false);
		s2Button.setFocusPainted(false);
		s2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s2Button.setIcon(stage2ButtonEnteredImage);
				s2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s2Button.setIcon(stage2ButtonBasicImage);
				s2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s2Button);

	//stage����â s3 ��ư ����
		s3Button.setVisible(false);
		s3Button.setBounds(725, 105, 100, 100);
		s3Button.setBorderPainted(false);
		s3Button.setContentAreaFilled(false);
		s3Button.setFocusPainted(false);
		s3Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s3Button.setIcon(stage3ButtonEnteredImage);
				s3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 3;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s3Button.setIcon(stage3ButtonBasicImage);
				s3Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s3Button);				

		//stage����â s4 ��ư ����
		s4Button.setVisible(false);
		s4Button.setBounds(850, 105, 100, 100);
		s4Button.setBorderPainted(false);
		s4Button.setContentAreaFilled(false);
		s4Button.setFocusPainted(false);
		s4Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s4Button.setIcon(stage4ButtonEnteredImage);
				s4Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 4;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s4Button.setIcon(stage4ButtonBasicImage);
				s4Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s4Button);

		//stage����â s5 ��ư ����
		s5Button.setVisible(false);
		s5Button.setBounds(975, 105, 100, 100);
		s5Button.setBorderPainted(false);
		s5Button.setContentAreaFilled(false);
		s5Button.setFocusPainted(false);
		s5Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s5Button.setIcon(stage5ButtonEnteredImage);
				s5Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 5;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s5Button.setIcon(stage5ButtonBasicImage);
				s5Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s5Button);

		//stage����â s6 ��ư ����
		s6Button.setVisible(false);
		s6Button.setBounds(475, 230, 100, 100 );
		s6Button.setBorderPainted(false);
		s6Button.setContentAreaFilled(false);
		s6Button.setFocusPainted(false);
		s6Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s6Button.setIcon(stage6ButtonEnteredImage);
				s6Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 6;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s6Button.setIcon(stage6ButtonBasicImage);
				s6Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s6Button);
		
		//stage����â s7 ��ư ����
		s7Button.setVisible(false);
		s7Button.setBounds(600, 230, 100, 100);
		s7Button.setBorderPainted(false);
		s7Button.setContentAreaFilled(false);
		s7Button.setFocusPainted(false);
		s7Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s7Button.setIcon(stage7ButtonEnteredImage);
				s7Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 7;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s7Button.setIcon(stage7ButtonBasicImage);
				s7Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s7Button);		
		
		//stage����â s8 ��ư ����
		s8Button.setVisible(false);
		s8Button.setBounds(725, 230, 100, 100 );
		s8Button.setBorderPainted(false);
		s8Button.setContentAreaFilled(false);
		s8Button.setFocusPainted(false);
		s8Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s8Button.setIcon(stage8ButtonEnteredImage);
				s8Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 8;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s8Button.setIcon(stage8ButtonBasicImage);
				s8Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s8Button);			
		
		//stage����â s9 ��ư ����
		s9Button.setVisible(false);
		s9Button.setBounds(850, 230, 100, 100 );
		s9Button.setBorderPainted(false);
		s9Button.setContentAreaFilled(false);
		s9Button.setFocusPainted(false);
		s9Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s9Button.setIcon(stage9ButtonEnteredImage);
				s9Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 9;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s9Button.setIcon(stage9ButtonBasicImage);
				s9Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s9Button);			
		
		//stage����â 10 ��ư ����
		s10Button.setVisible(false);
		s10Button.setBounds(975, 230, 100, 100 );
		s10Button.setBorderPainted(false);
		s10Button.setContentAreaFilled(false);
		s10Button.setFocusPainted(false);
		s10Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s10Button.setIcon(stage10ButtonEnteredImage);
				s10Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 10;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s10Button.setIcon(stage10ButtonBasicImage);
				s10Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s10Button);	
		
		//stage����â 11 ��ư ����
		s11Button.setVisible(false);
		s11Button.setBounds(475, 355, 100, 100);
		s11Button.setBorderPainted(false);
		s11Button.setContentAreaFilled(false);
		s11Button.setFocusPainted(false);
		s11Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s11Button.setIcon(stage11ButtonEnteredImage);
				s11Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 11;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s11Button.setIcon(stage11ButtonBasicImage);
				s11Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s11Button);			
		
		//stage����â 12 ��ư ����
		s12Button.setVisible(false);
		s12Button.setBounds(600, 355, 100, 100);
		s12Button.setBorderPainted(false);
		s12Button.setContentAreaFilled(false);
		s12Button.setFocusPainted(false);
		s12Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s12Button.setIcon(stage12ButtonEnteredImage);
				s12Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 12;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s12Button.setIcon(stage12ButtonBasicImage);
				s12Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s12Button);			

		//stage����â 13 ��ư ����
		s13Button.setVisible(false);
		s13Button.setBounds(725, 355, 100, 100);
		s13Button.setBorderPainted(false);
		s13Button.setContentAreaFilled(false);
		s13Button.setFocusPainted(false);
		s13Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s13Button.setIcon(stage13ButtonEnteredImage);
				s13Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 13;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s13Button.setIcon(stage13ButtonBasicImage);
				s13Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s13Button);					
		
		//stage����â 14 ��ư ����
		s14Button.setVisible(false);
		s14Button.setBounds(850, 355, 100, 100);
		s14Button.setBorderPainted(false);
		s14Button.setContentAreaFilled(false);
		s14Button.setFocusPainted(false);
		s14Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s14Button.setIcon(stage14ButtonEnteredImage);
				s14Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 14;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s14Button.setIcon(stage14ButtonBasicImage);
				s14Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s14Button);					

		//stage����â 15 ��ư ����
		s15Button.setVisible(false);
		s15Button.setBounds(975, 355, 100, 100);
		s15Button.setBorderPainted(false);
		s15Button.setContentAreaFilled(false);
		s15Button.setFocusPainted(false);
		s15Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s15Button.setIcon(stage15ButtonEnteredImage);
				s15Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 15;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s15Button.setIcon(stage15ButtonBasicImage);
				s15Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s15Button);							
		
		//stage����â 16 ��ư ����
		s16Button.setVisible(false);
		s16Button.setBounds(475, 480, 100, 100);
		s16Button.setBorderPainted(false);
		s16Button.setContentAreaFilled(false);
		s16Button.setFocusPainted(false);
		s16Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s16Button.setIcon(stage16ButtonEnteredImage);
				s16Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 16;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s16Button.setIcon(stage16ButtonBasicImage);
				s16Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s16Button);				

		//stage����â 17 ��ư ����
		s17Button.setVisible(false);
		s17Button.setBounds(600, 480, 100, 100);
		s17Button.setBorderPainted(false);
		s17Button.setContentAreaFilled(false);
		s17Button.setFocusPainted(false);
		s17Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s17Button.setIcon(stage17ButtonEnteredImage);
				s17Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 17;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s17Button.setIcon(stage17ButtonBasicImage);
				s17Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s17Button);		
		
		//stage����â 18 ��ư ����
		s18Button.setVisible(false);
		s18Button.setBounds(725, 480, 100, 100);
		s18Button.setBorderPainted(false);
		s18Button.setContentAreaFilled(false);
		s18Button.setFocusPainted(false);
		s18Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s18Button.setIcon(stage18ButtonEnteredImage);
				s18Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 18;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s18Button.setIcon(stage18ButtonBasicImage);
				s18Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s18Button);				

		//stage����â 19 ��ư ����
		s19Button.setVisible(false);
		s19Button.setBounds(850, 480, 100, 100);
		s19Button.setBorderPainted(false);
		s19Button.setContentAreaFilled(false);
		s19Button.setFocusPainted(false);
		s19Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s19Button.setIcon(stage19ButtonEnteredImage);
				s19Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 19;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s19Button.setIcon(stage19ButtonBasicImage);
				s19Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s19Button);				

		//stage����â 20 ��ư ����
		s20Button.setVisible(false);
		s20Button.setBounds(975, 480, 100, 100);
		s20Button.setBorderPainted(false);
		s20Button.setContentAreaFilled(false);
		s20Button.setFocusPainted(false);
		s20Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s20Button.setIcon(stage20ButtonEnteredImage);
				s20Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nowSelected = 20;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s20Button.setIcon(stage20ButtonBasicImage);
				s20Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectedStage(nowSelected);
				gameStart(nowSelected);
			}
		});
		add(s20Button);				
		
		
		//������ Ȯ���� staticButton ����  - ������������ ȭ�� (����ȭ��) �� ��ġ�Ѵ�. 
		statisticButton.setVisible(false); //�ϴ� ��Ȱ��ȭ ��Ų���·� �߰���ų ��
		statisticButton.setBounds(120, 100, 160,160); //����ư�� ��ġ 
		statisticButton.setBorderPainted(false); //��ư�� ������ ó�� ����
		statisticButton.setContentAreaFilled(false); //��ư�� ���� ä���� ������
		statisticButton.setFocusPainted(false); //��ư Ŭ���� ������ �ܰ��� �Ⱥ��̰� ��.
		statisticButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				statisticButton.setIcon(statisticButtonEnteredImage); //Ŀ���� ��ư���� �ø���쿡 EnteredImage�� �ٲ���. 
				statisticButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ���� ��ư���� �ø���쿡 ���콺 Ŀ���� �հ��� ������� �ٲ���. 
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				statisticButton.setIcon(statisticButtonBasicImage);
				statisticButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//���� Ȯ���ϴ� LeaderBoardȭ������ ���ư��� �̺�Ʈ
				enterLeaderBoard();
			}
		});
		add(statisticButton);
				
		//��� ȭ�鿡�� �������� ���ư��� �ϴ� �ڷΰ����ư backButton_leaderBoard ����
		backButton_leaderBoard.setVisible(false); //�ϴ� �Ⱥ��̴� ���·� �߰� 
		backButton_leaderBoard.setBounds(15, 35, 120,120); //���ư ��ġ
		backButton_leaderBoard.setBorderPainted(false); //��ư�� ������ �Ⱥ��̰���
		backButton_leaderBoard.setContentAreaFilled(false); //��ư ���� ä���� ����
		backButton_leaderBoard.setFocusPainted(false); //��ư�� ������ �� �ܰ��� �Ⱥ��̰� ��. 
		backButton_leaderBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton_leaderBoard.setIcon(backButtonEnteredImage); //Ŀ���� �ø��� �̹����� EnteredImage�� �ٲ�� ��
				backButton_leaderBoard.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ø��� ���콺 Ŀ���� �հ��� ������� �ٲ� 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton_leaderBoard.setIcon(backButtonBasicImage); //Ŀ������ ������ �⺻ �̹��� 
				backButton_leaderBoard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư Ŭ���Ҷ� ��������� �� �ִ� ��ü ����, �ݺ� ����
				buttonEnteredMusic.start(); //���� ���
				//����ȭ������ ���ư��� �̺�Ʈ
				backMain_leaderBoard();
			}
		});
		add(backButton_leaderBoard);
		
		//TitleMenu�� ���ư��� goTitleButton ����
		goTitleButton.setVisible(false); //ó���� �Ⱥ��̰� ����
		goTitleButton.setBounds(157, 400, 70,70); //��ư�� ��ġ
		goTitleButton.setBorderPainted(false); //��ư�� ������ �Ⱥ��̰� ��
		goTitleButton.setContentAreaFilled(false); //��ư�� ���� ��ä��
		goTitleButton.setFocusPainted(false); //��ư �����Ҷ� �ܰ��� �Ⱥ��̰� ��. 
		goTitleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goTitleButton.setIcon(goTitleButtonEnteredImage); //��ư�� Ŀ�� �ø��� EnteredImage�� �ٲ�� ��
				goTitleButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //��ư�� Ŀ�� �ø��� ���콺 Ŀ�� �̹��� �հ��� ������� �ٲٰ��� 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goTitleButton.setIcon(goTitleButtonBasicImage);
				goTitleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); 
				buttonEnteredMusic.start();
				//����ȭ������ ���ư��� �̺�Ʈ
				backTitle_Main();
			}
		});
		add(goTitleButton);		
		
		//TITLE�۾�
        title.setVisible(false);
        title.setBounds(120, 462, 500, 120);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        add(title);
		
		
	    //��� ���̺�
	    recordTable.setBounds(210, 150, 300, 500);
	    recordTable.setVisible(false);
	    recordTable.setBackground(new Color(0, 0, 0, 0));
	    recordTable.setShowGrid(false);
	    recordTable.setRowHeight(24);
	    recordTable.setFont(new Font("Arial", Font.BOLD, 12));
	    //��� ����
	    DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
	    tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tcmSchedule = recordTable.getColumnModel();
	    for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
	    tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
	    }
	    add(recordTable);
	    //��������� �ֽű�� �ִܱ�Ͽ� �̹��� �� ����
	    newRecordimage.setVisible(false);
	    newRecordimage.setBounds(314, 50, 90, 90);
	    add(newRecordimage);
	    bestRecordimage.setVisible(false);
	    bestRecordimage.setBounds(414, 50, 90, 90);
	    add(bestRecordimage);
	    
	  //RECORD�۾�
        reco.setVisible(false);
        reco.setBounds(90, 200, 500,120);
        reco.setFont(new Font("Arial", Font.BOLD, 50));
        add(reco);
	    
		//����ȭ�� ��� ǥ��
		stageString.setBounds(180, 150, 500, 100);
		stageString.setFont(new Font("Serif", Font.BOLD, 50));
		stageString.setVisible(false);
		add(stageString);
		recordBest.setBounds(360, 220, 200, 200);
		recordBest.setFont(new Font("Serif", Font.BOLD, 50));
		recordBest.setVisible(false);
		add(recordBest);
		bestRecordimage_success.setVisible(false);
		bestRecordimage_success.setBounds(230, 280, 100, 100);
		add(bestRecordimage_success);
		recordRecent.setBounds(360, 350, 200, 200);
		recordRecent.setFont(new Font("Serif", Font.BOLD, 50));
		recordRecent.setVisible(false);
		add(recordRecent);
		newRecordimage_success.setVisible(false);
		newRecordimage_success.setBounds(230, 400, 100, 100);
		add(newRecordimage_success);

		
		//��� �����ϴ� �޴��� ���� 
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { //�޴��ٸ� Ŭ������ �巡�� �Ұ�� ���콺�� x��ǥ�� y��ǥ�� ���� â�� ������ �� �ִ�. 
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//�޴��ٸ� Ŭ������ �巡�� �Ұ�� ���콺�� x��ǥ�� y��ǥ�� ���� â�� ������ �� �ִ�. 
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // �޴��ٸ� ��� �巡�� �ؼ� �̵� �� �� ���� ����â�� ��ġ�� �ٲٰ� ���� 
			}
		});
		add(menuBar); //JFRAME�� �޴��ٰ� �׷���. 
		

		Music introMusic = new Music("introMusic.mp3", true); //���� Ȥ�� ������ ���� �����Ű�� ������ ��� ���� 
		introMusic.start(); //���� ��� ����
	}

	public void paint(Graphics g) { // ���α׷� ȭ�� ũ�⸸ŭ �̹����� �����ؼ�, �� �̹����� �츮�� ���ϴ� ���� �׸��µ� �װ� �׸��°� screenDraw()�� ���
		screenImage = createImage(SMain.SCREEN_WIDTH, SMain.SCREEN_HEIGHT); // 1280 * 780 �� �̹����� ����� �װ� screenIamge ��ü��
																			// �־���
		screenGraphic = screenImage.getGraphics(); // screenImage�� �̿��ؼ� ��ü ������
		screenDraw(screenGraphic); // �� �� ������ �޼��� , ��ũ�� �׷��ȿ� �׸��� �׷��ִ� �Լ�
		g.drawImage(screenImage, 0, 0, null); // ��ũ�� �̹�� 0,0 ��ġ�� �׷��ִ� �Լ�
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // background�� ��ü �̹��� ��ũ�� �̹����� �׸��� ����.
		paintComponents(g); // �̹����� �ܼ��ϰ� ��ũ�� �̹����ȿ� �׷��ִ� �� �̿ܿ� JLABEL���� JFRAME�ȿ� �߰��ϸ� �װ� �׷��ִ°�, draw�� �׷��ִ°�
							// �ְ� , paintComponents�� �׷���. ���������� �����̴� �̹����� �ƴϱ� ������, paintComponents�� �׷��� ����
		this.repaint(); // �ٽ� ����Ʈ �Լ��� �׷���. ��ü ȭ�� �̹����� �� ��������, ����Ǵ� �������� �Դٰ����ϸ鼭 �׷��ִ� ����
	}
	
	public void selectedStage(int nowSelected) { //�������� ��ư���� Ŭ������ �� � ���������� Ŭ���ߴ��� �˷��� �޼ҵ�
		stageNumber = stageList.get(nowSelected).getStageNumber();
	}
	
	public void stageTurnOn() { //s1 ���� s20���� ��ư���� Ȱ��ȭ ��Ų��. 
		s1Button.setVisible(true);
		s2Button.setVisible(true);
		s3Button.setVisible(true); 
		s4Button.setVisible(true); 
		s5Button.setVisible(true); 
		s6Button.setVisible(true); 
		s7Button.setVisible(true); 
		s8Button.setVisible(true); 
		s9Button.setVisible(true); 
		s10Button.setVisible(true); 
		s11Button.setVisible(true); 
		s12Button.setVisible(true); 
		s13Button.setVisible(true); 
		s14Button.setVisible(true); 
		s15Button.setVisible(true); 
		s16Button.setVisible(true); 
		s17Button.setVisible(true); 
		s18Button.setVisible(true); 
		s19Button.setVisible(true); 
		s20Button.setVisible(true); 
	}
	
	public void stageTurnOff() {  //s1 ���� s20���� ��ư���� ��Ȱ��ȭ ��Ų��. 
		s1Button.setVisible(false);
		s2Button.setVisible(false); 
		s3Button.setVisible(false); 
		s4Button.setVisible(false); 
		s5Button.setVisible(false); 
		s6Button.setVisible(false); 
		s7Button.setVisible(false); 
		s8Button.setVisible(false); 
		s9Button.setVisible(false); 
		s10Button.setVisible(false); 
		s11Button.setVisible(false); 
		s12Button.setVisible(false); 
		s13Button.setVisible(false); 
		s14Button.setVisible(false); 
		s15Button.setVisible(false); 
		s16Button.setVisible(false); 
		s17Button.setVisible(false); 
		s18Button.setVisible(false); 
		s19Button.setVisible(false); 
		s20Button.setVisible(false); 
	}
	
	public void enterLeaderBoard() {
		//GameStart�� ����ϰ� ��Ÿ ��ư���� ����� �Ѵ�. 
		//������ Ȯ�� �� �� �ִ� ���â���� ���� �ϴ� �Լ� 
		startButton.setVisible(false); //��ŸƮ ��ư�� ���� �ʿ� x
		quitButton.setVisible(false); //quit��ư�� ��������
		isMainScreen = false;  //���â�̶� ����ȭ���� �ƴ�
		stageTurnOff(); //�������� ��ư���� ���� �ʿ䰡 ����. 
		goTitleButton.setVisible(false); //���â�̶� Ÿ��Ʋ�� ���ư� ��ư�� Ȱ��ȭ�� �ʿ䰡 ����. 
		title.setVisible(false); // ���θ޴��� ���̴� Title���� ���� �ʿ� ����
		reco.setVisible(false); //���θ޴��� ���̴� Record���� ���� �ʿ� ����
		statisticButton.setVisible(false); //��ư�� ������ �� ������ ��Ȳ�� ���̴� ���̱⿡ ���ȭ������ ���� ��ư�� ���� �ʿ� ����. 
		
		//�������� ȭ�鿡�� ������ ��ɵ� �����ֱ�
		background = new ImageIcon(SMain.class.getResource("../images/leaderBoard.jpg")).getImage();  // ��� ���ȭ�� �ҷ� �� �� �ִ� ��ü
		recordTable.setVisible(true); //���ȭ�鳻 ���̺��� �����ش�. 
		newRecordimage.setVisible(true); //���ȭ�鿡 ���̴� �ֱ� ��� �̹��� ����
		bestRecordimage.setVisible(true); //���ȭ�鿡 ���̴� �ִ� ��� �̹��� ����
		backButton_leaderBoard.setVisible(true); //���ȭ�鿡�� ����� �ڷΰ��� ��ư Ȱ��ȭ
	}
	public void backMain_leaderBoard() { //���ȭ�鿡�� �ٽ� ���θ޴��� ���ƿ��� �ϴ� �޼ҵ� 
		startButton.setVisible(false); //��ŸƮ ��ư �����ʿ� x
		quitButton.setVisible(false); //quit ��ư �����ʿ� x 
		
		//���� ȭ�鿡 ������ �ϴ� ���
		isMainScreen = true; //���θ޴��� ���ƿԱ� ����
		stageTurnOn(); //����ڿ��� ���������� �� �� �ְ� ����� ��. 
		goTitleButton.setVisible(true); //Title�� ���ư� �� �ִ� ��ư �����ְ�
		title.setVisible(true); //Ÿ��Ʋ ���� �����ֱ� 
		reco.setVisible(true); //Record���� �����ֱ� 
		statisticButton.setVisible(true); //���ȭ������ �ٽ� ���ư� �� �ְ� ��� ��ư Ȱ��ȭ 
		background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // �������� ���� ���ȭ�� �ҷ� �� �� �ִ� ��ü
		
	    //�������忡�� ���ƿ� ��쿡 ����Ǿ�� �ϴ� ���̵�
	    recordTable.setVisible(false); //���θ޴����� ���� ���̺��� �ƴϹǷ� ��Ȱ��ȭ
	    newRecordimage.setVisible(false); //���� �������� . 
		bestRecordimage.setVisible(false);
	    backButton_leaderBoard.setVisible(false);//���θ޴��� �Ա� ������ �ٽ� ���θ��� �������� ��ư �ʿ� ����. 
	    
	}
	
	public void backTitle_Main() { //���θ޴��� �Ѿ�� ������ �ٽ� Ÿ��Ʋ �޴��� ���̱� ���� ����ϴ� �޼ҵ�
		isMainScreen = false; //Ÿ��Ʋ ȭ���� ����ȭ���� �ƴ�
	    
		//Ÿ��Ʋ ȭ�鿡 ���� ���̵�
	    startButton.setVisible(true);
		quitButton.setVisible(true);
		background = new ImageIcon(SMain.class.getResource("../images/introBackground.jpg")).getImage();  // ���ȭ�� �ҷ� �� �� �ִ� ��ü
		
		//Ÿ��Ʋ ȭ�鿡 ���� ���̵�
		stageTurnOff(); //stage�� ����ȭ�鿡�� ����.
		backButton.setVisible(false); //start�� ����ȭ������ �� �� �ֱ⿡ �ڷΰ��� ��ư �ʿ� ����. 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ â���� x�� ������ �� �� �ְ� ���ش�. 
		goTitleButton.setVisible(false); //Ÿ��Ʋ ȭ������ �Ѿ�ͼ� ��� ������ ������ ����. 
		title.setVisible(false); //���� ����
		reco.setVisible(false);
		statisticButton.setVisible(false);
	}
		
	public void Success(int stageNum, String stageTime) { //���� ������ ����ȭ������ �Ѿ���� �κ�. 
		stageNum = this.stageNumber; //����ȭ�鳻 ���° ���������� Ŭ���� �ߴ��� �����ִ� ����
		stageTime = this.stageTime; //�����ϴµ� �ð��� �󸶳� �ɷȴ��� �����ִ� ���� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x������ ���� �� �� �־�� ��. 
		Music buttonEnteredMusic = new Music("buttonSuccessMusic.mp3", false); //�������� �� ���� ���� ���� ��ü ����, �ݺ� ����
		buttonEnteredMusic.start(); //���� ��� ���� 
		//�������� �ϴ� ��ü��
		background = new ImageIcon(SMain.class.getResource("../images/success.jpg")).getImage();  // ���� ���ȭ�� �ҷ� �� �� �ִ� ��ü
		backButton.setVisible(true); //����ȭ������ ���ư� �� �־�� �Ѵ�. 
		
		//��� ǥ�� ���̱�
		stageString.setText(stageNumber+" Stage Record"); //����� ���������� Ŭ���� �߳���? 
		stageString.setVisible(true); // �������� �� ���̺��� ���̰� �Ѵ�. 
		recordBest.setVisible(true); //�ִ� ��� ���̺��� ���̰� �Ѵ�. 
		recordRecent.setVisible(true); // �ֱ� ��� ���̺��� ���̰� �Ѵ�. 
		bestRecordimage_success.setVisible(true); //����ȭ��� �ִܱ�� �̹��� ���̰� �ϱ� 
		newRecordimage_success.setVisible(true); //����ȭ��� �ֱٱ�� �̹��� ���̰� �ϱ� 
		//�������� ���ƾ� �ϴ� ��ü�� 
		isMainScreen = false; //�翬�� ����ȭ���� �ƴ� 
		startButton.setVisible(false); //���� Ÿ��Ʋ ȭ�鿡���� ����
		quitButton.setVisible(false);
		recordTable.setVisible(false); //��� ���̺� ���� ���� ����.
		RecipePanel.setVisible(false);
	}
	
	public void enterMain() { //Ÿ��Ʋ ȭ�鿡�� ����ȭ������ ��ȯ�ϰ� �ϴ� �޼ҵ� 
		//������ �ϴ� ��ü�� 
		background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // ���ȭ�� �ҷ� �� �� �ִ� ��ü
		isMainScreen = true; //���� ȭ�鿡 ���� ���̹Ƿ� ���� ȭ���� ���� 
		stageTurnOn(); //stage��ư 1~20�� Ȱ��ȭ �����ش�.  
		goTitleButton.setVisible(true); //���� ȭ�鿡�� �ٽ� Ÿ��Ʋ ȭ������ ���ư� �� �ְ� ��ư�� Ȱ��ȭ ��Ų��. 
        title.setVisible(true); //���� ȭ�鿡 ���̴� Title ���̺� �����ֱ� 
		reco.setVisible(true); // ���� ȭ�鿡 ���̴� Record ���̺� �����ֱ� 
		statisticButton.setVisible(true); //���� ȭ�鿡 ���̴� ��� ��ư Ȱ��ȭ ��Ű��. 
		
		//������ ���ƾ� �ϴ� ��ü�� 
		startButton.setVisible(false); //���� Ÿ��Ʋ ȭ�� ����
		quitButton.setVisible(false);		
		recordTable.setVisible(false);	//���� ���̺��� ���� ������ ����. 
	}
	
	   public void gameStart(final int stageNumber) {
		      mode =1; //��� ���°� ���� �����Ҷ����� �ʱ�ȭ �ȴ�. 
		   	  /* �������� ������ ȭ�鿡�� �ΰ��� ȭ������ �Ѿ�� */
		      isMainScreen = false; 
		      stageTurnOff();
		      //selectedStage(nowSelected); //selectedStage�Լ��� stageNumber���� �˷���
		      background = new ImageIcon(SMain.class.getResource("../images/ingameBackground2.png")).getImage();  // ���ȭ�� �ҷ� �� �� �ִ� ��ü
		      
		      //�ΰ��� ��ư ����
		      backButton.setVisible(true);
		      recordTable.setVisible(false);
		      goTitleButton.setVisible(false);
		      title.setVisible(false);
		      reco.setVisible(false);
		      statisticButton.setVisible(false);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		      //���� ���������� �����Ǹ� �޾ƿ�
		      rcpcard=rcp.getRecipe(stageNumber);
		      
		      //�� ���� ���� - ��ư �� �г� �ʱ�ȭ
		      Go = new JButton(goButtonBasicImage);
		      Try = new JButton(tryButtonBasicImage);
		      TimerPanel = new JPanel();
		      TextArea = new JScrollPane(ta);
		      num = new JLabel("0");
		      Buttons = new JPanel();
		      RecipePanel = new JPanel();
		      
		      ta.setOpaque(false);
		      ta.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		      ta.setFont(new Font("����", Font.BOLD, 12));
		      ta.setText(null);//�ؽ�Ʈ �ʱ�ȭ
		      ta.append(" "+stageNumber + " ��° �������� ����!\n");
		      ta.append(" �ܹ��Ÿ� ���� ���� �� �ؿ��� �����Ͽ�\n");
		      ta.append(" ��Ḧ �ϳ��� �׾� �÷����մϴ�!\n");
		      ta.append(" �ִ��� ���� \n");
		      ta.append(" "+rcpcard.RecipeName+"��");
		      ta.append("\n ------------------------------\n");
		      for(int i=rcpcard.length-1; i>=0; i--) {
		         ta.append(" "+rcpcard.IngName[rcpcard.recipe[i]]+"\n");
		      }
		      ta.append(" ------------------------------\n");
		      ta.append(" ������ּ���.\n");
		      
		      //Ÿ�̸�
		      TimerPanel.setLayout(new FlowLayout());
		      TimerPanel.setLocation(540,50);
		      TimerPanel.setSize(200, 100);
		      TimerPanel.setBackground(new Color(0, 0, 0, 0));
		      num.setFont(new Font("Verdana",1,50));
		      TimerPanel.add(num);
		      timer.setInitialDelay(0);
		      timer.start();
		      //TimerPanel ����
		      add(TimerPanel);
		      //TimerPanel.setVisible(true);
		              
		         //���� �� ����� ���� �����ǽ��ÿ� ����
		         recipe.getRecipe(rcpcard.recipe);
		         recipe.printStack();//�ֿܼ� �Էµ� ������ ������ ���
		           
		         //text area����
		         TextArea.setLocation(24,165);
		         TextArea.setSize(250, 525);
		         TextArea.setBorder(BorderFactory.createEmptyBorder());//������ ����
		         TextArea.setOpaque(false);//��� ����
		         TextArea.getViewport().setOpaque(false);//��� ����
		         add(TextArea);
		         TextArea.setVisible(true);
		         
		         //�����ư
		         Go.setBounds(690,590,200,100);
	             Go.setBorderPainted(false); //��ư�� ������ �Ⱥ��̰� ��
	             Go.setContentAreaFilled(false); //��ư�� ���� ��ä��
	             Go.setFocusPainted(false); //��ư �����Ҷ� �ܰ��� �Ⱥ��̰� ��.
		         add(Go);
		         Go.setVisible(true);
		         
		         //������ư
		         Try.setBounds(390,590,200,100);
	             Try.setBorderPainted(false); //��ư�� ������ �Ⱥ��̰� ��
	             Try.setContentAreaFilled(false); //��ư�� ���� ��ä��
	             Try.setFocusPainted(false); //��ư �����Ҷ� �ܰ��� �Ⱥ��̰� ��.
		         add(Try);
		         Try.setVisible(true);
		         
		         //��ư���� JPanel : Buttons
		         ////���ī�� ��ư ����s
		         Buttons.setLayout(new GridLayout(2,6));
		         cardButton b[]= new cardButton[12];
		         cardButton cards=new cardButton(Integer.toString(0), 0, new ImageIcon("images/01.jpg"), new ImageIcon("images/01.jpg"));
		         //ī���ư�� ���� �޼ҵ�+��ư����(��ư,������)�� ���Խ�Ų �޼ҵ带 �߰����� (���� newGUI�� �ڵ带 �̵���Ŵ
		         //cards�迭�� �޼ҵ� ����� ���� �ӽû�����    -   cards.MakeCard()�� ���ÿ� ����ϱ� ����
		         b=cards.MakeCard(b, Buttons, this); //stage��ư�� ���������� �긦 �����ϰ�, b�� stage�� ���ο� �Ѱ��شٸ�??? 
		         
		         
		         //�����ư ������
		         Go.addActionListener(new goActionListener(b, this));
		         
		         //������ư ������
		         Try.addActionListener(new tryActionListener(b, this));
		         
		         //�ʱ� ��ư���� ���� - �����ư Ŭ�� �Ұ���/ ������ư Ŭ�� ����
		         //���� �����Ϸ��� ������ư�� ���� ���� ���¿����Ѵ�.
		         setButton(mode, Go, Try, b);
		         
		         Buttons.setLocation(300, 165);
		         Buttons.setSize(690, 400);
		         add(Buttons);
		         Buttons.setVisible(true);
		         
		         //�ڷΰ����ư backButton ����
		         backButton.setVisible(true); //�ϴ� ������ ���ۉ����Ƿ� ���ư�� ���̰� �߰��Ѵ�. 
		         backButton.setBounds(15, 35, 120,120); //��ư�� ��ġ 
		         backButton.setBorderPainted(false); //��ư�� ������ �Ⱥ��̰� �Ѵ�. 
		         backButton.setContentAreaFilled(false); //��ư�� ���� ��ä���. 
		         backButton.setFocusPainted(false); //��ư�� �����Ҷ� �ܰ��� �Ⱥ��̰� �Ѵ�. 
		         backButton.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseEntered(MouseEvent e) {
		               backButton.setIcon(backButtonEnteredImage); //���콺�� ��ư���� �ø���, �̹����� EnteredImage�� �ٲ۴�. 
		               backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ���� ��ư���� �ö���� �հ��� ������� �ٲ۴�. 
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		               backButton.setIcon(backButtonBasicImage); //������ �ٽ� �⺻�̹����� �ٲ� 
		               backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //������ �ٽ� ȭ��ǥ �̹����ιٲ�. 
		            }
		            @Override
		            public void mousePressed(MouseEvent e) {
		               //����ȭ������ ���ư��� �̺�Ʈ
		               backMain(); //�ϴܿ� ������ BackMain����� �����Ѵ�. 
		            }
		            private void backMain() { //�ΰ��� ȭ���̴�, ����ȭ�鿡�� �ٽ� ���� ȭ������ ��ȯ ��Ű�� �޼ҵ� 
		               isMainScreen = true; //����ȭ������ ���ƿ��⿡ ����ȭ������ �˷��ش�. 
		               startButton.setVisible(false); //���� Ÿ��Ʋ ȭ����̶� ���ش�. 
		               quitButton.setVisible(false);
		               
		               //���� ȭ�鿡 ������ �ϴ� ���
		               stageTurnOn(); //����ȭ���̹Ƿ� ����������ư S1 ~ s20���� Ȱ��ȭ �����ش�. 
		               goTitleButton.setVisible(true); //Ÿ��Ʋ ȭ������ ���ư� �� �ִ� ��ư�� Ȱ��ȭ 
		               title.setVisible(true); //Title�̶� �����ִ� ���̺� Ȱ��ȭ
		               statisticButton.setVisible(true); //���ȭ������ �� �� �ִ� ��ư Ȱ��ȭ
		               reco.setVisible(true); //Record��� �����ִ� ���̺� Ȱ��ȭ 
		               background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // �������� ���� ���ȭ�� �ҷ� �� �� �ִ� ��ü
		               
		               //���� ���� ���ƿ� ��쿡 ȭ�鿡�� ���������� �ϴ� ���̵�
		               backButton.setVisible(false); //�ΰ��ӿ� backButtonȤ�� ����ȭ�鿡 �ִ� Backbutton�� ���̻� ���� �ʿ� ����. 
		               Buttons.setVisible(false); //ī���ư ���� ���� �ʿ䰡 ����. 
		                Try.setVisible(false); //���� ��ư�� x
		                Go.setVisible(false); //���� ��ư�� x
		                TextArea.setVisible(false); //�ΰ��� ȭ��� ��ü�� �ƹ�ư �� ���ش�. 
		                TimerPanel.setVisible(false); //Ÿ�̸� �гε� ���� ���ش�.
		                RecipePanel.setVisible(false);
		               // TODO Auto-generated method stub
		                
		                /*
		                 * ���� ����� stageTimeList�迭�� �����Ű�� StackBurger_DB�� �����ϴ� �Լ� 
		                 * ���ư �� backMain()�Լ��� Success()�޼��忡���� �۵��ϱ⿡ ����ȭ�鿡�� ����ȭ������ ���ư� ���� ����ȴ�.
		                 */
		        	    RecordDAO rdao=new RecordDAO();
		                rdao.RecordSave(stageTimeList);  
		                
		                //���� ȭ�鿡�� ���ƿ� ��쿡 ȭ�鿡�� ���������� ���̵�
		                //��� ǥ�� �����
		                stageString.setVisible(false); //����ȭ�鿡�� ���̴� �� ��° stage���� �˷��ִ� ���̺� ��Ȱ��ȭ
		                recordBest.setVisible(false); //�ִܱ�� �����ִ� ���̺� ��Ȱ��ȭ
		                recordRecent.setVisible(false); //�ֱٱ�� �����ִ� ���̺� ��Ȱ��ȭ
		                bestRecordimage_success.setVisible(false); //�ִܱ�� �����ִ� ����ȭ��� �̹��� ��Ȱ��ȭ
		                newRecordimage_success.setVisible(false); //�ֱٱ�� �����ִ� ����ȭ��� �̹��� ��Ȱ��ȭ 

		            }
		         });
		         add(backButton);
		         
		         //������GUI
		         int yPos = 360-30*rcpcard.length;
		         if(yPos<50)yPos=50;//�޴��� �ؿ� �ֱ�
		         RecipePanel.setLocation(1030,yPos);
		         RecipePanel.setSize(200, 700);
		         RecipePanel.setBackground(new Color(0, 0, 0, 0));
		         RecipePanel.setLayout(new FlowLayout());
		         add(RecipePanel);
		         for(int i=rcpcard.length-1; i>0; i--) {//������ ���Ҹ��� �ش� �̹��� �ױ�
		        	 rFile = "images/r/"+Integer.toString(rcpcard.recipe[i])+".png";
		        	 r[i+1] = new JLabel(new ImageIcon(rFile));
		        	 RecipePanel.add(r[i+1]);
			      }
		         //�ǹؿ� ���� �ٸ� �׸�
		         r[1] = new JLabel(new ImageIcon("images/r/00.png"));
	        	 RecipePanel.add(r[1]);
	        	 //������ �̸� 
	        	 r[0] = new JLabel(rcpcard.RecipeName);
	        	 RecipePanel.add(r[0]);
//		         RecipePanel.add();

		   }
	
	//GUI ��ư ���� ���� �Լ� mode=1: ������ư Ȱ��ȭ/�����ư ��Ȱ��ȭ, mode=2: ������ư ��Ȱ��ȭ/�����ư Ȱ��ȭ
	void setButton(int mode, JButton g, JButton t, cardButton[] b) {
		if(mode==1) {
			g.setEnabled(false);
			t.setEnabled(true);
		}
		if(mode==2) {
			g.setEnabled(true);
			t.setEnabled(false);
		}
	}
}
