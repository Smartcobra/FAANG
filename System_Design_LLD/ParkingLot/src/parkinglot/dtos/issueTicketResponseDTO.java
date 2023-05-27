package parkinglot.dtos;

import parkinglot.model.Ticket;

public class issueTicketResponseDTO {
    private ResponseStatus responseStatus;
    private String failureReason;
    private Ticket ticket;
}
