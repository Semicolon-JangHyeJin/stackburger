package stackBurger;

//레시피카드 클래스
public class RecipeCard {
    public String RecipeName;
    public int stage, length;
    public int[] recipe;
    //IngAll 2차 배열안에 원소가 무슨 재료인지 알기위해 IngName[] 만듬: 
    ////IngAll원소를 IngName인덱스 값으로 넣은 해당 원소가 재료 이름이다.
    public String IngName[]={"빵", "치즈", "피클", "불고기", "토마토", "양상추"};
    
    //data area... 각 스테이지의 레시피 정보를 선언해둠
    private int IngAll[][]= {{0,1,0},{0,2,0},{0,3,0},{0,4,0},{0,5,0},
                      {0,3,2,0},{0,4,1,0},{0,3,5,0},{0,3,4,0},{0,1,1,0},
                      {0,3,4,4,0},{0,3,1,2,0},{0,1,5,3,0},{0,3,4,3,0},{0,5,4,3,0},
                      {0,5,4,3,1,0},{0,5,4,1,3,0},{0,4,2,3,2,0},{0,3,1,5,2,0},{0,2,5,1,3,4,5,3,4,2,1,0}};
    private String name[]= {"치즈버거", "피클버거", "불고기버거", "토마토버거", "양상추버거", 
                      "불고기피클버거","토마토치즈버거","불고기양상추버거","불고기토마토버거","더블치즈버거",
                      "불.양.토.버거","불.치.피클버거","치.양.불.버거","더블불.토.버거","양.토.불.버거",
                      "양.토.불.치즈버거","양.토.치.불.버거","토.피.불.피클버거","불.치.양.피클버거","몬스터버거"};
    //data area 끝
    
    //레시피 카드 생성자
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