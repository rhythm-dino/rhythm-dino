package dino.main;
import javax.swing.*;
import dino.beatmap.*;
import dino.extension.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Object> inif=new Map<String, Object>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public Object get(Object o) {
                return null;
            }

            @Override
            public Object put(String s, Object o) {
                return null;
            }

            @Override
            public Object remove(Object o) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ?> map) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Object> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Object>> entrySet() {
                return null;
            }
        };
        try {
            inif=readini.readIni("/home/caviarx/桌面/tests.ini");
        }catch (Exception e){
            e.printStackTrace();
        }
        Set s=inif.keySet();
        Iterator i=s.iterator();
        while (i.hasNext()){
            Object a=i.next();
            System.out.println("key: "+a+'\n'+"value: "+inif.get(a));
        }
    }
}
