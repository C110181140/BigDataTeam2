import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Spider {
    public static void main(String[] args) {
        try {
            List<String> RateList = new ArrayList<String>();
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
                    // 獲取td節點的所有子td
                    Elements td1 = td.select("td");
                    // 選擇一個子td
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
