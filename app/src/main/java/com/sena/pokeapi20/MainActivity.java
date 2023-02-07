package com.sena.pokeapi20;


import androidx.appcompat.app.AppCompatActivity;
;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private ImageView image_view19,image_view20,image_view21,image_view22,image_view23,image_view24;
   private int start , end;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_view19=findViewById(R.id. image_view19);
        image_view20=findViewById(R.id. image_view20);
        image_view21=findViewById(R.id. image_view21);
        image_view22=findViewById(R.id. image_view22);
        image_view23=findViewById(R.id. image_view23);
        image_view24=findViewById(R.id. image_view24);



        image_view19.setOnClickListener(this);
        image_view20.setOnClickListener(this);
        image_view21.setOnClickListener(this);
        image_view22.setOnClickListener(this);
        image_view23.setOnClickListener(this);
        image_view24.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.image_view19:
                start=0;
               end=1100;
                StarPokedex();
                break;


            case R.id.image_view20:
                    start = 0;
                    end = 151;
                    StarPokedex();
                    break;

            case R.id.image_view21:
                        start = 151;
                        end = 99;
                        StarPokedex();
                        break;

            case R.id.image_view22:
                            start = 251;
                            end = 134;
                            StarPokedex();
                            break;

            case R.id.image_view23:
                                start = 386;
                                end = 107;
                                StarPokedex();
                                break;


            case R.id.image_view24:
                start = 494;
                end = 155;
                StarPokedex();
                break;

                //case R.id.button_7:
            // start = 650;
            // end = 71;
            // StarPokedex();
            // break;

            // case R.id.button_8:
            //  start = 722;
            //  end = 85;
            // StarPokedex();
            // break;

            // case R.id.button_9:
            //  start = 808;
            //  end = 200;
            // StarPokedex();
            //  break;

                        }

                    }

                    public  void StarPokedex(){
                        Intent intent = new Intent(this, Lista_pokemon.class);
                        intent.putExtra("start" , start);
                        intent.putExtra("end", end);
                        startActivity(intent);


                    }

                }