package stackBurger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//���� ������� ����ϴ� Ŭ����
public class RecordFileDAO {	
	
	//���� ���� �������پ� �޾Ƶ鿩�� ArrayList�� ���� ����
	ArrayList<String> temp2 = new ArrayList<String>();
	//������ ����̴�. StackBurger201906090 ���丮 �ٷ� ���ο� StackBurger_DB.txt������ �����ϱ� ������ ����ημ� �����θ� �Է½�Ű�� �ʴ´�. 
	File dbFile = new File("StackBurger_DB.txt");
	StackBurger GUI;
	
	//StackBurger_DB.txt ������ �����ϴ��� ���ϴ��� Ȯ�� 
	public void fileCreate() {
		try {
			if(!dbFile.exists()) {
				dbFile.canWrite();
			}
		} catch(Exception e) {
			System.out.println("���� ���� �߻�");
			e.printStackTrace();
		}
	}
	
	//ArrayList�� StackBurger_DB.txt ����� �ҷ��´�. 
	public ArrayList<String> fileRead(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(dbFile));
			if(dbFile.exists()) {
				String tempRec; //�� �پ� �޾ƿ� ���ڿ�
				while((tempRec = br.readLine()) != null) {
					temp2.add(tempRec); //null���� �ƴ϶�� tempRec�� �о�� �� ���� ArrayList�� �߰��Ѵ�. 
				}
				br.close();	//���о����� ���۸����� ����
			} else {
				System.out.println("���� ����");
			}
		} catch(Exception e) {
			System.out.println("����: ������ �������� �ʽ��ϴ�.");
			e.printStackTrace();
		}
		return temp2;
	}
	
	//���޹��� arrayList�� txt���Ͽ� �ۼ��ϴ� �޼ҵ�
	public void fileWrite(ArrayList<String> READYTOBESAVED) {
		try {
			FileWriter fwrite = new FileWriter(dbFile);
			
			temp2 = READYTOBESAVED;
			//arrayList�� �ִ� ������ ���پ� �ۼ��س�����. 
			for(int i=0;i<60;i++) {
				fwrite.write(temp2.get(i)+"\r\n");
			}
			fwrite.close(); //�ٽ����� ����
		} catch(Exception e) {
			System.out.println("���� ���� �߻�");
			e.printStackTrace();
		}
	}
}
