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
      GUI.mode=2;//��� 2 �Ҵ�(������) 
      GUI.setButton(GUI.mode, GUI.Go, GUI.Try, b);//������ �����ϱ�
      GUI.ta.append("\n ����!\n");//������ ��� �ؽ�Ʈ�������� �˷��ֱ�
      GUI.selected.elemNum = 0;//�� ���ÿ� ���� ���� 0���� �ʱ�ȭ ���� ���ֱ�
   }
}