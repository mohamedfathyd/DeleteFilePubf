package com.example.deletefile;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Button deletea,deleteb;
int REQUEST_WRITE_STORAGE_REQUEST_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        requestAppPermissions();

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
        dlgAlert.setMessage("يجب أغلاق اللعبة أولا ");
        dlgAlert.setTitle("DeletePaks");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
        deletea=findViewById(R.id.deletea);
        deleteb=findViewById(R.id.deleteb);
        deletea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //com.tencent.ig
                //com.vng.pubgmobile
                File dir = new File("/storage/emulated/0/Android/data/com.tencent.ig/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Paks");
                if (dir.isDirectory())
                {
                    String[] children = dir.list();


                    for (int i = 0; i < children.length; i++)
                    {
                        String name=children[i];
                        if(name.contains("puffer_temp")||name.contains("puffer_res")||name.contains("PufferFilel_List.json")){
                            new File(dir, children[i]).delete();

                        }

                    }

                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("تم مسح ملفات ال Paks ");
                    dlgAlert.setTitle("DeletePaks");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });
        deleteb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = new File("/storage/emulated/0/Android/data/com.pubg.krmobile/files/UA4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Paks");
                if (dir.isDirectory())
                {
                    String[] children = dir.list();

                    Toast.makeText(MainActivity.this,children.length+"",Toast.LENGTH_LONG).show();

                    for (int i = 0; i < children.length; i++)
                    {
                        String name=children[i];
                        if(name.contains("puffer_temp")||name.contains("puffer_res")||name.contains("pufferFilel_ist")){
                            new File(dir, children[i]).delete();
                        }

                    }
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("تم مسح ملفات ال Paks ");
                    dlgAlert.setTitle("DeletePaks");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });
    }
    private void requestAppPermissions() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_WRITE_STORAGE_REQUEST_CODE); // your request code
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }
}
