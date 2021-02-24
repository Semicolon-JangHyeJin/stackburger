package stackBurger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class tryActionListener implements ActionListener{
   cardButton[] b;
   StackBurger GUI;
   
   tryActionListener(cardButton[] b, StackBurger GUI){
      this.b=b;
      this.GUI=GUI;
   }
   public void actionPerformed(ActionEvent e) {
      GUI.mode=2;//모드 2 할당(제출모드) 
      GUI.setButton(GUI.mode, GUI.Go, GUI.Try, b);//제출모드 설정하기
      GUI.ta.append("\n 도전!\n");//도전한 사실 텍스트영역에서 알려주기
      GUI.selected.elemNum = 0;//고른 스택에 원소 갯수 0으로 초기화 설정 해주기
   }
}