package company.google;

import java.util.*;

public class PhotoIteratorSorted implements Iterator {
    private final List<String> photos;
    private final List<String> favorites;
    private int favIndex;
    private int photoIndex;

    public PhotoIteratorSorted(List<String> photos, List<String> favorites) {
        this.photos = photos;
        this.favorites = favorites;
        this.favIndex = 0;
        this.photoIndex = 0;
    }


    public static void main(String[] args) {
        List<String> photos = Arrays.asList("p2", "p3", "p4", "p5", "p6", "p7", "p8", "p10");
        List<String> favourites = Arrays.asList("p4", "p8", "p10");

        PhotoIterator iterator = new PhotoIterator(photos, favourites);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return favIndex < favorites.size() || photoIndex < photos.size();
    }

    @Override
    public Object next() {
        if ( !hasNext()) throw new NoSuchElementException();
        if ( favIndex < favorites.size()) return favorites.get(favIndex++);
        return photos.get(photoIndex++);
    }
}
