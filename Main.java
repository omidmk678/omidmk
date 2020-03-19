import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        pop.addFile("to ro doos drm","Downloads","Shadmehr",1386);
        rock.addFavoriteFile("lose your self");
        pop.findFiles("doktre bandar");
        jazz.addFile("Labe karoon","Musics","Qomeyshi",1380);
        country.addFile("Iran","ahang ha","Aqili",1390);
        pop.listFile(0);

        pop.addFavoriteFile("Man ye divoonm");
        pop.addFile("Sunshine","new folder","Goooodarziiih",1398);
        pop.searcher("rock you");
        pop.listAllFiles();
    }

}
