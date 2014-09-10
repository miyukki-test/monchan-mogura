package com.example.mogura;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	// ImageView型の配列imageViewsを作る(配列の数は16個)
	ImageView[] imageViews = new ImageView[16];
	
	// 正解の場所を記録するint型のanswerを作る
	int answer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// answerに0〜15までのランダムな数を入れる
		answer = (int)(Math.random() * 16);
		
		// レイアウトのImageViewをimageViewsと結びつけ、最初に表示する画像をセットする
		for (int i = 0; i < 16; i++) {
			imageViews[i] = (ImageView) findViewById(getResources().getIdentifier("image" + i, "id", getPackageName()));
			imageViews[i].setImageResource(R.drawable.question);
		}
	}

	public void find(View view) {
		// タッチした場所をclick_numberに入れる
		int click_number = Integer.parseInt((String)(view.getTag()));
		
		// タッチした場所と正解の場所が一緒の時
		if (click_number == answer) {
			// タッチした場所にもんちゃんの画像を表示する
			imageViews[answer].setImageResource(R.drawable.mon);
			
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(MainActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}, 3000);
		}
	}
}
