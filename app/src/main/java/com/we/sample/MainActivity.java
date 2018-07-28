package com.we.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.we.widget.WeRecycleView;

public class MainActivity extends Activity {

    private WeRecycleView mRecycleView;

    private int mCount = 100;
    private int mDensity;
    private TextView mTitleView;
    private final int COL_3F51B5 = Color.parseColor("#3F51B5");
    private final int RED = Color.red(COL_3F51B5);
    private final int GREEN = Color.green(COL_3F51B5);
    private final int BLUE = Color.blue(COL_3F51B5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDensity = (int) getResources().getDisplayMetrics().density;

        mTitleView = findViewById(R.id.title);
        mTitleView.setBackgroundColor(Color.argb(0, RED, GREEN, BLUE));

        mRecycleView = findViewById(R.id.recycle);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setScrollMode(WeRecycleView.SCROLL_SCALE_HEAD);
        mRecycleView.setMaxScale(4f);
        mRecycleView.setSafeHeight(480);
        mRecycleView.setCloseOffset(50 * mDensity);
        mRecycleView.setOnHeadExpandListener(new WeRecycleView.OnHeadExpandListener() {
            @Override
            public void onExpand(float percent) {
                mTitleView.setBackgroundColor(Color.argb((int) (255 * (1 - percent)), RED, GREEN, BLUE));
            }

            @Override
            public void onEnterSafeArea(boolean isEnter) {

            }
        });

        mRecycleView.setMaxScale(4f);
        mRecycleView.setSafeHeight(480);
        mRecycleView.setCloseOffset(50 * mDensity);


        initAdapter();

    }


    private void initAdapter() {
        mRecycleView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public int getItemViewType(int position) {
                return position;
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                if (viewType == 0) {
                    final ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                            , (int) (getResources().getDisplayMetrics().widthPixels * 533f / 800)));
                    return new RecyclerView.ViewHolder(imageView) {
                        @Override
                        public String toString() {
                            return super.toString();
                        }
                    };
                } else {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(30);
                    textView.setGravity(Gravity.CENTER);
                    textView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mDensity * 150));

                    return new RecyclerView.ViewHolder(textView) {
                        @Override
                        public String toString() {
                            return super.toString();
                        }
                    };
                }
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                if (position == 0) {
                    ((ImageView) holder.itemView).setImageResource(R.drawable.pic);
                } else {
                    holder.itemView.setBackgroundColor(position % 2 == 0 ? Color.WHITE : Color.parseColor("#F0F0F0"));
                }
            }

            @Override
            public int getItemCount() {
                return mCount;
            }

        });
    }


}
