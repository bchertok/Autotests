package sberoad.generators;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dataprovider  {
//    @DataProvider
//    public Iterator<Object[]> data1() throws IOException {
//        List<Object[]> list = new ArrayList<Object[]>();
//        Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\BChertok\\Documents\\GitHub\\Autotests\\src\\test\\resources\\xxx.txt"),"utf-8");
//        BufferedReader br = new BufferedReader(reader);
//        String line = br.readLine();
//        while (line != null){
//            String[] split = line.split(";");
//                    list.add(new Object[]{new Str})
//
//        }
//
//    return list.iterator();
//    }


@DataProvider(name="data1")
public Iterator<Object[]> dataProviderTest() throws Exception{
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{"228","322"});
    list.add(new Object[]{"228","322"});

    return list.iterator();
}

@Test(dataProvider = "data1")
        public void RandomTest(String userName,String password) throws FileNotFoundException, UnsupportedEncodingException {
    System.out.println(userName);
    System.out.println(password);
}


}