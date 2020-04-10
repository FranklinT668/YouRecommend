import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String genre = req.getParameter("pref");
		ArrayList<YouTuber> list = new ArrayList<>();
		
		if (req.getParameter("flw-vid").equals("0")) {
			list = Main.sortedByFollowers(genre);
			for (int i = 0; i < 100; i++) {
				out.println(list.get(i).getTitle() + "\t" + list.get(i).getFollowers());
			}
		}
		else if (req.getParameter("flw-vid").equals("1")) {
			list = Main.sortedByVideos(genre);
			for (int i = 0; i < 100; i++) {
				out.println(list.get(i).getTitle() + "\t" + list.get(i).getVideos());
			}
		}
	}
}
