package Object.Ch2;

public class PercentDiscountPolicy implements DiscountPolicy {
    private long percent;
    private Movie movie;

    public PercentDiscountPolicy(long percent, Movie movie) {
        this.percent = percent;
        this.movie = movie;
    }

    @Override
    public long getDiscountAmount() {
        return movie.getFee() * percent;
    }

}
