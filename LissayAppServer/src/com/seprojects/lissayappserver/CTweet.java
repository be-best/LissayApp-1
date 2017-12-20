package com.seprojects.lissayappserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//类：每日一推
public class CTweet
{
    private String tweetID;     // 推文ID
    private String content;     // 内容
    private String pic;         // 图片
    private String releaseDate; // 发布时间
    
    // 函数：构造函数
    public CTweet()
    {
    }
    
    // 函数：获取每日一推
    public String CheckTweet()
    {
    	// 生成发送数据
    	JsonObject json = setData("70003", null);
    			
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
    
    // 函数：生成 Json 发送数据
 	// 参数：_op: 请求号, _tweetID: 推文ID
 	// return: JsonObject
 	private JsonObject setData(String _op, String _tweetID)
 	{
 		// 生成发送数据
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		json.add("info", info);
 		
 		return json;
 	}
 	
 	// 函数：向对象属性赋值
 	// 参数：jsonData: jsonData对象
 	private void putInfo(JsonObject jsonData)
 	{
 		JsonArray array = jsonData.get("info").getAsJsonArray(); 	// 得到jsonData中info的数组
 		jsonData = array.get(0).getAsJsonObject();					// 将array[0]转换为JsonObject
 		
 		// 逐个赋值
 		tweetID = jsonData.get("tweetID").getAsString();
 		content = jsonData.get("content").getAsString();
 		pic = jsonData.get("pic").getAsString();
 		releaseDate = jsonData.get("releaseDate").getAsString();
 	}
 	
 	// 函数：返回 tweetID
 	// return: String
 	public String getTweetID()
 	{
 		return tweetID;
 	}
 	
 	// 函数：返回 content
 	// return: String
 	public String getContent()
 	{
 		return content;
 	}
 	
 	// 函数：返回 pic
 	// return: String
 	public String getPic()
 	{
 		return pic;
 	}
 	
 	// 函数：返回 releaseDate
 	// return: String
 	public String getReleaseDate()
 	{
 		return releaseDate;
 	}
}
