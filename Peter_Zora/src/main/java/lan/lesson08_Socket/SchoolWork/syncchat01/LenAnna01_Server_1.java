package main.java.lan.lesson08_Socket.SchoolWork.syncchat01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class LenAnna01_Server_1 {
    private static ServerSocketChannel channel;
    private static SocketChannel socket;

    public static void main(String[] args) throws IOException {
        channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(30000));

        Scanner scan = new Scanner(System.in);
        String message = "init";

        socket = channel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(128);

        do {
            //Отправка сообщения
            System.out.print("Сообщение для отправки : ");
            message = scan.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            socket.write(buffer);
            buffer.clear();
            //Получение сообщения
            int bytes = 0;
            while ((bytes = socket.read(buffer)) > 0) {
                buffer.flip();
                message = new String(buffer.array(), 0, bytes);
                System.out.println("Входящее сообщение от (клиент) : " + message);
                buffer.clear();
                break;
            }

        } while (!message.equals("exit"));
    }
}
