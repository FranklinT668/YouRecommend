import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/*JUnit for Main Module.*/
/*Since the readCSV Module is designed for the front-end, when we try to read files in JUnit it raises errors.*/
/*Thus this JUnit is independent from the front-end, and we edited part of the original readCSV Module to run the JUnit.*/
/*In other words, this JUnit will not run if we use the code on GitLab, but all test cases pass if we do not use the front-end.*/
public class TestMain {

	/*Private values used in the test cases.*/
	private int[] number;
	private ArrayList<YouTuber> arr;
	private YouTuber source;
	
	/*Initialize the values before each test case.*/
	@Before
	public void setUp() {
		number = new int[10];
		arr = new ArrayList<YouTuber>();
		source = new YouTuber(20, "Gaming", "Canada", 23836130, "15-09-11", "VanossGaming", 891);
	}
	
	/*Usual case for getCountryFollowers method.*/
	@Test
	public void testgetCountryFollowers1() {
		arr = Main.getCountryFollowers(source);
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getFollowers();
		}
		int expect[] = {23836130,7719110,3629821,3176779,3099166,2683439,2596398,2404911,2193551,2033757};
		for (int j = 0; j < expect.length; j++) {
			if (number[j] != expect[j]) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	   }
	
	/*Case for getCountryFollowers method when enter an invalid country.*/
	@Test (expected = NullPointerException.class)
	public void testgetCountryFollowers2() {
		YouTuber error = new YouTuber(20, "Gaming", "canada", 23836130, "15-09-11", "VanossGaming", 891);
		arr = Main.getCountryFollowers(error);
		}
	
	/*Usual case for getCountryVideos method.*/
	@Test
	public void testgetCountryVideos1() {
		arr = Main.getCountryVideos(source);
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getVideos();
		}
		int expect[] = {12948,11989,10748,10724,10666,9491,8719,7819,7236,7140};
		for (int j = 0; j < expect.length; j++) {
			if (number[j] != expect[j]) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	   }
	
	/*Case for getCountryVideos method when enter an invalid country.*/
	@Test (expected = NullPointerException.class)
	public void testgetCountryVideos2() {
		YouTuber error = new YouTuber(20, "Gaming", "canada", 23836130, "15-09-11", "VanossGaming", 891);
		arr = Main.getCountryVideos(error);
		}
	
	/*Usual case for sortedByFollowers method.*/
	@Test
	public void testsortedByFollowers1() {
		arr = Main.sortedByFollowers("Sports");
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getFollowers();
		}
		int expect[] = {36301947,36254032,19752270,10148807,9073178,7887700,7373945,6380416,6154342,6109821};
		for (int j = 0; j < expect.length; j++) {
			if (number[j] != expect[j]) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	   }
	
	/*Case for sortedByFollowers method when enter an invalid category.*/
	@Test (expected = IndexOutOfBoundsException.class)
	public void testsortedByFollowers2() {
		arr = Main.sortedByFollowers("1");
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getFollowers();
		}
	}
	
	/*Usual case for sortedByVideos method.*/
	@Test
	public void testsortedByVideos1() {
		arr = Main.sortedByVideos("Sports");
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getVideos();
		}
		int expect[] = {273890,73918,53843,46951,44603,39782,37928,31350,30708,30022};
		for (int j = 0; j < expect.length; j++) {
			if (number[j] != expect[j]) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	   }
	
	/*Case for sortedByVideos method when enter an invalid category.*/
	@Test (expected = IndexOutOfBoundsException.class)
	public void testsortedByVideos2() {
		arr = Main.sortedByVideos("1");
		for (int i = 0; i < 10; i++) {
			number[i] = arr.get(i).getVideos();
		}
	}

}
