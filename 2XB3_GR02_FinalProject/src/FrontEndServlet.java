/**
 * Welcome to the module that is responsible for communicating with the back-end 
 * aspect of the project and displaying information to the front-end.
 * Please install Java EE and Apache Tomcat to run this program
 * Also, to run this project, you need to right-click the project folder and run
 * as 'Run on Server'
 * Designed and Programmed by Kabishan Suvendran
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* For handling user requests and delivering responses */
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String genre = req.getParameter("pref");
		ArrayList<YouTuber> list = new ArrayList<>();
		ArrayList<YouTuber> sug = new ArrayList<>();
		
		/*Suggesting YouTubers based on follower count*/
		if (req.getParameter("flw-vid").equals("0")) {
			list = Main.sortedByFollowers(genre);
			if (list.size() == 0) out.println("Invalid Category");
			else {
				out.println("Genre Based YouTube Channel Suggestions");
				out.printf("%-30s %s\n", "Channel Name", "Followers");
				out.println();
				for (int i = 0; i < 10; i++) out.printf("%-30s %d\n", list.get(i).getTitle(), list.get(i).getFollowers());
				
				/* Suggesting YouTube channels based on top channel's country */
				if (req.getParameter("sugg").equals("sugg")) {
					out.println();
					if (list.get(0).getCountry().equals("")) {
						out.println("No geographical suggestions");
						return;
					}
					out.println("Suggested YouTube Channels from " + list.get(0).getCountry());
					out.printf("%-30s %s\n", "Channel Name", "Followers");
					out.println();
					sug = Main.getCountryFollowers(list.get(0));
					if (sug.size() == 0) out.println("No geographical suggestions");
					sug = Sort.QuickSort_Followers(sug);
					for (int i = 1; i < 11; i++) out.printf("%-30s %d\n", sug.get(i).getTitle(), sug.get(i).getFollowers());
				}
				else return;
			}
		}
		
		/*Suggesting YouTubers based on video count*/
		else if (req.getParameter("flw-vid").equals("1")) {
			list = Main.sortedByVideos(genre);
			if (list.size() == 0) out.println("Invalid Category"); 
			else {
				out.println("Genre Based YouTube Channel Suggestions");
				out.printf("%-30s %s\n", "Channel Name", "Videos");
				out.println();
				for (int i = 0; i < 10; i++) out.printf("%-30s %d\n", list.get(i).getTitle(), list.get(i).getVideos());
				
				/* Suggesting YouTube channels based on top channel's country */
				if (req.getParameter("sugg").equals("sugg")) {
					out.println();
					if (list.get(0).getCountry().equals("")) {
						out.println("No geographical suggestions");
						return;
					}
					out.println("Suggested YouTube Channels from " + list.get(0).getCountry());
					out.printf("%-30s %s\n", "Channel Name", "Videos");
					out.println();
					sug = Main.getCountryVideos(list.get(0));
					if (sug.size() == 0) out.println("No geographical suggestions");
					sug = Sort.QuickSort_Videos(sug);
					for (int i = 1; i < 11; i++) out.printf("%-30s %d\n", sug.get(i).getTitle(), sug.get(i).getVideos());
				}
				else return;
			}
		}
	}
}
