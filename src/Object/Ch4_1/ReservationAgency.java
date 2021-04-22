package Object.Ch4_1;

/**
 * 데이터 중심 설계의 좀 나아진 예2
 * 책임은 객체 내부로 옮겨왔으나, 접근자, 수정자로 인해 내부 구현이 외부에 노출되었고,
 * 내부 정책도 노출됨.
 */
public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }

}
