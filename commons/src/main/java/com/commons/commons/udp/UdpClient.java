package com.commons.commons.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author zhaomengxia
 * @create 2019/10/15 13:43
 */
public class UdpClient {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        BufferedReader bufferedReader=null;
        try {
            //获得用户输入数据
            bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String line=null;

            while ((line=bufferedReader.readLine())!=null) {

                if ("q".equals(line)){
                    break;
                }
                ds = new DatagramSocket();
//                String str = "你好，世界！";
                //创建数据包对象，封装要发送的数据
                byte[] bs = line.getBytes();
                //创建InetAddress对象封装接收端的ip地址
                InetAddress inetAddress=InetAddress.getByName("127.0.0.1");

                //创建数据包。创建DatagramPacket对象，数据包的发送对象
                DatagramPacket dp = new DatagramPacket(bs, bs.length, inetAddress, 10000);
                //发送数据。调用send方法，发送数据包
                ds.send(dp);
            }
            System.out.println("退出客户端！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if (bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ds!=null){
                ds.close();
            }

        }
    }
}
