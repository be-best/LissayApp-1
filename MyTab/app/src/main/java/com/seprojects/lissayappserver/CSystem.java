package com.seprojects.lissayappserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

// 类：系统操作
// 备注：下方的json数据输出记得删除
public class CSystem
{

	// 构造函数
	public CSystem()
	{
	}

	// 函数: 数据交换  客户端<-->服务器   请求发起者：客户端
	// 参数: send: 待发送的数据
	// return: receive: 接收到的数据
	public static String dataExchange(String send)
	{
		String ip = "192.168.191.2";	// 服务器IP
		int port = 8080; 				// 服务器目的端口号
		String receive = "{\r\n" +
				"	\"state\": \"连接失败，请求超时！\"\r\n" +
				"}";

		try
		{
			Socket socket = new Socket(ip, port);						  			// 创建Socket对象
			socket.setSoTimeout(10 * 1000);											// 连接时间
			//System.out.println(send.getBytes("UTF-8"));
			// 根据输入输出流和服务端连接
			OutputStream outputStream = socket.getOutputStream();         			// 获取一个输出流，向服务端发送信息
			PrintWriter printWriter = new PrintWriter(outputStream);      			// 将输出流包装成打印流
			printWriter.print(send);                              					// 要发送给服务器的数据
			printWriter.flush();
			socket.shutdownOutput();                                      			// 关闭输出流

			InputStream inputStream = socket.getInputStream();            			// 获取一个输入流，接收服务端的信息
			InputStreamReader info = new InputStreamReader(inputStream, "UTF-8");  	// 包装成字符流，提高效率
			BufferedReader bufferedReader = new BufferedReader(info);     			// 缓冲区

			receive = "";
			String temp = null;                                           			// 临时变量
			while ((temp = bufferedReader.readLine()) != null)            			// 到这边即为接受到的消息
			{
				System.out.println(temp);//记得删除
				receive += temp;
			}

			// 关闭相对应的资源
			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
			socket.close();
		}
		catch (SocketTimeoutException e)
		{
			e.printStackTrace();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return receive;
	}

	// 函数: 获取验证码
	// 参数: _phoneNum: 手机号码
	// return: null(成功) String(失败)
	public static String getCode(String _phoneNum)
	{
		// 生成发送数据
		JsonObject json = new JsonObject();
		json.addProperty("op", "00002");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		json.add("info", info);

		// 发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// 验证码发送成功
		{
			JsonArray array = json.get("info").getAsJsonArray(); 	// 得到jsonData中info的数组
			json = array.get(0).getAsJsonObject();					// 将array[0]转换为JsonObject

			// 逐个赋值
			return json.get("tick").getAsString();
		}
		else
		{
			return json.get("state").getAsString(); // 验证码发送失败
		}
	}

	// 函数: 验证验证码
	// 参数: _phoneNum: 手机号码, _code: 验证码
	// return: null(成功) String(失败)
	public static String checkCode(String _phoneNum, String _code)
	{
		// 生成发送数据
		JsonObject json = new JsonObject();
		json.addProperty("op", "00003");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("code", _code);
		json.add("info", info);

		// 发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// 验证码正确
		{
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // 验证码错误
		}
	}
}
