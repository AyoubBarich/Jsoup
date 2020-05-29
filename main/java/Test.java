import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


import static java.rmi.server.LogStream.log;

public class Test {




    public static void main(String[] args) throws IOException {
       final String Url = "http://www.covidmaroc.ma/Pages/AccueilAR.aspx";

       try {
           final Document Doc = Jsoup.connect(Url).get();
          /* Elements num = Doc.select("table.ms-rtestate-field tr");
           System.out.println(num.toString());*/
           Element table = Doc.select(".ms-rtestate-field").parents().first().nextElementSibling();
           Elements rows = table.select("tr");
           for (Element row : rows) {
               String header = row.select("th").text();
               String value = row.select("td").text();
               System.out.println(header + ": " + value);
           }


       }catch (Exception e){
           e.printStackTrace();
       }

    }

}
