package com.seprojects.lissayappserver;

import java.util.Scanner;

// ÿ�����ܶ��в���һ��123
// �û� ʹ��      userID U00000001	  �ֻ�12345678901	  ����123ASD@01 �ͺ�123564
// IPIPIPIPIPIPIPIPIPIPIPIPIPIPIPIP

public class Test
{

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		// Ҫ���ĵ���Ϣ������
		//CTweet c = new CTweet();	// ���贴��
		//String str = c.CheckTweet();
//		CDiary c = new CDiary();	// ���贴��
//		String str = c.addDiary("U00000003", "ѧϰ", "G00000000007", "����", 0);
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
