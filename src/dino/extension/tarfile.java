package dino.extension;
import java.io.*;
import java.awt.*;
import java.util.zip.*;
class tarException extends Exception {
    tarException(String errMessage){
        super(errMessage);
    }
}
public class tarfile {
    private String tarname;
    public tarfile(String tarname){
        this.tarname=tarname;
    }
    private static void ZipFile(String filepath ,String zippath) throws tarException{
        if(filepath.indexOf(".zip")==-1 || zippath.indexOf(".zip")==-1)
        {
            throw new tarException("Error: This is not a zip File!");
        }
        try {
            File file = new File(filepath);// 要被压缩的文件夹
            File zipFile = new File(zippath);
            InputStream input = null;
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(int i = 0; i < files.length; ++i){
                    input = new FileInputStream(files[i]);
                    zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
                    int temp = 0;
                    while((temp = input.read()) != -1){
                        zipOut.write(temp);
                    }
                    input.close();
                }
            }
            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void UnZipFile(String zippath ,String outzippath) throws tarException{
        if(zippath.indexOf(".zip")==-1)
        {
            throw new tarException("Error: This is not a zip File!");
        }
        try {
            File file = new File(zippath);
            File outFile = null;
            ZipFile zipFile = new ZipFile(file);
            ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
            ZipEntry entry = null;
            InputStream input = null;
            OutputStream output = null;
            while((entry = zipInput.getNextEntry()) != null){
                outFile = new File(outzippath + File.separator + entry.getName());
                if(!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdir();
                }
                if(!outFile.exists()){
                    outFile.createNewFile();
                }
                input = zipFile.getInputStream(entry);
                output = new FileOutputStream(outFile);
                int temp = 0;
                while((temp = input.read()) != -1){
                    output.write(temp);
                }
                input.close();
                output.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
