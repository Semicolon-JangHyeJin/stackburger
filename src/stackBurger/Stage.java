package stackBurger;

public class Stage {
	
	private int stageNumber; // 몇번째 스테이지인가? 

	public int getStageNumber() {// 몇번째 스테이지 인지 가져올 getter 메소드 
		return stageNumber-1;
	}

	public void setStageNumber(int stageNumber) { //해당 스테이지의 번호를 추후에 바꿔줄 setter메소드 현 프로그램에서 사용 안됨
		this.stageNumber = stageNumber;
	}

	public Stage(int stageNumber) { //생성자 만들어줌
		super();
		this.stageNumber = stageNumber;
	}
	
	
}
