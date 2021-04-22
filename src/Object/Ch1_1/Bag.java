package Object.Ch1_1;

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

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
