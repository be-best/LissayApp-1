package com.seprojects.lissayappserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// 类：用户
// 说明：用于用户操作是使用
public class CUser
{
	private String userID; 		// 用户ID
	private String passwd; 		// 登录密码
	private String phoneNum; 	// 手机号码
	private String photo; 		// 头像所用的照片的所在链接
	private String lastLogin; 	// 上次登录时间
	private String phoneModel; 	// 常用登录手机的型号
	private int diaryNum; 		// 可以查看他人的日记数目

	// 函数：构造函数
	public CUser()
	{
	}

	// 函数：登录
	// 参数：_phoneNum: 手机号码 ,_passwd: 密码, _phoneModel: 手机型号
	// return: null(登录成功) String(登录失败信息)
	public String login(String _phoneNum, String _passwd, String _phoneModel)
	{
		// 生成发送数据
		JsonObject json = new JsonObject();
		json.addProperty("op", "10001");
		JsonObject info = new JsonObject();
		info.addProperty("phoneNum", _phoneNum);
		info.addProperty("passwd", _passwd);
		info.addProperty("phoneModel", _phoneModel);
		json.add("info", info);

		// 数据发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));

		if (json.get("state").isJsonNull() == true)	// 登录成功
		{
			putInfo(json); 							// 对各属性值进行赋值
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // 登录失败返回状态标识(此处额外写出，是由于不可 return "")
		}
	}

	// 函数：登录
	// 参数：_phoneNum: 手机号码 ,_passwd: 密码, _photo: 图片链接, _phoneModel: 手机型号
	// return: null(注册成功) String(注册失败信息)
	public String registered(String _phoneNum, String _passwd, String _photo, String _phoneModel)
	{
		return "111";
	}
	
	// 函数：退出登录
	// return: null(退出登录成功) String(退出登录失败信息)
	public String leave()
	{
		return "111";
	}
	
	// 函数：设置/忘记密码
	// 参数：_passwd: 密码
	// return: null(设置成功) String(设置失败信息)
	public String setPasswd(String _passwd)
	{
		return "111";
	}
	
	// 函数：更改头像
	// 参数：_photo: 图片链接
	// return: null(更改成功) String(更改失败信息)
	public String setPhoto(String _photo)
	{
		return "111";
	}
	
	// 函数：向对象属性赋值
	// 参数：jsonData: jsonData对象
	private void putInfo(JsonObject jsonData)
	{
		JsonArray array = jsonData.get("info").getAsJsonArray(); 	// 得到jsonData中info的数组
		jsonData = array.get(0).getAsJsonObject();					// 将array[0]转换为JsonObject
		
		// 逐个赋值
		userID = jsonData.get("userID").getAsString();
		phoneNum = jsonData.get("phoneNum").getAsString();
		photo = jsonData.get("photo").getAsString();
		lastLogin = jsonData.get("lastLogin").getAsString();
		phoneModel = jsonData.get("phoneModel").getAsString();
		diaryNum = jsonData.get("diaryNum").getAsInt();
	}
	
	// 函数：返回 userID
	// return: String
	public String getUserID()
	{
		return userID;
	}
	
	// 函数：返回 passwd
	// return: String
	public String getPasswd()
	{
		return passwd;
	}
	
	// 函数：返回 phoneNum
	// return: String
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	// 函数：返回 photo
	// return: String
	public String getPhoto()
	{
		return photo;
	}
	
	// 函数：返回 lastLogin
	// return: String
	public String getLastLogin()
	{
		return lastLogin;
	}
	
	// 函数：返回 phoneModel
	// return: String
	public String getPhoneModel()
	{
		return phoneModel;
	}
	
	// 函数：返回 diaryNum
	// return: int
	public int getDiaryNum()
	{
		return diaryNum;
	}
}
