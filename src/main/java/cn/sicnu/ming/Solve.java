package cn.sicnu.ming;

import java.io.*;
import java.util.*;

public class Solve {

    final String PATH_READ = "subway.txt";
    static List<Line> lines = new ArrayList<Line>();
    static List<Station> stations = new ArrayList<Station>();
    static HashMap<String, Station> map = new HashMap<>();

    public void getSubwayMessage() {
        try {
            int cnt = 1;
            String path = PATH_READ;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String getLine = null;

            while ((getLine = bufferedReader.readLine()) != null) {
                Line line = new Line();
                String[] list = getLine.split(" ");
                line.id = cnt;
                line.name = list[0];

                for(int i = 1; i < list.length-1; i++) {
                    Station station1 = new Station();
                    Station station2 = new Station();
                    if(map.containsKey(list[i])) {
                        station1 = map.get(list[i]);
                        map.remove(list[i]);
                    } else {
                        station1.name = list[i];
                        station1.visited = false;
                    }
                    if(map.containsKey(list[i+1])) {
                        station2 = map.get(list[i+1]);
                        map.remove(list[i+1]);
                    } else {
                        station2.name = list[i+1];
                        station2.visited = false;
                    }
                    if(!station1.lineNow.contains(line.name)) {
                        station1.lineNow.add(line.name);
                    }
                    if(!station2.lineNow.contains(line.name)) {
                        station2.lineNow.add(line.name);
                    }
                    if(!station1.nextStation.contains(station2)) {
                        station1.nextStation.add(station2);
                    }
                    if(!station2.nextStation.contains(station1)) {
                        station2.nextStation.add(station1);
                    }
                    station1.preStation = station1.name;
                    station2.preStation = station2.name;
//                    System.out.println(list[i] + "   " + station1.name);
//                    System.out.println("-----------------");
                    map.put(list[i], station1);
                    map.put(list[i+1], station2);

                    if (!line.stations.contains(station1.name)) {
                        line.stations.add(station1.name);
                    }
                    if (!line.stations.contains(station2.name)) {
                        line.stations.add(station2.name);
                    }
                }

                lines.add(line);
                cnt++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("read errors: " + e);
        }
        return ;
    }


    public static void main(String[] args) {


    }
}