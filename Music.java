/**
 * this class hold details about musics.
 * @author Omid Mohkamkar
 * @version 2020.03.12
 */
public class Music {
    //the address of music file.
    private String musicFile;
    //the person song the music.
    private String artist;
    //the year it published.
    private int year;

    /**
     * Constructor for music objects.
     * @param addMusicFile the address of music files.
     * @param singer who song the music.
     * @param c the year that published the music.
     */

    public Music(String addMusicFile,String singer,int c){
        musicFile = addMusicFile;
        artist = singer;
        year = c;
    }

    /**
     * @return the string of name of artist.
     */
    public String getArtist(){
        return artist;
    }

    /**
     * @return the string of address of music files.
     */
    public String getMusicFile(){
        return musicFile;
    }
    /**
     * @return the year of music files.
     */
    public int getYear(){
        return year;
    }
}
