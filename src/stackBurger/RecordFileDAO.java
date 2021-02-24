package stackBurger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//파일 입출력을 담당하는 클래스
public class RecordFileDAO {	
	
	//추후 파일 한줄한줄씩 받아들여서 ArrayList에 집어 넣음
	ArrayList<String> temp2 = new ArrayList<String>();
	//파일의 경로이다. StackBurger201906090 디렉토리 바로 내부에 StackBurger_DB.txt파일이 존재하기 때문에 상대경로로서 절대경로를 입력시키지 않는다. 
	File dbFile = new File("StackBurger_DB.txt");
	StackBurger GUI;
	
	//StackBurger_DB.txt 파일이 존재하는지 안하는지 확인 
	public void fileCreate() {
		try {
			if(!dbFile.exists()) {
				dbFile.canWrite();
			}
		} catch(Exception e) {
			System.out.println("생성 오류 발생");
			e.printStackTrace();
		}
	}
	
	//ArrayList로 StackBurger_DB.txt 기록을 불러온다. 
	public ArrayList<String> fileRead(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(dbFile));
			if(dbFile.exists()) {
				String tempRec; //한 줄씩 받아올 문자열
				while((tempRec = br.readLine()) != null) {
					temp2.add(tempRec); //null값이 아니라면 tempRec에 읽어온 한 줄을 ArrayList에 추가한다. 
				}
				br.close();	//다읽었으면 버퍼리더기 종료
			} else {
				System.out.println("파일 없음");
			}
		} catch(Exception e) {
			System.out.println("오류: 파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
		return temp2;
	}
	
	//전달받은 arrayList를 txt파일에 작성하는 메소드
	public void fileWrite(ArrayList<String> READYTOBESAVED) {
		try {
			FileWriter fwrite = new FileWriter(dbFile);
			
			temp2 = READYTOBESAVED;
			//arrayList에 있는 노드들을 한줄씩 작성해나간다. 
			for(int i=0;i<60;i++) {
				fwrite.write(temp2.get(i)+"\r\n");
			}
			fwrite.close(); //다썼으면 종료
		} catch(Exception e) {
			System.out.println("쓰기 오류 발생");
			e.printStackTrace();
		}
	}
}
