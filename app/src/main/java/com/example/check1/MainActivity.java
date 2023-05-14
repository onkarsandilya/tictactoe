package com.example.check1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=1;  //g1
    int [][] winningstate = {{0,1,2},
                          {3,4,5},
                          {6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int[]gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean gameover=false;
    public void load(View view){
    ImageView v=(ImageView) view;
    int tag=Integer.parseInt(v.getTag().toString());
    if(player==1 && !gameover)
    {
        if(gamestate[tag]==-1){
            v.setImageResource(R.drawable.g1);
            Toast.makeText(this, tag+" p1", Toast.LENGTH_SHORT).show();
            gamestate[tag]=player;
            player=2;
        }
        else{
            Toast.makeText(this,"click on right state",Toast.LENGTH_SHORT).show();
        }

    } else if (!gameover && player==2 ) {
        if(gamestate[tag]==-1) {
            v.setImageResource(R.drawable.g2);
            Toast.makeText(this, tag + " p2", Toast.LENGTH_SHORT).show();
            gamestate[tag] = player;
            player = 1;
        }
        else{
            Toast.makeText(this,"click on right state",Toast.LENGTH_SHORT).show();
        }
    }
    else{
        Toast.makeText(this,"GAME Over", Toast.LENGTH_SHORT).show();
    }
        for (int[] ints : winningstate) {
            if (gamestate[ints[0]] == gamestate[ints[1]] && gamestate[ints[1]] == gamestate[ints[2]] && gamestate[ints[0]] > 0 && gamestate[ints[1]] > 0) {
                Toast.makeText(this, "winner is player" + (player == 1 ? 2 : 1), Toast.LENGTH_SHORT).show();
                gameover = true;
            }
        }


}
public void reset(View view){
    GridLayout b=findViewById(R.id.gridlayout);
    int child=b.getChildCount();
    for(int j=0 ; j<child;j++){
        ImageView a= (ImageView) b.getChildAt(j);
        a.setImageDrawable(null);
        gamestate[j]=-1;
    }
    gameover=false;

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}