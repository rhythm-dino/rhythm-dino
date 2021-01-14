package dino.extension;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class zip {
    /**
     * 解压到指定目录
     * @param zipPath
     * @param descDir
     */
    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        unZipFiles(new File(zipPath), descDir);
    }
    /**
     * 解压文件到指定目录
     * 解压后的文件名，和之前一致
     * @param zipFile	待解压的zip文件
     * @param descDir 	指定目录
     */
    @SuppressWarnings("rawtypes")
    private static void unZipFiles(File zipFile, String descDir) throws IOException {

        ZipFile zip = new ZipFile(zipFile,Charset.forName("GBK"));//解决中文文件夹乱码
        String name = zip.getName().substring(zip.getName().lastIndexOf('\\')+1, zip.getName().lastIndexOf('.'));
        File pathFile = new File(descDir+name);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + name +"/"+ zipEntryName).replaceAll("\\*", "/");
            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        return;
    }
    public static void zipFiles(String zipFileName, String... files) {
        try {
            byte[] buffer = new byte[1024];
            File zipFile = new File(zipFileName);
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
            for (String file : files) {
                File file1 = new File(file);
                String fileName = file1.getName();
                ZipEntry zipEntry = new ZipEntry(fileName);
                zos.putNextEntry(zipEntry);
                FileInputStream fis = new FileInputStream(file1);
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                fis.close();
            }
            zos.closeEntry();
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
