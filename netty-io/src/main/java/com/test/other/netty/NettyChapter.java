package com.test.other.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class NettyChapter {

    public void server(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", StandardCharsets.UTF_8));
        EventLoopGroup group = new OioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandler() {
                                @Override
                                public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
                                    channelHandlerContext.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                }

                                @Override
                                public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                }

                                @Override
                                public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                                }

                                @Override
                                public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }
                            });
                        }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
