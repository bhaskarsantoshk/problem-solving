package company.google;

import java.util.*;

public class PhotoIteratorSorted implements Iterator<String> {
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

    @Override
    public boolean hasNext() {
        // Check if there are more elements in favorites or photos
        return favIndex < favorites.size() || photoIndex < photos.size();
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();

        // Return the next favorite if available
        if (favIndex < favorites.size()) {
            String fav = favorites.get(favIndex);
            favIndex++;

            // Skip duplicates in favorites
            while (favIndex < favorites.size() && favorites.get(favIndex).equals(fav)) {
                favIndex++;
            }
            return fav;
        }

        // Return the next photo if available
        if (photoIndex < photos.size()) {
            String photo = photos.get(photoIndex);
            photoIndex++;

            // Skip duplicates in photos
            while (photoIndex < photos.size() && photos.get(photoIndex).equals(photo)) {
                photoIndex++;
            }
            return photo;
        }

        // No more elements to return
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        List<String> photos = Arrays.asList("p2", "p3", "p4", "p5", "p6", "p7", "p8", "p10");
        List<String> favorites = Arrays.asList("p4", "p8", "p10");

        PhotoIteratorSorted iterator = new PhotoIteratorSorted(photos, favorites);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
