import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;//匯入java.util包下的Scanner類，以讀取來自System.in的輸入
public class Homework {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);//建立一個Scanner物件input

        String Currency = "";//幣別
        String category = "";//即期、現鈔
        String BAS = "";//買入、賣出
        String math = "";//輸入數字
        String judge = "";//判斷如何找出需要的資料
        List<String> RateList = new ArrayList<String>();//建立陣列

        //選擇一種幣別
        System.out.println("請選擇一種幣別：" + "\n");
        System.out.println("A:美金(USD)");
        System.out.println("B:英鎊(GBP)");
        System.out.println("C:港幣(HKD)" + "\n");
        Currency = input.nextLine();//獲取輸入的幣別選擇
        if (Currency.equals("A")){
            Currency = "美金(USD)";
        }else if (Currency.equals("B")){
            Currency = "英鎊(GBP)";
        }else if (Currency.equals("C")) {
            Currency = "港幣(HKD)";
        }else{
            System.out.println("輸入錯誤,請重新輸入：");
            Currency = input.nextLine();
        }


        //選擇類別
        System.out.println("請選擇一種類別：" + "\n");
        System.out.println("A:即期");
        System.out.println("B:現鈔" + "\n");
        category = input.nextLine();
        if (category.equals("A")){
        }else if (category.equals("B")){
        }else{
            System.out.println("輸入錯誤,請重新輸入：");
            category = input.nextLine();
        }


        //選擇買入、賣出
        System.out.println("請選擇一種方式：" + "\n");
        System.out.println("A:買入");
        System.out.println("B:賣出" + "\n");
        BAS = input.nextLine();
        if (BAS.equals("A")){
        }else if (BAS.equals("B")){
        }else{
            System.out.println("輸入錯誤,請重新輸入：");
            BAS = input.nextLine();
        }

        //輸入數字
        System.out.println("輸入要計算的數字：" + "\n");
        math = input.nextLine();
        boolean isNumeric =  math.matches("[+-]?\\d*(\\.\\d+)?");
        System.out.println(isNumeric);
        if (isNumeric == true){
        }else if(isNumeric == false){
            System.out.println("請重新輸入有效的數值：");
            math = input.nextLine();
        }



        judge = category + BAS;

        Document doc = Jsoup.connect("https://www.firstbank.com.tw/sites/fcb/ForExRatesInquiry").get();
        // 根據class獲取table
        Elements table = doc.getElementsByClass("table");
        // 使用選擇器選擇該table內所有的<tr> <tr/>
        Elements trs = table.select("tr");
        //遍歷該表格內的所有的<tr> <tr/>
        for (int i = 0; i < trs.size(); ++i) {
            // 獲取一個tr
            Element tr = trs.get(i);
            // 獲取該行的所有td節點
            Elements tds = tr.select("td");
            // 選擇某一個td節點
            for (int j = 0; j < tds.size(); ++j) {
                Element td = tds.get(j);
                // 獲取td節點的所有div
                Elements td1 = td.select("td");
                // 選擇一個div
                for (int k = 0; k < td1.size(); k++) {
                    Element td2 = td1.get(k);
                    //獲取文字資訊
                    String text = td2.text();
                    //輸出到控制檯
                    RateList.add(text);
                }
            }
        }
        System.out.println(RateList);
        Date.GetDate();
        String a = "";
        int b= RateList.indexOf(Currency);
        System.out.println(b);
        System.out.println(judge);

        //找出對應的值
        switch (judge){
            case"AA":
                a = RateList.get(RateList.indexOf(Currency)+2);
                System.out.println(a);
            case"AB":
                a = RateList.get(RateList.indexOf(Currency)+3);
                System.out.println(a);
            case"BA":
                a = RateList.get(RateList.indexOf(Currency)+6);
                System.out.println(a);
            case"BB":
                a = RateList.get(RateList.indexOf(Currency)+7);
                System.out.println(a);
        }

    }
}
