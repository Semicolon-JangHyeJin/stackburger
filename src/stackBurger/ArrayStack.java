package stackBurger;

class ArrayStack{//���� ��ü�� �����Ҷ� ArrayStack Ŭ���� ����ϱ�
    private int top, top_r;//top:�Ϲ� ����//top_r:�����ǽ���
    private int stackSize;
    private int itemArray[];
    public int elemNum=0;//������ ���� ����
    
    public ArrayStack getRecipe(int[] recipe) {//������ �迭�� �������� �ٲٱ�
       top=recipe.length-1;
       this.stackSize=recipe.length;
       itemArray=recipe;
       top_r=top;
       return this;
    }

    public ArrayStack(int stackSize){//������
      top = -1;
      this.stackSize = stackSize;
      itemArray = new int[this.stackSize];
    }
    public boolean isEmpty(){//������ �������� true����
      return (top == -1);
    }
    public boolean isFull(){//������ ���������� true����
      return (top == this.stackSize-1);
    }
    public void push(int item){//���ÿ� �Ű����� �� �����ϱ�
      if(isFull()){//���������� �߰����� �ʱ�
         System.out.println("Inserting fail! Array Stack is full!!");
      }
      else{
         itemArray[++top] = item;//(top�� 1�� ���� ��)�ε����� item���� ����
         System.out.println("�Է���� = " + item);
         elemNum++;//������ ���� ���� 1 �÷���
      }
    }
    public int pop(){//���ÿ� ���� �ֱٿ� ������ ���� �����ϱ�
      if(isEmpty()) {//�������� pop���� ����, -1�� ����
        System.out.println("Deleting fail! Array Stack is empty!!");
        return -1;
      }
      else{
        elemNum--;//������ ���� ���� 1 ���̳ʽ�
        return itemArray[top--];//(top�� 1�� �A ��)�ε����� ����� �� �����ϱ�
      }
    }
    //�񱳽� ������ī�� ��� pop�ϸ� ��õ� �� ���� �߻�
    //������ ī�� �� pop�Լ� ���� ����
    public int popRecipe(){
        if(isEmpty()) {//����
          System.out.println("Deleting fail! Array Stack is empty!!");
          return -1;
        }
        else{
           return itemArray[top_r--];//(top�� 1�� �A ��)�ε����� ����� �� �����ϱ�
        }
      }
   
    public void printStack(){//�ܼ�â�� ���� ���
      if(isEmpty())
        System.out.printf("Array Stack is empty!! %n");
      else{
       for(int i=0; i<=top; i++)
          System.out.printf("%d ", itemArray[i]);
          System.out.println();
        }
      }
    
    public int getTop() {//top�� ����
       return this.top;
    }
    
    public void setTopLow() {//top���� -1�� �����ؼ� ���ִ� �������� �����
       this.top=-1;
    }
    
    public void setTop_R(int length) {//top_r���� �Ű������� �ٽ� �������ִ� �Լ�
       this.top_r=length;
    }
}