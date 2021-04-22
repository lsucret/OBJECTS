package Object.Ch2;

public class Movie {
    private Money fee;
    private String name;

    public Movie(Money fee, String name) {
        this.fee = fee;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Money getFee() {
        return fee;
    }


}
