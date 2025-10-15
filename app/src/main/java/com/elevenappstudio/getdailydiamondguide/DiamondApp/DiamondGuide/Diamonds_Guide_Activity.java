package com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

public class Diamonds_Guide_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamonds_guide);

        AdsClass.Show_Native_Ads(Diamonds_Guide_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Diamonds_Guide_Activity.this, findViewById(R.id.lnr_banner_ads),"Big");

        TextView tv_main = findViewById(R.id.tv_main);
        TextView tv_title = findViewById(R.id.tv_title);
        TextView tv_description = findViewById(R.id.tv_description);

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        if (getIntent().getStringExtra("name").equals("Diamond Guide")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Learn how to win gold and diamonds.\n\n In FFF FF you don9 just want to win, you want to show off unique weapon skins and features. To do this, you need to accumulate gold and diamonds by playing or paying with real money. Due to the amount of options, events and menus, many of us may feel confused.\n\n Discover the methods of winning gold and diamonds, and how to spend them to unlock various items in the game. We have compiled the 5 ways to win gold and diamonds, supported by images to help you in the best possible way.\n\n Play games.\n\n We will get a sum of gold just for participating, so entering a game will always be a good time invested. If you want to earn more money, its good to practice and work hard, as the game rewards survival time, final position, eliminations and headshots. In addition, by playing games you will be able to complete daily challenges.\n\n There are a variety of different challenges, especially if you have purchased Elite Pass (only unlocked with real money). When you complete a challenge, youll receive one or more explosive medals. The tasks are usually to play a certain number of minutes, use specific weapons, reach a specific number of eliminations or end up in high positions. \n\n Explosive medals are used for the Fire Pass. On this site, youll unlock items as you get more medals. If you purchase Elite Pass, youll get better rewards in the form of gold, diamonds and even skins. Otherwise, you can limit yourself to the Pass, but the rewards will be much scarcer. \n\n Enter the game every day \n\n This is a simple and safe way to earn gold, but in no case will we get diamonds just for entering. The daily rewards always come out when you enter the game and, as a general rule, you will get 350 gold each week. Its a very easy way to accumulate this virtual money, so try to get into FFF FF every day.Open boxes and participate in Gold Royale \n\n Every day well have a box in the game store. To find this box, go to the Normal section and click on the Offer of the day section.");

        } else if (getIntent().getStringExtra("name").equals("Tips & Tricks")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Become the best with these tips. \n\n In FFF FF we have many tools at our disposal to become the last survivor standing, but you must also know how to use them. Discover how to become the best player with these tips. \n\n Choose the right landing site \n\n Choosing the landing site is only the first step to victory. Although it may seem trivial, its not; determining where youll start will allow you to decide whether to start the game right or not. Its important to choose a place isolated from other players, near a city but not so close to it. \n\n Therefore, the best option is to fall out of towns and cities, observe where others fall and then enter to explore. It is fundamental not to expose ourselves too much until we are properly equipped, especially when we move around places with loot in quantity and quality, where many times there will be players. \n\n Get equipment \n\n As soon as we land, the first thing we have to do is to find weapons, protection, first aid kits, among other things. At the beginning of the game, the best thing to do is to grab everything we can find, as we can always improve and change the equipment. \n\n Explore military sites \n\n If there are no enemies in sight, its a good idea to explore sites like watchtowers, cargo containers, trenches or military tents. There are usually good loot in these kinds of places, both in weaponry and supplies. \n\n Its not very smart to explore these areas from the beginning, but if were halfway through the game, there will always be things to take. Surely there will be fewer players lurking around to eliminate us. \n\n In places like this, its also common to find kits to improve bulletproof vests. Pay attention as you explore because, although its okay to have a level one vest, its highly recommended to upgrade it soon. The last players will always have a powerful weapon. \n\n Pay attention to the safe area \n\n The safe zone is described by a white circle, which we can see both on the map and in the mini-map. Inside this zone we will be safe, since, outside of it, the radioactive storm will take away our life with the passage of time. \n\n If we pay attention to the safe area, we will often see players running for their lives to get away from the storm, before its too late. Situations like this are a perfect opportunity to eliminate opponents. \n\n Look at the mini-map.");

        } else if (getIntent().getStringExtra("name").equals("Sport Car")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The sports car in the game is the ultimate choice for players due to its outstanding attributes. With a remarkable top speed of 214 km/hr, it offers unmatched speed on the virtual roads. Its capacity for two people makes it ideal for duos or solo missions, ensuring a sleek and agile gaming experience.");

        } else if (getIntent().getStringExtra("name").equals("Monster")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The monster truck is a unique addition to the game, as it arrives via airdrop approximately five minutes into the match. This vehicle boasts exceptional armor, making it a formidable choice for traversing challenging terrain. However, it advisable not to use it as a permanent mode of transportation due to a significant drawback: its large size and slow mobility make it an easy target for enemies to hit directly.");

        } else if (getIntent().getStringExtra("name").equals("Moto")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The smallest vehicle in the game is designed for players who need to navigate narrower areas efficiently. Despite having a seating capacity of two, it often seen as a solo player choice. However, it comes with lower armor, leaving you vulnerable to direct hits from all directions. This compact vehicles advantage lies in its ability to access tight spaces and swiftly maneuver through confined terrain. In essence, while it offers agility and versatility, it also requires caution due to its reduced defensive capabilities, making players susceptible to incoming attacks from any angle.");

        } else if (getIntent().getStringExtra("name").equals("Amphibian")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The Amphibious is the only vehicle that can drive in both, land and water. It acceleration is somewhat mediocre when compared to the other vehicles, but it posses a sturdy durability.");

        } else if (getIntent().getStringExtra("name").equals("Military Jeep")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("A jeep is a heavy vehicle, meaning it is a safe way of travelling around the map. It can withstand severe damage and also be used as a cover during fights.");

        } else if (getIntent().getStringExtra("name").equals("Tuk Tuk")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Tuk-Tuk Is the Slowest Vehicle Of The Game And Comes With Lower Armor. I Would recommend It To Use Only In An Urgent Situation Like Reaching The Safe Zone Or Escaping From Enemies In Open Grounds. It Also Allows Enemies To Hit You Directly.");

        } else if (getIntent().getStringExtra("name").equals("Van")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The Amphibious Vehicle an Be used On Both The Surfaces: Land And Water. this Is the Vehicle With Low Armor And Exposes You To Direct Hits From The Enemies.");

        } else if (getIntent().getStringExtra("name").equals("Mk12")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("It a semi-automatic weapon, meaning it fires one shot per trigger pull. You need to release the trigger and pull it again to fire another shot. The fire rate depends on how fast you can pull the trigger.The M14 usually has a magazine capacity of 15 rounds. However, this can be increased with attachments.");

        } else if (getIntent().getStringExtra("name").equals("Scarl")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Scar Is A Popular Weapon That Is Often Used By Players Who Are Looking For A Well-Rounded Weapon That Can Be Used In A Variety Of Situations.");

        } else if (getIntent().getStringExtra("name").equals("AKM")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("AK47 is an Assault Rifle with AR Ammo. The weapon has a high damage of 38 and a medium range and a medium rate of fire. The weapon has also low accuracy which makes it require a skill to control.");

        } else if (getIntent().getStringExtra("name").equals("Grozny")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Grozny is an Assault Rifle with AR Ammo. Groza has a damage of 61 and a medium accuracy and a medium rate of fire. The weapon is good for very Long range.");

        } else if (getIntent().getStringExtra("name").equals("Crossbow")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Crossbow is the only Bow in the game and the only weapon that uses Crossbow Bolts. The weapon has a damage of 90 and also has a medium accuracy and rate of fire. The weapon is good for Medium-Range.");

        } else if (getIntent().getStringExtra("name").equals("QBZ95")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("QBZ-95 was the first Chinese bullpup assault rifle and is the predecessor of QBZ-97. It has been produced since 1995 but currently, it is no longer manufactured.");

        } else if (getIntent().getStringExtra("name").equals("AUG A3")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("The AUGA3 is a free weapon but does require you to unlock it on the Prize Wheel and is very rare (0.5% chance). This weapon deals around 41-64 damage per shot that is hit and has a firerate of 660 rounds per minute. This gun also has a magazine compacity of 30 rounds with a special optic that is exclusive to this gun.");

        } else if (getIntent().getStringExtra("name").equals("Hayato")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Hayato, a boy from a legendary Samurai family Being the only son of the family, Hayato is the only one who must continue with tradition and curse in turn...\n" +
                    "\n" +
                    "This samurai has a secret that no one knows... That's why Hayato wishes his life to end as soon as possible.\n" +
                    "\n" +
                    "Hayato had much on his shoulders as the eldest heir to the Yagami corporation.\n" +
                    "\n" +
                    "He was raised in a life where his existence was meant to serve the honor and glory of his family.\n" +
                    "\n" +
                    "When his family corporation was acquired by Horizon, he did not hesitate to get involved in corporate affairs to ensure that the Yagami continued to operate with honour.");

        } else if (getIntent().getStringExtra("name").equals("Moco")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Moco is tech genius that joined Horizon, the most prestigious tech company on the continent. But when she finds out they are up to nefarious acts, she pulls a disappearing act, wipes her identity from the public record and goes into hiding to find a way to stop their plans. She likes to operate alone, but will soon realize this threat is too big for her to take on by herself.");

        } else if (getIntent().getStringExtra("name").equals("Wukong")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("A Monkey that looks like a humanbeing. He still likes bananas, though. \n Wukong's ability is Camouflage which Turns him into a Bush. Taking down an enemy resets cooldown.");

        } else if (getIntent().getStringExtra("name").equals("Antonio")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Antonio, the well-known Gangster.\n" +
                    "\n" +
                    "He was an orphan who grew up to be a gangster. He started his own gang and spent 7 years to wiping out all the other gangesters in his hometown.\n" +
                    "\n" +
                    "To protect his loved ones, he puts himself in danger over and over again.");

        } else if (getIntent().getStringExtra("name").equals("Andrew")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Andrew was a police officer. With his strong sense of justice, he spent most of his time chasing criminals.\n" +
                    "\n" +
                    "His singlet was his lucky charm, he had already lost count of the number of fights he survived wearing it.\n" +
                    "\n" +
                    "Searching for the truth behind everything was his call of duty.");

        } else if (getIntent().getStringExtra("name").equals("Kelly")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Kelly is a high-school sprinter.\n" +
                    "\n" +
                    "She is also known as Shimada Kiriko.\n" +
                    "\n" +
                    "She loves to run, and can always be seen on the track.\n" +
                    "\n" +
                    "Running forward is built into her mind and body. No matter the obstacle, she will always push forward.\n" +
                    "\n" +
                    "Keep Running! KIRIKO!");

        }else if (getIntent().getStringExtra("name").equals("Olivia")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("After an operation from a childhood accident, Olivia developed a special abilityto heal and revive - with one miraculous touch, she can gently will the pain away and promote healing in injuries. Despite hertraumatic childhood, Olivia grew to become the most caring and compassionate among her peers. However, she has little social interaction outside Ford's safe zone and shies away from the world.");

        }else if (getIntent().getStringExtra("name").equals("Ford")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Ford is a playable character at Free Fire and a former seaman. He costs 2000 Cash.\n" +
                    "\n" +
                    "His experiences as a seaman granted him increased toughness and resistance, reducing the damage he takes while outside the safe zone.");

        }else if (getIntent().getStringExtra("name").equals("Nikita")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Nikita is a playable character in Free Fire. She can be purchased at the store for 2.500 Cash.\n" +
                    "\n" +
                    "She works as a bodyguard, and have increased experience with Submachineguns, being able to reload them faster than any other character in the game.");

        }else if (getIntent().getStringExtra("name").equals("Misha")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Misha is a female character in Free Fire. At 8000 Cash, she is the most expensive character so far.\n" +
                    "\n" +
                    "She is an adept racer, with the ability to drive any vehicle at increased speed.");

        }else if (getIntent().getStringExtra("name").equals("Maxim")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Maxim is a character in Garena Free Fire. He can be purchased with 8000 Gold or 499 Diamonds.\n" +
                    "\n" +
                    "An competitive eater with a insatiable hunger, he eats mushrooms and is able to use medkits faster than other characters. He has a girl friend named Kelly.");

        }else if (getIntent().getStringExtra("name").equals("Kla")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Kla was an esteemed martial artist, specializing in Muay Thai.\n" +
                    "\n" +
                    "A few years ago, he mysteriously disappeared and no one could find him.\n" +
                    "\n" +
                    "The Kla that reappeared before everyone is not the same one as the famous Kla that everyone in the industry was familiar with.\n" +
                    "\n" +
                    "He is now an avenger, and leaves no mercy to anyone.");

        }else if (getIntent().getStringExtra("name").equals("Palona")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Paloma has a painful past that she does not talk about often.\n" +
                    "\n" +
                    "A beauty queen raised in the poorest suburbs of her country, she used to be every girl's role model.\n" +
                    "\n" +
                    "But now, she is the epitome of evil, an arms dealer that controls the underworld in the palm of her hands.");

        }else if (getIntent().getStringExtra("name").equals("Miquel")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Miguel is a well-rounded Elite Soldier in the Special Forces.\n" +
                    "\n" +
                    "As a leader of his squad, Miguel and his team have sent numerous criminals into custody.\n" +
                    "\n" +
                    "He does not care about how hard the mission is, as long as he can provide justice.\n" +
                    "\n" +
                    "However, after a failed operation 6 months ago, he realized that he was betrayed by his trusted allies.");

        }else if (getIntent().getStringExtra("name").equals("Caroline")) {

            tv_main.setText(getIntent().getStringExtra("name"));
            tv_title.setText(getIntent().getStringExtra("name"));
            tv_description.setText("Caroline, a girl who grew up in an extremely wealthy family. She is always surrounded by bodyguards wherever she goes.\n" +
                    "\n" +
                    "She has enough fans to fill up an entire stadium. She is no doubt the most popular girl at school.\n" +
                    "\n" +
                    "Her father and her friends--- The most valuable things in her life.");

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