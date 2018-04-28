package main.java.lan.lesson08_Socket.SchoolWork.syncchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 15.01.17.
 */
public class SyncClient {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        String message;
        Scanner scan = new Scanner(System.in);

        do {
            //Получение
            int bytes;
            while ((bytes = channel.read(buffer)) > 0) {
                buffer.flip();
                message = new String(buffer.array(), 0, bytes);
                System.out.println("Входящее сообщение от (сервер) : " + message);
                buffer.clear();
                break;
            }
            //Отправка
            System.out.print("Сообщение для отправки : ");
            message = scan.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();

        } while (!message.equals("exit"));
    }
}
