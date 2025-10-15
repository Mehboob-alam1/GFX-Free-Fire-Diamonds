package com.elevenappstudio.getdailydiamondguide.DiamondApp.RareEmotes;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

import org.w3c.dom.Text;

public class Emotes_Claim_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotes_claim);

        AdsClass.Show_Banner_Ads(Emotes_Claim_Activity.this, findViewById(R.id.lnr_banner_ads), "Small");

        ImageView iv_emote = (ImageView) findViewById(R.id.iv_emote);
        TextView tv_description = (TextView) findViewById(R.id.tv_description);
        CardView card_view = (CardView) findViewById(R.id.card_view);
        RelativeLayout rlt_claim_now = (RelativeLayout) findViewById(R.id.rlt_claim_now);

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rlt_claim_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Emotes_Claim_Activity.this, android.R.style.Theme_Light);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.congrates);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.getWindow().setLayout(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setGravity(Gravity.CENTER);
                ImageView iv_no = dialog.findViewById(R.id.iv_no);
                ImageView iv_yes = dialog.findViewById(R.id.iv_yes);

                iv_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                iv_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        if (getIntent().getStringExtra("name").equals("Emote 1")) {
            iv_emote.setImageResource(R.drawable.iv_emote_01);
            tv_description.setText("The Hello Emote features A Character Waving Their Hand In Greeting. It Is Often Used To Say Hello to Other Playrs At The Beginning Of A Match Or To Greet Soneone In the Game Lobby.");
        } else if (getIntent().getStringExtra("name").equals("Emote 2")) {
            iv_emote.setImageResource(R.drawable.iv_emote_02);
            tv_description.setText("The character will act like he is proposing to someone with a rose. This emote is mostly used to flirt with a female gaming character in the game or when you knock someone down after long combat.");
        } else if (getIntent().getStringExtra("name").equals("Emote 3")) {
            iv_emote.setImageResource(R.drawable.iv_emote_03);
            tv_description.setText("The character will act like he is proposing to someone with a rose. This emote is mostly used to flirt with a female gaming character in the game or when you knock someone down after long combat.");
        } else if (getIntent().getStringExtra("name").equals("Emote 4")) {
            iv_emote.setImageResource(R.drawable.iv_emote_04);
            tv_description.setText("There are many variants of Selfie emote in various games, and FFF Game MAX also features one. It was introduced by Garena in December of 2019 and received instant love from fans upon introduction.");
        } else if (getIntent().getStringExtra("name").equals("Emote 5")) {
            iv_emote.setImageResource(R.drawable.iv_emote_05);
            tv_description.setText("Top DJ is an emote inspired by the popular character Top DJ. Both the character and the emote are a favorite with players. The legendary emote features a floating DJ console.");
        } else if (getIntent().getStringExtra("name").equals("Emote 6")) {
            iv_emote.setImageResource(R.drawable.iv_emote_06);
            tv_description.setText("I’m Rich is also a Money Heist special edition emote that was also available in the FFF Game store. I’m Rich emote, the same as Make it Rain, was also inspired by a famous scene in Money Heist.");
        } else if (getIntent().getStringExtra("name").equals("Emote 7")) {
            iv_emote.setImageResource(R.drawable.iv_emote_07);
            tv_description.setText("The ‘Kungfu Tigers Top-Up’ is the most recent top-up available in FFF Game, and it will be offered to players until February 2. Listed below are the specific criteria that players must meet to get the Kungfu Tigers emote and other rewards.");
        } else if (getIntent().getStringExtra("name").equals("Emote 8")) {
            iv_emote.setImageResource(R.drawable.iv_emote_08);
            tv_description.setText("Provoke is also a good choice of emote for players playing FFF Game MAX. The emote is priced at 399 diamonds. Upon using the emote, the character does a thumbs-down action.");
        } else if (getIntent().getStringExtra("name").equals("Emote 9")) {
            iv_emote.setImageResource(R.drawable.iv_emote_09);
            tv_description.setText("The Dance Emote Freatures A Character Performing A Dance. there Are Several Different Dance Emotes Available In FF, Each With Its Own Unique Sytyle.");
        } else if (getIntent().getStringExtra("name").equals("Emote 10")) {
            iv_emote.setImageResource(R.drawable.iv_emote_010);
            tv_description.setText("Garena FFF Game always announces new sets of events to engage users in the game. FFF Game Booyah Watch to Win Event is one of the most popular events for gamers.");
        } else if (getIntent().getStringExtra("name").equals("Emote 11")) {
            iv_emote.setImageResource(R.drawable.iv_emote_011);
            tv_description.setText("It was featured in the game in 2019 during the Pirate Top Up event. While using this emote the in-game character takes out the flag and bangs it on the ground when it’s fully equipped. It is one of the legendary emotes of the FFF Game.");
        } else if (getIntent().getStringExtra("name").equals("Emote 12")) {
            iv_emote.setImageResource(R.drawable.iv_emote_012);
            tv_description.setText("While you use this emote character do a single Push-up. This emote is shown to display the power of your techniques during close combat.");
        } else if (getIntent().getStringExtra("name").equals("Emote 13")) {
            iv_emote.setImageResource(R.drawable.iv_emote_013);
            tv_description.setText("The character will act like he is proposing to someone with a rose. This emote is mostly used to flirt with a female gaming character in the game or when you knock someone down after long combat.");
        } else if (getIntent().getStringExtra("name").equals("Emote 14")) {
            iv_emote.setImageResource(R.drawable.iv_emote_014);
            tv_description.setText("Mostly it is well-known for the gameplay and the diversity of character skins it offers. Apart from that, FFF Game also puts forward many cool emotes which help the game get even more fun.");
        } else if (getIntent().getStringExtra("name").equals("Emote 15")) {
            iv_emote.setImageResource(R.drawable.iv_emote_015);
            tv_description.setText("he acquisition of the Haven Guardian Loot Box is even more of an attraction as it is one of the rewards in the Top Up event, where players must top up 100 diamonds to receive it for Feree. The FFWS Top Up event will be concluding today.");
        } else if (getIntent().getStringExtra("name").equals("Map 1")) {
            card_view.setVisibility(View.GONE);
            rlt_claim_now.setVisibility(View.GONE);
            tv_description.setText("Santa Catarina is one of the places in FFF Game which is known for its scenic view. It is a place where you can hide and you can find an armor upgrading kit also at the location. Santa Catarina can be your first looting place and it is a place that is considered a hot-spot for fights.");
        } else if (getIntent().getStringExtra("name").equals("Map 2")) {
            card_view.setVisibility(View.GONE);
            rlt_claim_now.setVisibility(View.GONE);
            tv_description.setText("As mentioned earlier, FFWS Bayfront is a part of the Faded Wheel running from May 29th to June 4th. There are ten items present in it, and to begin with, players must remove two rewards that they do not require.");
        } else if (getIntent().getStringExtra("name").equals("Map 3")) {
            card_view.setVisibility(View.GONE);
            rlt_claim_now.setVisibility(View.GONE);
            tv_description.setText("Next up is Councill hall. This location is built by the community leaders in Kalahari. You can see there’s a platform that is used for meetings.Although the map is quite small, Councill Hall has high-tier loot items.");
        } else if (getIntent().getStringExtra("name").equals("Map 4")) {
            card_view.setVisibility(View.GONE);
            rlt_claim_now.setVisibility(View.GONE);
            tv_description.setText("The fourth place on the list for passive players to land is Old Hampton. It is situated on the upper corner of the map and does not have many players landing there. Players can find lots of hiding places to be safe from enemy players. Loot is equally spread throughout the area, and players can quickly get sufficient ammunition and other necessities.");
        }

    }

    @Override
    public void onBackPressed() {
        AdsClass.Show_Back_Interstitial_Ads(this, new AdsClass.AdsClick() {
            @Override
            public void AdsDismiss(boolean b) {
                finish();
            }
        });
    }
}