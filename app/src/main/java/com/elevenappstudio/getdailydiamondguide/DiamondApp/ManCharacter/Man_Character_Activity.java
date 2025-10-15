package com.elevenappstudio.getdailydiamondguide.DiamondApp.ManCharacter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamonds_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.DifferentWeapons.Different_Weapons_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

public class Man_Character_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_character);

        AdsClass.Show_Native_Ads(Man_Character_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Man_Character_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.iv_hayato).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Hayato");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_moco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Moco");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_wukong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Wukong");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_antonio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Antonio");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_andrew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Andrew");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_kelly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Kelly");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_olivia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Olivia");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_ford).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Ford");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_nikita).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Nikita");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_misha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Misha");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_maxim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Maxim");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_kla).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Kla");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_palona).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Palona");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_miguel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Miquel");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_caroline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Man_Character_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Man_Character_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Caroline");
                        startActivity(intent);
                    }
                });
            }
        });

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