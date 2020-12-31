package dino.extension;
import java.util.*;
import java.io.*;
class iniException extends Exception{
    iniException(String errmessage){
        super(errmessage);
    }
}
public class readini {
    /**
     * 去除ini文件中的注释，以";"或"#"开头，顺便去除UTF-8等文件的BOM头
     * @param source
     */
    private static String removeIniComments(String source){
        String result = source;

        if(result.contains(";")){
            result = result.substring(0, result.indexOf(";"));
        }

        if(result.contains("#")){
            result = result.substring(0, result.indexOf("#"));
        }

        return result.trim();
    }



    public static Map<String,Object> readIni(String filename) throws iniException{
        if(filename.indexOf(".ini")==-1) {
            throw new iniException("Error: This is not an ini file!\n");
        }
        Map<String,List<String>> listResult=new HashMap<>();
        Map<String,Object> result=new HashMap();
        String globalSection = "global";

        File file = new File(filename);
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = null;
            String currentSection = globalSection; //处理缺省的section
            List<String> currentProperties = new ArrayList<>();
            boolean lineContinued = false;
            String tempStr = null;

            //一次读入一行（非空），直到读入null为文件结束
            //先全部放到listResult<String, List>中
            while ((str = reader.readLine()) != null) {
                str = removeIniComments(str).trim(); //去掉尾部的注释、去掉首尾空格

                if("".equals(str)||str==null){
                    continue;
                }

                //如果前一行包括了连接符'\'
                if(lineContinued){
                    str = tempStr + str;
                }

                //处理行连接符'\'
                if(str.endsWith("\\")){
                    lineContinued = true;
                    tempStr = str.substring(0,str.length()-1);
                    continue;
                }else {
                    lineContinued = false;
                }

                //是否一个新section开始了
                if(str.startsWith("[") && str.endsWith("]")){
                    String newSection = str.substring(1, str.length()-1).trim();

                    //如果新section不是现在的section，则把当前section存进listResult中
                    if(!currentSection.equals(newSection)){
                        listResult.put(currentSection, currentProperties);
                        currentSection = newSection;

                        //新section是否重复的section
                        //如果是，则使用原来的list来存放properties
                        //如果不是，则new一个List来存放properties
                        currentProperties=listResult.get(currentSection);
                        if(currentProperties==null){
                            currentProperties = new ArrayList<>();
                        }
                    }
                }else{
                    currentProperties.add(str);
                }
            }
            //把最后一个section存进listResult中
            listResult.put(currentSection, currentProperties);

            reader.close();


        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }


        //整理拆开name=value对，并存放到MAP中：
        //从listResult<String, List>中，看各个list中的元素是否包含等号“=”，如果包含，则拆开并放到Map中
        //整理后，把结果放进result<String, Object>中
        for(String key : listResult.keySet()){
            List<String> tempList = listResult.get(key);

            //空section不放到结果里面
            if(tempList==null||tempList.size()==0){
                continue;
            }

            if(tempList.get(0).contains("=")){ //name=value对，存放在MAP里面
                Map<String, String> properties = new HashMap<>();
                for(String s : tempList){
                    int delimiterPos = s.indexOf("=");
                    //处理等号前后的空格
                    properties.put(s.substring(0,delimiterPos).trim(), s.substring(delimiterPos+1, s.length()).trim());
                }
                result.put(key, properties);
            }else{ //只有value，则获取原来的list
                result.put(key, listResult.get(key));
            }
        }

        return result;


    }
}
