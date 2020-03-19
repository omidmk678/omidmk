import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
    // An ArrayList for storing the details of music files.
    private ArrayList<Music> Information = new ArrayList<>();
    //An ArrayLIst for sorting the favorite music files.
    private ArrayList<String> concern = new ArrayList<>();

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename,String address,String artist,int year)
    {
        files.add(filename);
        Information.add(new Music(address,artist,year));
    }
    /**
     * Add a favorite file to the collection.
     *
     * @param favoriteFilename the file to be added.
     */
    public void addFavoriteFile(String favoriteFilename) {
        concern.add(favoriteFilename);
    }
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        System.out.println(files.get(index));
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for (String str : files)
            System.out.println(str);
    }
    /**
     * Show a list of all the favorite files in the collection.
     */
    public void listAllFavoriteFiles() {
        for (String filename : concern) {
            System.out.println(filename);
        }
    }
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        files.remove(index);
    }
    /**
     * Remove a favorite file from the collection.
     *
     * @param favoriteMusicFile favorite music file to be removed.
     */
    public void removeFavoriteFile(String favoriteMusicFile) {
        Iterator<String> it = files.iterator();
        while (it.hasNext()) {
            String file = it.next();
            if (file.equals(concern.contains(favoriteMusicFile))) {
                it.remove();
                System.out.println("\nThe selected file is removed");
                break;
            }
        }
    }
    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        player.startPlaying(files.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        return files.contains(files.get(index));
    }

    /**
     * if you forget the file name ,you find it by this method.
     *
     * @param searchString the file , you try to find it.
     */
    public void findFiles(String searchString) {
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
            }
            else
                System.out.println("sorry, your file name not found...");
        }
    }
    /**
     * if you want music, this ethod can help you.you just send your music and it done his work.
     * @param music the music you wanted.
     * @return the music files and artist.
     */
    public void searcher(String music) {
        for (Music temp : Information) {
            if (temp.getArtist().contains(music) || temp.getMusicFile().contains(music)) {
                System.out.println(temp);
            }
            else
                System.out.println("sorry, not found...");
        }
    }
}