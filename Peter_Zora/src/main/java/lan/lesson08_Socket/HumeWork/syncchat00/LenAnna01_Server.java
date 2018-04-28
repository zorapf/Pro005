package main.java.lan.lesson08_Socket.HumeWork.syncchat00;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class LenAnna01_Server {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel sc = ServerSocketChannel.open();
        sc.bind(new InetSocketAddress(30001));

        System.out.println("Сервер создан, ждем подключения клиента");
        SocketChannel client = sc.accept();

        System.out.println("Соединение установлено...");

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bts;
        Scanner scn = new Scanner(System.in);
        String message = "";

        while (!message.equals("exit")) {
            //Отправка сообщения
            System.out.println("Сообщение для отправки: ");
            message = scn.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            client.write(buffer);
            buffer.clear();
            //Получение сообщения
            while ((bts = client.read(buffer)) > 0) {
                buffer.flip();
                message = new String(buffer.array(), 0, bts);
                System.out.println("Сообщение от клиента " + message);
                buffer.clear();
                break;
            }
        }
        System.out.println("Останавливаем сервер");
    }
}
