package com.tsao.parsexml;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


//�Զ���Adapter
public class MyAdapter extends BaseAdapter {
	
	//����һ��bean����������Ϊ����Դ��һ��bean���������һ����Ŀ��Ҫ������
	private List<Note> mList;
	//����һ��LayoutInflater�����ڽ������ļ�ת��Ϊһ��View
	private LayoutInflater inflater;
	
	//���캯��������ʵ����Adapter
	public MyAdapter(Context context,List<Note> list){
		
        mList = list;
        
        //
        inflater = LayoutInflater.from(context);
	}
        
	
	
	//��Ŀ��
	@Override
	public int getCount() {
		return mList.size();
	}
	//��ȡ��Ŀ
	@Override
	public Object getItem(int arg0) {
		return null;
	}
	//��ȡ��ĿId
	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	/*
	 * ��ȡչʾָ��λ�����ݵ�View,���View����ΪlistView��һ����Ŀ
	 * ����������
	 * 1.��viewҪ��ʾ�����������ݼ��е�λ��
	 * 2.���õ�view
	 * 3.��view�ĸ�����
	 * */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//ͨ��LayoutInflater�������ļ�ת����һ��View
        View view = inflater.inflate(R.layout.item,null);
        //�ҵ������еĿؼ�
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
        TextView title = (TextView) view.findViewById(R.id.tv_title);
        TextView content = (TextView) view.findViewById(R.id.tv_content);

        Note bean = mList.get(position);
        //�������
        //imageView.setImageResource(bean.itemImageResid);
        title.setText(bean.getTitle());
        content.setText(bean.getBody());
		return view;
	}

}
