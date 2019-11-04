package cn.sicnu.ming;

import java.util.ArrayList;
import java.util.List;

public class Line {
    int id;
    String name;
    List<String> stations = new ArrayList<>();

    public List<String> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        String s="";
        s = s+"name:"+name+"\n";
        if (stations.size()>0)
        {
            for (String a : stations) {
                s = s + a +"->";
            }
        }
        return  s;
    }
}
