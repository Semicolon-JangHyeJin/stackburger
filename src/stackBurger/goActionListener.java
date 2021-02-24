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
         GUI.recipe.setTop_R(GUI.recipe.getTop());//레시피 pop해도 사라지지 변형안되도록 top고정
         //확인용으로 콘솔창에 레시피 스택과 선택재료 스택 출력
         System.out.print("  레시피 : ");
         GUI.recipe.printStack();
         System.out.print("선택재료 : ");
         GUI.selected.printStack();
         //정답인지 체점하기(맞으면 result==true)
         result=marking(GUI.selected,GUI.recipe); //선택한 재료순서를 레시피 재료 순서와 확인하기
         System.out.println(result);//확인용 콘솔창에 정답 여부 출력
         if(result==true) {//정답이면
            GUI.ta.append(" "+stageTime+"초 도전 성공!\n");//텍스트 영역에 맞았다고 알려주기
            GUI.num.setText("0"); //성공 시 다음 stage의 타이머 restart 값 0에서 시작
            //기록 2차 배열 stageTimeList에 저장
            GUI.stageTimeList[GUI.stageNumber-1][1]=stageTime;//최근시간 업데이트
            GUI.recordRecent.setText(stageTime+" sec");//성공화면 최근기록 업데이트
            //최단시간인지 비교 : 현재시간이 최단시간보다 짧(a==true)거나(||) 최단시간이 0(이전 기록 없음)
            boolean a =Integer.parseInt(GUI.stageTimeList[GUI.stageNumber-1][2]) > Integer.parseInt(stageTime); 
            if(GUI.stageTimeList[GUI.stageNumber-1][2].equals("0") || a) { 
               GUI.recordBest.setText(stageTime+" sec");//성공화면에서 보일 최단기록 Label 업데이트                  
               GUI.stageTimeList[GUI.stageNumber-1][2]=stageTime;//최단시간 업데이트
            }
            //최단시간이 아니면
            else {
            	//성공화면 최단기록 Label은 기존에 있던 최단 기록 불러오기
            	GUI.recordBest.setText(GUI.stageTimeList[GUI.stageNumber-1][2]+" sec");       
            }
            GUI.recordTable.updateUI();//enterLeaderBoard에 있는 기록 테이블 경신
            GUI.Success(GUI.stageNumber, stageTime);//StackBurger클래스 성공함수 실행
            //패널들 끄기
              GUI.Buttons.setVisible(false);
              GUI.Try.setVisible(false);
              GUI.Go.setVisible(false);
              GUI.TextArea.setVisible(false);
              GUI.TimerPanel.setVisible(false);
         }
         //정답 아니면
         else {
            GUI.ta.append(" "+stageTime+"초 도전 실패...\n");
         }
         //결과에 상관없이 항상 실행
         GUI.mode=1;//결과 보여주고 도전모드로 넘어감
         GUI.setButton(GUI.mode, GUI.Go, GUI.Try, b);//도전모드 설정
         GUI.selected.setTopLow();//선택재료 스택을 초기화
         for(int i=0;i<12;i++) {
            b[i].setEnabled(true);
         }
   }
   
   //정답확인 함수: marking
   // * 매개변수: ArrayStack클래스 타입 2개 받음: 앞이 고른 재료 스택, 뒤가 레시피 스택
   boolean marking(ArrayStack input, ArrayStack answer) {
	   //두 스택이 하나라도 비어있거나 둘의 크기가 다른가 판단 
         if(input.isEmpty() == false && answer.isEmpty() == false && input.getTop()==answer.getTop()) {
        	//스택 크기 만큼 반복문
			while(input.isEmpty() == false && answer.isEmpty() == false) {
			   int i = input.pop();
			   int j = answer.popRecipe();//레시피의 틀리면 다시 써야하는 자료구조임으로 특별한 popRecipe()
			   if(i!=j) {
			      return false;//pop리턴 값이 같지 않으면 틀림
			   }
            }
            return true;//스택이 빌때까지 반복문 돌 수 있었으면 모든 원소 같음=> 정답
         } 
         else return false;//둘 중 하나라도 비어있거나 크기가 다르면 틀림
   }
   
}