import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;//匯入java.util包下的Scanner類，以讀取來自System.in的輸入
public class Homework {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);//建立一個Scanner物件input

        String Currency;//幣別
        String category;//即期、現鈔
        String BAS;//買入、賣出
        String math;//輸入數字
        String judge;//判斷如何找出需要的資料
        List<String> RateList = new ArrayList<>();//建立陣列

        Date.GetDate();

        Document doc = Jsoup.connect("https://www.firstbank.com.tw/sites/fcb/ForExRatesInquiry").get();
        // 根據class獲取table
        Elements table = doc.getElementsByClass("table");
        // 使用選擇器選擇該table內所有的<tr> <tr/>
        Elements trs = table.select("tr");
        //遍歷該表格內的所有的<tr> <tr/>
        for (Element tr : trs) {
            // 獲取該行的所有td節點
            Elements tds = tr.select("td");
            // 選擇某一個td節點
            for (Element td : tds) {
                // 獲取td節點的所有子td
                Elements td1 = td.select("td");
                // 選擇一個子td
                for (Element td2 : td1) {
                    //獲取文字資訊
                    String text = td2.text();
                    //輸出到控制檯
                    RateList.add(text);
                }
            }
        }
//        System.out.println(RateList);
        Date.GetDate();
        String rate = "";//匯率
//        int b= RateList.indexOf(Currency);
//        System.out.println(b);
//        System.out.println(judge);


        //選擇一種幣別
        System.out.println("請選擇一種幣別：" + "\n");
        System.out.println("A:美金(USD)");
        System.out.println("B:英鎊(GBP)");
        System.out.println("C:港幣(HKD)" + "\n");
        Currency = input.nextLine();//獲取輸入的幣別選擇
        label:
        while (true) {
            switch (Currency) {
                case "A":
                    Currency = "美金(USD)";
                    System.out.println("你輸入的是" + Currency);
                    break label;
                case "B":
                    Currency = "英鎊(GBP)";
                    System.out.println("你輸入的是" + Currency);
                    break label;
                case "C":
                    Currency = "港幣(HKD)";
                    System.out.println("你輸入的是" + Currency);
                    break label;
                default:
                    System.out.println("輸入錯誤,請重新輸入：");
                    Currency = input.nextLine();
                    break;
            }
        }

        String a;
            //選擇類別
            System.out.println("請選擇一種類別：" + "\n");
            System.out.println("A:即期");
            System.out.println("B:現鈔" + "\n");
            category = input.nextLine();
            while (true) {
                if (category.equals("A")) {
                    a = "即期";
                    System.out.println("你輸入的是" + a);
                    break;
                } else if (category.equals("B")) {
                    a = "現鈔";
                    System.out.println("你輸入的是" + a);
                    break;
                } else {
                    System.out.println("輸入錯誤,請重新輸入：");
                    category = input.nextLine();
                }

            }
            //選擇買入、賣出
            String b;
            System.out.println("請選擇一種方式：" + "\n");
            System.out.println("A:買入");
            System.out.println("B:賣出" + "\n");
            BAS = input.nextLine();
            while (true) {
                if (BAS.equals("A")) {
                    b = "買入";
                    System.out.println("你輸入的是" + b);
                    break;
                } else if (BAS.equals("B")) {
                    b = "賣出";
                    System.out.println("你輸入的是" + b);
                    break;
                } else {
                    System.out.println("輸入錯誤,請重新輸入：");
                    BAS = input.nextLine();
                }

            }
            //輸入數字
            System.out.println("輸入要計算的數值" + (Currency) + "：" + "\n");
            math = input.nextLine();
            boolean isNumeric = math.matches("[+-]?\\d*(\\.\\d+)?");
//        System.out.println(isNumeric);
            while (true) {
                if (isNumeric) {
                    break;
                } else {
                    System.out.println("請重新輸入有效的數值：");
                    math = input.nextLine();
                }
            }
            judge = category + BAS;//判斷
                //找出對應的值
                switch (judge) {
                    case "AA"://即期買入
                        rate = RateList.get(RateList.indexOf(Currency) + 2);
                        System.out.println(Currency + "即期買入價:" + rate + "\n");
                        break;
                    case "AB"://即期買出
                        rate = RateList.get(RateList.indexOf(Currency) + 3);
                        System.out.println(Currency + "即期買出價:" + rate + "\n");
                        break;
                    case "BA"://現鈔買入
                        rate = RateList.get(RateList.indexOf(Currency) + 6);
                        System.out.println(Currency + "現鈔買入價:" + rate + "\n");
                        break;
                    case "BB"://現鈔買出
                        rate = RateList.get(RateList.indexOf(Currency) + 7);
                        System.out.println(Currency + "現鈔買出價:" + rate + "\n");
                        break;
                }



                //計算過程
                double ans;//答案
                double maths = Double.parseDouble(math);//輸入數字
                double rates = Double.parseDouble(rate);//輸入匯率
                ans = maths * rates;

                Date.showDate();
                System.out.println("計算結果:" + ans);//輸出結過

    }
}