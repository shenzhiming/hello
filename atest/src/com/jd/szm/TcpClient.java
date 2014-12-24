package com.jd.szm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
enum SocketStatus {
	OCCUPIED,AVAILABLE,INVALID
}
public class TcpClient {
	private HashMap<Socket, SocketStatus> _sets = new HashMap<Socket, SocketStatus>();
	public Socket allocate() {
		Socket s = new Socket();
		try {
			s.connect(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 7777),
					  3 * 1000);
			_sets.put(s, SocketStatus.OCCUPIED);
			System.out.println(s.getInetAddress().getHostAddress());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	public void deallocate(Socket s) {
		_sets.put(s, SocketStatus.AVAILABLE);
	}
	public void disable(Socket s) {
		_sets.put(s, SocketStatus.INVALID);
	}
	public void print(Socket s) {
		SocketStatus ss = _sets.get(s);
		System.out.println(ss);
	}
	public static void main(String[] args){
		TcpClient tc = new TcpClient();
		Socket s = tc.allocate();
		System.out.println(s.hashCode());
		tc.print(s);
		tc.deallocate(s);
		tc.print(s);
		tc.disable(s);
		tc.print(s);
	}
}
