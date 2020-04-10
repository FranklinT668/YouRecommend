import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;

public class FrontEndServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String genre = req.getParameter("pref");
		ArrayList<YouTuber> gaming = Main.sortedByFollowers(genre);
		for (int i = 0; i < 100; i++) {
			out.println(gaming.get(i).getTitle() + "\t" + gaming.get(i).getFollowers());
		}
	}
}
