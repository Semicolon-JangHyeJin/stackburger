package stackBurger;

import java.util.ArrayList;

public class RecordDAO {
		//추후 파일 한줄한줄씩 받아들여서 ArrayList에 집어 넣음
		ArrayList<String> loadinglist= new ArrayList<String>(60);
		//GUI 사용해서 ArrayList에 들어온 정보들을 Update 시켜줄 예정, 저장은 배열에서 바로 저장. 
		StackBurger GUI;
		//StackBurger클래스안 stageTimeList 2차배열에 대입시켜줄 임시 배열 생성
		static String[][] temp = new String[20][3]; 
		
		//게임시작할때 파일로부터 List를 불러와 2차배열화 시키는 메소드   
		public String[][] recordInit() {
			RecordFileDAO rfdao = new RecordFileDAO(); //RecordFileDAO 생성 및 호출
			rfdao.fileCreate(); //StackBurger_DB파일이 존재하는지 확인 
			loadinglist = rfdao.fileRead(); //StackBurger_DB파일로부터 한줄씩 읽어들여 loadinglist 리스트에 추가시켜줌
			//loadinglist는 총 60줄로 이뤄져 있다. (1번째줄 stage #, 2번째줄 최근기록, 3번째줄 최단기록) x 20개 해서 60줄
			for(int i=0; i<60; i++) {
				int q = i/3; //q(몫)는 2차배열에서 몇번째 스테이지의 정보인지를 나타낸다.
				int r = i%3; //r(나머지)는 2차배열에서  stage#, 최근기록, 최단기록의 위치를 결정 짓는다. 
				temp[q][r] = loadinglist.get(i); //해당하는 위치에 List로부터의 값을 삽입 시킨다. 
			}
			return temp; //2차 배열 반납. 
		}
		//기록을 파일에 저장시킬 메소드
		//사용할 때, stageTimeList 2차배열을 parameter로 받아 List화 시키고 파일에 작성시키는 메소드 
		public void RecordSave(String[][] STAGETIMELIST) {
	        RecordFileDAO fdao = new RecordFileDAO(); //RecordFileDAO 생성 및 호출
	        String[][] temp1 = STAGETIMELIST; //stageTimeList를 받아온다. 
	        for(int i=0;i<20;i++) { //변수 i는 stage #를 상징 
				loadinglist.add(temp1[i][0]); //0번째는 stage #
				loadinglist.add(temp1[i][1]); //1번째는 최근기록
				loadinglist.add(temp1[i][2]); //2번째는 최단기록
			}
	        //RecordFileDAO내의 fileWrite 메소드를 통해 파일 내부에 작성시킨다. 
	        fdao.fileWrite(loadinglist); 
	    }
}
