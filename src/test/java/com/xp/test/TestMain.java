package com.xp.test;

import com.xp.prompt.TaskPool;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class TestMain {
    public static void main(String[] args) {
        java.util.ArrayList<String> dics =new ArrayList<String>(){{
            add("String");
            add("java.lang.String");
            add("xp");
        }};


        TaskPool.getInstance().setDic(dics);



        Frame f =new Frame();
        final TextField textField = new TextField(20);
        final Label show = new Label();
        Panel p =new Panel();

        GridLayout layout =new GridLayout(1,1);
        p.setLayout(layout);

        textField.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                try {
                    String matchString = TaskPool.getInstance().matchString(textField.getText());
                    show.setText(matchString);
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        });
        p.add(textField);

        p.add(show);
        f.add(p);



        f.setBounds(20,30,550,720);
        f.setVisible(true);
    }
}
