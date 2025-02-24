package com.sefide.objects.chapter_06.ticket;

public class Audience {
    private Bag bag;

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

//    public Long setTicket(Ticket ticket) {
//        if (bag.hasInvitation()) {
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
//    }
}
