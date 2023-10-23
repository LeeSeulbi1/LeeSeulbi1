import java.util.ArrayList;

public class Order extends Product{
    //기본 생성자
    Order(){}

    // 주문 금액 합계 메서드
    // 주문 리스트 출력 메서드 참고하여 변형.
    public void setTotalList(){
        ArrayList<Integer> totalList = new ArrayList<>();
        int total = 0;
        for(int n = 0 ; n+6 <= shoppingBasket.size(); n += 6){
            int price = Integer.parseInt(shoppingBasket.get(n + 4));
            totalList.add(price);
        }
        for (Integer a : totalList){
            total += a;
        }
        System.out.println("총 합계 : " + total + "원");
    }

    // 주문 리스트 출력 메서드.
    // shoppingBasket 목록에서 필요한 요소 배열 0,2(메뉴),3(설명),4(가격)
    public void getShoppingBasket(){
        // 쇼핑리스트의 0(2)2(1)3(1)4...(묶음) 가져오기
       // (n, n+2, n+3, n+4),(n+6,n+8,n+9,n+10)...
        //매개 변수 n를 주고, n을 6씩 증가시키고, 값을 가져올 수 없을 때?? shoppingBasket의 길이가 n+6보다 작을 때까지 반복
        //Key 값으로 지정한 것이 아니기 때문에, Menu에 새로운 요소가 추가되면 여기 함수도 수정해야 한다는 약점이 있음.
           System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println();
           for (int n = 0 ; n+6 <= shoppingBasket.size(); n += 6) {
               System.out.print(shoppingBasket.get(n) + " | ");
               System.out.print(shoppingBasket.get(n + 2) + " | ");
               System.out.print(shoppingBasket.get(n + 3) + " | ");
               System.out.println(shoppingBasket.get(n + 4) + " | ");
           }
            setTotalList();
           System.out.print("1. 확인      ");
           System.out.println("2. 메뉴판");
    }
}
