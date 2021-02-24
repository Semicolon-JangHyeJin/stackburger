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
		check=true;//�޸��� �����̸� true
		this.setBorderPainted(false); //��ư�� ���� ��ä��
		this.setFocusPainted(false);//��ư �����Ҷ� �ܰ��� �Ⱥ��̰� ��.
	}
	
	public void clickButton() {//ī���� �ո��� ������
		if(check)
		{
			setIcon(image1);
			check=false;
			this.setFocusPainted(false);//��ư �����Ҷ� �ܰ��� �Ⱥ��̰� ��.
		}
	}
	public void  returnImage() {
		setIcon(image2);
		check=true;
	}
	
	public cardButton[] MakeCard(cardButton[] cards, JPanel Buttons, StackBurger GUI) {
		//���ī�� �̹��� ����
		ImageIcon images[]= {new ImageIcon("images/0.PNG"),new ImageIcon("images/1.PNG"),new ImageIcon("images/2.PNG"),new ImageIcon("images/3.PNG"),new ImageIcon("images/4.PNG"),new ImageIcon("images/5.PNG")};
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,6));
		
		Integer[] arr = new Integer[12];//���ī�� ���ÿ� ���
		////���ī�����
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = i;
	    }
	    Collections.shuffle(Arrays.asList(arr));
	    
	    //���� �� ���ī�� ��ġ �ֿܼ� ���
	    for (int i = 0; i < arr.length; i++) {
	    	System.out.println("���ī�� : "+i+"��° "+arr[i]%6);
	    }
        
		////���ī�� ��ư�� ��� �ֱ�
		for(int i=0;i<12;i++) {
			////���⼭ �ߺ� ���� �������� ī�� �־����
			cards[i] = new cardButton(Integer.toString(arr[i]%6), i, images[arr[i]%6], new ImageIcon("images/999.PNG"));
			jp.add(cards[i]);
		}
		
		for(int i=0;i<12;i++) {
			//��ư ���� �����ʻ���
			cards[i].addActionListener(new newActionListener(cards, GUI, i));
		}
		GUI.Buttons=jp;
		return cards;
	}
}