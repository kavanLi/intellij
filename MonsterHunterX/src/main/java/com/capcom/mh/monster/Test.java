package com.capcom.mh.monster;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * Created by Ritchie on 9/10/2017.
 */

class A {

}

public class Test {
    final int x = 0;

    public static void main(String[] args) {
        System.out.println(Long.valueOf("101"));


        //int ran1 = ThreadLocalRandom.current().nextInt(10000, 99999);
        //System.out.println(ran1);
        //int ran2 = new Random().nextInt(9000) + 1000;
        //System.out.println(ran2);
        //int ran3 = (int) (Math.random()*900 + 100);
        //System.out.println(ran3);
        //NumberFormat f = new DecimalFormat();
        //long rand4 = ((long)ran1 * (long)ran2 * (long)ran3);
        //System.out.println(rand4);
        //String rand5 = new StringBuilder(String.valueOf(rand4)).reverse().toString();
        //System.out.println(Long.parseLong(rand5));
        //long test_unuse = Long.parseLong(rand5)%10000;
        //System.out.println(test_unuse);
        //int randomNumber = (int) (Long.parseLong(rand5)%10000 + 1);
        //System.out.println(randomNumber);

        //int c = (int) ((Long.parseLong(rand5)) % 10000);
        //System.out.println(c);
        //
        //NumberFormat format = new DecimalFormat("0000");
        //String a = format.format(100);
        //System.out.println(a);
        //int b = 1234;
        //String test = format.format(10);
        //char te = '1';
        //String c = new StringBuilder(String.valueOf()).reverse().toString();
        //System.out.println(format.format(10));
        //int aaa = format.format(10);
        //System.out.println(c);
        //int g = Integer.parseInt(c);
        //System.out.println(g);
        //
        //int aa = new Random().nextInt(2);
        //long asd = 111111111133333323L;
        //System.out.println((2342353450001L%10000));
        //JFrame frame = new JFrame();
        //JButton button = new JButton("click me");
        //frame.getContentPane().add(button);
        //frame.setSize(300,300);
        //frame.setVisible(true);
        //FlyingDragon a = new FireDragon();
        //Monster b =  a;

        //com.capcom.mh.Test asdf;
        //asdf = new com.capcom.mh.Test();

        //FlyingDragon d = (FireDragon) (new SilverSun()); //????转型成火龙又转型成飞龙.
        //d.dash();
        ////d = null;
        //d.dash();//空指针异常.
        //Monster asd = new FireDragon();
        //asd = new FlyingDragon();//小遥控器可以指向功能大的对象
        ////FireDragon c = new FlyingDragon();//大遥控器不能指向功能不全的对象,类型不安全.

        //SilverSun a = new SilverSun();
        //a.skyDive();//为什么会无限循环?

        //ArrayList<FireDragon> fireDragonList = new ArrayList<FireDragon>();
        //
        ////FlyingDragon a = new FlyingDragon();
        ////FlyingDragon a = new FireDragon();
        //Monster ab = new SilverSun();
        //((FlyingDragon) ab).dash();
        //System.out.println();

        //FlyingDragon b = new FireDragon();
        //FlyingDragon c = new SilverSun();
        //SilverSun d = new SilverSun();
        //fireDragonList.add((SilverSun) b); //1.编译报错,类型不安全?带着银火龙的面具的雄火龙,指向错了?
        //fireDragonList.add((FireDragon) c);//2.这句话什么意思?雄火龙面具的银火龙所以可以放进去?
        //fireDragonList.add(d);
        //((FireDragon)c).hoverAttack(); //3.运行以后为什么用的是银火龙的的方法,因为银火龙覆盖了这个方法,个转换后的c不应该只能用雄火龙的方法么?
        //4.((FireDragon)c)这句话的意思是什么,展开分步写怎么写,是不是这样:FireDragon c = new SilverSun();

        //FireDragon e = new FireDragon();
        //fireDragonList.add(0,d);
        //fireDragonList.add(1,e);
        //SilverSun test_2 = fireDragonList.get(3);
        //FireDragon test_1 = fireDragonList.get(4);
        //SilverSun v = fireDragonList.get(0);


        //FireDragon d1 = new FireDragon();
        //SilverSun s1 = new SilverSun();
        //Monster s3 = new SilverSun();
        //s1 = d1;
        //d1 = s1;

        //覆写
        //Monster a = new FireDragon();
        //System.out.println(a.getClass());
        //((SilverSun)a).hoverAttcak(3);

        //FireDragon s2 = (FireDragon) s1;
        //
        //if (a instanceof SilverSun) {
        //    SilverSun s2 = (SilverSun) a;
        //
        //}

        //System.out.println("sdfassf");
        //((FlyingDragon)a).bite();
        //((FireDragon) a).skyDive();
        //
        //
        //killMonster(a);
        //
        //FireDragon fireDragon = new FireDragon();
        //killMonster((FlyingDragon)c);
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(b, 1);
            track.add(noteOn);

            ShortMessage c = new ShortMessage();
            c.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(c, 16);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void killMonster(SilverSun silverSun) {
        // kill monster
        SilverSun s2 = (SilverSun) silverSun;
        silverSun.hoverAttack();
    }
}
