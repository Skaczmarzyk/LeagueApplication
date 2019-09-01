package pl.lolapp.static_data;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.*;

@Service
public class StaticDataService {

    final String staticDataUrl = "https://ddragon.leagueoflegends.com/cdn/dragontail-";
    final String staticDataPath ="/../RiotData/current_patch";
    final String staticZipedDataPath ="/../RiotData";
    public static String currentVersion=null;
    public String championsPath=null;
    private boolean updating=false;

    public static String getCurrentVersion() {
        return currentVersion;
    }

    private StaticDataService()
    {
        if (!Files.isDirectory(Paths.get(staticDataPath)))
        {
            new File(staticDataPath).mkdirs();
        }
        checkVersion();
    }

    @Scheduled(fixedRate = 1000 * 60/*sec*/ * 60/*min.*/)
    public void checkVersion() {
        try {
            URL url = new URL("https://ddragon.leagueoflegends.com/api/versions.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
            {
                content.append(inputLine);
            }
            in.close();
            String[] versions = content.toString().replaceAll("[^\\d|\\.\\,]", "").split(",");
            if (isUpdated(versions[0]))
            {
                updating=true;
                getStaticData(versions[0]);
                updating=false;
            }
            else System.out.println("Patch up to date");
            currentVersion = versions[0];
            championsPath=staticDataPath+"/dragontail-"+versions[0]+"/"+versions[0]+"/data/pl_PL/championFull.json";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getChampionsPath() {
        return championsPath;
    }

    public boolean isUpdated(String version) {
        try (Stream<Path> paths = Files.walk(Paths.get(staticZipedDataPath)))
        {
            boolean fileNotExists = paths
                    .filter(Files::isRegularFile)
                    .noneMatch(s -> s.getFileName().endsWith("dragontail-" + version + ".tgz"));
            return fileNotExists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getStaticData(String version) {

        File tgzFile = new File(staticZipedDataPath+"/dragontail-"+version+".tgz");

        System.out.println("File downloading");
        try (BufferedInputStream inFile = new BufferedInputStream(new URL(staticDataUrl + version + ".tgz").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(tgzFile)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = inFile.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("File downloaded");
            unzipFiles(tgzFile,true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void unzipFiles(File tgzFile,boolean unTar)
    {
        File tarFile = new File(tgzFile.toString().substring(0,tgzFile.toString().lastIndexOf("."))+".tar");
        try {
            System.out.println("Unziping file");
            GZIPInputStream ginstream = new GZIPInputStream(new FileInputStream(tgzFile));
            FileOutputStream outstream = new FileOutputStream(tarFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = ginstream.read(buf)) > 0) {
                outstream.write(buf, 0, len);
            }
            System.out.println("Unziped file");
            if(unTar==true)
            {
                untarFiles(tarFile);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void untarFiles(File tarFile) {
        try
        {
            System.out.println("Untaring file");
            TarArchiveInputStream myTarFile = new TarArchiveInputStream(new FileInputStream(tarFile));
            TarArchiveEntry entry = null;
            int offset;
            FileOutputStream outputFile = null;
            //czyta wszystkie wpisy w pliku tar
            while ((entry = myTarFile.getNextTarEntry()) != null) {
                String fileName = tarFile.getName().substring(0, tarFile.getName().lastIndexOf('.'));
                File outputDir = new File(staticDataPath+ "/" + fileName + "/" + entry.getName());
                if (!outputDir.getParentFile().exists()) {
                    outputDir.getParentFile().mkdirs();
                }
                if (entry.isDirectory()) {
                    outputDir.mkdirs();
                } else {
                    byte[] content = new byte[(int) entry.getSize()];
                    offset = 0;
                    myTarFile.read(content, offset, content.length - offset);
                    outputFile = new FileOutputStream(outputDir);
                    IOUtils.write(content, outputFile);
                    outputFile.close();
                }
            }
            //zamkniecie streamu i usuniecie pliku tar
            myTarFile.close();
            tarFile.delete();
            System.out.println("File unpacked");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}





