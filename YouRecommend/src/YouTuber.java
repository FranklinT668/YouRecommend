/**
 * @brief An ADT that represents YouTuber.
 */

public class YouTuber{
    private int cat_id;
    private String cat_name;
    private String country;
    private int followers;
    private String joinDate;
    private String title;
    private int videos;

    /**
     * @brief Constructor of YouTuber ADT.
     * @param id The YouTuber's category id
     * @param n The YouTuber's category name
     * @param c Country of the YouTuber
     * @param f Followers of the YouTuber
     * @param j Joindate of the YouTuber
     * @param t Title of the YouTuber
     * @param v The number of videos of the YouTuber
     */
    public YouTuber(int id, String n, String c, 
                    int f, String j, String t, int v){
        this.cat_id = id;
        this.cat_name = n;
        this.country = c;
        this.followers = f;
        this.joinDate = j;
        this.title = t;
        this.videos = v;
    }

    public int getCategory_id(){
        return this.cat_id;
    }

    public String getCategory_name(){
        return this.cat_name;
    }

    public String getCountry(){
        return this.country;
    }

    public int getFollowers(){
        return this.followers;
    }

    public String getJoinDate(){
        return this.joinDate;
    }

    public String getTitle(){
        return this.title;
    }

    public int getVideos(){
        return this.videos;
    }

}