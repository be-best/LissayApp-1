package com.seprojects.lissayappserver;

// 每个功能都有测试一次123
// 用户 使用      userID U00000001	  手机12345678901	  密码123ASD@01 型号123564
// IPIPIPIPIPIPIPIPIPIPIPIPIPIPIPIP

public class Test
{

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		// 要更改的信息是下面
		//CTweet c = new CTweet();	// 按需创建
		//String str = c.CheckTweet();
		CDiary c = new CDiary();	// 按需创建
		String str = c.delDiary();
		if (str == null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println(str);
		}
		
//		CUser c = new CUser();
//		String str = c.aaa("12", null);
//		System.out.println(str);
		
	}

}
