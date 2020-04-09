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
    
    /**
     * @brief Gets the category id of a YouTuber.
     * @return The category id of a YouTuber.
     */
    public int getCategory_id(){
        return this.cat_id;
    }
    
    /**
     * @brief Gets the category name of a YouTuber.
     * @return The category name of a YouTuber.
     */
    public String getCategory_name(){
        return this.cat_name;
    }
    
    /**
     * @brief Gets the country of a YouTuber.
     * @return The country of a YouTuber.
     */
    public String getCountry(){
        return this.country;
    }
    
    /**
     * @brief Gets the followers of a YouTuber.
     * @return The followers of a YouTuber.
     */
    public int getFollowers(){
        return this.followers;
    }

    /**
     * @brief Gets the join date of a YouTuber.
     * @return The join date of a YouTuber.
     */
    public String getJoinDate(){
        return this.joinDate;
    }
    
    /**
     * @brief Gets the title of a YouTuber.
     * @return The title of a YouTuber.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * @brief Gets the number of videos of a YouTuber.
     * @return The number of videos of a YouTuber.
     */
    public int getVideos(){
        return this.videos;
    }
    
    /**
     * @brief Judges whether this YouTuber is equal to that.
     * @param that A YouTuber used to compare.
     * @return True if this YouTuber object is equal to that
     * 		   YouTuber object and false otherwise.
     */
    public boolean equals(YouTuber that) {
    	return (this.getCategory_id() == that.getCategory_id() &&
				this.getCategory_name().equals(that.getCategory_name()) &&
				this.getCountry().equals(that.getCountry()) &&
				this.getFollowers() == that.getFollowers() &&
				this.getJoinDate().equals(that.getJoinDate()) &&
				this.getTitle().equals(that.getTitle()) &&
				this.getVideos() == that.getVideos());
    }

}