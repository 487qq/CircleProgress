package com.qiuqiaohua.CircleProgress;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.qiuqiaohua.widget.CircleProgress;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
     CircleProgress arc;
    CircleProgress sector;
    CircleProgress round;
    Button arcBtn;
    Button sectorBtn;
    Button roundBtn;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

         arc= (CircleProgress) findViewById(R.id.arc);
        sector= (CircleProgress) findViewById(R.id.sector);
        round= (CircleProgress) findViewById(R.id.round);


        arcBtn= (Button) findViewById(R.id.artBtn);
        sectorBtn= (Button) findViewById(R.id.sectorBtn);
        roundBtn= (Button) findViewById(R.id.rounBtn);
        arcBtn.setOnClickListener(onClickListener);
        sectorBtn.setOnClickListener(onClickListener);
        roundBtn.setOnClickListener(onClickListener);

    }


    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.artBtn:
                    arc.setType(CircleProgress.ARC);
                    new AsyncTask<Integer, Integer, Integer>() {
                        @Override
                        protected Integer doInBackground(Integer... params) {
                            for(int i=0;i<=100;i++){
                                publishProgress(i);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            return null;
                        }

                        @Override
                        protected void onProgressUpdate(Integer... values) {
                            super.onProgressUpdate(values);
                            arc.setmSubCurProgress(values[0]);
                        }
                    }.execute(0);
                    break;
                case R.id.sectorBtn:
                    sector.setType(CircleProgress.SECTOR);

                    new AsyncTask<Integer, Integer, Integer>() {
                        @Override
                        protected Integer doInBackground(Integer... params) {
                            for(int i=0;i<=100;i++){
                                publishProgress(i);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            return null;
                        }

                        @Override
                        protected void onProgressUpdate(Integer... values) {
                            super.onProgressUpdate(values);
                            sector.setmSubCurProgress(values[0]);
                        }


                    }.execute(0);
                    break;
                case R.id.rounBtn:
                    round.setType(CircleProgress.ROUND);

                    new AsyncTask<Integer, Integer, Integer>() {
                        @Override
                        protected Integer doInBackground(Integer... params) {
                            for(int i=0;i<=100;i++){
                                publishProgress(i);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            return null;
                        }

                        @Override
                        protected void onProgressUpdate(Integer... values) {
                            super.onProgressUpdate(values);
                            round.setmSubCurProgress(values[0]);
                        }
                    }.execute(0);
                    break;
            }
        }
    };
}
