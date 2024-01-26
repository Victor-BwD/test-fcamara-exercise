package com.victorbwd.desafiofcamara.domain.report;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
@Getter
@Setter
public class ReportDTO {
    private int totalEntries;
    private int totalExits;

    public ReportDTO(int totalEntries, int totalExits) {
        this.totalEntries = totalEntries;
        this.totalExits = totalExits;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }
}
