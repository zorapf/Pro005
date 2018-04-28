package main.java.lan.lesson08_Socket.SchoolWork.Chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class LanEx01 {

    public static void main(String[] args) throws IOException {
        /*ServerSocketChannel
        *
         */
        ServerSocketChannel sc = ServerSocketChannel.open();
        sc.bind(new InetSocketAddress(30002));

        System.out.println("Сервер создан, ждем подключения клиента");
        SocketChannel client = sc.accept();

        System.out.println("Соединение установлено...");

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bts;
        while ((bts = client.read(buffer))>0){
            buffer.flip();
            String inputText = new String(buffer.array(), 0, bts);
            System.out.println("Сообщение " + inputText);
            buffer.clear();
        }
        System.out.println("Останавливаем сервер");

    }
}
