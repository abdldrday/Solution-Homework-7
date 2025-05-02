public class Series {
    private List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public EpisodeIterator getBingeIterator() {
        return new BingeIterator(seasons);
    }

}

class BingeIterator implements EpisodeIterator {
    private Queue<Episode> allEpisodes = new LinkedList<>();

    public BingeIterator(List<Season> seasons) {
        for (Season season : seasons) {
            for (Episode e : season) {
                allEpisodes.add(e);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !allEpisodes.isEmpty();
    }

    @Override
    public Episode next() {
        return allEpisodes.poll();
    }
}
