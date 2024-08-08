package company.google;

import java.util.*;

public class PhotoIterator implements Iterator<String> {
    private final Iterator<String> favourieIterator;
    private final Iterator<String> photoIterator;
    private Set<String> seenPhotos;
    private String nextPhoto;

    public PhotoIterator(List<String> photos, List<String> favourites) {
        this.favourieIterator = favourites.iterator();
        this.photoIterator = photos.iterator();
        this.seenPhotos = new HashSet<>();
        this.nextPhoto = findNext();
    }

    public static void main(String[] args) {
        List<String> photos = Arrays.asList("p10", "p2", "p3", "p4", "p5", "p6", "p7", "p8");
        List<String> favourites = Arrays.asList("p8", "p4", "p10");

        PhotoIterator iterator = new PhotoIterator(photos, favourites);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return nextPhoto != null ;
    }

    @Override
    public String next() {
        if (nextPhoto == null ) throw new NoSuchElementException();
        String currentPhoto = nextPhoto;
        nextPhoto = findNext();
        return currentPhoto;
    }

    private String findNext() {
        while (favourieIterator.hasNext()){
            String fav = favourieIterator.next();
            if ( !seenPhotos.contains(fav)) {
                seenPhotos.add(fav);
                return fav;
            }
        }

        while ( photoIterator.hasNext()){
            String fav = photoIterator.next();
            if ( !seenPhotos.contains(fav)){
                seenPhotos.add(fav);
                return fav;
            }
        }
        return null;
    }
}

