package socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * create by tan on 2018/6/6
 * 测试服务端ServerSocket
 **/
public class TestServerSocket {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(60000);
        /**
         * 创建一个ServerSocket对象时往往会制定一个端口号，通过端口号来监听客户端连接
         * 服务器会不间断接收客户端的连接请求
         * */
        while (true) {
            Socket s = ss.accept();
            /**
             * 在服务端调用accept()方法接收客户端连接对象，该方法是个阻塞式方法，一直在等待着客户端连接
             * 客户端是否能连上取决于服务器是否接受了客户端的连接请求
             * */
            System.out.println("A client Connected");
            /**
             * 使用InputStream输入流来接收从客户端发过来的信息，使用DataInputStream流处理接收到的信息
             * */
            DataInputStream dis = new DataInputStream(s.getInputStream());
            /**
             * 使用readUTF()方法将接收到的信息全部读取出来，存储到字符串中，readUTF()是阻塞式方法，会
             * 一直等待客户端发送信息过来，阻塞式的方法效率一般不高的，客户端连上服务器端，就必须调用
             * 服务器端的accept()方法，可accept()必须要等下一次循环才能被调用，如果上一个客户端一直不
             * 发送信息，那么readUTD()方法就一直得不到信息，服务器端的程序就阻塞在这里，无法进入下一个
             * 循环，这样其它客户端就无法连接了
             * */
            String str = dis.readUTF();
            System.out.println(str);
            dis.close(); // 关闭输入流
            s.close(); // 关闭连接
        }
    }
}
