package com.seprojects.lissayappserver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//类：日记
public class CDiary
{
	private String diaryID;     // 日记ID
    private String userID;      // 日记编写者ID
    private String tags;        // 标签
    private String groupID;     // 分组ID
    private String content;     // 日记内容
    private int state;         	// 日记权限
    private String releaseDate; // 发布日期时间
    
    // 函数：构造函数
    public CDiary()
    {
    }
    
    // 函数：添加日记
    // 参数：_userID: 用户ID, _tags: 标签, _groupID: 分组ID, _content: 内容, _state: 日记权限（1可评论 2可公开）
    // return: null(添加日记成功) String(添加日记失败信息)
    public String addDiary(String _userID, String _tags, String _groupID, String _content, int _state)
    {
    	// 生成发送数据
    	JsonObject json = setData("20001", null, _userID, _tags, _groupID, _content, _state);
    	//System.out.println(json.toString());//记得删除
    	
    	// 数据发送
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// 添加日记成功
   		{
   				
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // 添加日记失败返回状态标识
    	}
    }
    
   // 函数：删除日记
   // return: null(删除日记成功) String(删除日记失败信息)
    public String delDiary()
    {
    	// 生成发送数据
		JsonObject json = setData("20002", diaryID, null, null, null, null, -1);
				
		// 数据发送
		JsonParser parser = new JsonParser();
		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
				
		if (json.get("state").isJsonNull() == true)	// 删除日记成功
		{
			return null;
		}
		else
		{
			return json.get("state").getAsString(); // 删除日记失败返回状态标识
		}
    }
    
    // 函数：更改日记权限
    // return: null(添加日记成功) String(添加日记失败信息)
 	public String SetState()
 	{
 	    // 生成发送数据
    	JsonObject json = setData("20003", diaryID, null, null, null, null, state);
    	//System.out.println(json.toString());//记得删除
    	
    	// 数据发送
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// 更改日记权限成功
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // 更改日记权限失败返回状态标识
    	}
 	}

 	// 函数：更改日记标签
    // return: null(更改日记标签成功) String(更改日记标签失败信息)
 	public String SetTags()
 	{
 		 // 生成发送数据
    	JsonObject json = setData("20004", diaryID, null, null, null, null, -1);
    	//System.out.println(json.toString());//记得删除
    	
    	// 数据发送
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// 更改日记标签成功
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // 更改日记标签失败返回状态标识
    	}
 	}
 
 	// 函数：更改日记分组
    // return: null(更改日记分组成功) String(更改日记分组失败信息)
 	public String SetGroup()
 	{
 		// 生成发送数据
    	JsonObject json = setData("20005", diaryID, null, null, groupID, null, -1);
    	//System.out.println(json.toString());//记得删除
    	
    	// 数据发送
    	JsonParser parser = new JsonParser();
   		json = (JsonObject) parser.parse(CSystem.dataExchange(json.toString()));
   		if (json.get("state").isJsonNull() == true)	// 更改日记分组成功
   		{
  			return null;
    	}
   		else
  		{
   			return json.get("state").getAsString(); // 更改日记分组失败返回状态标识
    	}
 	}
    
    // 函数：生成 Json 发送数据
 	// 参数：_op: 请求号, _userID: 用户ID, _tags: 标签, _groupID: 分组ID, _content: 内容, _state: 日记权限
 	// return: JsonObject
 	private JsonObject setData(String _op, String _diaryID, String _userID, String _tags, String _groupID, String _content, int _state)
 	{
 		// 生成发送数据
 		JsonObject json = new JsonObject();
 		json.addProperty("op", _op);
 		JsonObject info = new JsonObject();
 		info.addProperty("diaryID", _diaryID);
 		info.addProperty("userID", _userID);
 		info.addProperty("tags", _tags);
 		info.addProperty("groupID", _groupID);
 		info.addProperty("content", _content);
 		info.addProperty("_state", _state);
 		json.add("info", info);
 		
 		return json;
 	}
 	
    // 函数：返回 diaryID
  	// return: String
 	public String getDiaryID()
 	{
 		return diaryID;
 	};  
 	
    // 函数：返回 userID
 	// return: String
 	public String getUserID() 
 	{
 		return userID;
 	}

 	//函数：返回 tags
 	// return: String
 	public String getTags() 
 	{
 		return tags;
 	}

 	//函数：返回 groupID
 	// return: String
 	public String getGroupID() 
 	{
 		return groupID;
 	}

 	//函数：返回 content
 	// return: String
 	public String getContent()  
 	{
 		return content;
 	}

 	//函数：返回 state
 	// return: int
 	public int getState()
 	{
 		return state;
 	}

 	//函数：返回 releaseDate
 	// return: String
 	public String getReleaseDate()
 	{
 		return releaseDate;
 	}
}
