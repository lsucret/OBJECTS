package Object.Ch4_1;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 캡슐화 위반
 * 1. getter가 객체 내부의 정보를 노출 -> 이 객체의 속성 변경시 클라이언트에도 수정이 필요함(파급 효과)
 */
public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }
        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }

}
