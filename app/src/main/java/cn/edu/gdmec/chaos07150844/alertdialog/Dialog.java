package cn.edu.gdmec.chaos07150844.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dialog extends AppCompatActivity {

    private TextView tv1;
    private AlertDialog.Builder bulider;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tv1 = (TextView) findViewById(R.id.textView);
        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt3 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.button4);
        Button bt5 = (Button) findViewById(R.id.button5);
        Button bt6 = (Button) findViewById(R.id.button6);
        Button bt7 = (Button) findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;

                }
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);

    }

    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("三个按钮");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时不忙";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",lis);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",lis);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",lis);
        dialog.show();

    }
    public void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    Dialog.this.finish();
                }else if (which == DialogInterface.BUTTON_NEUTRAL){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"退出",lis);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",lis);
        dialog.show();
    }
    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    public void dialog4(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mLis = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        bulider = new AlertDialog.Builder(this);
        bulider.setMultiChoiceItems(item,null,mLis);
        dialog = bulider.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for (int i = 0;i < bSelect.length;i++){
                    if (bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    public void dialog5(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sLis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which] = true;
            }
        };
        bulider = new AlertDialog.Builder(this);
        bulider.setSingleChoiceItems(item,-1,sLis);
        dialog = bulider.create();
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    public void dialog6(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sLis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了："+item[which];
                tv1.setText(str);
            }
        };
        bulider = new AlertDialog.Builder(this);
        bulider.setItems(item,sLis);
        dialog = bulider.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",lis);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis);
        dialog.show();
    }

}
