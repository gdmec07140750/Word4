package com.example.administrator.word4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText nameEditText;
    private EditText moblieEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = (EditText) findViewById(R.id.name);
        moblieEditText = (EditText) findViewById(R.id.mobile);
        qqEditText = (EditText) findViewById(R.id.qq);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        addressEditText = (EditText) findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
       menu.add(0, 1, 0, "保存");
        menu.add(0,2,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       switch (item.getItemId()){
           case 1:
               if(!nameEditText.getText().toString().equals("")){//如果姓名不为空
                    User user = new User();
                   user.setName(nameEditText.getText().toString());
                   user.setMoblie(moblieEditText.getText().toString());
                   user.setQq(qqEditText.getText().toString());
                   user.setDanwei(danweiEditText.getText().toString());
                   user.setAddress(addressEditText.getText().toString());
                   ContactsTable ct =new ContactsTable(MainActivity.this);
                   if(ct.addData(user)){
                       Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_LONG).show();

                   }
                   else{
                       Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_LONG).show();
                   }
               }
               else{
                   Toast.makeText(MainActivity.this,"请先输入数据",Toast.LENGTH_LONG).show();
               }
               break;
           case 2:
               finish();
               break;
           default:
               break;
       }

        return super.onOptionsItemSelected(item);
    }
}
