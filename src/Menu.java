import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Menu {
    // 메뉴 필드
    String[][][] menu = {
            {
                    {"마라탕","맛있습니다."},{"0단계 마라탕","안맵습니다."},{"8000", "원"}
            },
            {
                    {"마라탕","맛있습니다."},{"1단계 마라탕","신라면정도."},{"8000", "원"}
            },
            {
                    {"마라탕","맛있습니다."},{"2단계 마라탕","얼얼합니다."},{"8000", "원"}
            },
            {
                    {"꿔바로우","바삭합니다."},{"사천 꿔바로우","매콤합니다"},{"15000", "원"}
            },
            {
                    {"꿔바로우","바삭합니다."},{"찹쌀 꿔바로우","쫀득합니다"},{"15000", "원"}
            },
            {
                    {"꿔바로우","바삭합니다."},{"미니 꿔바로우","저렴합니다"},{"7000", "원"}
            },
            {
                    {"음료","시원합니다."},{"콜라","펩시입니다."},{"2000", "원"}
            },
            {
                    {"음료","시원합니다."},{"사이다","칠성입니다."},{"2000", "원"}
            },
            {
                    {"음료","시원합니다."},{"물","삼다수입니다."},{"500", "원"}
            }
    };

    // 기본 생성자
    Menu(){}

    // 카테고리 출력 메서드
    // 메뉴 카테고리, 반복문을 통해 중복을 제거하기
    // 앞 번호와 뒷 번호를 비교하는 로직으로, 마지막 번호는 비교할 뒷 번호가 없으므로 가장 상단 조건에 두고 출력
    // 배열의 순서가 중요하기 때문에... 음료 바로 뒤에 다시 마라탕 카테고리를 붙이면 중복 제거가 되지 않는다는 약점이 있음
    public void printCategory(){
        for(int i = 0 ; i < menu.length ; i++) {
            if (Objects.equals(i, menu.length - 1)) {
                System.out.print(menu[i][0][0]);
                System.out.print(" | ");
                System.out.println(menu[i][0][1]);
            } else if (Objects.equals(menu[i][0][0],menu[i+1][0][0])){
                continue;
            } else {
                System.out.print(menu[i][0][0]);
                System.out.print(" | ");
                System.out.println(menu[i][0][1]);
            }
        }
    }

    // 상품 출력 메서드
    // 0~8까지 index를 받음
    // menu[i][1][0], [i][1][1], [i][2][0] 출력 필요
    public void printProduct(String food){
        switch (food){
            case "마라탕", "꿔바로우", "음료":
                for(int i = 0 ; i < menu.length ; i++){
                    if(Objects.equals(food,menu[i][0][0])){
                        System.out.print(i + ". ");
                        System.out.print(menu[i][1][0] + " | ");
                        System.out.print(menu[i][1][1] + " | ");
                        System.out.println(menu[i][2][0] + " | ");
                    }
                }
                break;

            default:
                System.out.println("잘못된 이름을 입력하셨습니다.");
        }
    }
}
