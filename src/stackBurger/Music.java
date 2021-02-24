package stackBurger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; //java zoom 사이트에 있던 라이브러리를 불러오게 된다. 
	private boolean isLoop; //현재 곡이 무한반복인가? 
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //StackBurger 클래스 안에서 음악 객체를 생성할 때 쓰이는 생성자 , 음악파일 이름과, 반복여부를 설정해준다. 
		try {
			this.isLoop = isLoop; //is loop 변수 초기화
			file = new File(SMain.class.getResource("../music/"+name).toURI()); // music.java 상위폴더의 music 폴더 안에 있는 해당음악의 주소를 가져와file변수에 집어 넣는다.  
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() { //스레드 상속 받으면 무조건 써야함. 
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop); //true면 무한 반복
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	/*하단 코드는 안쓰인다
	
	public int getTime() { //현재 실행되는 음악이 어떤 위치에서 실행되고 있는가? 예) 3분짜리 실행중이라면, 10초까지 플레이 = 10000 반환할것. 0.001초 단위까지 알려주는 것 
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { //음악이 언제 실행되던간에 항상 종료 할 수 있다. 
		isLoop = false;
		player.close();
		this.interrupt(); //해당 스레드를 중지상태로 만듦. 그 곡을 실행하는 프로그램을 종료 하는것
	}
	*/
	

}
