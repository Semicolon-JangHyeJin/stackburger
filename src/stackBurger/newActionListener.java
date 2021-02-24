package stackBurger;

//재료버튼 리스너 클래스

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class newActionListener implements ActionListener{//재료버튼 리스너에 사용
	cardButton b[];
	StackBurger GUI;
	int num;
	public newActionListener(cardButton[] b, StackBurger GUI, int i){
		this.b=b;
		this.GUI=GUI;
		num=i;
	}
	
	public void actionPerformed(ActionEvent e) {
		int clicked=Integer.parseInt(e.getActionCommand()); //클릭한 버튼 번호를 리턴함
		System.out.println(clicked); //콘솔로 확인가능
		
		if(GUI.mode==2) {//도전중에는 클릭한 카드를 selected 배열에 삽입함
			GUI.selected.push(clicked);
			b[num].setEnabled(false);//도전중에 클릭된 카드는 비활성화됨
			GUI.ta.append(" "+GUI.selected.elemNum+"번째 재료를 쌓았습니다.\n");
		}
		else {
			b[num].clickButton();//카드 앞면 보여줌
		}
		//카드 앞면 보여주고 1초 후 뒷면 보여주기
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	b[num].returnImage();//카드 뒷면으로 되돌아감
		            }
		        }, 
		        1000 
		);
	}
}