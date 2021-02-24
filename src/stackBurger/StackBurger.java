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
	/* 더블 버퍼링을 위해서 전체 화면에 대한 이미지를 담는 이미지 */

	// 버튼 이미지 선언 : 종료버튼 (화면 오른쪽 상단), 타이틀화면 시작 & 종료버튼, 뒤로가기버튼, 점수확인버튼, 타이틀화면 돌아가기 버튼
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
	// 버튼 이미지 선언: 인게임 화면 내 도전버튼, 제출 버튼 
	private ImageIcon goButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/goButtonBasic.png"));
	private ImageIcon goButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/goButtonEntered.png")); //goActionListener에서 사용됨
	private ImageIcon tryButtonBasicImage = new ImageIcon(SMain.class.getResource("../images/tryButtonBasic.png"));
    private ImageIcon tryButtonEnteredImage = new ImageIcon(SMain.class.getResource("../images/tryButtonEntered.png")); //tryActionListener에서 사용됨
	
	//Stage 번호 1~20번까지 기본이미지와 선택될때 바뀌는 이미지 둘다 선언
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
	
	//객체 선언
	private Image background = new ImageIcon(SMain.class.getResource("../images/introBackground.jpg")).getImage();  // 배경화면 불러 올 수 있는 객체 
	private JLabel menuBar = new JLabel(new ImageIcon(SMain.class.getResource("../images/menuBar.png"))); // 메뉴바 불러오는 객체
	private JLabel newRecordimage = new JLabel(new ImageIcon(SMain.class.getResource("../images/newRecord.png"))); // 최근기록 아이콘 불러오는 객체
	private JLabel bestRecordimage = new JLabel(new ImageIcon(SMain.class.getResource("../images/bestRecord.png"))); // 최단기록 아이콘 불러오는 객체
	private JLabel newRecordimage_success = new JLabel(new ImageIcon(SMain.class.getResource("../images/newRecord.png"))); //최근기록 아이콘 (성공화면)용 객체  
	private JLabel bestRecordimage_success = new JLabel(new ImageIcon(SMain.class.getResource("../images/bestRecord.png"))); //최단기록 아이콘 (성공화면)용 객체 

	//RECORD글씨
	private JLabel reco = new JLabel("RECORD");
	private JLabel title = new JLabel("TITLE");
	
	//버튼이미지를 사용한 버튼 객체 선언
	private JButton exitButton = new JButton(exitButtonBasicImage); //화면 오른쪽 상단에 위치한 x모양 버튼 객체
	private JButton startButton = new JButton(startButtonBasicImage); //타이틀 화면 시작 버튼 객체
	private JButton quitButton = new JButton(quitButtonBasicImage); //타이틀 화면 종료 버튼 객체
	private JButton s1Button = new JButton(stage1ButtonBasicImage); //메인화면 s1 버튼 ~ 
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
	private JButton backButton = new JButton(backButtonBasicImage); //인게임 화면, 성공화면에 있는 뒤로가기 버튼 객체 
	private JButton backButton_leaderBoard = new JButton(backButtonBasicImage); //점수확인 화면에서 메인으로 돌아갈때 사용할 뒤로가기 버튼 객체
	private JButton statisticButton = new JButton(statisticButtonBasicImage); // 메인화면에서 점수확인 화면으로 가기 위해 누를 점수확인 통계 버튼 객체
	private JButton goTitleButton = new JButton(goTitleButtonBasicImage); // 메인화면에서 타이틀 화면으로 돌아가기 위해 필요한 버튼 객체
	
	private int mouseX, mouseY; //프로그램내 마우스의 x와 y위치 
	
	private boolean isMainScreen = false; //처음 게임을 시작할 때는 메인 화면임을 알려줄 필요가 없다. 
	//해당 게임 안에서 메인 화면은 = 스테이지 선택 화면을 의미한다. 
	//The value of the field StackBurger.isMainScreen is not used
	//라고는 뜨지만, 현 게임의 전반적인 화면 전환 메소드에서 사용되고 있다. 
	
	//스테이지 관련 변수
	ArrayList<Stage> stageList = new ArrayList<Stage>(); 
	public int stageNumber; //현재 선택이 된 스테이지
	public int nowSelected = 0; //현재 선택이 된 스테이지 초기화 

	
	/*
	 * 해당부분은 RecordDAO 클래스 안에서, 
	 * recordInit()을 할경우 파일입출력을 통해 2차배열을 초기화 하는 작업을 하기에
	 * 더이상 사용 안하므로 주석 처리함 
	 * 모두들 코드 확인하고나면
	 * 추 후 삭제 예정 
	//스테이지 기록 저장
	public String[][] stageTimeList = new String[20][3]; //모든 stage 기록 저장 리스트
	{for(int i=0;i<20;i++) {
		stageTimeList[i][0]=(i+1)+" stage";
		stageTimeList[i][1]="0";
		stageTimeList[i][2]="0";
	}}//배열은 참조형이라서 null값이 안들어간다. 그러므로 0이 들어가 있으면 null 취급
	*/	
	
	//실질적으로 점수판 초기화 하는 생성자 및 함수들 
	RecordDAO rdao = new RecordDAO();
	//게임 실행할 때마다
	//RecordDAO클래스내 recordInit()함수를 통해 
	//StackBurger_DB.txt에서 데이터를 불러와 2차배열을 생성하고 
	//stageTimeList에 대입해준다.
	public String[][] stageTimeList = rdao.recordInit();  
	
	//기록 GUI 표 만들기
	String header[]= {"Stage","최근 기록","최단 시간 기록"}; //표의 헤더로써의 역할을 해야했으나, 이유는 모르겠지만 작동 안함
	public JTable recordTable = new JTable(stageTimeList, header); //JTable로 새로운 객체 생성
	//기록 성공화면에 보여주기
	JLabel stageString = new JLabel(); //성공화면에 몇 번재 스테이지를 성공했는지 알려줄 레이블 객체 생성
	JLabel recordBest = new JLabel(); //성공화면에 성공한 스테이지의 최단기록을 표시할 레이블 객체 생성
	JLabel recordRecent = new JLabel(); //성공화면에 성공한 스테이지의 최근기록을 표시할 레이블 객체 생성

	
	public JTextArea ta = new JTextArea(); //인게임 화면내의 현 게임상태를 표시할 텍스트 에어리어 객체 생성
	////레시피카드 ArrayStack클래스 사용하기
	public ArrayStack recipe= new ArrayStack(100);
		
	////내가 고른 카드  ArrayStack클래스 사용
	public ArrayStack selected= new ArrayStack(100);
	    	    
	//레시피정보
	public int stage =1; //레시피 카드랑 맞물려서 해당 스테이지에 맞는 레시피 카드를 불러오는 전역 변수
	private RecipeCard rcp=new RecipeCard(stage);
	public RecipeCard rcpcard=rcp.getRecipe(stage);
	    
	//게임모드: 도전 전&제출 후의 카드 뒤집어보는 상황=1, 도전상황=2
	public int mode=1;

		//인게임 구성요소
		JButton Go = new JButton("완성!");
		JButton Try = new JButton("도전!");
		JPanel TimerPanel = new JPanel();
		JScrollPane TextArea = new JScrollPane(ta);
		JLabel num = new JLabel("0");
		JPanel Seek = new JPanel();
		JPanel Buttons = new JPanel();
		JPanel Compare = new JPanel();
		JPanel RecipePanel = new JPanel();
		JLabel[] r = new JLabel[13];
		String rFile;
		//타이머
		Timer timer = new Timer(1000, new ActionListener() {
	        int count=0;
	       @Override
	        public void actionPerformed(ActionEvent e) {
	    	   count=Integer.parseInt(num.getText()); //타이머 재시작을 위해 필요한 코드
	    	   count++;
	          if (count < 100000) {
	             num.setText(Integer.toString(count));
	          } else {
	            ((Timer) (e.getSource())).stop();
	          }
	        }
	      });
	
	//StackBurger생성자
	public StackBurger() {
		setUndecorated(true); //제목 표시줄이 없는 프레임을 생성한다. 
		setTitle("Stack Burger"); //만약 제목표시줄이 있다면 타이틀은 Stack Burger가 뜨게 한다. 
		setSize(SMain.SCREEN_WIDTH, SMain.SCREEN_HEIGHT); //SMain에 정의된 창의 최대 가로와 세로길이를 통해 창의 사이즈를 설정한다. 
		setResizable(false); //게임창은 사용자가 인위적으로 줄일 수 없음 
		setLocationRelativeTo(null);  // 실행했을 때 게임창이 컴퓨터의 중앙창에 띄움
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창을 종료했을 때 게임창이 종료 됨
		setVisible(true); //눈에 게임창이 보이게 됨  
		setBackground(new Color(0,0,0,0)); //배경화면 색상 설정 
		setLayout(null); //절대값으로 화면내 객체들 위치를 배열해줄 것 이기 때문
		
		for (int i=1; i<22; i++) {
			stageList.add(new Stage(i)); //stage는 총 20가지이므로 1부터 20까지 스테이지 추가
		}
		
		//메뉴바 맨 오른쪽 x자 종료 버튼 구현
		exitButton.setBounds(1245, 0, 30, 30); //버튼의 위치 
		exitButton.setBorderPainted(false); //버튼의 외각선을 없애준다.
		exitButton.setContentAreaFilled(false); //버튼의 내용영역 채우기 안한다.
		exitButton.setFocusPainted(false); //버튼이 선택되었을때 생기는 테두리 사용안한다. 
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); //마우스가 올라갔을때 enteredImage로 바꿔줌
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 커서를 손가락 모양으로 바꿔줌 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 나왔을 때  커서를 기본 모양으로 바꿔줌 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //버튼이 눌렸을때 buttonPressedMusic을 실행할 객체 생성, 반복안함.
				buttonPressedMusic.start(); //음악 재생 
				try {
					Thread.sleep(1200); //소리가 나온다음에 1초정도 있다가 프로그램 종료됨. 
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit버튼을 클릭하면 프로그램이 종료가 된다. 
				
			}
		});
		add(exitButton); 
		
		//타이틀 창 start 버튼 구현
		startButton.setBounds(170, 400, 300, 124); //시작 버튼의 위치 
		startButton.setBorderPainted(false); //버튼의 외각선을 없애준다.
		startButton.setContentAreaFilled(false); //버튼의 내용영역 채우기 안한다.
		startButton.setFocusPainted(false); //버튼이 선택되었을때 생기는 테두리 사용안한다. 
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); //마우스가 올라갔을때 enteredImage로 바꿔줌
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 커서를 손가락 모양으로 바꿔줌 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); //마우스가 나왔을때 다시 기본이미지로 바꿔준다. 
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 나왔을 때  커서를 기본 모양으로 바꿔줌 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //마우스가 눌렸을대 실행할 음악 객체 생성, 반복 안함
				buttonPressedMusic.start(); //음악 재생
				//게임 시작 이벤트 시작
				enterMain();
			}
		});
		add(startButton);
		
		//title창 quit 버튼 구현
		quitButton.setBounds(810, 400, 300, 124); //버튼의 위치
		quitButton.setBorderPainted(false); //버튼 외각선 표시안함.
		quitButton.setContentAreaFilled(false); //버튼 내부 채우지 않음.
		quitButton.setFocusPainted(false); //버튼 선택되었을때 나올 테두리 표시하지 않는다. 
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); //마우스가 올라갔을때 enteredImage로 바꿔줌
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 커서를 손가락 모양으로 바꿔줌 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); //마우스 내려오면 기본이미지로 바꿔줌
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 나왔을 때  커서를 기본 모양으로 바꿔줌 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //종료되기전에 버튼 눌리는 소리재생할 객체 생성, 반복 안함
				buttonPressedMusic.start(); //음악 재생
				try {
					Thread.sleep(1200); //소리가 나온다음에 1초정도 있다가 프로그램 종료됨. 
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit버튼을 클릭하면 프로그램이 종료가 된다. 
			}
		});
		add(quitButton);
		
		//stage선택창 s1 버튼 구현 
		//1부터 20은 동일 하다. 
		s1Button.setVisible(false); //일단 생성할땐 눈에 보이지 않게 한다. 
		s1Button.setBounds(475, 105, 100,100); //버튼의 위치 
		s1Button.setBorderPainted(false); //버튼의 외각선 표시 안함
		s1Button.setContentAreaFilled(false); // 버튼 내부 채우지 않음.
		s1Button.setFocusPainted(false); //버튼 선택 할때 나오는 테두리 표시하지 않음. 
		s1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s1Button.setIcon(stage1ButtonEnteredImage); //마우스가 진입할 때 나올 아이콘은 EnteredImage로 바꿔줌. 
				s1Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스에 커서 올리면 커서가 손가락 모양으로 바뀜 .
				nowSelected = 1; //지금 선택한 스테이지가 1임을 알려줄 변수
			}
			@Override
			public void mouseExited(MouseEvent e) {
				s1Button.setIcon(stage1ButtonBasicImage); //마우스가 내려오면 아이콘은 다시 기본 이미지로 바꾼다.
				s1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 내려오면 커서의 이미지도 기본 화살표로 변경 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //음악 재생을 위한 객체 생성, 반복 x
				buttonEnteredMusic.start(); //버튼이 눌릴 때  음악을 재생한다. 
				selectedStage(nowSelected); //mouseEntered를 할때 입력된 nowSelected =1를 활용해, 지금 선택한 스테이지가 1임을 알려주게한다 .
				gameStart(nowSelected); //선택된 stage번호를 인게임 화면에 들어갈때 변수로 전달을 하고, 그에 걸맞는 레시피를 불러와서 게임을 시작하게 한다 .
			}
		});
		add(s1Button); //버튼을 추가한다. 
		
		//stage선택창 s2 버튼 구현
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

	//stage선택창 s3 버튼 구현
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

		//stage선택창 s4 버튼 구현
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

		//stage선택창 s5 버튼 구현
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

		//stage선택창 s6 버튼 구현
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
		
		//stage선택창 s7 버튼 구현
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
		
		//stage선택창 s8 버튼 구현
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
		
		//stage선택창 s9 버튼 구현
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
		
		//stage선택창 10 버튼 구현
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
		
		//stage선택창 11 버튼 구현
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
		
		//stage선택창 12 버튼 구현
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

		//stage선택창 13 버튼 구현
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
		
		//stage선택창 14 버튼 구현
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

		//stage선택창 15 버튼 구현
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
		
		//stage선택창 16 버튼 구현
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

		//stage선택창 17 버튼 구현
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
		
		//stage선택창 18 버튼 구현
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

		//stage선택창 19 버튼 구현
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

		//stage선택창 20 버튼 구현
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
		
		
		//점수를 확인할 staticButton 구현  - 스테이지선택 화면 (메인화면) 에 위치한다. 
		statisticButton.setVisible(false); //일단 비활성화 시킨상태로 추가시킬 것
		statisticButton.setBounds(120, 100, 160,160); //통계버튼의 위치 
		statisticButton.setBorderPainted(false); //버튼의 윤곽선 처리 안함
		statisticButton.setContentAreaFilled(false); //버튼의 내부 채우지 않음음
		statisticButton.setFocusPainted(false); //버튼 클릭시 나오는 외각선 안보이게 함.
		statisticButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				statisticButton.setIcon(statisticButtonEnteredImage); //커서를 버튼위에 올릴경우에 EnteredImage로 바꿔줌. 
				statisticButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서를 버튼위에 올릴경우에 마우스 커서를 손가락 모양으로 바꿔줌. 
				
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
				//점수 확인하는 LeaderBoard화면으로 돌아가는 이벤트
				enterLeaderBoard();
			}
		});
		add(statisticButton);
				
		//통계 화면에서 메인으로 돌아가게 하는 뒤로가기버튼 backButton_leaderBoard 구현
		backButton_leaderBoard.setVisible(false); //일단 안보이는 상태로 추가 
		backButton_leaderBoard.setBounds(15, 35, 120,120); //백버튼 위치
		backButton_leaderBoard.setBorderPainted(false); //버튼의 윤곽선 안보이게함
		backButton_leaderBoard.setContentAreaFilled(false); //버튼 내부 채우지 않음
		backButton_leaderBoard.setFocusPainted(false); //버튼을 선택할 때 외각선 안보이게 함. 
		backButton_leaderBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton_leaderBoard.setIcon(backButtonEnteredImage); //커서를 올릴때 이미지가 EnteredImage로 바뀌게 함
				backButton_leaderBoard.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 올리면 마우스 커서가 손가락 모양으로 바뀜 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton_leaderBoard.setIcon(backButtonBasicImage); //커서에서 나오면 기본 이미지 
				backButton_leaderBoard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼 클릭할때 음악재생할 수 있는 객체 생성, 반복 안함
				buttonEnteredMusic.start(); //음악 재생
				//메인화면으로 돌아가는 이벤트
				backMain_leaderBoard();
			}
		});
		add(backButton_leaderBoard);
		
		//TitleMenu로 돌아가는 goTitleButton 구현
		goTitleButton.setVisible(false); //처음에 안보이게 구현
		goTitleButton.setBounds(157, 400, 70,70); //버튼의 위치
		goTitleButton.setBorderPainted(false); //버튼의 윤곽선 안보이게 함
		goTitleButton.setContentAreaFilled(false); //버튼의 내부 안채움
		goTitleButton.setFocusPainted(false); //버튼 선택할때 외각선 안보이게 함. 
		goTitleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goTitleButton.setIcon(goTitleButtonEnteredImage); //버튼에 커서 올리면 EnteredImage로 바뀌게 함
				goTitleButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //버튼에 커서 올리면 마우스 커서 이미지 손가락 모양으로 바꾸게함 
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
				//메인화면으로 돌아가는 이벤트
				backTitle_Main();
			}
		});
		add(goTitleButton);		
		
		//TITLE글씨
        title.setVisible(false);
        title.setBounds(120, 462, 500, 120);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        add(title);
		
		
	    //기록 테이블
	    recordTable.setBounds(210, 150, 300, 500);
	    recordTable.setVisible(false);
	    recordTable.setBackground(new Color(0, 0, 0, 0));
	    recordTable.setShowGrid(false);
	    recordTable.setRowHeight(24);
	    recordTable.setFont(new Font("Arial", Font.BOLD, 12));
	    //가운데 정렬
	    DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
	    tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tcmSchedule = recordTable.getColumnModel();
	    for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
	    tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
	    }
	    add(recordTable);
	    //리더보드용 최신기록 최단기록용 이미지 상세 설명
	    newRecordimage.setVisible(false);
	    newRecordimage.setBounds(314, 50, 90, 90);
	    add(newRecordimage);
	    bestRecordimage.setVisible(false);
	    bestRecordimage.setBounds(414, 50, 90, 90);
	    add(bestRecordimage);
	    
	  //RECORD글씨
        reco.setVisible(false);
        reco.setBounds(90, 200, 500,120);
        reco.setFont(new Font("Arial", Font.BOLD, 50));
        add(reco);
	    
		//성공화면 기록 표시
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

		
		//계속 존재하는 메뉴바 구현 
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { //메뉴바를 클릭이후 드래그 할경우 마우스의 x좌표와 y좌표에 따라 창이 움직일 수 있다. 
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//메뉴바를 클릭이후 드래그 할경우 마우스의 x좌표와 y좌표에 따라 창이 움직일 수 있다. 
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 메뉴바를 잡고 드래그 해서 이동 할 때 마다 게임창의 위치를 바꾸게 해줌 
			}
		});
		add(menuBar); //JFRAME에 메뉴바가 그려짐. 
		

		Music introMusic = new Music("introMusic.mp3", true); //음악 혹은 게임을 직접 종료시키기 전까진 계속 실행 
		introMusic.start(); //음악 재생 시작
	}

	public void paint(Graphics g) { // 프로그램 화면 크기만큼 이미지를 생성해서, 그 이미지에 우리가 원하는 것을 그리는데 그걸 그리는건 screenDraw()를 사용
		screenImage = createImage(SMain.SCREEN_WIDTH, SMain.SCREEN_HEIGHT); // 1280 * 780 의 이미지를 만들고 그걸 screenIamge 객체에
																			// 넣어줌
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용해서 객체 가져옴
		screenDraw(screenGraphic); // 추 후 생성할 메서드 , 스크린 그래픽에 그림을 그려주는 함수
		g.drawImage(screenImage, 0, 0, null); // 스크린 이미즈를 0,0 위치에 그려주는 함수
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // background를 전체 이미지 스크린 이미지에 그리게 해줌.
		paintComponents(g); // 이미지를 단순하게 스크린 이미지안에 그려주는 것 이외에 JLABEL들을 JFRAME안에 추가하면 그걸 그려주는것, draw로 그려주는게
							// 있고 , paintComponents로 그려줌. 역동적으로 움직이는 이미지가 아니기 때문에, paintComponents로 그려줄 생각
		this.repaint(); // 다시 페인트 함수를 그려옴. 전체 화면 이미지를 매 순간마다, 종료되는 순간까지 왔다갔다하면서 그려주는 것임
	}
	
	public void selectedStage(int nowSelected) { //스테이지 버튼들을 클릭했을 때 어떤 스테이지를 클릭했는지 알려줄 메소드
		stageNumber = stageList.get(nowSelected).getStageNumber();
	}
	
	public void stageTurnOn() { //s1 부터 s20까지 버튼들을 활성화 시킨다. 
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
	
	public void stageTurnOff() {  //s1 부터 s20까지 버튼들을 비활성화 시킨다. 
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
		//GameStart와 비슷하게 기타 버튼들을 꺼줘야 한다. 
		//점수를 확인 할 수 있는 통계창으로 들어가게 하는 함수 
		startButton.setVisible(false); //스타트 버튼은 보일 필요 x
		quitButton.setVisible(false); //quit버튼도 마찬가지
		isMainScreen = false;  //통계창이라서 메인화면이 아님
		stageTurnOff(); //스테이지 버튼들이 보일 필요가 없다. 
		goTitleButton.setVisible(false); //통계창이라 타이틀로 돌아갈 버튼의 활성화도 필요가 없다. 
		title.setVisible(false); // 메인메뉴에 보이는 Title문구 보일 필요 없음
		reco.setVisible(false); //메인메뉴에 보이는 Record문구 보일 필요 없음
		statisticButton.setVisible(false); //버튼을 누르고 난 이후의 상황을 보이는 것이기에 통계화면으로 들어가는 버튼도 보일 필요 없음. 
		
		//리더보드 화면에서 보여줄 기능들 보여주기
		background = new ImageIcon(SMain.class.getResource("../images/leaderBoard.jpg")).getImage();  // 통계 배경화면 불러 올 수 있는 객체
		recordTable.setVisible(true); //통계화면내 테이블을 보여준다. 
		newRecordimage.setVisible(true); //통계화면에 쓰이는 최근 기록 이미지 보임
		bestRecordimage.setVisible(true); //통계화면에 쓰이는 최단 기록 이미지 보임
		backButton_leaderBoard.setVisible(true); //통계화면에서 사용할 뒤로가기 버튼 활성화
	}
	public void backMain_leaderBoard() { //통계화면에서 다시 메인메뉴로 돌아오게 하는 메소드 
		startButton.setVisible(false); //스타트 버튼 보일필요 x
		quitButton.setVisible(false); //quit 버튼 보일필요 x 
		
		//메인 화면에 보여야 하는 기능
		isMainScreen = true; //메인메뉴로 돌아왔기 때문
		stageTurnOn(); //사용자에게 스테이지를 볼 수 있게 해줘야 함. 
		goTitleButton.setVisible(true); //Title로 돌아갈 수 있는 버튼 보여주고
		title.setVisible(true); //타이틀 문구 보여주기 
		reco.setVisible(true); //Record문구 보여주기 
		statisticButton.setVisible(true); //통계화면으로 다시 돌아갈 수 있게 통계 버튼 활성화 
		background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // 스테이지 셀렉 배경화면 불러 올 수 있는 객체
		
	    //리더보드에서 돌아올 경우에 종료되어야 하는 아이들
	    recordTable.setVisible(false); //메인메뉴에서 보일 테이블이 아니므로 비활성화
	    newRecordimage.setVisible(false); //이하 마찬가지 . 
		bestRecordimage.setVisible(false);
	    backButton_leaderBoard.setVisible(false);//메인메뉴로 왔기 때문에 다시 메인모드로 돌려보낼 버튼 필요 없음. 
	    
	}
	
	public void backTitle_Main() { //메인메뉴로 넘어온 순간에 다시 타이틀 메뉴를 보이기 위해 사용하는 메소드
		isMainScreen = false; //타이틀 화면은 메인화면이 아님
	    
		//타이틀 화면에 있을 아이들
	    startButton.setVisible(true);
		quitButton.setVisible(true);
		background = new ImageIcon(SMain.class.getResource("../images/introBackground.jpg")).getImage();  // 배경화면 불러 올 수 있는 객체
		
		//타이틀 화면에 없을 아이들
		stageTurnOff(); //stage는 메인화면에만 있음.
		backButton.setVisible(false); //start로 메인화면으로 올 수 있기에 뒤로가기 버튼 필요 없다. 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //여전히 창에서 x를 누르면 끌 수 있게 해준다. 
		goTitleButton.setVisible(false); //타이틀 화면으로 넘어와서 계속 보여줄 이유가 없음. 
		title.setVisible(false); //이하 동문
		reco.setVisible(false);
		statisticButton.setVisible(false);
	}
		
	public void Success(int stageNum, String stageTime) { //도전 성공시 성공화면으로 넘어가게할 부분. 
		stageNum = this.stageNumber; //성공화면내 몇번째 스테이지를 클리어 했는지 보여주는 변수
		stageTime = this.stageTime; //성공하는데 시간이 얼마나 걸렸는지 보여주는 변수 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누르면 종료 할 수 있어야 함. 
		Music buttonEnteredMusic = new Music("buttonSuccessMusic.mp3", false); //성공했을 때 나올 성공 음악 객체 생성, 반복 안함
		buttonEnteredMusic.start(); //음악 재생 시작 
		//보여져야 하는 객체들
		background = new ImageIcon(SMain.class.getResource("../images/success.jpg")).getImage();  // 성공 배경화면 불러 올 수 있는 객체
		backButton.setVisible(true); //메인화면으로 돌아갈 수 있어야 한다. 
		
		//기록 표시 보이기
		stageString.setText(stageNumber+" Stage Record"); //몇번재 스테이지를 클리어 했나요? 
		stageString.setVisible(true); // 스테이지 명 레이블을 보이게 한다. 
		recordBest.setVisible(true); //최단 기록 레이블을 보이게 한다. 
		recordRecent.setVisible(true); // 최근 기록 레이블을 보이게 한다. 
		bestRecordimage_success.setVisible(true); //성공화면용 최단기록 이미지 보이게 하기 
		newRecordimage_success.setVisible(true); //성공화면용 최근기록 이미지 보이게 하기 
		//보여지지 말아야 하는 객체들 
		isMainScreen = false; //당연히 메인화면이 아님 
		startButton.setVisible(false); //이하 타이틀 화면에서만 보임
		quitButton.setVisible(false);
		recordTable.setVisible(false); //통계 테이블 보일 이유 없음.
		RecipePanel.setVisible(false);
	}
	
	public void enterMain() { //타이틀 화면에서 메인화면으로 전환하게 하는 메소드 
		//보여야 하는 객체들 
		background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // 배경화면 불러 올 수 있는 객체
		isMainScreen = true; //메인 화면에 들어가는 것이므로 메인 화면이 맞음 
		stageTurnOn(); //stage버튼 1~20을 활성화 시켜준다.  
		goTitleButton.setVisible(true); //메인 화면에서 다시 타이틀 화면으로 돌아갈 수 있게 버튼을 활성화 시킨다. 
        title.setVisible(true); //메인 화면에 보이는 Title 레이블 보여주기 
		reco.setVisible(true); // 메인 화면에 보이는 Record 레이블 보여주기 
		statisticButton.setVisible(true); //메인 화면에 보이는 통계 버튼 활성화 시키기. 
		
		//보이지 말아야 하는 객체들 
		startButton.setVisible(false); //이하 타이틀 화면 전용
		quitButton.setVisible(false);		
		recordTable.setVisible(false);	//통계용 테이블이 보일 이유가 없다. 
	}
	
	   public void gameStart(final int stageNumber) {
		      mode =1; //모드 상태가 게임 시작할때마다 초기화 된다. 
		   	  /* 스테이지 셀렉션 화면에서 인게임 화면으로 넘어가기 */
		      isMainScreen = false; 
		      stageTurnOff();
		      //selectedStage(nowSelected); //selectedStage함수로 stageNumber뭔지 알려줌
		      background = new ImageIcon(SMain.class.getResource("../images/ingameBackground2.png")).getImage();  // 배경화면 불러 올 수 있는 객체
		      
		      //인게임 버튼 세팅
		      backButton.setVisible(true);
		      recordTable.setVisible(false);
		      goTitleButton.setVisible(false);
		      title.setVisible(false);
		      reco.setVisible(false);
		      statisticButton.setVisible(false);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		      //현재 스테이지의 레시피를 받아옴
		      rcpcard=rcp.getRecipe(stageNumber);
		      
		      //새 게임 시작 - 버튼 및 패널 초기화
		      Go = new JButton(goButtonBasicImage);
		      Try = new JButton(tryButtonBasicImage);
		      TimerPanel = new JPanel();
		      TextArea = new JScrollPane(ta);
		      num = new JLabel("0");
		      Buttons = new JPanel();
		      RecipePanel = new JPanel();
		      
		      ta.setOpaque(false);
		      ta.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		      ta.setFont(new Font("돋음", Font.BOLD, 12));
		      ta.setText(null);//텍스트 초기화
		      ta.append(" "+stageNumber + " 번째 스테이지 시작!\n");
		      ta.append(" 햄버거를 만들 때는 맨 밑에서 시작하여\n");
		      ta.append(" 재료를 하나씩 쌓아 올려야합니다!\n");
		      ta.append(" 최대한 빨리 \n");
		      ta.append(" "+rcpcard.RecipeName+"를");
		      ta.append("\n ------------------------------\n");
		      for(int i=rcpcard.length-1; i>=0; i--) {
		         ta.append(" "+rcpcard.IngName[rcpcard.recipe[i]]+"\n");
		      }
		      ta.append(" ------------------------------\n");
		      ta.append(" 만들어주세요.\n");
		      
		      //타이머
		      TimerPanel.setLayout(new FlowLayout());
		      TimerPanel.setLocation(540,50);
		      TimerPanel.setSize(200, 100);
		      TimerPanel.setBackground(new Color(0, 0, 0, 0));
		      num.setFont(new Font("Verdana",1,50));
		      TimerPanel.add(num);
		      timer.setInitialDelay(0);
		      timer.start();
		      //TimerPanel 부착
		      add(TimerPanel);
		      //TimerPanel.setVisible(true);
		              
		         //제출 후 정답과 비교할 레시피스택에 저장
		         recipe.getRecipe(rcpcard.recipe);
		         recipe.printStack();//콘솔에 입력된 레시피 재료들을 출력
		           
		         //text area생성
		         TextArea.setLocation(24,165);
		         TextArea.setSize(250, 525);
		         TextArea.setBorder(BorderFactory.createEmptyBorder());//윤곽선 투명
		         TextArea.setOpaque(false);//배경 투명
		         TextArea.getViewport().setOpaque(false);//배경 투명
		         add(TextArea);
		         TextArea.setVisible(true);
		         
		         //제출버튼
		         Go.setBounds(690,590,200,100);
	             Go.setBorderPainted(false); //버튼의 윤곽선 안보이게 함
	             Go.setContentAreaFilled(false); //버튼의 내부 안채움
	             Go.setFocusPainted(false); //버튼 선택할때 외각선 안보이게 함.
		         add(Go);
		         Go.setVisible(true);
		         
		         //도전버튼
		         Try.setBounds(390,590,200,100);
	             Try.setBorderPainted(false); //버튼의 윤곽선 안보이게 함
	             Try.setContentAreaFilled(false); //버튼의 내부 안채움
	             Try.setFocusPainted(false); //버튼 선택할때 외각선 안보이게 함.
		         add(Try);
		         Try.setVisible(true);
		         
		         //버튼생성 JPanel : Buttons
		         ////재료카드 버튼 생성s
		         Buttons.setLayout(new GridLayout(2,6));
		         cardButton b[]= new cardButton[12];
		         cardButton cards=new cardButton(Integer.toString(0), 0, new ImageIcon("images/01.jpg"), new ImageIcon("images/01.jpg"));
		         //카드버튼에 셔플 메소드+버튼생성(버튼,리스너)를 포함시킨 메소드를 추가했음 (기존 newGUI의 코드를 이동시킴
		         //cards배열은 메소드 사용을 위해 임시생성함    -   cards.MakeCard()를 셔플에 사용하기 위함
		         b=cards.MakeCard(b, Buttons, this); //stage버튼이 눌릴때마다 얘를 실행하고, b랑 stage를 메인에 넘겨준다면??? 
		         
		         
		         //제출버튼 리스너
		         Go.addActionListener(new goActionListener(b, this));
		         
		         //도전버튼 리스너
		         Try.addActionListener(new tryActionListener(b, this));
		         
		         //초기 버튼상태 설정 - 제출버튼 클릭 불가능/ 도전버튼 클릭 가능
		         //답을 제출하려면 도전버튼을 누른 이후 상태여야한다.
		         setButton(mode, Go, Try, b);
		         
		         Buttons.setLocation(300, 165);
		         Buttons.setSize(690, 400);
		         add(Buttons);
		         Buttons.setVisible(true);
		         
		         //뒤로가기버튼 backButton 구현
		         backButton.setVisible(true); //일단 게임이 시작됬으므로 백버튼을 보이게 추가한다. 
		         backButton.setBounds(15, 35, 120,120); //버튼의 위치 
		         backButton.setBorderPainted(false); //버튼의 윤곽선 안보이게 한다. 
		         backButton.setContentAreaFilled(false); //버튼의 내부 안채운다. 
		         backButton.setFocusPainted(false); //버튼을 선택할때 외각선 안보이게 한다. 
		         backButton.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseEntered(MouseEvent e) {
		               backButton.setIcon(backButtonEnteredImage); //마우스가 버튼위에 올리면, 이미지를 EnteredImage로 바꾼다. 
		               backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서가 버튼위에 올라오면 손가락 모양으로 바꾼다. 
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		               backButton.setIcon(backButtonBasicImage); //나오면 다시 기본이미지로 바꿈 
		               backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //나오면 다시 화살표 이미지로바꿈. 
		            }
		            @Override
		            public void mousePressed(MouseEvent e) {
		               //메인화면으로 돌아가는 이벤트
		               backMain(); //하단에 서술할 BackMain명령을 수행한다. 
		            }
		            private void backMain() { //인게임 화면이던, 성공화면에서 다시 메인 화면으로 전환 시키는 메소드 
		               isMainScreen = true; //메인화면으로 돌아오기에 메인화면임을 알려준다. 
		               startButton.setVisible(false); //이하 타이틀 화면용이라 꺼준다. 
		               quitButton.setVisible(false);
		               
		               //메인 화면에 보여야 하는 기능
		               stageTurnOn(); //메인화면이므로 스테이지버튼 S1 ~ s20까지 활성화 시켜준다. 
		               goTitleButton.setVisible(true); //타이틀 화면으로 돌아갈 수 있는 버튼도 활성화 
		               title.setVisible(true); //Title이라 쓰여있는 레이블 활성화
		               statisticButton.setVisible(true); //통계화면으로 갈 수 있는 버튼 활성화
		               reco.setVisible(true); //Record라고 쓰여있는 레이블 활성화 
		               background = new ImageIcon(SMain.class.getResource("../images/mainBackground.jpg")).getImage();  // 스테이지 셀렉 배경화면 불러 올 수 있는 객체
		               
		               //게임 도중 돌아올 경우에 화면에서 없어져야할 하는 아이들
		               backButton.setVisible(false); //인게임용 backButton혹은 성공화면에 있는 Backbutton은 더이상 보일 필요 없다. 
		               Buttons.setVisible(false); //카드버튼 또한 있을 필요가 없다. 
		                Try.setVisible(false); //도전 버튼도 x
		                Go.setVisible(false); //제출 버튼도 x
		                TextArea.setVisible(false); //인게임 화면용 객체는 아무튼 다 꺼준다. 
		                TimerPanel.setVisible(false); //타이머 패널도 종료 해준다.
		                RecipePanel.setVisible(false);
		               // TODO Auto-generated method stub
		                
		                /*
		                 * 현재 기록을 stageTimeList배열에 저장시키고 StackBurger_DB를 갱신하는 함수 
		                 * 백버튼 안 backMain()함수는 Success()메서드에서도 작동하기에 성공화면에서 메인화면으로 돌아갈 때도 저장된다.
		                 */
		        	    RecordDAO rdao=new RecordDAO();
		                rdao.RecordSave(stageTimeList);  
		                
		                //성공 화면에서 돌아올 경우에 화면에서 없어져야할 아이들
		                //기록 표시 숨기기
		                stageString.setVisible(false); //성공화면에서 보이는 몇 번째 stage인지 알려주는 레이블 비활성화
		                recordBest.setVisible(false); //최단기록 보여주는 레이블 비활성화
		                recordRecent.setVisible(false); //최근기록 보여주는 레이블 비활성화
		                bestRecordimage_success.setVisible(false); //최단기록 보여주는 성공화면용 이미지 비활성화
		                newRecordimage_success.setVisible(false); //최근기록 보여주는 성공화면용 이미지 비활성화 

		            }
		         });
		         add(backButton);
		         
		         //레시피GUI
		         int yPos = 360-30*rcpcard.length;
		         if(yPos<50)yPos=50;//메뉴바 밑에 있기
		         RecipePanel.setLocation(1030,yPos);
		         RecipePanel.setSize(200, 700);
		         RecipePanel.setBackground(new Color(0, 0, 0, 0));
		         RecipePanel.setLayout(new FlowLayout());
		         add(RecipePanel);
		         for(int i=rcpcard.length-1; i>0; i--) {//레시피 원소마다 해당 이미지 쌓기
		        	 rFile = "images/r/"+Integer.toString(rcpcard.recipe[i])+".png";
		        	 r[i+1] = new JLabel(new ImageIcon(rFile));
		        	 RecipePanel.add(r[i+1]);
			      }
		         //맨밑에 빵은 다른 그림
		         r[1] = new JLabel(new ImageIcon("images/r/00.png"));
	        	 RecipePanel.add(r[1]);
	        	 //레시피 이름 
	        	 r[0] = new JLabel(rcpcard.RecipeName);
	        	 RecipePanel.add(r[0]);
//		         RecipePanel.add();

		   }
	
	//GUI 버튼 상태 설정 함수 mode=1: 도전버튼 활성화/제출버튼 비활성화, mode=2: 도전버튼 비활성화/제출버튼 활성화
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
