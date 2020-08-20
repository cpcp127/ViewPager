package com.example.viewpager;

import androidx.viewpager.widget.PagerAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.util.List;
public class Adapter extends PagerAdapter {
    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;


    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }
    //isViewFromObject() 메서드는 뷰페이저 내부적으로 관리되는 키 객체(key object)와
    // 페이지뷰가 연관되는지 여부를 확인하는 역할을 수행합니다.
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    //화면에 표시할 페이지뷰를 만드는 작업은 페이저어댑터의 instantiateItem() 메서드에서 수행합니다.
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        //layoutInflater : XML에 정의된 Resource(자원) 들을 View의 형태로 반환해 줍니다
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0) {
                  //  Intent intent = new Intent(context, TargetActivity.class);

                  //  context.startActivity(intent);

                }
                else if(position==1){
                 //   Intent intent = new Intent(context, HomeActivity.class);

                //    context.startActivity(intent);
                }
                else if(position==2){
                  //  Intent intent = new Intent(context, MartActivity.class);

                  //  context.startActivity(intent);
                }
                else if(position==3){
                  //  Intent intent = new Intent(context, CarActivity.class);

                  //  context.startActivity(intent);
                }
            }

        });
        // 뷰페이저에 추가.
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);// 뷰페이저에서 삭제.
    }
}
