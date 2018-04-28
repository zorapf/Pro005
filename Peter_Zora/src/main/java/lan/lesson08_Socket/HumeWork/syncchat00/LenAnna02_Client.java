package main.java.lan.lesson08_Socket.HumeWork.syncchat00;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class LenAnna02_Client {
    public static void main(String[] args)throws IOException {

        SocketChannel client = SocketChannel.open(
                new InetSocketAddress("192.168.1.109", 30001));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bts;
        Scanner scn = new Scanner(System.in);

        String message = scn.nextLine();
        while (!message.equals("exit")) {
            //Получение
            while ((bts = client.read(buffer)) > 0) {
                buffer.flip();
                message = new String(buffer.array(), 0, bts);
                System.out.println("Сообщение от сервера: " + message);
                buffer.clear();
                break;
            }
            //Отправка
            System.out.println("Сообщение для отправки: ");
            message = scn.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            client.write(buffer);
            buffer.clear();
        }
        System.out.println("Останавливаем сервер");
    }
}
