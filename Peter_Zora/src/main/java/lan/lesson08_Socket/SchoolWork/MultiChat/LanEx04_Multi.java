package main.java.lan.lesson08_Socket.SchoolWork.MultiChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class LanEx04_Multi {

    public static void main(String[] args) throws IOException {
        SocketChannel channel =
                SocketChannel.open(
                        new InetSocketAddress("127.0.0.1", 20000));

        ByteBuffer buffer = ByteBuffer.allocate(128);
        String message;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Сообщение для отправки : ");
            message = scan.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();

        } while (!message.equals("exit"));
    }
}
