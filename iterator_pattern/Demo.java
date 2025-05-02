public class Demo {
    public static void main(String[] args){

        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1", 1000));
        s1.addEpisode(new Episode("S1E2", 1100));

        Season s2 = new Season();
        s2.addEpisode(new Episode("S2E1", 1200));
        s2.addEpisode(new Episode("S2E2", 1300));

        Series series = new Series();
        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("Normal:");
        EpisodeIterator it1 = s1.getNormalIterator();
        while (it1.hasNext()) System.out.println(it1.next());

        System.out.println("\nReverse:");
        EpisodeIterator it2 = s1.getReverseIterator();
        while (it2.hasNext()) System.out.println(it2.next());

        System.out.println("\nShuffle:");
        EpisodeIterator it3 = s1.getShuffleIterator(42);
        while (it3.hasNext()) System.out.println(it3.next());

        System.out.println("\nBinge watch:");
        EpisodeIterator it4 = series.getBingeIterator();
        while (it4.hasNext()) System.out.println(it4.next());

    }
}
