package com.zserg.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class EchoClientWithPool {
    private final String host;
    private final int port;
    FixedChannelPool pool;


    public EchoClientWithPool(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        FixedChannelPool pool;

        if (args.length != 2) {
            System.out.println("Usage: " + EchoClientWithPool.class.getSimpleName() + " <host> <port>");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        EchoClientWithPool client = new EchoClientWithPool(host, port);
        pool = client.start();
        Channel ch1 = client.getChannel(pool);
        Channel ch2 = client.getChannel(pool);
        Channel ch3 = client.getChannel(pool);
        Channel ch4 = client.getChannel(pool);
        pool.release(ch3);
        System.out.println("cp0");
        Channel ch5 = client.getChannel(pool);
        System.out.println("cp1");


    }

    public FixedChannelPool start() throws Exception {
        FixedChannelPool pool = null;
        Channel ch;
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port));
            SimpleChannelPoolHandler handler = new SimpleChannelPoolHandler();
            pool = new FixedChannelPool(b, handler, 3, Integer.MAX_VALUE);
        } catch (Exception e){
        }
        return pool;

    }

    public Channel getChannel(FixedChannelPool pool) {
        System.out.println("Get channel");
        io.netty.util.concurrent.Future<Channel> future = pool.acquire();
        try {
            if (!future.awaitUninterruptibly(3, TimeUnit.SECONDS)) {
                System.out.println("Timeout");
//                future.cancel(true);
                return null;
            } else {
                return ((io.netty.util.concurrent.Future<Channel>) future).getNow();
            }
        }catch (Exception e) {

        }
        return null;
    }

}
