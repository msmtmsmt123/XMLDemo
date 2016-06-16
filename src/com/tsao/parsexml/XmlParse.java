package com.tsao.parsexml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

//����XML����
public class XmlParse {
	
	//����XML�ķ���
	public static List<Note> parseXml(InputStream in) throws XmlPullParserException, IOException{
		
		System.out.println("parseXml(InputStream in)");
		//��ȡXML������
		XmlPullParser parse = Xml.newPullParser();
		//���ý�����Ҫ����������
		parse.setInput(in, null);
		//�������ݣ�����ֱ�ӽ����õķ������߼�д��������������ǽ�����߼�д��һ������
		return readChannel(parse);
	}
	
	//
	private static List<Note> readChannel(XmlPullParser parse) throws XmlPullParserException, IOException{
		
		System.out.println("readChannel(XmlPullParser parse)");
		
		List<Note> notes = null;
		Note note = null;
		
		//��ȡ�¼�����
		int type = parse.getEventType();
		//��ʼ����
		while(type != XmlPullParser.END_DOCUMENT){
			switch(type){
			case XmlPullParser.START_TAG:
				if("channel".equals(parse.getName())){
					//����һ����������
					notes = new ArrayList<Note>();
				}else if("note".equals(parse.getName())){
					//����һ��note����
					note = new Note();
				}else if("title".equals(parse.getName())){
					note.setTitle(parse.nextText());
				}else if("body".equals(parse.getName())){
					note.setBody(parse.nextText());
				}
				break;
			case XmlPullParser.END_TAG:
				if("note".equals(parse.getName())){
					//��note�������notes����
					notes.add(note);
				}
				break;
			}
			
			//��ͣ�����½���
			type = parse.next();
			
		}
		
		return notes;
	}	

}
