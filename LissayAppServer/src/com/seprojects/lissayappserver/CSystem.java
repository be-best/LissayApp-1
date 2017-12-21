package com.seprojects.lissayappserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// �ࣺϵͳ����
// ��ע���·���json��������ǵ�ɾ��
public class CSystem
{
	
	// ���캯��
	public CSystem()
	{
	}
	
	// ����: ���ݽ���  �ͻ���<-->������   �������ߣ��ͻ���
	// ����: send: �����͵�����
	// return: receive: ���յ�������
	public static String dataExchange(String send)
	{
		String ip = "192.168.191.2";	// ������IP
		int port = 8080; 				// ������Ŀ�Ķ˿ں�
		String receive = "{\r\n" + 
						 "	\"state\": \"����ʧ�ܣ�����ʱ��\"\r\n" +
						 "}";
		
		try
        {
            Socket socket = new Socket(ip, port);						  			// ����Socket����
            socket.setSoTimeout(10 * 1000);											// ����ʱ��
            //System.out.println(send.getBytes("UTF-8"));
            // ��������������ͷ��������
            OutputStream outputStream = socket.getOutputStream();         			// ��ȡһ��������������˷�����Ϣ
            PrintWriter printWriter = new PrintWriter(outputStream);      			// ���������װ�ɴ�ӡ��
            printWriter.print(send);                              					// Ҫ���͸�������������
            printWriter.flush();
            socket.shutdownOutput();                                      			// �ر������

            InputStream inputStream = socket.getInputStream();            			// ��ȡһ�������������շ���˵���Ϣ
            InputStreamReader info = new InputStreamReader(inputStream, "UTF-8");  	// ��װ���ַ��������Ч��
            BufferedReader bufferedReader = new BufferedReader(info);     			// ������
            
            receive = "";
            String temp = null;                                           			// ��ʱ����
            while ((temp = bufferedReader.readLine()) != null)            			// ����߼�Ϊ���ܵ�����Ϣ
            {
            	System.out.println(temp);//�ǵ�ɾ��
            	receive += temp;
            }

            // �ر����Ӧ����Դ
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
	
	// ����: ��ȡ��֤��
	// ����: _phoneNum: �ֻ�����
	// return: null(�ɹ�) String(ʧ��)
	public static String getCode(String _phoneNum)
	{
		// ���ɷ�������
		JsonObject json = new JsonObject();
		json.addProperty("op", "00002");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		json.add("info", info);
		 
		// ����
		JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		
   		if (json.get("state").isJsonNull() == true)	// ��֤�뷢�ͳɹ�
   		{
   			JsonArray array = json.get("info").getAsJsonArray(); 	// �õ�jsonData��info������
   			json = array.get(0).getAsJsonObject();					// ��array[0]ת��ΪJsonObject
   			
   			// �����ֵ
   			return json.get("tick").getAsString();
    	}
   		else
  		{
   			return json.get("state").getAsString(); // ��֤�뷢��ʧ��
    	}
	}
	
	// ����: ��֤��֤��
	// ����: _phoneNum: �ֻ�����, _code: ��֤��
	// return: null(�ɹ�) String(ʧ��)
	public static String checkCode(String _phoneNum, String _code)
	{
		// ���ɷ�������
		JsonObject json = new JsonObject();
		json.addProperty("op", "00003");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("code", _code);
		json.add("info", info);
			 
		// ����
		JsonParser parser = new JsonParser();
	   	json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
	   		
	   	if (json.get("state").isJsonNull() == true)	// ��֤����ȷ
	   	{
	   		return null;
	    }
	   	else
	  	{
	   		return json.get("state").getAsString(); // ��֤�����
	    }
	} 
}
