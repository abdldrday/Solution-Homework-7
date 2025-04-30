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

