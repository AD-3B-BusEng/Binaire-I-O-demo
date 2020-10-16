import java.io.*;
public class EOFExceptionDemo {
  public static void test() {
    String fileName = "numbers.dat";
    try
    {
      ObjectInputStream inputStream =
              new ObjectInputStream (new FileInputStream (fileName));
      System.out.println ("Reading ALL the integers");
      System.out.println ("in the file " + fileName);
      try
      {
        while (true)
        {
          int anInteger = inputStream.readInt ();
          System.out.println (anInteger);
        }
      }
      catch (EOFException e)
      {
        System.out.println ("End of reading from file.");
      }
      inputStream.close ();
    }
    catch (FileNotFoundException e)
    {
      System.out.println ("Cannot find file " + fileName);
    }
    catch (IOException e)
    {
      System.out.println ("Problem with input from file " + fileName);
    }
  }
  
}
