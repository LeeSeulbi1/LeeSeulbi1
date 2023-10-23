import java.util.Objects;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        // 손주 order 객체 생성
        Order b = new Order();
        // 스캐너 생성
        Scanner sc = new Scanner(System.in);
        // 메인 인사
        System.out.println("어서 오세요. 마라탕 집입니다.");
        // 주문 목록 무한 반복
        boolean makeOrder = true;
        //주문 번호
        int orderNumber = 0;

        while (makeOrder) {
            // 메인 메뉴
            System.out.println();
            System.out.println("아래 메뉴판에서 종류를 골라 이름을 입력해 주세요.");
            System.out.println();
            System.out.println("[식사]");
            System.out.println();
            // 메뉴 카테고리 출력 메서드
            b.printCategory();
            // 주문 메뉴
            System.out.println();
            System.out.println("주문을 확인하시려면 아래 번호를 골라 입력해 주세요.");
            System.out.println("[주문 확인]");
            System.out.println("1. 장바구니 확인 및 주문");
            System.out.println("2. 장바구니 비우기");

            //카테고리 입력
            String category = sc.next();
            //카테고리 처리
            switch (category) {
                case "1":
                    if(b.shoppingBasket.isEmpty()){
                        System.out.println("장바구니가 비어 있습니다.");
                        System.out.println("3초 후 메뉴판으로 돌아갑니다.");
                        try {
                            // 3초 동안 현재 스레드를 일시 정지
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            System.out.println("시스템 오류");
                        }
                        break;
                    }else {
                    b.getShoppingBasket();
                    }
                    String finalChoice = sc.next();
                    switch (finalChoice){
                        case "1":
                            System.out.println("주문이 완료되었습니다!");
                            b.deleteShoppingBasket();
                            orderNumber++;
                            System.out.println("대기 번호는 " + orderNumber + "번입니다.");
                            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
                            try {
                                // 3초 동안 현재 스레드를 일시 정지
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                System.out.println("시스템 오류");
                            }
                            break;

                        case "2":
                            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
                            try {
                                // 3초 동안 현재 스레드를 일시 정지
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                System.out.println("시스템 오류");
                            }
                        default:
                            System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                    }

                    break;

                case "2":
                    b.deleteShoppingBasket();
                    System.out.println("장바구니를 모두 비우셨습니다.");
                    break;

                case "마라탕", "꿔바로우", "음료":

                    System.out.println("아래 음식을 보고 번호를 골라 입력해 주세요.");
                    // 카테고리 출력
                    b.printProduct(category);
                    // 음식 선택
                    String choice = sc.next();
                    // 카테고리별 입력 수 제한
                    if(Objects.equals(category,"마라탕")){
                        while (!choice.equals("0") && !choice.equals("1") && !choice.equals("2")){
                            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
                            choice = sc.next();
                        }
                        int intChoice = parseInt(choice);
                        b.showEachShoppingBasket(intChoice);
                        System.out.println();
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.print("1. 확인     ");
                        System.out.println("2. 취소");
                    }

                    else if (Objects.equals(category,"꿔바로우")){
                        while (!choice.equals("3") && !choice.equals("4") && !choice.equals("5")){
                            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
                            choice = sc.next();
                        }
                        int intChoice = parseInt(choice);
                        b.showEachShoppingBasket(intChoice);
                        System.out.println();
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.print("1. 확인     ");
                        System.out.println("2. 취소");
                    }

                    else if(Objects.equals(category,"음료")){
                        while (!choice.equals("6") && !choice.equals("7") && !choice.equals("8")){
                            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
                            choice = sc.next();
                        }
                        int intChoice = parseInt(choice);
                        b.showEachShoppingBasket(intChoice);
                        System.out.println();
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.print("1. 확인     ");
                        System.out.println("2. 취소");
                    } else {
                        System.out.println("잘못된 내용을 입력하셨습니다. 다시 입력해 주세요.");
                        sc.next();
                    }

                    // 옵션 선택
                    String choice2 = sc.next();
                    switch (choice2){
                        case "1":
                            int intChoice = parseInt(choice);
                            b.addShoppingBasket(intChoice);
                            System.out.println("메뉴가 무사히 장바구니에 담겼습니다.");
                            System.out.println("결제를 진행하시려면 [1. 장바구니 확인 및 주문]을 선택해 주세요.");
                            System.out.println();
                            break;

                        case "2":
                            System.out.println("장바구니 담기가 취소되었습니다.");
                            break;

                        default:
                            while (!choice2.equals("1") && !choice2.equals("2")){
                            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
                                choice2 = sc.next();
                            }
                            switch (choice2){
                                case "1":
                                    intChoice = parseInt(choice);
                                    b.addShoppingBasket(intChoice);
                                    System.out.println("메뉴가 무사히 장바구니에 담겼습니다.");
                                    System.out.println("결제를 진행하시려면 [1. 장바구니 확인 및 주문]을 선택해 주세요.");
                                    System.out.println();
                                    break;

                                case "2":
                                    System.out.println("장바구니 담기가 취소되었습니다.");
                                    break;
                            }
                            break;
                    }
                    break;

                default:
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    break;
            }
        }
    }
}

