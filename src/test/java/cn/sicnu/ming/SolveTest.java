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
        System.out.println( solve.map.keySet().size() );
        solve.map.keySet().forEach( x-> System.out.println(x) );
    }

    @Test
    public void getStationByLine() {
        Solve solve = new Solve();
        solve.getSubwayMessage();
        solve.getStationByLine("2号线");
    }

    @Test
    public void BFS() {
        Solve solve = new Solve();
        solve.getSubwayMessage();
        solve.BFS( "积水潭","朝阳门" );
    }

    @Test
    public void printPath() {
        Solve solve = new Solve();
        solve.getSubwayMessage();
        solve.BFS( "积水潭","朝阳门" );
        solve.printPath("积水潭","朝阳门"   );
    }
}