import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  @SuppressWarnings("resource")
public static void main(String[] args) throws IOException {
    ServerSocket servsock = new ServerSocket(23456);
    File myFile = new File("Manik.txt");
    while (true) {
      Socket sock = servsock.accept();
      byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
      OutputStream os = sock.getOutputStream();
      os.write(mybytearray, 0, mybytearray.length);
      Scanner in = new Scanner(sock.getInputStream());
      System.out.println("Server response: " + in.nextLine());

      os.flush();
      sock.close();
    }
  }
}
