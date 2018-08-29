import java.io.File;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SecurityManager {

    public static void main (String[] args) throws Exception {
        if (!"".equals("hello")) {
            File f = new File ("YOUR PATH/names.txt");

        if (f.isFile()) {
            Scanner rd = new Scanner(f);
            while (rd.hasNext()) {
                String name = rd.nextLine();
                String result = "";
                try {
                    InetAddress ip = InetAddress.getByName(name);
                    result = ip + "...";
                    Socket s = new Socket(name,80);
                    System.out.println(result + "AVAILABLE");
                } catch (UnknownHostException ex) {
                    System.out.println(name + " does not exist!");
                } catch (ConnectException ex) {
                    System.out.println(result + "UNAVAILABLE");
                }
            }
            rd.close();
        }
        else System.out.println("The input file names.txt was not found");
     }
    }
}
