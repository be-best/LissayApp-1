package com.seprojects.lissayappserver;

import java.util.Scanner;

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
//		CDiary c = new CDiary();	// 按需创建
//		String str = c.addDiary("U00000003", "学习", "G00000000007", "哈哈", 0);
		String str = CSystem.getCode("15905909948");
		if (str == null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println(str);
		}
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		
		String str2 = sc.nextLine();
		
		String str1 = CSystem.checkCode("15905909948", str2);
		if (str1 == null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println(str1);
		}
//		CUser c = new CUser();
//		String str = c.aaa("12", null);
//		System.out.println(str);
		
	}

}
