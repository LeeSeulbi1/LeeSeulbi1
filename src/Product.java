import java.util.ArrayList;

public class Product extends Menu{
    // 상품 저장 필드. 계속 추가가 가능하게 자료구조형 사용
    ArrayList<String> shoppingBasket = new ArrayList<>();
    //기본 생성자
    Product(){}
    //상품 저장 메서드. 3차원 배열을 무너뜨려 저장함.
    //Key 값으로 지정한 것이 아니기 때문에, Menu에 새로운 요소가 추가되면 여기 함수도 수정해야 한다는 약점이 있음.
    //저장 및 저장된 개별 요소 즉시 출력 [a][0][0] [a][1][0] [a][1][1] [a][2][0] / 필요 없는 건 [a][0][1] [a][2][1]
    public void addShoppingBasket(int i) {
        for(int a = i ; a <i+1 ;a++){
            for(int b = 0 ; b < 3 ; b++){
                for(int c = 0 ; c < 2 ; c++){
                    shoppingBasket.add(menu[a][b][c]);
                    if(b==0 && c==1){
                        continue;
                    } else if (b==2 && c==1) {
                        continue;
                    } else if (b==2 && c==0) {
                        System.out.println(menu[a][b][c]+ " | ");
                    } else {
                        System.out.print(menu[a][b][c] + " | ");
                    }
                }
            }
        }
    }

    // 선택한 상품 확인하기
    public void showEachShoppingBasket(int i) {
        for(int a = i ; a <i+1 ;a++){
            for(int b = 0 ; b < 3 ; b++){
                for(int c = 0 ; c < 2 ; c++){
                    if(b==0 && c==1){
                        continue;
                    } else if (b==2 && c==1) {
                        continue;
                    } else {
                        System.out.print(menu[a][b][c] + " | ");
                    }
                }
            }
        }
    }

    //상품 삭제 메서드
    public void deleteShoppingBasket() {
        shoppingBasket.clear();
    }

}
