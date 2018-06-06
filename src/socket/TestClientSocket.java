package socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * create by tan on 2018/6/6
 * 测试客户端Socket
 **/
public class TestClientSocket {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("192.168.42.4", 60000);
        /**
         * 客户端输入服务器端的IP和指定端口号申请连接服务器，成功连接之后就向服务器端发送消息
         * 和接收客户端返回信息
         * */
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Thread.sleep(30000); // 客户端睡眠30秒后向服务端发送信息
        dos.writeUTF("Hello, Server!!!");
        os.close(); // 关闭输出流
        s.close(); // 关闭客户端连接
    }
}
