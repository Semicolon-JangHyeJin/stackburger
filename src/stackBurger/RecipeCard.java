package stackBurger;

//������ī�� Ŭ����
public class RecipeCard {
    public String RecipeName;
    public int stage, length;
    public int[] recipe;
    //IngAll 2�� �迭�ȿ� ���Ұ� ���� ������� �˱����� IngName[] ����: 
    ////IngAll���Ҹ� IngName�ε��� ������ ���� �ش� ���Ұ� ��� �̸��̴�.
    public String IngName[]={"��", "ġ��", "��Ŭ", "�Ұ��", "�丶��", "�����"};
    
    //data area... �� ���������� ������ ������ �����ص�
    private int IngAll[][]= {{0,1,0},{0,2,0},{0,3,0},{0,4,0},{0,5,0},
                      {0,3,2,0},{0,4,1,0},{0,3,5,0},{0,3,4,0},{0,1,1,0},
                      {0,3,4,4,0},{0,3,1,2,0},{0,1,5,3,0},{0,3,4,3,0},{0,5,4,3,0},
                      {0,5,4,3,1,0},{0,5,4,1,3,0},{0,4,2,3,2,0},{0,3,1,5,2,0},{0,2,5,1,3,4,5,3,4,2,1,0}};
    private String name[]= {"ġ�����", "��Ŭ����", "�Ұ�����", "�丶�����", "����߹���", 
                      "�Ұ����Ŭ����","�丶��ġ�����","�Ұ�����߹���","�Ұ���丶�����","����ġ�����",
                      "��.��.��.����","��.ġ.��Ŭ����","ġ.��.��.����","�����.��.����","��.��.��.����",
                      "��.��.��.ġ�����","��.��.ġ.��.����","��.��.��.��Ŭ����","��.ġ.��.��Ŭ����","���͹���"};
    //data area ��
    
    //������ ī�� ������
    RecipeCard(int stage) {
       this.stage=stage;
       RecipeName=this.name[stage-1];
       recipe=IngAll[stage-1];
       length=recipe.length;
    }
    
    public RecipeCard getRecipe(int stage) {
       return new RecipeCard(stage);
    }
}