package stackBurger;

class ArrayStack{//스택 객체를 생성할때 ArrayStack 클래스 사용하기
    private int top, top_r;//top:일반 스택//top_r:레시피스택
    private int stackSize;
    private int itemArray[];
    public int elemNum=0;//스택의 원소 갯수
    
    public ArrayStack getRecipe(int[] recipe) {//레시피 배열을 스택으로 바꾸기
       top=recipe.length-1;
       this.stackSize=recipe.length;
       itemArray=recipe;
       top_r=top;
       return this;
    }

    public ArrayStack(int stackSize){//생성자
      top = -1;
      this.stackSize = stackSize;
      itemArray = new int[this.stackSize];
    }
    public boolean isEmpty(){//스택이 비여있으면 true리턴
      return (top == -1);
    }
    public boolean isFull(){//스택이 꽉차있으면 true리턴
      return (top == this.stackSize-1);
    }
    public void push(int item){//스택에 매개변수 값 저장하기
      if(isFull()){//꽉차있으면 추가하지 않기
         System.out.println("Inserting fail! Array Stack is full!!");
      }
      else{
         itemArray[++top] = item;//(top에 1을 더한 값)인덱스에 item변수 저장
         System.out.println("입력재료 = " + item);
         elemNum++;//스택의 원소 갯수 1 플러스
      }
    }
    public int pop(){//스택에 제일 최근에 저장한 원소 리턴하기
      if(isEmpty()) {//비여있으면 pop하지 않음, -1값 리턴
        System.out.println("Deleting fail! Array Stack is empty!!");
        return -1;
      }
      else{
        elemNum--;//스택의 원소 갯수 1 마이너스
        return itemArray[top--];//(top에 1을 뺸 값)인덱스에 저장된 값 리턴하기
      }
    }
    //비교시 레시피카드 재료 pop하면 재시도 떄 오류 발생
    //레시피 카드 용 pop함수 따로 설정
    public int popRecipe(){
        if(isEmpty()) {//동일
          System.out.println("Deleting fail! Array Stack is empty!!");
          return -1;
        }
        else{
           return itemArray[top_r--];//(top에 1을 뺸 값)인덱스에 저장된 값 리턴하기
        }
      }
   
    public void printStack(){//콘솔창에 스택 출력
      if(isEmpty())
        System.out.printf("Array Stack is empty!! %n");
      else{
       for(int i=0; i<=top; i++)
          System.out.printf("%d ", itemArray[i]);
          System.out.println();
        }
      }
    
    public int getTop() {//top값 리턴
       return this.top;
    }
    
    public void setTopLow() {//top변수 -1로 설정해서 비여있는 스택으로 만들기
       this.top=-1;
    }
    
    public void setTop_R(int length) {//top_r변수 매개변수로 다시 설정해주는 함수
       this.top_r=length;
    }
}