package stackBurger;

//����ư ������ Ŭ����

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class newActionListener implements ActionListener{//����ư �����ʿ� ���
	cardButton b[];
	StackBurger GUI;
	int num;
	public newActionListener(cardButton[] b, StackBurger GUI, int i){
		this.b=b;
		this.GUI=GUI;
		num=i;
	}
	
	public void actionPerformed(ActionEvent e) {
		int clicked=Integer.parseInt(e.getActionCommand()); //Ŭ���� ��ư ��ȣ�� ������
		System.out.println(clicked); //�ַܼ� Ȯ�ΰ���
		
		if(GUI.mode==2) {//�����߿��� Ŭ���� ī�带 selected �迭�� ������
			GUI.selected.push(clicked);
			b[num].setEnabled(false);//�����߿� Ŭ���� ī��� ��Ȱ��ȭ��
			GUI.ta.append(" "+GUI.selected.elemNum+"��° ��Ḧ �׾ҽ��ϴ�.\n");
		}
		else {
			b[num].clickButton();//ī�� �ո� ������
		}
		//ī�� �ո� �����ְ� 1�� �� �޸� �����ֱ�
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	b[num].returnImage();//ī�� �޸����� �ǵ��ư�
		            }
		        }, 
		        1000 
		);
	}
}