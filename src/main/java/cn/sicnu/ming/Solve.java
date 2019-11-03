package cn.sicnu.ming;

import java.io.*;
import java.util.*;

public class Solve {

    final String PATH_READ = "subway.txt";
    final String PATH_WRITE = "station.txt";
    static List<Line> lines = new ArrayList<Line>();
    static List<Station> stations = new ArrayList<Station>();
    static HashMap<String, Station> map = new HashMap<>();

    public void getSubwayMessage() {

        String getLine = null;
        try {
            int cnt = 1;
            String path=System.getProperty("user.dir") + File.separator + "\\" +PATH_READ;
            File file = new File(path);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((getLine = bufferedReader.readLine()) != null) {
                Line line = new Line();
                String[] lineList = getLine.split(" ");
                line.id = cnt;
                line.name = lineList[0];

                for(int i = 1; i <lineList.length-1; i++) {
                    Station station1 = new Station();
                    Station station2 = new Station();

                    if(map.containsKey(lineList[i])) {
                        station1 = map.get(lineList[i]);
                        map.remove(lineList[i]);
                    } else {
                        station1.setName(lineList[i] );
                        station1.setVisited( false );
                    }

                    if(map.containsKey(lineList[i+1])) {
                        station2 = map.get(lineList[i+1]);
                        map.remove(lineList[i+1]);
                    } else {
                        station2.setName(lineList[i+1]);
                        station2.setVisited( false );
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
                    map.put(lineList[i], station1);
                    map.put(lineList[i+1], station2);

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
    }
    public void getStationByLine(String name) {
        String path =System.getProperty("user.dir") + File.separator + "\\" +PATH_WRITE;
        String content = ""+name;
        List<String> ans = new ArrayList<String>();
        for (Line line : lines) {
            if (line.name.equals(name)) {
                ans = line.stations;
                break;
            }
        }
        for (String station : ans) {
            content = content + station;
        }
        try {
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finish");
        }

    }

    public static void main(String[] args) {


    }
}