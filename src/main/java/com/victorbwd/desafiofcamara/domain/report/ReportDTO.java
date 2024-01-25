package com.victorbwd.desafiofcamara.domain.report;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
@Getter
@Setter
public class ReportDTO {
    private int totalEntries;

    public ReportDTO(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }
}
