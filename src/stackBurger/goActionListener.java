package stackBurger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class goActionListener implements ActionListener{
   cardButton[] b;
   StackBurger GUI;
   
   goActionListener(cardButton[] b, StackBurger GUI){
      this.b=b;
      this.GUI=GUI;
   }
   public void actionPerformed(ActionEvent e) {
	   	 String stageTime = GUI.num.getText();
         boolean result;
         GUI.recipe.setTop_R(GUI.recipe.getTop());//������ pop�ص� ������� �����ȵǵ��� top����
         //Ȯ�ο����� �ܼ�â�� ������ ���ð� ������� ���� ���
         System.out.print("  ������ : ");
         GUI.recipe.printStack();
         System.out.print("������� : ");
         GUI.selected.printStack();
         //�������� ü���ϱ�(������ result==true)
         result=marking(GUI.selected,GUI.recipe); //������ �������� ������ ��� ������ Ȯ���ϱ�
         System.out.println(result);//Ȯ�ο� �ܼ�â�� ���� ���� ���
         if(result==true) {//�����̸�
            GUI.ta.append(" "+stageTime+"�� ���� ����!\n");//�ؽ�Ʈ ������ �¾Ҵٰ� �˷��ֱ�
            GUI.num.setText("0"); //���� �� ���� stage�� Ÿ�̸� restart �� 0���� ����
            //��� 2�� �迭 stageTimeList�� ����
            GUI.stageTimeList[GUI.stageNumber-1][1]=stageTime;//�ֱٽð� ������Ʈ
            GUI.recordRecent.setText(stageTime+" sec");//����ȭ�� �ֱٱ�� ������Ʈ
            //�ִܽð����� �� : ����ð��� �ִܽð����� ª(a==true)�ų�(||) �ִܽð��� 0(���� ��� ����)
            boolean a =Integer.parseInt(GUI.stageTimeList[GUI.stageNumber-1][2]) > Integer.parseInt(stageTime); 
            if(GUI.stageTimeList[GUI.stageNumber-1][2].equals("0") || a) { 
               GUI.recordBest.setText(stageTime+" sec");//����ȭ�鿡�� ���� �ִܱ�� Label ������Ʈ                  
               GUI.stageTimeList[GUI.stageNumber-1][2]=stageTime;//�ִܽð� ������Ʈ
            }
            //�ִܽð��� �ƴϸ�
            else {
            	//����ȭ�� �ִܱ�� Label�� ������ �ִ� �ִ� ��� �ҷ�����
            	GUI.recordBest.setText(GUI.stageTimeList[GUI.stageNumber-1][2]+" sec");       
            }
            GUI.recordTable.updateUI();//enterLeaderBoard�� �ִ� ��� ���̺� ���
            GUI.Success(GUI.stageNumber, stageTime);//StackBurgerŬ���� �����Լ� ����
            //�гε� ����
              GUI.Buttons.setVisible(false);
              GUI.Try.setVisible(false);
              GUI.Go.setVisible(false);
              GUI.TextArea.setVisible(false);
              GUI.TimerPanel.setVisible(false);
         }
         //���� �ƴϸ�
         else {
            GUI.ta.append(" "+stageTime+"�� ���� ����...\n");
         }
         //����� ������� �׻� ����
         GUI.mode=1;//��� �����ְ� �������� �Ѿ
         GUI.setButton(GUI.mode, GUI.Go, GUI.Try, b);//������� ����
         GUI.selected.setTopLow();//������� ������ �ʱ�ȭ
         for(int i=0;i<12;i++) {
            b[i].setEnabled(true);
         }
   }
   
   //����Ȯ�� �Լ�: marking
   // * �Ű�����: ArrayStackŬ���� Ÿ�� 2�� ����: ���� �� ��� ����, �ڰ� ������ ����
   boolean marking(ArrayStack input, ArrayStack answer) {
	   //�� ������ �ϳ��� ����ְų� ���� ũ�Ⱑ �ٸ��� �Ǵ� 
         if(input.isEmpty() == false && answer.isEmpty() == false && input.getTop()==answer.getTop()) {
        	//���� ũ�� ��ŭ �ݺ���
			while(input.isEmpty() == false && answer.isEmpty() == false) {
			   int i = input.pop();
			   int j = answer.popRecipe();//�������� Ʋ���� �ٽ� ����ϴ� �ڷᱸ�������� Ư���� popRecipe()
			   if(i!=j) {
			      return false;//pop���� ���� ���� ������ Ʋ��
			   }
            }
            return true;//������ �������� �ݺ��� �� �� �־����� ��� ���� ����=> ����
         } 
         else return false;//�� �� �ϳ��� ����ְų� ũ�Ⱑ �ٸ��� Ʋ��
   }
   
}