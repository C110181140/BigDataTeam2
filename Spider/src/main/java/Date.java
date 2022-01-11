import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Date {
    public static void GetDate(){
        try {
            Document doc = Jsoup.connect("https://www.firstbank.com.tw/sites/fcb/ForExRatesInquiry").get();
            //System.out.println(doc.title());
            Elements newDate = doc.select("#forex_rate_content div.table-title.text-right small");
            for (Element Dates : newDate) {
                String LastDate = Dates.text();
                System.out.println(LastDate);
            }
        }
        catch(Exception ignored) {
        }
    }
}
