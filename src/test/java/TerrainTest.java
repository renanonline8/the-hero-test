import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.print.DocFlavor;
import java.lang.reflect.Method;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Terrain.class)
public class TerrainTest {
    @Test
    public void isSquare() {
        boolean expected = true;
        boolean actual = true;

        int side1 = 10;
        int side2 = 10;
        Terrain terrain = new Terrain(side1, side2);
        actual = terrain.isSquare();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isRectangle() {
        boolean expected = false;
        boolean actual = false;

        int side1 = 15;
        int side2 = 10;
        Terrain terrain = new Terrain(side1, side2);
        actual = terrain.isSquare();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateArea() {
        int expected = 1000;
        int actual = 0;

        Terrain terrain = new Terrain(100, 10);
        actual = terrain.calculateArea();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorBellowMinArea() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = false;
        boolean actual = true;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1, 1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(99);

        actual = terrainSpy.checkMinArea();

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void area100() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = true;
        boolean actual = false;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1,1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(100);
        actual = terrainSpy.checkMinArea();

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void arableLandBefore2000s() throws Exception {
        final String METHOD = "calculateArea";
        double expected = 160;
        double actual = 0;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1, 1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.getArableLand(1999);

        Assert.assertEquals(expected, actual, 0);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void arableLandAfter2000s() throws Exception {
        final String METHOD = "calculateArea";
        double expected = 40;
        double actual = 0;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1,1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.getArableLand(2000);
        Assert.assertEquals(expected, actual, 0);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void isLegalBefore2000s() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = true;
        boolean actual = false;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1,1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.isLegal(160, 1999);

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void isntLegalBefore2000s() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = false;
        boolean actual = true;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1,1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.isLegal(161, 1999);

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void isLegalAfter2000s() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = true;
        boolean actual = false;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1, 1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.isLegal(40, 2000);

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }

    @Test
    public void isntLegalAfter2000s() throws Exception {
        final String METHOD = "calculateArea";
        boolean expected = false;
        boolean actual = true;

        Terrain terrainSpy = PowerMockito.spy(new Terrain(1, 1));
        PowerMockito.when(terrainSpy, METHOD).thenReturn(200);
        actual = terrainSpy.isLegal(41, 2000);

        Assert.assertEquals(expected, actual);

        PowerMockito.verifyPrivate(terrainSpy, Mockito.times(1)).invoke(METHOD);
    }
}
