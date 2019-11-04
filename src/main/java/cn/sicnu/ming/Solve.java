package cn.sicnu.ming;

import java.io.*;
import java.util.*;

public class Solve {

    final String PATH_READ = "subway.txt";
    final String PATH_WRITE = "station.txt";
    final String PATH_ROUTINE = "routine.txt";
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
                for(int i = 1; i <=lineList.length-1; i++) {

                    if (i<lineList.length-1)
                    {

                        if(!map.containsKey(lineList[i])||!map.containsKey( lineList[i+1] )) {
                          Station station1 = new Station(lineList[i]);
                          Station station2 = new Station(lineList[i+1]);
                          station1.lineNow.add( line.name );
                          station2.lineNow.add( line.name );
                          station1.nextStation.add(station2);
                          station2.nextStation.add( station1 );
                          map.put( lineList[i],station1 );
                          map.put( lineList[i],station1 );
                        }else{
                          if(map.containsKey( lineList[i] ))
                        }

                    }else if(i==lineList.length-1)
                    {
                        if(!map.containsKey(lineList[i])) {
                            Station station = new Station(lineList[i]);
                            station.lineNow.add( line.name );
                            map.put( lineList[i],station );
                        }
                        else {
                            map.get(lineList[i]).lineNow.add( line.name );
                        }
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
        String content = ""+name+":  ";
        List<String> ans = new ArrayList<String>();
        for (Line line : lines) {
            if (line.name.equals(name)) {
                ans = line.stations;
                break;
            }
        }
        for (String station : ans) {
            content = content + station+"->";
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

    public void BFS(String st, String ed) {
        for (Map.Entry<String, Station> entry : map.entrySet()) {
            entry.getValue().setVisited( false );
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(st);
        while(!queue.isEmpty()) {
            String now = queue.poll();
            map.get( now ).setVisited( true );

            if(now.equals(ed)) {
                break;
            }
            for(Station station : map.get(now).nextStation) {
                if(map.get(station.name).visited==false) {
                    map.get(station.name).preStation = now;
                    queue.add(station.name);
                }
            }
        }
    }

    public void printPath(String st, String ed) {
        String path=System.getProperty("user.dir") + File.separator + "\\" +PATH_ROUTINE;
        List<String> list = new ArrayList<>();
        String now = ed;
        String content="";
        while(!now.equals(st)) {
            list.add(now);
            now = map.get(now).preStation;
        }
        list.add( st );
        Collections.reverse(list);
        list.stream().forEach( x-> System.out.println(x) );
        for (String s :
                list) {
            content = content + s +"->";
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