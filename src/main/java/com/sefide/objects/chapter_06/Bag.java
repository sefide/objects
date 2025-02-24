package com.sefide.objects.chapter_06;

public class Bag {
    private Ticket ticket;
    private Long invitation;
    private Long amount;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            this.ticket = ticket;
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

//    public Long setTicket(Ticket ticket) {
//        if (hasInvitation()) {
//            this.ticket = ticket;
//            return 0L;
//        } else {
//            this.ticket = ticket;
//            minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
//    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
