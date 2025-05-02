class Season implements Iterable<Episode>{
    private List<Episode> episodes = new ArrayList<>();


    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator getNormalIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator getReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator getShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    public Iterator<Episode> iterator() {
        return new SeasonIterator(episodes);
    }
}

class SeasonIterator implements EpisodeIterator, Iterator<Episode> {
    protected List<Episode> episodes;
    protected int index = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public boolean hasNext() {
        return index < episodes.size();
    }

    public Episode next() {
        return episodes.get(index++);
    }
}

class ReverseSeasonIterator extends SeasonIterator {
    public ReverseSeasonIterator(List<Episode> episodes) {
        super(new ArrayList<>(episodes));
        Collections.reverse(this.episodes);
    }
}

class ShuffleSeasonIterator extends SeasonIterator {
    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        super(new ArrayList<>(episodes));
        Collections.shuffle(this.episodes, new Random(seed));
    }
}

