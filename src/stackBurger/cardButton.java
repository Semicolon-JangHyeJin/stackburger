package stackBurger;

import java.util.Arrays;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;

@SuppressWarnings("serial")
class cardButton extends JButton {
	public int num;
	ImageIcon image1,image2;
	boolean check;
	
	public cardButton(String str,int n,ImageIcon image,ImageIcon back) {
		// TODO Auto-generated constructor stub
		super(str,back);
		image1=image;
		image2=back;
		num=n;
		check=true;//뒷면인 상태이면 true
		this.setBorderPainted(false); //버튼의 내부 안채움
		this.setFocusPainted(false);//버튼 선택할때 외각선 안보이게 함.
	}
	
	public void clickButton() {//카드의 앞면을 보여줌
		if(check)
		{
			setIcon(image1);
			check=false;
			this.setFocusPainted(false);//버튼 선택할때 외각선 안보이게 함.
		}
	}
	public void  returnImage() {
		setIcon(image2);
		check=true;
	}
	
	public cardButton[] MakeCard(cardButton[] cards, JPanel Buttons, StackBurger GUI) {
		//재료카드 이미지 삽입
		ImageIcon images[]= {new ImageIcon("images/0.PNG"),new ImageIcon("images/1.PNG"),new ImageIcon("images/2.PNG"),new ImageIcon("images/3.PNG"),new ImageIcon("images/4.PNG"),new ImageIcon("images/5.PNG")};
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,6));
		
		Integer[] arr = new Integer[12];//재료카드 셔플에 사용
		////재료카드셔플
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = i;
	    }
	    Collections.shuffle(Arrays.asList(arr));
	    
	    //셔플 된 재료카드 위치 콘솔에 출력
	    for (int i = 0; i < arr.length; i++) {
	    	System.out.println("재료카드 : "+i+"번째 "+arr[i]%6);
	    }
        
		////재료카드 버튼에 재료 넣기
		for(int i=0;i<12;i++) {
			////여기서 중복 없는 랜덤으로 카드 넣어야함
			cards[i] = new cardButton(Integer.toString(arr[i]%6), i, images[arr[i]%6], new ImageIcon("images/999.PNG"));
			jp.add(cards[i]);
		}
		
		for(int i=0;i<12;i++) {
			//버튼 마다 리스너생성
			cards[i].addActionListener(new newActionListener(cards, GUI, i));
		}
		GUI.Buttons=jp;
		return cards;
	}
}