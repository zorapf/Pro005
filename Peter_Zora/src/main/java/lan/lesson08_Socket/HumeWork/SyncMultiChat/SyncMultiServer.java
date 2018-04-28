package main.java.lan.lesson08_Socket.HumeWork.SyncMultiChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SyncMultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel sc = ServerSocketChannel.open();
        sc.bind(new InetSocketAddress(20000));

        System.out.println("Ожидаем подключения...");
        ExecutorService clients = Executors.newFixedThreadPool(20);



        ScheduledExecutorService clientListener =
                Executors.newSingleThreadScheduledExecutor();
        clientListener.scheduleAtFixedRate(() -> {
            try {

                SocketChannel client = sc.accept();
                clients.submit(() -> {
                    try {
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        Scanner scan = new Scanner(System.in);
                        String message = "init";
                        do {
                            //Отправка сообщения
                            System.out.print("Сообщение для отправки : ");
                            message = scan.nextLine();
                            buffer.put(message.getBytes());
                            buffer.flip();
                            client.write(buffer);
                            buffer.clear();
                            //Получение сообщения
                            int bytes = 0;
                            while ((bytes = client.read(buffer)) > 0) {
                                buffer.flip();
                                message = new String(buffer.array(), 0, bytes);
                                System.out.println("Входящее сообщение от (клиент) : " + message);
                                buffer.clear();
                                break;
                            }

                        } while (!message.equals("exit"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
