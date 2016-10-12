package com.tirkiyaicloud.businesscompliments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class TextActivity extends AppCompatActivity {
    private Intent intent;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        getSupportActionBar().hide();
        intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        if (type < 4) {
            makeStandart(type);
        } else {
            setContentView(R.layout.slide_activity);
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            makeSlide();
        }
    }

    public void makeStandart(int type) {
        setContentView(R.layout.content_activity_text);
        int tom = intent.getIntExtra("tom", 0);
        ScrollView layout = (ScrollView) findViewById(R.id.text_layout);
        toolbar = (Toolbar) layout.findViewById(R.id.my_toolbar);
        toolbarSetting();
        TextView title = (TextView) layout.findViewById(R.id.text_title);
        title.setText(intent.getStringExtra("title"));
        TextView bigText = (TextView) layout.findViewById(R.id.bigText);
        TextSize textSize = TextSize.getInstance();
        bigText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.getTextSize());
        switch (type) {
            case 1:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color1));
                title.setTextColor(getResources().getColor(R.color.color1));
                switch (tom) {
                    case 1:
                        bigText.setText(R.string.text11);
                        break;
                    case 2:
                        bigText.setText(R.string.text12);
                        break;
                    case 3:
                        bigText.setText(R.string.text13);
                        break;
                    case 4:
                        bigText.setText(R.string.text14);
                        break;
                    case 5:
                        bigText.setText(R.string.text15);
                        break;
                    case 6:
                        bigText.setText(R.string.text16);
                        break;
                    case 7:
                        bigText.setText(R.string.text17);
                        break;
                    case 8:
                        bigText.setText(R.string.text18);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color3));
                title.setTextColor(getResources().getColor(R.color.color3));
                switch (tom) {
                    case 1:
                        bigText.setText(R.string.text21);
                        break;
                    case 2:
                        bigText.setText(R.string.text22);
                        break;
                    case 3:
                        bigText.setText(R.string.text23);
                        break;
                    case 4:
                        bigText.setText(R.string.text24);
                        break;
                    case 5:
                        bigText.setText(R.string.text25);
                        break;
                    case 6:
                        bigText.setText(R.string.text26);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color2));
                title.setTextColor(getResources().getColor(R.color.color2));
                switch (tom) {
                    case 1:
                        bigText.setText(R.string.text31);
                        break;
                    case 2:
                        bigText.setText(R.string.text32);
                        break;
                    case 3:
                        bigText.setText(R.string.text33);
                        break;
                    case 4:
                        bigText.setText(R.string.text34);
                        break;
                    case 5:
                        bigText.setText(R.string.text35);
                        break;
                    case 6:
                        bigText.setText(R.string.text36);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public void makeSlide() {
        ArrayList<Integer> texts = makeTexts(intent.getIntExtra("tom", 0));
        StarItems starItems = StarItems.getInstance();
        for (int i = 0; i < texts.size(); i++) {
            TempFragment tm = new TempFragment();
            tm.setIn(i + 1);
            tm.setAll(texts.size());
            tm.setMainTitle(intent.getStringExtra("title"));
            TextView tempText = new TextView(this);
            tempText.setText(texts.get(i));
            tm.setTextView(tempText);
            if (starItems.isStar(tempText))
                tm.setStarred(true);
            else
                tm.setStarred(false);
            viewPagerAdapter.addFragment(tm);
        }
        viewPager.setAdapter(viewPagerAdapter);
    }

    public ArrayList<Integer> makeTexts(int tom) {
        ArrayList<Integer> text = new ArrayList<>();
        switch (tom) {
            case 1:
                text.add(R.string.prim100);
                text.add(R.string.prim101);
                text.add(R.string.prim102);
                text.add(R.string.prim103);
                text.add(R.string.prim104);
                text.add(R.string.prim105);
                text.add(R.string.prim106);
                text.add(R.string.prim107);
                text.add(R.string.prim108);
                text.add(R.string.prim109);
                text.add(R.string.prim110);
                text.add(R.string.prim111);
                text.add(R.string.prim112);
                text.add(R.string.prim113);
                text.add(R.string.prim114);
                text.add(R.string.prim115);
                text.add(R.string.prim116);
                text.add(R.string.prim117);
                text.add(R.string.prim118);
                text.add(R.string.prim119);
                text.add(R.string.prim120);
                text.add(R.string.prim121);
                text.add(R.string.prim122);
                text.add(R.string.prim123);
                text.add(R.string.prim124);
                text.add(R.string.prim125);
                text.add(R.string.prim126);
                text.add(R.string.prim127);
                text.add(R.string.prim128);
                text.add(R.string.prim129);
                text.add(R.string.prim130);
                text.add(R.string.prim131);
                text.add(R.string.prim132);
                text.add(R.string.prim133);
                text.add(R.string.prim134);
                text.add(R.string.prim135);
                text.add(R.string.prim136);
                text.add(R.string.prim137);
                text.add(R.string.prim138);
                text.add(R.string.prim139);
                text.add(R.string.prim140);
                text.add(R.string.prim141);
                text.add(R.string.prim142);
                text.add(R.string.prim143);
                text.add(R.string.prim144);
                text.add(R.string.prim145);
                text.add(R.string.prim146);
                text.add(R.string.prim147);
                text.add(R.string.prim148);
                text.add(R.string.prim149);
                text.add(R.string.prim150);
                text.add(R.string.prim151);
                break;
            case 2:
                text.add(R.string.prim200);
                text.add(R.string.prim201);
                text.add(R.string.prim202);
                text.add(R.string.prim203);
                text.add(R.string.prim204);
                text.add(R.string.prim205);
                text.add(R.string.prim206);
                text.add(R.string.prim207);
                text.add(R.string.prim208);
                text.add(R.string.prim209);
                text.add(R.string.prim210);
                text.add(R.string.prim211);
                text.add(R.string.prim212);
                text.add(R.string.prim213);
                text.add(R.string.prim214);
                text.add(R.string.prim215);
                text.add(R.string.prim216);
                text.add(R.string.prim217);
                text.add(R.string.prim218);
                text.add(R.string.prim219);
                text.add(R.string.prim220);
                text.add(R.string.prim221);
                text.add(R.string.prim222);
                text.add(R.string.prim223);
                text.add(R.string.prim224);
                text.add(R.string.prim225);
                text.add(R.string.prim226);
                text.add(R.string.prim227);
                text.add(R.string.prim228);
                text.add(R.string.prim229);
                text.add(R.string.prim230);
                text.add(R.string.prim231);
                text.add(R.string.prim232);
                text.add(R.string.prim233);
                text.add(R.string.prim234);
                text.add(R.string.prim235);
                text.add(R.string.prim236);
                text.add(R.string.prim237);
                text.add(R.string.prim238);
                text.add(R.string.prim239);
                text.add(R.string.prim240);
                text.add(R.string.prim241);
                text.add(R.string.prim242);
                text.add(R.string.prim243);
                text.add(R.string.prim244);
                text.add(R.string.prim245);
                text.add(R.string.prim246);
                text.add(R.string.prim247);
                text.add(R.string.prim248);
                text.add(R.string.prim249);
                break;
            case 3:
                text.add(R.string.prim300);
                text.add(R.string.prim301);
                text.add(R.string.prim302);
                text.add(R.string.prim303);
                text.add(R.string.prim304);
                text.add(R.string.prim305);
                text.add(R.string.prim306);
                text.add(R.string.prim307);
                text.add(R.string.prim308);
                text.add(R.string.prim309);
                text.add(R.string.prim310);
                text.add(R.string.prim311);
                text.add(R.string.prim312);
                text.add(R.string.prim313);
                text.add(R.string.prim314);
                text.add(R.string.prim315);
                text.add(R.string.prim316);
                text.add(R.string.prim317);
                text.add(R.string.prim318);
                text.add(R.string.prim319);
                text.add(R.string.prim320);
                text.add(R.string.prim321);
                text.add(R.string.prim322);
                text.add(R.string.prim323);
                text.add(R.string.prim324);
                text.add(R.string.prim325);
                text.add(R.string.prim326);
                text.add(R.string.prim327);
                text.add(R.string.prim328);
                text.add(R.string.prim329);
                text.add(R.string.prim330);
                text.add(R.string.prim331);
                text.add(R.string.prim332);
                text.add(R.string.prim333);
                text.add(R.string.prim334);
                text.add(R.string.prim335);
                text.add(R.string.prim336);
                text.add(R.string.prim337);
                text.add(R.string.prim338);
                text.add(R.string.prim339);
                text.add(R.string.prim340);
                break;
            case 4:
                text.add(R.string.prim400);
                text.add(R.string.prim401);
                text.add(R.string.prim402);
                text.add(R.string.prim403);
                text.add(R.string.prim404);
                text.add(R.string.prim405);
                text.add(R.string.prim406);
                text.add(R.string.prim407);
                text.add(R.string.prim408);
                text.add(R.string.prim409);
                text.add(R.string.prim410);
                text.add(R.string.prim411);
                text.add(R.string.prim412);
                text.add(R.string.prim413);
                text.add(R.string.prim414);
                text.add(R.string.prim415);
                text.add(R.string.prim416);
                text.add(R.string.prim417);
                text.add(R.string.prim418);
                text.add(R.string.prim419);
                text.add(R.string.prim420);
                text.add(R.string.prim421);
                text.add(R.string.prim422);
                text.add(R.string.prim423);
                text.add(R.string.prim424);
                text.add(R.string.prim425);
                text.add(R.string.prim426);
                text.add(R.string.prim427);
                text.add(R.string.prim428);
                text.add(R.string.prim429);
                text.add(R.string.prim430);
                text.add(R.string.prim431);
                text.add(R.string.prim432);
                text.add(R.string.prim433);
                text.add(R.string.prim434);
                text.add(R.string.prim435);
                text.add(R.string.prim436);
                text.add(R.string.prim437);
                text.add(R.string.prim438);
                text.add(R.string.prim439);
                text.add(R.string.prim440);
                text.add(R.string.prim441);
                text.add(R.string.prim442);
                text.add(R.string.prim443);
                text.add(R.string.prim444);
                text.add(R.string.prim445);
                text.add(R.string.prim446);
                text.add(R.string.prim447);
                text.add(R.string.prim448);
                text.add(R.string.prim449);
                break;
            case 5:
                text.add(R.string.prim500);
                text.add(R.string.prim501);
                text.add(R.string.prim502);
                text.add(R.string.prim503);
                text.add(R.string.prim504);
                text.add(R.string.prim505);
                text.add(R.string.prim506);
                text.add(R.string.prim507);
                text.add(R.string.prim508);
                text.add(R.string.prim509);
                text.add(R.string.prim510);
                text.add(R.string.prim511);
                text.add(R.string.prim512);
                text.add(R.string.prim513);
                text.add(R.string.prim514);
                text.add(R.string.prim515);
                text.add(R.string.prim516);
                text.add(R.string.prim517);
                text.add(R.string.prim518);
                text.add(R.string.prim519);
                text.add(R.string.prim520);
                text.add(R.string.prim521);
                text.add(R.string.prim522);
                text.add(R.string.prim523);
                text.add(R.string.prim524);
                text.add(R.string.prim525);
                text.add(R.string.prim526);
                text.add(R.string.prim527);
                text.add(R.string.prim528);
                text.add(R.string.prim529);
                text.add(R.string.prim530);
                text.add(R.string.prim531);
                text.add(R.string.prim532);
                text.add(R.string.prim533);
                text.add(R.string.prim534);
                text.add(R.string.prim535);
                text.add(R.string.prim536);
                text.add(R.string.prim537);
                text.add(R.string.prim538);
                text.add(R.string.prim539);
                text.add(R.string.prim540);
                text.add(R.string.prim541);
                text.add(R.string.prim542);
                text.add(R.string.prim543);
                text.add(R.string.prim544);
                text.add(R.string.prim545);
                text.add(R.string.prim546);
                text.add(R.string.prim547);
                text.add(R.string.prim548);
                text.add(R.string.prim549);
                break;
            case 6:
                text.add(R.string.prim600);
                text.add(R.string.prim601);
                text.add(R.string.prim602);
                text.add(R.string.prim603);
                text.add(R.string.prim604);
                text.add(R.string.prim605);
                text.add(R.string.prim606);
                text.add(R.string.prim607);
                text.add(R.string.prim608);
                text.add(R.string.prim609);
                text.add(R.string.prim610);
                text.add(R.string.prim611);
                text.add(R.string.prim612);
                text.add(R.string.prim613);
                text.add(R.string.prim614);
                text.add(R.string.prim615);
                text.add(R.string.prim616);
                text.add(R.string.prim617);
                text.add(R.string.prim618);
                text.add(R.string.prim619);
                text.add(R.string.prim620);
                text.add(R.string.prim621);
                text.add(R.string.prim622);
                text.add(R.string.prim623);
                text.add(R.string.prim624);
                text.add(R.string.prim625);
                text.add(R.string.prim626);
                text.add(R.string.prim627);
                text.add(R.string.prim628);
                text.add(R.string.prim629);
                text.add(R.string.prim630);
                text.add(R.string.prim631);
                text.add(R.string.prim632);
                text.add(R.string.prim633);
                text.add(R.string.prim634);
                text.add(R.string.prim635);
                text.add(R.string.prim636);
                text.add(R.string.prim637);
                text.add(R.string.prim638);
                text.add(R.string.prim639);
                text.add(R.string.prim640);
                text.add(R.string.prim641);
                text.add(R.string.prim642);
                text.add(R.string.prim643);
                text.add(R.string.prim644);
                text.add(R.string.prim645);
                text.add(R.string.prim646);
                text.add(R.string.prim647);
                text.add(R.string.prim648);
                text.add(R.string.prim649);
                text.add(R.string.prim650);
                text.add(R.string.prim651);
                text.add(R.string.prim652);
                text.add(R.string.prim653);
                text.add(R.string.prim654);
                text.add(R.string.prim655);
                text.add(R.string.prim656);
                text.add(R.string.prim657);
                text.add(R.string.prim658);
                text.add(R.string.prim659);
                text.add(R.string.prim660);
                break;
            case 7:
                text.add(R.string.prim700);
                text.add(R.string.prim701);
                text.add(R.string.prim702);
                text.add(R.string.prim703);
                text.add(R.string.prim704);
                text.add(R.string.prim705);
                text.add(R.string.prim706);
                text.add(R.string.prim707);
                text.add(R.string.prim708);
                text.add(R.string.prim709);
                text.add(R.string.prim710);
                text.add(R.string.prim711);
                text.add(R.string.prim712);
                text.add(R.string.prim713);
                text.add(R.string.prim714);
                text.add(R.string.prim715);
                text.add(R.string.prim716);
                text.add(R.string.prim717);
                text.add(R.string.prim718);
                text.add(R.string.prim719);
                text.add(R.string.prim720);
                text.add(R.string.prim721);
                text.add(R.string.prim722);
                text.add(R.string.prim723);
                text.add(R.string.prim724);
                text.add(R.string.prim725);
                text.add(R.string.prim726);
                text.add(R.string.prim727);
                text.add(R.string.prim728);
                text.add(R.string.prim729);
                text.add(R.string.prim730);
                text.add(R.string.prim731);
                text.add(R.string.prim732);
                text.add(R.string.prim733);
                text.add(R.string.prim734);
                text.add(R.string.prim735);
                text.add(R.string.prim736);
                text.add(R.string.prim737);
                text.add(R.string.prim738);
                text.add(R.string.prim739);
                break;
            case 8:
                text.add(R.string.prim800);
                text.add(R.string.prim801);
                text.add(R.string.prim802);
                text.add(R.string.prim803);
                text.add(R.string.prim804);
                text.add(R.string.prim805);
                text.add(R.string.prim806);
                text.add(R.string.prim807);
                text.add(R.string.prim808);
                text.add(R.string.prim809);
                text.add(R.string.prim810);
                text.add(R.string.prim811);
                text.add(R.string.prim812);
                text.add(R.string.prim813);
                text.add(R.string.prim814);
                text.add(R.string.prim815);
                text.add(R.string.prim816);
                text.add(R.string.prim817);
                text.add(R.string.prim818);
                text.add(R.string.prim819);
                text.add(R.string.prim820);
                text.add(R.string.prim821);
                text.add(R.string.prim822);
                text.add(R.string.prim823);
                text.add(R.string.prim824);
                text.add(R.string.prim825);
                text.add(R.string.prim826);
                text.add(R.string.prim827);
                text.add(R.string.prim828);
                text.add(R.string.prim829);
                text.add(R.string.prim830);
                text.add(R.string.prim831);
                text.add(R.string.prim832);
                text.add(R.string.prim833);
                text.add(R.string.prim834);
                text.add(R.string.prim835);
                text.add(R.string.prim836);
                text.add(R.string.prim837);
                text.add(R.string.prim838);
                text.add(R.string.prim839);
                text.add(R.string.prim840);
                text.add(R.string.prim841);
                text.add(R.string.prim842);
                text.add(R.string.prim843);
                text.add(R.string.prim844);
                text.add(R.string.prim845);
                text.add(R.string.prim846);
                text.add(R.string.prim847);
                text.add(R.string.prim848);
                text.add(R.string.prim849);
                break;
            case 9:
                text.add(R.string.prim900);
                text.add(R.string.prim901);
                text.add(R.string.prim902);
                text.add(R.string.prim903);
                text.add(R.string.prim904);
                text.add(R.string.prim905);
                text.add(R.string.prim906);
                text.add(R.string.prim907);
                text.add(R.string.prim908);
                text.add(R.string.prim909);
                text.add(R.string.prim910);
                text.add(R.string.prim911);
                text.add(R.string.prim912);
                text.add(R.string.prim913);
                text.add(R.string.prim914);
                text.add(R.string.prim915);
                text.add(R.string.prim916);
                text.add(R.string.prim917);
                text.add(R.string.prim918);
                text.add(R.string.prim919);
                text.add(R.string.prim920);
                text.add(R.string.prim921);
                text.add(R.string.prim922);
                text.add(R.string.prim923);
                text.add(R.string.prim924);
                text.add(R.string.prim925);
                text.add(R.string.prim926);
                text.add(R.string.prim927);
                text.add(R.string.prim928);
                text.add(R.string.prim929);
                text.add(R.string.prim930);
                text.add(R.string.prim931);
                text.add(R.string.prim932);
                text.add(R.string.prim933);
                text.add(R.string.prim934);
                break;
            case 10:
                text.add(R.string.prim1000);
                text.add(R.string.prim1001);
                text.add(R.string.prim1002);
                text.add(R.string.prim1003);
                text.add(R.string.prim1004);
                text.add(R.string.prim1005);
                text.add(R.string.prim1006);
                text.add(R.string.prim1007);
                text.add(R.string.prim1008);
                text.add(R.string.prim1009);
                text.add(R.string.prim1010);
                text.add(R.string.prim1011);
                text.add(R.string.prim1012);
                text.add(R.string.prim1013);
                text.add(R.string.prim1014);
                text.add(R.string.prim1015);
                text.add(R.string.prim1016);
                text.add(R.string.prim1017);
                text.add(R.string.prim1018);
                text.add(R.string.prim1019);
                text.add(R.string.prim1020);
                text.add(R.string.prim1021);
                text.add(R.string.prim1022);
                text.add(R.string.prim1023);
                text.add(R.string.prim1024);
                text.add(R.string.prim1025);
                text.add(R.string.prim1026);
                text.add(R.string.prim1027);
                text.add(R.string.prim1028);
                text.add(R.string.prim1029);
                break;
            default:
                break;
        }
        return text;
    }

    public void toolbarSetting() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.go_back_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_text);
        title.setText(intent.getStringExtra("main_title"));
        title.setTextColor(getResources().getColor(R.color.colorWhite));
    }
}
