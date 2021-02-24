package stackBurger;

import java.util.ArrayList;

public class RecordDAO {
		//���� ���� �������پ� �޾Ƶ鿩�� ArrayList�� ���� ����
		ArrayList<String> loadinglist= new ArrayList<String>(60);
		//GUI ����ؼ� ArrayList�� ���� �������� Update ������ ����, ������ �迭���� �ٷ� ����. 
		StackBurger GUI;
		//StackBurgerŬ������ stageTimeList 2���迭�� ���Խ����� �ӽ� �迭 ����
		static String[][] temp = new String[20][3]; 
		
		//���ӽ����Ҷ� ���Ϸκ��� List�� �ҷ��� 2���迭ȭ ��Ű�� �޼ҵ�   
		public String[][] recordInit() {
			RecordFileDAO rfdao = new RecordFileDAO(); //RecordFileDAO ���� �� ȣ��
			rfdao.fileCreate(); //StackBurger_DB������ �����ϴ��� Ȯ�� 
			loadinglist = rfdao.fileRead(); //StackBurger_DB���Ϸκ��� ���پ� �о�鿩 loadinglist ����Ʈ�� �߰�������
			//loadinglist�� �� 60�ٷ� �̷��� �ִ�. (1��°�� stage #, 2��°�� �ֱٱ��, 3��°�� �ִܱ��) x 20�� �ؼ� 60��
			for(int i=0; i<60; i++) {
				int q = i/3; //q(��)�� 2���迭���� ���° ���������� ���������� ��Ÿ����.
				int r = i%3; //r(������)�� 2���迭����  stage#, �ֱٱ��, �ִܱ���� ��ġ�� ���� ���´�. 
				temp[q][r] = loadinglist.get(i); //�ش��ϴ� ��ġ�� List�κ����� ���� ���� ��Ų��. 
			}
			return temp; //2�� �迭 �ݳ�. 
		}
		//����� ���Ͽ� �����ų �޼ҵ�
		//����� ��, stageTimeList 2���迭�� parameter�� �޾� Listȭ ��Ű�� ���Ͽ� �ۼ���Ű�� �޼ҵ� 
		public void RecordSave(String[][] STAGETIMELIST) {
	        RecordFileDAO fdao = new RecordFileDAO(); //RecordFileDAO ���� �� ȣ��
	        String[][] temp1 = STAGETIMELIST; //stageTimeList�� �޾ƿ´�. 
	        for(int i=0;i<20;i++) { //���� i�� stage #�� ��¡ 
				loadinglist.add(temp1[i][0]); //0��°�� stage #
				loadinglist.add(temp1[i][1]); //1��°�� �ֱٱ��
				loadinglist.add(temp1[i][2]); //2��°�� �ִܱ��
			}
	        //RecordFileDAO���� fileWrite �޼ҵ带 ���� ���� ���ο� �ۼ���Ų��. 
	        fdao.fileWrite(loadinglist); 
	    }
}
