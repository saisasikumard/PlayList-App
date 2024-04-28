import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Album album1=new Album("Jersey","Anirudh");
        Album album2=new Album("KGF","Ravi bansuri");

        album1.addSong("Sprit of jersey",4.02);
        album1.addSong("Adentogani",3.57);
        album1.addSong("Adentogani",4.02);

        album2.addSong("mehabooba",3.47);
        album2.addSong("dheera",3.2);
        album2.addSong("English rap",2.50);

        //find song
        if(album1.findSong("Vikram")){
            System.out.println("vikram  is present");
        }
        else{
            System.out.println("vikram in not present");
        }
        if(album2.findSong("mehabooba")){
            System.out.println("mehabooba is present");

        }
        else{
            System.out.println("mehabooba is not present");
        }
        //creste playlist
        LinkedList<Song> myplaylist=new LinkedList<>();
        album1.addToPlaylistFromAlbum("Sprit of jersey",myplaylist);
        album1.addToPlaylistFromAlbum(1,myplaylist);
        album2.addToPlaylistFromAlbum("English rap",myplaylist);

        //invalid songs
        album1.addToPlaylistFromAlbum("gaali valuga",myplaylist);
        album2.addToPlaylistFromAlbum(4,myplaylist);
        Main.play(myplaylist);

        LinkedList<Song> playlist2=new LinkedList<>();
        Main.play(playlist2);

    }
    public static void play(LinkedList<Song> myplayList){
        ListIterator<Song> itr= myplayList.listIterator();
        if(!itr.hasNext()){
            System.out.println("no songs are avilable inn the playlist.");
            return;
        }
        System.out.println("Now Playing: ");
        System.out.println(itr.next());

        Scanner sc=new Scanner(System.in);


        while(true){
            int choice=sc.nextInt();
            switch (choice ){
                case 1:
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                        break;
                    }
                    System.out.println("You reached last song of Playlist");
                    break;
                case 2:
                    itr.previousIndex();
                    System.out.println("You are the starting of the PlayList");
                    break;
                case 3:
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing!! ");
                        System.out.println(itr.previous());
                        break;
                    }
                    break;
                case 4:
                    printSongs(myplayList);
                    break;
                case 5:
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                   exit(0);
            }
        }



    }
    public static void printSongs(LinkedList<Song> playList){
        for(Song s: playList){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1.Play Next Song");
        System.out.println("2.Play Previous Song");
        System.out.println("3.Repeat current song");
        System.out.println("4.Show all songs in playlist");
        System.out.println("5.Delete the current song");
        System.out.println("6.show printMenu again");
        System.out.println("7. Exit");

    }

}