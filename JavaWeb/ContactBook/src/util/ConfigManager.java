package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private Properties properties;
    private static ConfigManager configManager=null;

    private ConfigManager(){
        String configFile="database.properties";
        //加载器->Stream.
        InputStream in= ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        properties=new Properties();
        try{
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过单例模式创建configManager对象
    public static synchronized ConfigManager getInstance(){
        if(configManager==null){
            configManager=new ConfigManager();
        }
        return configManager;
    }
    //根据属性文件中的键获得对应的值
    public String getString(String key){
        return properties.getProperty(key);
    }

}
