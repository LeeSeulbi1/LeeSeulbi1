import java.util.*;

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
        // 매개 변수 n를 주고, n을 6씩 증가시키고, 값을 가져올 수 없을 때?? shoppingBasket의 길이가 n+6보다 작을 때까지 반복
        // Key 값으로 지정한 것이 아니기 때문에, Menu에 새로운 요소가 추가되면 여기 함수도 수정해야 한다는 약점이 있음.

        // 원하는 값만 다시 담기 위한 자료구조
        ArrayList<String> basketList = new ArrayList<>();
        // 중복 검사지
        Set<String> seenItems = new HashSet<>();
        // 총 메뉴 개수
        Set<String> totalItems = new LinkedHashSet<>();

        int count;
           System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println();

            // 키워드 중심으로 중복 제거하며 담기
        for (int n = 0 ; n+6 <= shoppingBasket.size(); n += 6) {
            String menu = shoppingBasket.get(n + 2);

            if (!seenItems.contains(menu)) {
                basketList.add(shoppingBasket.get(n) + " | ");
                basketList.add(menu + " | ");
                basketList.add(shoppingBasket.get(n + 3) + " | ");
                basketList.add(shoppingBasket.get(n + 4) + " | ");

                seenItems.add(menu);
            }
        }

            // 물건 종류와 갯수 따로 세기
        for (int n = 0 ; n+6 <= shoppingBasket.size(); n += 6) {
            count = Collections.frequency(shoppingBasket,shoppingBasket.get(n+2));
            String strCount = String.valueOf(count);
            totalItems.add(shoppingBasket.get(n+2) + " : " + strCount + "개");
        }

        for(int n = 0 ; n < basketList.size() ; n +=4){
            System.out.print(basketList.get(n));
            System.out.print(basketList.get(n+1));
            System.out.print(basketList.get(n+2));
            System.out.println(basketList.get(n+3));
        }
        for(String a : totalItems){
            System.out.println(a);
        }

            setTotalList();
           System.out.print("1. 확인      ");
           System.out.println("2. 메뉴판");

    }

}
