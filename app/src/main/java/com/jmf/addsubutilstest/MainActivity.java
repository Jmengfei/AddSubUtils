package com.jmf.addsubutilstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jmf.addsubutils.AddSubUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRecycler;
    private Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddSubUtils addSubUtils = (AddSubUtils) findViewById(R.id.add_sub_0);
        addSubUtils.setBuyMax(30)
                .setInventory(50)
                .setCurrentNumber(5)
                .setStep(5)
                .setBuyMin(2)
                .setOnWarnListener(new AddSubUtils.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        Toast.makeText(MainActivity.this, "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMax(int max) {
                        Toast.makeText(MainActivity.this, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMin(int min) {
                        Toast.makeText(MainActivity.this, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                    }

                });

        btnRecycler = (Button) findViewById(R.id.btn_recycler);
        btnList = (Button) findViewById(R.id.btn_list);

        btnList.setOnClickListener(this);
        btnRecycler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recycler :
                Intent intent = new Intent(MainActivity.this,RecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_list :
               Intent intent1 = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
