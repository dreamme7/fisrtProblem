package net.xinshi.jemall.frontend.vshang.poster.springmvc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.xinshi.jemall.commons.StringUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {
	public static void main(String[] args) {
//		String strImg = GetImageStr();
//		System.out.println(strImg);
//		GenerateImage(strImg);
		
		String str = "eyJhY3Rpdml0eUlkIjoiMiIsInBvc3RlclBhdGgiOiIiLCJwcm9kdWN0cyI6W3sicHJvZHVjdElkIjoiMTAxMTU0NzkiLCJvcmRlckJ5IjoxLCJuZWVkU2VsZWN0IjoiMSJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODAiLCJvcmRlckJ5IjoyLCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODEiLCJvcmRlckJ5IjozLCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODIiLCJvcmRlckJ5Ijo0LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODMiLCJvcmRlckJ5Ijo1LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODQiLCJvcmRlckJ5Ijo2LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODUiLCJvcmRlckJ5Ijo3LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODYiLCJvcmRlckJ5Ijo4LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0OTAiLCJvcmRlckJ5Ijo5LCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0ODkiLCJvcmRlckJ5IjoxMCwibmVlZFNlbGVjdCI6IjAifSx7InByb2R1Y3RJZCI6IjEwMTE1NDg4Iiwib3JkZXJCeSI6MTEsIm5lZWRTZWxlY3QiOiIwIn0seyJwcm9kdWN0SWQiOiIxMDExNTQ4NyIsIm9yZGVyQnkiOjEyLCJuZWVkU2VsZWN0IjoiMCJ9LHsicHJvZHVjdElkIjoiMTAxMTU0OTQiLCJvcmRlckJ5IjoxMywibmVlZFNlbGVjdCI6IjAifSx7InByb2R1Y3RJZCI6IjEwMTE1NDkzIiwib3JkZXJCeSI6MTQsIm5lZWRTZWxlY3QiOiIwIn0seyJwcm9kdWN0SWQiOiIxMDExNTE4NSIsIm9yZGVyQnkiOjE1LCJuZWVkU2VsZWN0IjoiMCJ9XX0=";

		 byte[] bt = null;    
		   try {    
		       sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();    
		       bt = decoder.decodeBuffer( str );    
		   } catch (IOException e) {    
		       e.printStackTrace();    
		   }    
		   
		   System.err.println(bt);
		   try {
			   String s = new String(bt, "GBK");
			   JSONObject posterObject = JSONArray.parseObject(s);
				long activityId = StringUtil.longValue(posterObject.get("activityId").toString(), 0);
				String posterPath = posterObject.get("posterPath").toString();
				JSONArray products = posterObject.getJSONArray("products");
			   System.err.println(s);
			   System.err.println("activityId:"+activityId);
			   System.err.println("posterPath:"+posterPath);
			   System.err.println("products:"+products);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
	}

	// ͼƬת����base64�ַ���
	public static String GetImageStr() {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
		String imgFile = "C://Users/Administrator/Desktop/174686.jpg";// �������ͼƬ
		InputStream in = null;
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

	// base64�ַ���ת����ͼƬ
	public static boolean GenerateImage(String imgStr) { // ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null) // ͼ������Ϊ��
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// �����쳣����
					b[i] += 256;
				}
			}
			// ����jpegͼƬ
			String imgFilePath = "d://222.jpg";// �����ɵ�ͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
