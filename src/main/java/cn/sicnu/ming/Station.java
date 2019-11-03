package cn.sicnu.ming;

import java.util.ArrayList;
import java.util.List;

public class Station {
    String name;
    boolean visited;
    String preStation;
    List<String> lineNow = new ArrayList<String>();
    List<Station> nextStation = new ArrayList<Station>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getPreStation() {
        return preStation;
    }

    public void setPreStation(String preStation) {
        this.preStation = preStation;
    }

    public List<String> getLineNow() {
        return lineNow;
    }

    public void setLineNow(List<String> lineNow) {
        this.lineNow = lineNow;
    }

    public List<Station> getNextStation() {
        return nextStation;
    }

    public void setNextStation(List<Station> nextStation) {
        this.nextStation = nextStation;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + name;
        return s;
    }
}
