package ua.lviv.lgs;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SeanceTest {

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
	public void newSeanceTest() throws TimeException {
		Cinema cinema = new Cinema(new Time(0,9), new Time(0,23));
		Movie movie = new Movie("test",new Time(48,1));
		Seance seance = new Seance(movie, new Time(27,10));
		Assert.assertTrue(seance.getEndTime().getHour()==12 && seance.getEndTime().getMin()==15);
	}

	
	@Test(expected=TimeException.class)
	public void newSeanceWithException1Test() throws TimeException {
		Cinema cinema = new Cinema(new Time(0,8), new Time(0,9));
		Movie movie = new Movie("test",new Time(48,1));
		Seance seance = new Seance(movie, new Time(27,10));
		Assert.assertTrue(seance.getEndTime().getHour()==12 && seance.getEndTime().getMin()==15);
	}

	@Test(expected=TimeException.class)
	public void newSeanceWithException2Test() throws TimeException {
		Cinema cinema = new Cinema(new Time(0,10), new Time(0,23));
		Movie movie = new Movie("test",new Time(48,1));
		Seance seance = new Seance(movie, new Time(27,10));
		Assert.assertTrue(seance.getEndTime().getHour()==12 && seance.getEndTime().getMin()==15);
	}

}
