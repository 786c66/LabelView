package com.github.xlf.labelview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView listView;
    String[] strings = {"测试测试color","测试测试radius","测试测试width"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter());

    }



    class MyAdapter extends BaseAdapter{

        public MyAdapter() {
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public Object getItem(int position) {
            return strings[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView ==null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.item,null);
                holder.labelView = (LabelView) convertView.findViewById(R.id.labelView);
                holder.labelView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (position){
                            case 0:
                                ((LabelView)v).setBorderColor(Color.BLUE);
                                ((LabelView)v).setBorderWidth(2);
                                break;
                            case 1:
                                ((LabelView)v).setBorderWidth(3);
                                ((LabelView)v).setBorderRadius(8);
                                break;
                            case 2:
                                ((LabelView)v).setBorderRadius(7);
                                ((LabelView)v).setBorderColor(Color.GREEN);
                                break;
                        }
                    }
                });
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.labelView.setText(strings[position]);

            return convertView;
        }

        class ViewHolder{
            LabelView labelView;
        }
    }
}
