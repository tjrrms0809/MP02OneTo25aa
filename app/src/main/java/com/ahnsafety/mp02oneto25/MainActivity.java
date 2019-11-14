package com.ahnsafety.mp02oneto25;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btnRetry;
    Random rnd;
    Button[] btns= new Button[25];//Button 참조변수가 25개짜리인 배열

    //현재 눌러야 할 번호
    int number=1;

    //버튼의 배경그림객체 참조변수
    Drawable backDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        btnRetry= findViewById(R.id.btn_retry);

        rnd=new Random();
        //중복되지 않는 랜덤값 25개를 가진 배열
        int[] arr= new int[25];
        for(int i=0; i<25; i++){
            arr[i]= rnd.nextInt(25)+1;//1-25
            for(int k=0; k<i; k++){
                if(arr[k]==arr[i]){//
                    i--;
                }
            }
        }
        //Button참조변수들에게 Button 객체를 대입하기
        for(int i=0; i<25; i++){
            btns[i]= findViewById(R.id.btn01+i);
            btns[i].setText(arr[i]+"");
        }
        //버튼의 배경이미지 얻어오기
        backDrawable= btns[0].getBackground();
    }//onCreat Method..
    //onClick속성에 지정한 콜백메소드
    //onClick속성으로 지정한 메소드가 자동 실행됨
    public void clickBtn(View v){
        //매개변수로 전달된 View v가 현재 클릭한 뷰 (버튼
        //클릭된 버튼의 글씨을 얻어오기
        Button btn= (Button)v;//다운캐스팅
        String s= btn.getText().toString();
        int n=Integer.parseInt(s);
        //얻어온 글씨와 현재 누를 번호 (Number)와 같은지 비교
        if(n==number){
            //눌러야한 번호를 잘 눌렀다!!
            btn.setText("Ok");
            btn.setTextColor(0x88FF0000);//ARGB A 투명도(알파) R 레드 G 그린 B 블루
            btn.setBackgroundColor(Color.TRANSPARENT);
            btn.setEnabled(false);
            //눌러야 번호를 증가
            number++;

            if(number>25){
                tv.setText("CLEAR!!!!!");
                btnRetry.setEnabled(true);
            }else{
                tv.setText(number+"");
            }
        }
        btn.setEnabled(false); //실수로 눌러도 끝남
    }
    public void clickRetry(View v){

        Random rnd = new Random();
        int[]arr = new int[25];
        for(int i=0; i<arr.length; i++){
            arr[i]=rnd.nextInt(25)+1;
            for(int k=0; k<i; k++){
                if(arr[k]==arr[i]){
                    i--;
                    break;
                }
            }
            /////
        }
        for(int i=0; i<btns.length; i++){
            btns[i].setText(arr[i]+"");
            btns[i].setTextColor(Color.BLACK);
            btns[i].setBackground(backDrawable);
        }
        number=1;
        tv.setText(number+"");
        btnRetry.setEnabled(false);

        for(int i=0; i<25; i++){
            btns[i].setEnabled(true);
        }
    }
}//MainActivity
