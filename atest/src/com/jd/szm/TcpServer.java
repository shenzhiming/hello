package com.jd.szm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args){
		Socket s = null;
		try {
			ServerSocket ss;
			ss = new ServerSocket(7777);
			System.out.println("start listen" + "你好，世界！".length());
			s = ss.accept();
			System.out.println("accepted");
			InputStream ips = s.getInputStream();
			OutputStream ops = s.getOutputStream();
			byte[] bi = new byte[1024];
			ips.read(bi,0,1024);
			System.out.println(new String(bi,"UTF-8"));
			ops.write("你好，世界！".getBytes("UTF-8"));
			/*
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			ops.write("你好，世界！".getBytes("UTF-8"));
			ops.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
