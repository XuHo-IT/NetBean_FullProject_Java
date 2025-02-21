
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 public class fileProcessor {
  private BufferedReader reader;
  private String FilePath;
  public void openFile(String filePath){
      try{
          reader = new BufferedReader(new FileReader(filePath));
          if(filePath!=null||filePath.isEmpty()){
              System.out.println("File open");
          }
      }catch(IOException e){
          System.out.println("Eroor"+e.getMessage());
      }
  }
  public void readFile() throws IOException{
      String line;
      try{
          while((line=reader.readLine())!=null){
              System.out.println(line);
          }
      }catch(IOException e){
          System.out.println("Eroor"+e.getMessage());
  }finally{
          reader.close();
      }
  }
  public void processFile() throws IOException{
      openFile(FilePath);
       System.out.println("Eroor");
       if (FilePath==null){
             System.out.println("Eroor");
             return;
       }
       readFile();
      
  }
    
}

