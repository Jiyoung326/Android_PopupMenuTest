package kr.or.womanup.nambu.hjy.popupmenutest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //팝업메뉴를 텍스트 뷰에 붙이기
                PopupMenu pop = new PopupMenu(MainActivity.this,textView);
                //pop.getMenu()를 하면 비어있는 메뉴 참조값이 나옴
                Menu menu = pop.getMenu();
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_popup,menu);
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.popup1 :
                                textView.setText("popup1선택"); break;
                            case R.id.popup2 :
                                textView.setText("popup2선택"); break;
                            case R.id.popup3 :
                                textView.setText("popup3선택"); break;
                        }
                        return false;
                    }
                });
                pop.show();
            }
        });
    }
}