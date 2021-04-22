package Object.Ch1;

public class Bag {
    private Long amount;
    private Ticket ticket;
    private Invitation invitation;

    public Bag (Long amount) {
        this.invitation = null;
        this.amount = amount;
    }
    public Bag (Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasTicket() {
        return ticket != null;
    }
    public boolean hasInvitation() {
        return invitation != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
