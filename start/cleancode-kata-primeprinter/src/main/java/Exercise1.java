import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class Exercise1 {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public Exercise1(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible() {
        return Optional.ofNullable(expirationDate)
                .map(date -> date.isAfter(LocalDate.now()))
                .orElse(false) &&
               Boolean.TRUE.equals(approvedForConsumption) &&
               Objects.nonNull(inspectorId);
    }
}