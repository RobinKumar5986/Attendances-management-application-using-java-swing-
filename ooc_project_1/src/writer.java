import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class writer {
        public void writerFunction(String[] data,String fileName,int count) throws IOException {

        try {
            //----------------------------------------------//
//            for (String s:data)
//            {
//                System.out.println(s);
//            }
            FileReader usn = new FileReader("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+fileName+"_total.txt");
            //System.out.println(fileName+"year usn file ");
            BufferedReader br = new BufferedReader(usn);
            String line;
            int[] totalDay=new int[count];
            int i=0;
            while ((line = br.readLine()) != null) {
                int n=line.length();
                char ch=line.charAt(n-1);
                int a = ch - '0';
                totalDay[i++]=a+1;
            }
            usn.close();
            //----------------------------------------------//
            int j=0;
            FileWriter fr=new FileWriter("C:\\Users\\sachi\\Desktop\\attandancr management\\ooc_project_1\\total attandance data\\"+fileName+"_total.txt",false);
            for(String s:data)
            {
                fr.write(s+"\t"+totalDay[j++]+"\n");
//                System.out.println(s);
            }
            fr.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}