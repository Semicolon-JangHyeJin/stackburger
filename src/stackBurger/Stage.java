package stackBurger;

public class Stage {
	
	private int stageNumber; // ���° ���������ΰ�? 

	public int getStageNumber() {// ���° �������� ���� ������ getter �޼ҵ� 
		return stageNumber-1;
	}

	public void setStageNumber(int stageNumber) { //�ش� ���������� ��ȣ�� ���Ŀ� �ٲ��� setter�޼ҵ� �� ���α׷����� ��� �ȵ�
		this.stageNumber = stageNumber;
	}

	public Stage(int stageNumber) { //������ �������
		super();
		this.stageNumber = stageNumber;
	}
	
	
}
