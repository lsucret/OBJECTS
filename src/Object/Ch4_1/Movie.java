package Object.Ch4_1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
* 캡슐화 위반
 * 1. 내부 구현을 인터페이스에 노출(어떤 정책이 있는지)
*/
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    /*
    * 높은 결합도
    * 1. 할인조건의 명칭이 변경되면 Movie를 수정해야 한다
    * 2. 할인조건이 추가된다면 if ~ else 구문을 수정해야 한다
    * 3. 각 조건 만족 여부를 판단하는 데 필요한 정보가 변경된다면 isDiscountable 메서드 파라미터를 변경해야 한다.(시그니처 변경)
    *    이로 인해 이 메서드를 의존하는 Screening에 대한 변경을 초래할 것이다.
    * */
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }
        return true;
    }
}
