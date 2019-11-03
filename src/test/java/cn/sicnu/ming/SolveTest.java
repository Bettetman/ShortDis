package cn.sicnu.ming;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolveTest {

    @Test
    public void getSubwayMessage() {
        Solve solve = new Solve();
        solve.getSubwayMessage();
        System.out.println("line"+"\n");
        solve.lines.stream().forEach( x-> System.out.println(x.toString()) );
        System.out.println("key"+"\n");
        solve.map.keySet().forEach( x-> System.out.println(x) );
    }

    @Test
    public void getStationByLine() {
        Solve solve = new Solve();
        solve.getSubwayMessage();
        solve.getStationByLine("2号线");
    }
}