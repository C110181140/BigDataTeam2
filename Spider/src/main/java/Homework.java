import java.lang.invoke.SwitchPoint;
import java.util.Scanner;//匯入java.util包下的Scanner類，以讀取來自System.in的輸入
public class Homework {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);//建立一個Scanner物件input

        String Currency = "";//幣別
        String category = "";//即期、現鈔
        String BAS = "";//買入、賣出
        String judge = "";//判斷如何找出需要的資料

        //選擇一種幣別
        System.out.println("請選擇一種幣別：" + "\n");
        System.out.println("A:美金");
        System.out.println("B:英鎊");
        System.out.println("C:港幣" + "\n");
        Currency = input.nextLine();//獲取輸入的幣別選擇
        if (Currency.equals("A")){
            Currency = "美金";
        }        else if (Currency.equals("B")){
            Currency = "英鎊";
        }        else if (Currency.equals("C")){
            Currency = "港幣";
        }


        //選擇類別
        System.out.println("請選擇一種類別：" + "\n");
        System.out.println("A:即期");
        System.out.println("B:現鈔" + "\n");
        category = input.nextLine();
        if (category.equals("A")){
            category = "即期";
        }        else {
            category = "現鈔";
        }

        //選擇買入、賣出
        System.out.println("請選擇一種方式：" + "\n");
        System.out.println("A:買入");
        System.out.println("B:賣出" + "\n");
        BAS = input.nextLine();
        if (BAS.equals("A")){
            BAS = "買入";
        }        else {
            BAS = "賣出";
        }

        judge = category + BAS;

        switch (judge){



        }


    }
}
