package lan.lesson08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LanEx02 {

    public static void main(String[] args) throws IOException {
        /* SocketChannel*/
        SocketChannel channel =
                SocketChannel.open(
                        new InetSocketAddress("127.0.0.1", 30000));

        String text = "Текстовое сообщение";

        ByteBuffer buffer = ByteBuffer.allocate(128);
        /*put        - добавляет информацию в буфер обмена
        * getBytes() - преобразуеь строку в массив байтов для передачи*/
        buffer.put(text.getBytes());

        buffer.flip();
        /* write - отправляет подготовленные данные по сети*/
        channel.write(buffer);

        buffer.clear();
    }
}
