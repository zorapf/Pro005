package main.java.lan.lesson08_Socket.SchoolWork.Chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LanEx02 {
    public static void main(String[] args)throws IOException{

        SocketChannel channel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 30002));

        String text = "Текстовое сообщение";

        ByteBuffer buffer = ByteBuffer.allocate(128);

        buffer.put(text.getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
    }


}
