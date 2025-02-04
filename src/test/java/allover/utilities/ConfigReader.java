package allover.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



     /*
    Bu class projectde sadece bir kez olusturulacak ve tekrar tekrar
    kullanilacak bir classtir
    Bu classin tek görevi test classlarimiz icinden bu getProperty methodunu cagirarak
    configuration properties dosyamizdan data cekmektir

     */


    public static String getProperty(String key){


        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);

    }




}
