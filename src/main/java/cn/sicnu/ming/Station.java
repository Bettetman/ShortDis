package cn.sicnu.ming;

import java.util.ArrayList;
import java.util.List;

public class Station {
    String name;
    boolean visited;
    String preStation;
    List<String> lineNow = new ArrayList<String>();
    List<Station> nextStation = new ArrayList<Station>();
}
