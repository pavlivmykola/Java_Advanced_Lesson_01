package ua.lviv.lgs;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTest {
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher () {
		protected void failed(Throwable e, Description description) {
			System.out.println("Failed --->"+description.getMethodName());
		}
		
		protected void succeeded (Description description) {
			System.out.println("Succeed --->"+description.getMethodName());
		}
	};
	
	@Test
	public void newTimeTest() throws TimeException {
		Time time = new Time(50,1);
		Assert.assertTrue(time.getMin()==50 && time.getHour()==1);	
	}
	
	@Test (expected = TimeException.class)
	public void newTimeWithWrongMin1Test() throws TimeException {
		Time time = new Time(62,2);		
	}

	@Test (expected = TimeException.class)
	public void newTimeWithWrongMin2Test() throws TimeException {
		Time time = new Time(-1,2);		
	}

	@Test (expected = TimeException.class)
	public void newTimeWithWrongHour1Test() throws TimeException {
		Time time = new Time(17,25);		
	}

	@Test (expected = TimeException.class)
	public void newTimeWithWrongHour2Test() throws TimeException {
		Time time = new Time(2,-2);		
	}

	
	@Test
	public void newTimeWithStringTest() throws TimeException {
		Time time = new Time("Введіть 9год 40хв");
		Assert.assertTrue(time.getMin()==40 && time.getHour()==9);
	}
	
	
	@Test
	public void compareTime1Test() throws TimeException {
		Assert.assertTrue(Time.compareTime(new Time(35,10), new Time(40,9)));
	}
	
	@Test
	public void compareTime2Test() throws TimeException {		
		Assert.assertTrue(Time.compareTime(new Time(35,9), new Time(10,9)));
	}
	
	@Test
	public void compareTime3Test() throws TimeException {
		Assert.assertTrue(!Time.compareTime(new Time(35,8), new Time(50,8)));
	}

	@Test
	public void checkTimeInterval1Test() throws TimeException {
		Assert.assertTrue(Time.checkTimeInterval(new Time(35,8), new Time(15,9), new Time(47,9), new Time(2,11)));
	}

	@Test
	public void checkTimeInterval2Test() throws TimeException {
		Assert.assertTrue(!Time.checkTimeInterval(new Time(35,8), new Time(50,9), new Time(47,9), new Time(2,11)));
	}


	@Test
	public void checkTimeInterval3Test() throws TimeException {
		Assert.assertTrue(!Time.checkTimeInterval(new Time(35,8), new Time(7,13), new Time(47,9), new Time(2,11)));
	}

	@Test
	public void checkTimeInterval4Test() throws TimeException {
		Assert.assertTrue(!Time.checkTimeInterval(new Time(35,10), new Time(15,14), new Time(47,9), new Time(2,11)));
	}

	@Test
	public void checkTimeInterval5Test() throws TimeException {
		Assert.assertTrue(Time.checkTimeInterval(new Time(35,11), new Time(15,12), new Time(47,9), new Time(2,11)));
	}

	@Test
	public void addTimeTest() throws TimeException {
		Time time1 = new Time(7,14);
		Time time2 = time1.addTime(new Time(47,12), new Time(20,1));
		Assert.assertTrue(time1.getHour()==time2.getHour() && time1.getMin()==time2.getMin());
	}

}
