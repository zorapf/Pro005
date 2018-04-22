package lan.lesson08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class LanEx01 {

    /**
     * Сетевое взаимодействие
     *
     * Protocol - описывает набор правил для
     * интерактивного обмена информацией между
     * компьютерами в пределах локальной сети
     *
     * TCP/IP:
     *
     * Transmission Control Protocol - основное
     * назначение данного протокола, заключается в
     * том, чтобы гарантировать передачу данных
     * между компьютерами в рамках сети
     * Internet Protocol - решает возникающие
     * комуникационные вопросы в рамках локальной
     * (либо глобальной) сети.
     *
     * IPv4:
     * 127.0.0.1 (localhost) - локальный адрес
     *
     * XXX.XXX.XXX.XXX
     * */

    public static void main(String[] args) throws IOException {
        /*ServerSocketChannel
        *
        * - на этапе создания серверной части нам необходимо
        *   создать SocketChannel и настроить порт который будет
        *   прослушиваться на компьютере
        *
        * - 1-1029 - порты которые зарезервированы для ОС
        * - 8081 - 65536 - порты котрые можно свободно использовать
        *                  в работе
        *                  */
        ServerSocketChannel sc = ServerSocketChannel.open();
        sc.bind(new InetSocketAddress(30000));

        System.out.println("Сервер создан, ждем подключение клиента");

        SocketChannel client = sc.accept();

        System.out.println("Соеденение установлено....");

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bts;
        while ((bts = client.read(buffer)) > 0) {
            buffer.flip();
            String inputText = new String(buffer.array(), 0, bts);
            System.out.println("Сообщение от клиента: " + inputText);
        }
        System.out.println("Останавливаем сервер");
    }
}
