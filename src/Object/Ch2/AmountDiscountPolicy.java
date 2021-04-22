package Object.Ch2;

public class AmountDiscountPolicy implements DiscountPolicy {
    private long discountAmount;
    private Movie movie;

    public AmountDiscountPolicy(long discountAmount, Movie movie) {
        this.discountAmount = discountAmount;
        this.movie = movie;
    }

    @Override
    public long getDiscountAmount() {
        return discountAmount;
    }
}
