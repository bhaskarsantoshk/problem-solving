package LeetCode.explore.arrays;

class Array {

    DVD[] dvdCollection= new DVD[15];

    class DVD{
        public String name;
        public int releaseYear;
        public String director;
    
        public DVD(String name, int releaseYear, String director) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.director = director;
        }

        public String toString() {
            System.out.println(
                this.name + ", directed by " + this.director + ", released in " + this.releaseYear);
                return null;
        }
    }
}