package com.example.tanko.viewsample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewSampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //アプリ起動時に実行されるメソッド
        super.onCreate(savedInstanceState);
        //シーンの描画
        setContentView(R.layout.activity_view_sample);


        //リスナーのインスタンス
        HelloListener helloListener = new HelloListener();
        //表示用buttonオブジェクト取得する
        Button viewButton = findViewById(R.id.btClick);
        viewButton.setOnClickListener(helloListener);
        //表示クリア用Buttonオブジェクト取得する
        Button clearButton = findViewById(R.id.btClear);
        clearButton.setOnClickListener(helloListener);
    }


    //ボタンを押したときのリスナークラス
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText inputText = findViewById(R.id.etNmae);
            TextView textView  = findViewById(R.id.tvOutPut);

            //Viewにはタップされた画面上のオブジェクトのIdが取得できるメソッドがある
            int id = view.getId();
            switch (id){
                case R.id.btClick:
                    nameView(inputText,textView);
                    break;

                case R.id.btClear:
                    nameClear(inputText,textView);
                    break;
            }
            ////引数の中は、表示しているXMLのIDがetNameと書いてあるオブジェクト
            //EditText inputText = findViewById(R.id.etNmae);
            ////入力された文字を取得
            //String name = inputText.getText().toString();
            ////表示用のオブジェクトを取得
            //TextView outPutText = findViewById(R.id.tvOutPut);
            ////表示用のオブジェクトにStringを埋めこむ。
            //outPutText.setText(name + "さん、こんにちは。");
        }

        @SuppressLint("SetTextI18n")
        private void nameView (EditText inputText, TextView textView){
            String name = inputText.getText().toString();
            if(!name.trim().equals("")){
                textView.setText(name.trim() + "さん、こんにちは。");
            }
        }

        private void nameClear(EditText inputText, TextView textView){
            inputText.setText("");
            textView.setText("");
        }
    }
}
