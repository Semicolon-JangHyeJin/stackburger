package stackBurger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; //java zoom ����Ʈ�� �ִ� ���̺귯���� �ҷ����� �ȴ�. 
	private boolean isLoop; //���� ���� ���ѹݺ��ΰ�? 
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //StackBurger Ŭ���� �ȿ��� ���� ��ü�� ������ �� ���̴� ������ , �������� �̸���, �ݺ����θ� �������ش�. 
		try {
			this.isLoop = isLoop; //is loop ���� �ʱ�ȭ
			file = new File(SMain.class.getResource("../music/"+name).toURI()); // music.java ���������� music ���� �ȿ� �ִ� �ش������� �ּҸ� ������file������ ���� �ִ´�.  
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() { //������ ��� ������ ������ �����. 
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop); //true�� ���� �ݺ�
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	/*�ϴ� �ڵ�� �Ⱦ��δ�
	
	public int getTime() { //���� ����Ǵ� ������ � ��ġ���� ����ǰ� �ִ°�? ��) 3��¥�� �������̶��, 10�ʱ��� �÷��� = 10000 ��ȯ�Ұ�. 0.001�� �������� �˷��ִ� �� 
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { //������ ���� ����Ǵ����� �׻� ���� �� �� �ִ�. 
		isLoop = false;
		player.close();
		this.interrupt(); //�ش� �����带 �������·� ����. �� ���� �����ϴ� ���α׷��� ���� �ϴ°�
	}
	*/
	

}
