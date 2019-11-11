package com.commons.commons.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author zhaomengxia
 * @create 2019/10/15 11:56
 */
public class UdpServer {

    public static void main(String[] args) {
        DatagramSocket ds=null;
        try {
            //创建数据包传输对象DatagramSocket绑定端口号
            ds=new DatagramSocket(10000);
            //创建一个字节数组来接收发过来的数据
            byte[] bs=new byte[1024];
            //创建一个数据包对象DatagramPacket
            DatagramPacket dp=new DatagramPacket(bs,bs.length);
            System.out.println("UDP服务端已经启动！");
           while (true){
               //调用数据包传输对象的receive方法来接收数据
               ds.receive(dp);
               //获得客户端的ip
               InetAddress inetAddress=dp.getAddress();
               //获得数据
               byte[] data=dp.getData();
               //获得接收数据的长度
               int length=dp.getLength();
               String str=new String(bs,0,length);
               System.out.println(inetAddress.getHostAddress()+"发送的数据是："+str);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ds!=null){
                ds.close();
            }
        }
    }
}
